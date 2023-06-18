package pl.edu.agh.cs.ds;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Scanner;

@Slf4j
public class Main {

    private static boolean running = true;
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        if (args.length < 3) {
            log.error("Not enough parameters");
            System.exit(2);
        }

        String hostPort = args[0];
        String znodeName = args[1];
        String execPath = args[2];

        log.info("HOST: " + hostPort);
        log.info("ZNODE: " + znodeName);
        log.info("PATH: " + execPath);

        try {
            ZooWatcher executor = new ZooWatcher(hostPort, znodeName, execPath);
            handleInput(executor);
        } catch (IOException e) {
            running = false;
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void handleInput(ZooWatcher executor) {
        while (running) {
            scanner.nextLine();
            TreePrinter.printTree(executor.getZnode(), executor.getZooKeeper());
        }
    }
}
