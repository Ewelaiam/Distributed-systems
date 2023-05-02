package pl.edu.agh.cs.ds.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;

import java.io.IOException;

public class DynamicServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        int port = 50048;
        Server server = ServerBuilder
                .forPort(port)
                .addService(ProtoReflectionService.newInstance())
                .addService(new PetrolStationHistoryDataImpl())
                .addService(new PetrolStationNewDataImpl())
                .build()
                .start();


        System.out.println("Server: listening on port " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.err.println("Server: JVM is shutting down");
                server.shutdown();
                System.err.println("Server: shutting down");
            }
        });

        server.awaitTermination();
    }
}
