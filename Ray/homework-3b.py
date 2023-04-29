# 3.3 Take a look on implement parralel Pi computation
# based on https://docs.ray.io/en/master/ray-core/examples/highly_parallel.html
#
# Implement calculating pi as a combination of actor (which keeps the
# state of the progress of calculating pi as it approaches its final value)
# and a task (which computes candidates for pi)

import ray
import time
import random
import logging


if ray.is_initialized:
    ray.shutdown()
ray.init(logging_level=logging.ERROR)

SAMPLES = 1000000
WORKERS = 1000

@ray.remote
class DigitsOfPI:
    def __init__(self) -> None:
        self.samples_in = 0
        self.num_of_samples = 0

    def add_samples(self, in_count: int) -> None:
        self.samples_in += in_count
        self.num_of_samples += SAMPLES

    def get_pi(self) -> float:
        return self.samples_in / self.num_of_samples * 4 if self.num_of_samples != 0 else 0

@ray.remote
def pi4_sample(pi_calculator) -> None:
    in_count = 0
    for _ in range(SAMPLES):
        x = random.random()
        y = random.random()
        if x*x + y*y <= 1:
            in_count += 1

    pi_calculator.add_samples.remote(in_count)


pi_digits = DigitsOfPI.remote()
task_refs = [pi4_sample.remote(pi_digits) for _ in range(WORKERS)]

for i in range(10):
    print(ray.get(pi_digits.get_pi.remote()))
    time.sleep(1)

