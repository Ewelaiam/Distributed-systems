import grpc
import grpc_requests
from google.protobuf.descriptor_pool import DescriptorPool
from grpc_reflection.v1alpha.proto_reflection_descriptor_database import ProtoReflectionDescriptorDatabase


def run_program():
    services = show_services()

    while True:
        try:
            action_input = input("\nChoose the number of service:\n")
            if action_input in {"X", 'O', "T", "M"}:
                return action_input
            show_operations(services[int(action_input)])
        except IndexError:
            print("Service number does not exist!")


def show_services():
    print("Services:\n")
    services = list(filter(lambda s: s != "grpc.reflection.v1alpha.ServerReflection", reflection_db.get_services()))
    for i, service in enumerate(services):
        service_name = service.split(".")[-1]
        print(f"{i} - {service_name}")

    return services


def show_operations(service_name):
    chosen_service = desc_pool.FindServiceByName(service_name)
    name_of_service = service_name.split(".")[-1]
    print(f"Operations for {name_of_service} service:\n")

    for i, method in enumerate(list(map(lambda m: m.full_name, chosen_service.methods))):
        method_name = method.split(".")[-1]
        print(f"{i} - {method_name}")

        method_desc = desc_pool.FindMethodByName(method)

        print("\tArguments", end=": ")
        for field in method_desc.input_type.fields:
            print(field.full_name.split(".")[-1], end=", ")
        print()


def statistics():
    args = [4.94, 5.67, 5.95, 5.96, 5.48, 4.58, 4.28, 4.47, 5.24, 5.27, 4.94, 5.83]
    operations = ["AVG", "MIN", "MAX", "MIN_SEQ", "MAX_SEQ", "DIFF"]

    print(f"args: {args}\n")
    opStructure = []
    for op in operations:
        opStructure.append({"operationType": op, "arg": args})

    result = client.request("petrolStationHistoryData.PetrolStationHistoryData", "Statistics",
                            {"operations": opStructure})
    print(f"Operations: {operations}\nResults: {result}\n")

def trip_calculator():
    distance = 150
    mileage = 8.2
    price = 6.76
    people = 4
    result = client.request("petrolStationHistoryData.PetrolStationHistoryData", "Calculator",
                            {"distance": distance, "mileage": mileage, "price": price, "people": people})

    print(f"Cost of trip: {result}")


def future_fuel_price():
    year = 2025
    result = client.request("petrolStationNewData.PetrolStationNewData", "PricePrediction",
                   {"year": year})
    print(f"Cost of petrol in {year}: {result}")



if __name__ == '__main__':
    server_address = 'localhost:50048'
    client = grpc_requests.Client.get_by_endpoint("localhost:50048")
    channel = grpc.insecure_channel(server_address)
    reflection_db = ProtoReflectionDescriptorDatabase(channel)
    desc_pool = DescriptorPool(reflection_db)

    action = run_program()

    if action == 'X':
        statistics()
        trip_calculator()
        future_fuel_price()
    if action == 'O':
        statistics()
    if action == 'T':
        statistics()
        trip_calculator()
    if action == 'M':
        statistics()
        future_fuel_price()


