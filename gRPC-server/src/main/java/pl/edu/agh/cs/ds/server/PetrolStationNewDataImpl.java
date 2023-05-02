package pl.edu.agh.cs.ds.server;

import ds.grpc.PetrolStationNewDataGrpc;
import ds.grpc.PetrolStationPredictionRequest;
import ds.grpc.PetrolStationPredictionResponse;
import io.grpc.stub.StreamObserver;

import java.util.Random;

public class PetrolStationNewDataImpl extends PetrolStationNewDataGrpc.PetrolStationNewDataImplBase {

    @Override
    public void pricePrediction(PetrolStationPredictionRequest request, StreamObserver<PetrolStationPredictionResponse> responseObserver) {

        if (request.getYear() < 2022) {
            responseObserver.onError(new IllegalArgumentException("Year must be greater than 2022!"));
        }

        double[] oldData = {4.94, 5.67, 5.95, 5.96, 5.48, 4.58, 4.28, 4.47, 5.24, 5.27, 4.94, 5.83};
        Random random = new Random();
        int difference = Math.abs(request.getYear() - 2022);
        double sum = 0;
        double prevDate = oldData[oldData.length - 1];
        int i = 0;

        while (i < 5 * difference) {
            double nextPrice = random.nextDouble(4.0, 6.0);
            if (Math.abs(nextPrice - prevDate) < 0.5) {
                sum += nextPrice;
                i++;
            }
        }

        PetrolStationPredictionResponse response = PetrolStationPredictionResponse
                .newBuilder()
                .setPrediction(Math.round((sum / (5 * difference)) * 100.0) / 100.0)
                .build();

        System.out.println(response);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
