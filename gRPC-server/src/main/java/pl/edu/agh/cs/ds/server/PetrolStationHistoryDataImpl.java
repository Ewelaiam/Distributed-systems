package pl.edu.agh.cs.ds.server;

import ds.grpc.*;
import ds.grpc.PetrolStationHistoryDataGrpc;
import ds.grpc.PetrolStationHistoryDataStatisticsRequest;
import ds.grpc.PetrolStationHistoryDataStatisticsResponse;
import ds.grpc.TheCostOfTravelCalculationRequest;
import io.grpc.stub.StreamObserver;

import java.util.List;

public class PetrolStationHistoryDataImpl extends PetrolStationHistoryDataGrpc.PetrolStationHistoryDataImplBase {

    @Override
    public void statistics(PetrolStationHistoryDataStatisticsRequest request, StreamObserver<PetrolStationHistoryDataStatisticsResponse> responseObserver) {

        System.out.println("Statistics - operationList: \n " + request.getOperationsList());

        if (request.getOperationsCount() == 0) {
            responseObserver.onError(new IllegalArgumentException("No operations provided!"));
        }

        Double[] stats = new Double[request.getOperationsCount()];


        for (int i = 0; i < request.getOperationsCount(); i++){
            switch (request.getOperations(i).getOperationType()) {
                case AVG:
                    double sum = 0;
                    for (Double d : request.getOperations(i).getArgList()) sum += d;
                    sum /= request.getOperationsCount();
                    stats[i] = (double) Math.round(100.0 * sum) / 100.0;
                    break;
                case MIN:
                    double minValue = Double.POSITIVE_INFINITY;
                    for (Double d : request.getOperations(i).getArgList()) minValue = (d < minValue) ? d : minValue;
                    stats[i] = minValue;
                    break;
                case MAX:
                    double maxValue = Double.NEGATIVE_INFINITY;
                    for (Double d : request.getOperations(i).getArgList()) maxValue = (d > maxValue) ? d : maxValue;
                    stats[i] = maxValue;
                    break;
                case MIN_SEQ:
                    int minSeq = 0;
                    double minRes = 0;
                    List<Double> argList = request.getOperations(i).getArgList();
                    for (int j = 1; j < argList.size(); j++){
                        if (argList.get(j - 1) >= argList.get(j)) minSeq++;
                        else {
                            minRes = Math.max(minSeq, minRes);
                            minSeq = 0;
                        }
                    }
                    stats[i] = minRes;
                    break;
                case MAX_SEQ:
                    int maxSeq = 0;
                    double maxRes = 0;
                    List<Double> maxArgList = request.getOperations(i).getArgList();
                    for (int j = 1; j < maxArgList.size(); j++){
                        if (maxArgList.get(j - 1) <= maxArgList.get(j)) maxSeq++;
                        else {
                            maxRes = Math.max(maxSeq, maxRes);
                            maxSeq = 0;
                        }
                    }
                    stats[i] = maxRes;
                    break;
                case DIFF:
                    double diffSum = 0;
                    List<Double> diffArgList = request.getOperations(i).getArgList();
                    for (int j = 1; j < diffArgList.size(); j++){
                        diffSum += (Math.abs(diffArgList.get(j) - diffArgList.get(j - 1)));
                    }
                    stats[i] = (double) Math.round(100.0 * diffSum / (diffArgList.size() - 1)) / 100.0;
                    break;
                case UNRECOGNIZED:
                    throw new RuntimeException("Operation does not exist!");
            }
        }

        PetrolStationHistoryDataStatisticsResponse response = PetrolStationHistoryDataStatisticsResponse
                .newBuilder()
                .addAllStats(List.of(stats))
                .build();

        System.out.println(response);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void calculator(TheCostOfTravelCalculationRequest request, StreamObserver<ds.grpc.TheCostOfTravelCalculationResponse> responseObserver) {

        double mileagePeople = (request.getPeople() * 60) / 100;
        double price = (request.getPrice() * request.getDistance() * (request.getMileage() + mileagePeople)) / 100;
        price = Math.round(price * 100.0) / 100.0;

        TheCostOfTravelCalculationResponse response = TheCostOfTravelCalculationResponse
                .newBuilder()
                .setCost(price)
                .build();

        System.out.println(response);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
