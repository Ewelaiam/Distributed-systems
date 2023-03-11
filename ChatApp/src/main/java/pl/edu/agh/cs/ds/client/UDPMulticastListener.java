package pl.edu.agh.cs.ds.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Arrays;

import static pl.edu.agh.cs.ds.ConnectionInfo.MULTICAST_ADDRESS;
import static pl.edu.agh.cs.ds.ConnectionInfo.MULTICAST_PORT;

public class UDPMulticastListener extends Thread{
    private final int hostPort;

    public UDPMulticastListener(int hostPost) {
        this.hostPort = hostPost;
    }

    @Override
    public void run() {
        super.run();
        byte[] receiveBuffer = new byte[1024];
        while (true) {
            try (MulticastSocket socket = new MulticastSocket(MULTICAST_PORT)) {
                socket.joinGroup(InetAddress.getByName(MULTICAST_ADDRESS));
                Arrays.fill(receiveBuffer, (byte) 0);
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                socket.receive(receivePacket);
                if (receivePacket.getPort() != hostPort) {
                    System.out.println(new String(receivePacket.getData()).split("\0")[0]);
                }
            } catch (IOException e) {
                System.out.println("!MULTICAST MESSAGE RECEIVING ERROR!");
                e.printStackTrace();
            }
        }
    }
}