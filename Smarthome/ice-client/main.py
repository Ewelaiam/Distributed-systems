from enum import Enum
import sys, Ice
from logging import info
from typing import List

import smarthome
from smarthome import SpeakerPrx
from smarthome import RadioPrx
from smarthome import WeatherStationPrx


class SmartDevice(Enum):
    Speaker = 1
    Radio = 2
    WeatherStation = 3


def select_device():
    menu = """
    Select device:
     1 - Speaker
     2 - Radio
     3 - WeatherStation
    """.strip()

    device_no = int(input(menu))
    while device_no not in [1, 2, 3]:
        device_no = input(menu)

    for device in SmartDevice:
        if device.value == device_no:
            return device
    raise ValueError('Device not found')



def get_possible_methods(clazz):
    return [method for method in dir(clazz) if not (
            method.startswith('__') or
            method.startswith("begin") or
            method.startswith("end") or
            method.startswith("ice") or
            method.endswith("Async") or
            method == "checkedCast" or
            method == "uncheckedCast")]


def to_map(seq: List):
    return {idx: item for idx, item in enumerate(seq)}


def choose_method(clazz):
    possible_methods = to_map(get_possible_methods(clazz))
    possible_methods[max(possible_methods.keys()) + 1] = 'exit'
    for idx, method in possible_methods.items():
        print(f"{idx} - {method}")
    method_id = int(input())
    while method_id not in possible_methods.keys():
        for idx, method in possible_methods.items():
            print(f"{idx} - {method}")
        method_id = int(input())

    return possible_methods[method_id]


def handle_methods_calls(obj, clazz):
    while True:
        method = choose_method(clazz)
        if method == 'exit':
            break
        else:
            method_to_call = getattr(obj, method)
            result = method_to_call()
            if result is not None:
                print(f"RESULT: {result}")



def handle_communication(device: SmartDevice, communicator):
    match device:
        case SmartDevice.Speaker:
            base = communicator.propertyToProxy("speaker.Proxy")
            speaker = SpeakerPrx.uncheckedCast(base)
            speaker.turnOn()
            handle_methods_calls(speaker, SpeakerPrx)
        case SmartDevice.Radio:
            base = communicator.propertyToProxy("radio.Proxy")
            radio = RadioPrx.uncheckedCast(base)
            handle_methods_calls(radio, RadioPrx)
        case SmartDevice.WeatherStation:
            base = communicator.propertyToProxy("weatherStation.Proxy")
            weatherStation = WeatherStationPrx.uncheckedCast(base)
            handle_methods_calls(weatherStation, WeatherStationPrx)


def main():
    with Ice.initialize("config.client") as communicator:
        while True:
            try:
                device = select_device()
                handle_communication(device, communicator)
            except smarthome.Error as e:
                print(f'Ice error: {e.errorMessage}\n')
            except Exception as e:
                print(e)


if __name__ == "__main__":
    main()
