package pl.edu.agh.cs.ds.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

public class TCPListener extends Thread{
    private final BufferedReader bufferedReader;
    private final Socket socket;

    public TCPListener(BufferedReader bufferedReader, Socket socket) {
        this.bufferedReader = bufferedReader;
        this.socket = socket;
    }

    @Override
    public void run() {
        super.run();
        try {
            while (socket.isConnected()) {
                System.out.println(bufferedReader.readLine());
            }
        } catch (IOException e) {
            System.out.println("!TCP MESSAGE RECEIVING ERROR!");
            e.printStackTrace();
        }
    }
}
