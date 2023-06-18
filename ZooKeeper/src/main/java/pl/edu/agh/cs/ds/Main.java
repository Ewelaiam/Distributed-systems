package pl.edu.agh.cs.ds;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Scanner;

@Slf4j
public class Main {
    private static boolean isRunning = true;
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        if (args.length < 3) {
            log.error("Not enough arguments provided! \nFormat: <host:port> <znode> <exec>");
            System.exit(2);
        }

        String hostAndPort = args[0];
        String znodeName = args[1];
        String execPath = args[2];

        log.info("<host:port>: " + hostAndPort);
        log.info("<znode>: " + znodeName);
        log.info("<exec>: " + execPath);

        try {
            ZooKeeperWatcher executor = new ZooKeeperWatcher(hostAndPort, znodeName, execPath);
            handleExecutorInput(executor);
        } catch (IOException e) {
            isRunning = false;
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void handleExecutorInput(ZooKeeperWatcher executor) {
        while (isRunning) {
            scanner.nextLine();
            TreeCreator.showTree(executor.getZnode(), executor.getZooKeeper());
        }
    }
}
