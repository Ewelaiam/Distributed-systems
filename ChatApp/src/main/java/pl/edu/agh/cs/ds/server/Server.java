package pl.edu.agh.cs.ds.server;

import pl.edu.agh.cs.ds.client.ClientThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static pl.edu.agh.cs.ds.ConnectionInfo.PORT;

public class Server {
    private final List<Socket> clients = new ArrayList<>();
    private final ExecutorService executorService = Executors.newFixedThreadPool(50);

    private void connectClients(ServerSocket serverTcpSocket) {
        executorService.submit(new UDPHandler(PORT, clients));

        while (!serverTcpSocket.isClosed()) {
            try {
                Socket clientSocket = serverTcpSocket.accept();
                ClientThread clientThread = new ClientThread(clientSocket, clients);
                executorService.submit(clientThread);
                System.out.println("A new client has connected");
            } catch (IOException e) {
                System.out.println("!CLIENT CONNECTING ERROR!");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Server is starting ...");
        try (ServerSocket serverTcpSocket = new ServerSocket(PORT)) {
            Server server = new Server();
            server.connectClients(serverTcpSocket);
        } catch (IOException e) {
            System.out.println("!SERVER INITIALIZATION ERROR!");
            e.printStackTrace();
        }
    }
}

