import ray
import logging
from sklearn.model_selection import train_test_split
import pandas as pd

from ray.data.preprocessors.scaler import StandardScaler
from ray.tune.sklearn import TuneGridSearchCV
from sklearn.tree import DecisionTreeRegressor

if ray.is_initialized:
    print("Ray shutting down...")
    ray.shutdown()
print("Ray initializing...")
ray.init(logging_level=logging.ERROR)

ds = ray.data.read_csv("kidney-stone.csv")
ds.show(3)

# Risk of stone=target
ds.groupby("target").count().show()

print("Schema: \n", ds.schema())

ds = ds.drop_columns([""])
print("Data without # column")
ds.show(3)

X = ds.copy(ds)
X = X.drop_columns(["target"])
y = ds.select_columns(cols=["target"])

y.show(3)
X.show(3)

X_pandas = X.to_pandas()
y_pandas = y.to_pandas()

@ray.remote
def train_test_split_ray(X, y, test_size=0.2):
    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=test_size)
    return ray.put(X_train), ray.put(X_test), ray.put(y_train), ray.put(y_test)

X_id = ray.put(X_pandas)
y_id = ray.put(y_pandas)

# Rozproszenie funkcji do węzłów i uruchomienie jej równolegle
X_train_id, X_test_id, y_train_id, y_test_id = ray.get(train_test_split_ray.remote(X_id, y_id))

# Pobranie danych wyjściowych z węzłów
X_train = ray.get(X_train_id)
X_test = ray.get(X_test_id)
y_train = ray.get(y_train_id)
y_test = ray.get(y_test_id)


X_train_ray = ray.data.from_pandas(X_train)
X_test_ray = ray.data.from_pandas(X_test)

scaler_ray = StandardScaler(list(X_train.columns))

X_train_scaled = scaler_ray.fit_transform(X_train_ray)
X_test_scaled = scaler_ray.transform(X_test_ray)

print(len(X_train_scaled.take_all()))
print(pd.DataFrame(X_train_scaled.take(10)))


param_grid = {'criterion': ['squared_error', 'absolute_error'],
              'max_depth' : [2, 4, 7, 10, 15, 25],
              'min_samples_leaf' : [2, 5, 15, 50, 150]
              }

ray_search = TuneGridSearchCV(estimator=DecisionTreeRegressor(),
                            param_grid=param_grid,
                            cv=10,
                            verbose=2)

#ray_search.fit(pd.DataFrame(X_train_scaled.take_all()), y_train)
#smaller part for testing purposes
TRAIN_LIMIT = 6000
ray_search.fit(pd.DataFrame(X_train_scaled.take_all()).head(TRAIN_LIMIT), y_train[:TRAIN_LIMIT])

print(ray_search.best_params)

TEST_LIMIT = 3000
y_predicted = ray_search.predict(pd.DataFrame(X_test_scaled.take_all()).head(TEST_LIMIT))

result = pd.DataFrame({
    'y_true': y_test[:TEST_LIMIT],
    'y_pred': y_predicted
})

print('\n', result)