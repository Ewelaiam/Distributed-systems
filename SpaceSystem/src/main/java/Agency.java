import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeoutException;



public class Agency {
    public static void main(String[] args) throws IOException, TimeoutException {
        Set<String> SERVICES = new HashSet<>(Arrays.asList("human", "cargo", "satellite"));
        SpaceWriter adminWriter = new SpaceWriter();
        Map<String, SpaceWriter> serviceToWriterMap = new HashMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("@@@ SPACE AGENCY @@@\nAgency ID:");
        String agencyID = reader.readLine();

        new Thread(new SpaceListener(KeyConstant.AGENCY_KEY + agencyID, toIgnore -> {}, false)).start();
        new Thread(new SpaceListener(KeyConstant.ADMIN_AGENCY_KEY, toIgnore -> {}, false)).start();
        new Thread(new SpaceListener(KeyConstant.ADMIN_EVERYONE_KEY, toIgnore -> {}, false)).start();

        for (String service : SERVICES){
            serviceToWriterMap.put(service, new SpaceWriter( KeyConstant.CARRIER_KEY+ service));
        }


        System.out.println("\nInfo:\t\tAgency is ready to work! Waiting for service requests...");
        System.out.println("Services:\thuman/cargo/satellite");
        System.out.println("Format:\t\tserviceType@data");

        while(true) {
            String input = reader.readLine();
            if ("end".equals(input)) {
                System.out.println("Closing agency...");
                break;
            }

            String[] inputData = input.split("@", 2);
            if (inputData.length != 2) {
                System.out.println("Wrong input format!\nFormat:\tservice@msg");
                continue;
            }

            SpaceWriter serviceWriter = serviceToWriterMap.get(inputData[0]);

            if (serviceWriter != null) {
                String msg = "@From agency: '" + agencyID + "'"
                        + "\t\t@With orderId: '" + ThreadLocalRandom.current().nextInt(0, 10000) + "'"
                        + "\t\t@And message: '" + inputData[1] + "' ";

                try {
                    serviceWriter.send(msg, null, "queue");
                    adminWriter.send(msg, "admin", "topic");
                    System.out.println("\u001B[34m" + "Sent: " + msg  + "\u001B[0m");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Wrong input format!\nFormat:\tservice@msg");
            }

        }
    }
}
