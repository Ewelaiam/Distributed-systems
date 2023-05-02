from enum import Enum

import Ice

import smarthome
from smarthome import RadioPrx
from smarthome import SpeakerPrx
from smarthome import WeatherStationPrx


class SmartDevice(Enum):
    Speaker = 1
    Radio = 2
    WeatherStation = 3

def transformator(clazz):
    candidates = [method for method in dir(clazz) if not (
            method.startswith('__') or
            method.startswith("begin") or
            method.startswith("end") or
            method.startswith("ice") or
            method.endswith("Async") or
            method == "checkedCast" or
            method == "uncheckedCast")]

    return {idx: item for idx, item in enumerate(candidates)}


def method_picker(clazz):
    candidate_methods = transformator(clazz)
    candidate_methods[max(candidate_methods.keys()) + 1] = 'exit'

    for idx, method in candidate_methods.items():
        print(f"{idx} - {method}")

    method_id = int(input())
    while method_id not in candidate_methods.keys():
        for idx, method in candidate_methods.items():
            print(f"{idx} - {method}")
        method_id = int(input())

    return candidate_methods[method_id]


def enable_methods(obj, clazz):
    while True:
        method = method_picker(clazz)
        if method == 'exit':
            break
        else:
            method_to_call = getattr(obj, method)
            method_result = method_to_call()

            if method_result is not None:
                print(f"RESULT: {method_result}")



def communication(device: SmartDevice, communicator):
    match device:
        case SmartDevice.Speaker:
            base = communicator.propertyToProxy("speaker.Proxy")
            speaker = SpeakerPrx.uncheckedCast(base)
            speaker.turnOn()
            enable_methods(speaker, SpeakerPrx)
        case SmartDevice.Radio:
            base = communicator.propertyToProxy("radio.Proxy")
            radio = RadioPrx.uncheckedCast(base)
            enable_methods(radio, RadioPrx)
        case SmartDevice.WeatherStation:
            base = communicator.propertyToProxy("weatherStation.Proxy")
            weatherStation = WeatherStationPrx.uncheckedCast(base)
            enable_methods(weatherStation, WeatherStationPrx)

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

def main():
    with Ice.initialize("config.client") as communicator:
        while True:
            try:
                device = select_device()
                communication(device, communicator)
            except smarthome.Error as e:
                print(f'Ice error: {e.errorMessage}\n')
            except Exception as e:
                print(e.args)
                print(e)


if __name__ == "__main__":
    main()
