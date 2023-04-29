# Excercises 1.1)Try using local bubble sort and remote bubble sort,
# show difference

import cProfile
import logging
import ray
import random

if ray.is_initialized:
    ray.shutdown()
ray.init(logging_level=logging.ERROR)
# ray.init(address='auto', ignore_reinit_error=True, logging_level=logging.ERROR)

random_1D_value = [random.randint(1, 3000) for _ in range(500)]
random_2D_value = [[random.randint(1, 3000) for _ in range(500)] for _ in range(3)]


def bubblesort(t):
    l = len(t)
    for i in range(l - 1):
        for j in range(l - i - 1):
            if t[j] > t[j + 1]:
                t[j], t[j + 1] = t[j + 1], t[j]
    return t


@ray.remote
def bubblesort_distributed(t):
    return bubblesort(t)


def local_bubble_sort():
    return bubblesort(random_2D_value)


def remote_bubble_sort():
    return ray.get(bubblesort_distributed.remote(random_2D_value))


print('local run')
cProfile.run("local_bubble_sort()")

print('remote run')
cProfile.run("remote_bubble_sort()")

ray.shutdown()



