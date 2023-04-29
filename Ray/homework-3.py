# excercise 3
# 3.0 start remote cluster settings and observe actors in cluster
# a) make screenshot of dependencies
# 3.1. Modify the Actor class MethodStateCounter and add/modify methods that return the following:
# a) - Get number of times an invoker name was called
# b) - Get a list of values computed by invoker name
# 3- Get state of all invokers
# 3.2 Modify method invoke to return a random int value between [5, 25]

import logging
import time
import ray
import random

if ray.is_initialized:
    ray.shutdown()
ray.init(logging_level=logging.ERROR)
# ray.init(address='auto', ignore_reinit_error=True, logging_level=logging.ERROR)

CALLERS=["A","B","C"]


@ray.remote
class MethodStateCounter:
    def __init__(self):
        self.invokers = {caller: 0 for caller in CALLERS}
        self.invokers_values = {caller: [] for caller in CALLERS}

    def invoke(self, name):
        time.sleep(0.5)
        self.invokers[name] += 1
        value = random.randint(5, 25)
        self.invokers_values[name].append(value)
        return value

    def get_invoker_state(self, name):
        return self.invokers[name]

    def get_invoker_values(self, name):
        return self.invokers_values[name]

    def get_all_invoker_state(self):
        return self.invokers

    def get_all_invoker_values(self):
        return self.invokers_values


worker_invoker = MethodStateCounter.remote()
print(worker_invoker)

for _ in range(10):
    name = random.choice(CALLERS)
    worker_invoker.invoke.remote(name)

print('method callers')
for _ in range(5):
    random_name_invoker = random.choice(CALLERS)
    value = ray.get(worker_invoker.invoke.remote(random_name_invoker))
    print(f"Named caller: {random_name_invoker} returned a value {value}")

print(ray.get(worker_invoker.get_all_invoker_values.remote()))

