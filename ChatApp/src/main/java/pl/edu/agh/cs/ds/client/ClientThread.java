package pl.edu.agh.cs.ds.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

public class ClientThread extends Thread{
    private final List<Socket> clients;
    private final Socket socket;
    private final BufferedReader bufferedReader;
    private final String name;

    public ClientThread(Socket socket, List<Socket> clients) throws IOException {
        clients.add(socket);
        this.socket = socket;
        this.clients = clients;
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.name = socket.getInetAddress().getHostName();
    }

    @Override
    public void run() {
        super.run();
        try {
            while (!socket.isClosed()) {
                String msg = bufferedReader.readLine();
                for (Socket clientSocket : clients) {
                    if (!clientSocket.equals(socket)) {
                        new PrintWriter(clientSocket.getOutputStream(), true).println(msg);
                    }
                }
            }
        } catch (SocketException e) {
            System.out.println("!CONNECTION WAS CLOSED!");
        } catch (IOException e) {
            System.out.println("MESSAGE RECEIVING ERROR: " + name);
            e.printStackTrace();
        } finally {
            clients.remove(socket);
        }
    }
}
