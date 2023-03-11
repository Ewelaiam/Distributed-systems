package pl.edu.agh.cs.ds.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class UDPListener extends Thread{
    private final DatagramSocket socket;

    public UDPListener(DatagramSocket datagramSocket) {
        this.socket = datagramSocket;
    }

    @Override
    public void run() {
        super.run();
        byte[] receiveBuffer = new byte[1024];
        while (true) {
            try {
                Arrays.fill(receiveBuffer, (byte) 0);
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                socket.receive(receivePacket);
                System.out.println(new String(receivePacket.getData()).split("\0")[0]);
            } catch (IOException e) {
                System.out.println("!UDP MESSAGE RECEIVING ERROR!");
                e.printStackTrace();
            }
        }
    }
}
