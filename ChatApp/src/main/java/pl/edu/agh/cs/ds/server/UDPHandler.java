package pl.edu.agh.cs.ds.server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

import static pl.edu.agh.cs.ds.ConnectionInfo.HOSTNAME;

public class UDPHandler extends Thread{
    private final int port;
    private final List<Socket> clients;

    public UDPHandler(int port, List<Socket> clients) {
        this.port = port;
        this.clients = clients;
    }

    @Override
    public synchronized void run() {
        super.start();
        try (DatagramSocket socket = new DatagramSocket(port)) {
            byte[] receiveBuffer = new byte[1024];

            while (true) {
                Arrays.fill(receiveBuffer, (byte) 0);
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                socket.receive(receivePacket);
                String msg = new String(receivePacket.getData()).split("\0")[0];
                byte[] sendBuffer = msg.getBytes();

                for (Socket clientSocket : clients) {
                    if (clientSocket.getPort() != receivePacket.getPort()) {
                        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, InetAddress.getByName(HOSTNAME), clientSocket.getPort());
                        socket.send(sendPacket);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
