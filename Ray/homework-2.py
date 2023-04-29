# Excercises 2.1) Create large lists and python dictionaries,
# put them in object store. Write a Ray task to process them.

import cProfile
import logging
import ray
import random
from ray.exceptions import GetTimeoutError

if ray.is_initialized:
    ray.shutdown()
ray.init(logging_level=logging.ERROR)
# ray.init(address='auto', ignore_reinit_error=True, logging_level=logging.ERROR)

large_list = [random.randint(1, 3000) for _ in range(5000)]
large_2D_list = [[random.randint(1, 3000) for _ in range(5000)] for _ in range(20)]

large_dict_1 = {i: '0.' + str(random.randint(1, 2000)) for i in range(5000)}
large_dict_2 = {i: chr(i) for i in range(1000)}

large_dict_with_lists = {i: ray.put([j for j in range(25)]) for i in range(125)}

large_list_ref = ray.put(large_list)
large_2D_list_ref = ray.put(large_2D_list)

large_dict_1_ref = ray.put(large_dict_1)
large_dict_2_ref = ray.put(large_dict_2)

large_dict_with_lists_ref = ray.put(large_dict_with_lists)

@ray.remote
def process_list(list_ref):
    return [elem + 3 for elem in list_ref]

@ray.remote
def process_2D_list(list_ref):
    return [[list_ref[i][j] + 15 for j in range(len(list_ref[i]))] for i in range(len(list_ref))]

@ray.remote
def process_dict_1(dict_ref):
    return {k: float(v) + 1 for k, v in dict_ref.items()}

@ray.remote
def process_dict_2(dict_ref):
    return {k: 'ascii_' + v for k, v in dict_ref.items()}

@ray.remote
def process_dict_with_lists(dict_with_lists_ref):
    return {k: [i * 2 for i in ray.get(v)] for k, v in dict_with_lists_ref.items()}

def process_tasks():
    list_ref = process_list.remote(large_list_ref)
    list_2D_ref = process_2D_list.remote(large_2D_list_ref)
    dict_1_ref = process_dict_1.remote(large_dict_1_ref)
    dict_2_ref = process_dict_2.remote(large_dict_2_ref)
    dict_with_lists_ref = process_dict_with_lists.remote(large_dict_with_lists_ref)

    ray.get(list_ref)
    ray.get(list_2D_ref)
    ray.get(dict_1_ref)
    ray.get(dict_2_ref)
    ray.get(dict_with_lists_ref)

    # try:
    #     ray.get(list_ref, timeout=20)
    # except GetTimeoutError :
    #     print("`get` timed out")

print("Process lists and dictionaries")
cProfile.run("process_tasks()")