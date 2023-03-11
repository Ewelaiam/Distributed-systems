package pl.edu.agh.cs.ds.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

import static pl.edu.agh.cs.ds.ConnectionInfo.*;
import static pl.edu.agh.cs.ds.client.AsciiArtCollection.asciiArt;

public class Client {
    private static final Scanner scanner = new Scanner(System.in);
    private static String name = "noName";

    private void sendMessage(PrintWriter serverOutput, DatagramSocket datagramSocket, Socket socket) {
        while (socket.isConnected()) {
            try {
                String msg = scanner.nextLine();
                switch (msg) {
                    case "U" -> sendAsciiArtMessage(datagramSocket, name, InetAddress.getByName(HOSTNAME), PORT, "UDP");
                    case "M" -> sendAsciiArtMessage(datagramSocket, name, InetAddress.getByName(MULTICAST_ADDRESS), MULTICAST_PORT, "Multicast");
                    default -> serverOutput.println("\n[TCP]\n@" + name + ": " + msg + "\n" + "> ");
                }

                System.out.print("> ");


            } catch (IOException e) {
                System.out.println("!MESSAGE SENDING ERROR!");
                e.printStackTrace();
            }
        }
    }

    private void sendAsciiArtMessage(DatagramSocket datagramSocket, String name, InetAddress address, int destinationPort, String type) throws IOException {
        byte[] sendBuffer = ("[" + type + "]\n@" + name + ":" + "\n" + asciiArt).getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, address, destinationPort);
        datagramSocket.send(sendPacket);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the chat!");
        try (Socket socket = new Socket(HOSTNAME, PORT);
             DatagramSocket datagramSocket = new DatagramSocket(socket.getLocalPort())
        ) {
            System.out.print("Nickname: ");
            name = scanner.nextLine();
            System.out.println("Hi " + name  + "!\n>");

            new TCPListener(new BufferedReader(new InputStreamReader(socket.getInputStream())), socket).start();
            new UDPListener(datagramSocket).start();
            new UDPMulticastListener(socket.getLocalPort()).start();

            Client client = new Client();

            client.sendMessage(new PrintWriter(socket.getOutputStream(), true), datagramSocket, socket);


        } catch (IOException e) {
            System.out.println("!CLIENT INITIALIZATION ERROR!");
            e.printStackTrace();
        }
    }

}


