import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;

public class Carrier {
    public static void main(String[] args) throws IOException, TimeoutException {
        Set<String> SERVICES = new HashSet<>(Arrays.asList("human", "cargo", "satellite"));

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("@@@ SPACE CARRIER @@@\nCarrier ID:");
        String carrierID = reader.readLine();

        String firstService = "";
        String secondService = "";

        boolean isInputValid = false;
        while (!isInputValid) {
            System.out.println("Pick two services: human/cargo/satellite");
            firstService = reader.readLine();
            secondService = reader.readLine();
            System.out.println();

            if (SERVICES.contains(firstService) &&
                    SERVICES.contains(secondService) &&
                    !firstService.equals(secondService)) {
                isInputValid = true;
            }
        }

        System.out.println("\nInfo:\t\tCarrier is ready to work! Waiting for order requests...");
        SpaceWriter writer = new SpaceWriter();
        Consumer<String> consumer = msg -> {
            String[] split = msg.split("'");
            if (split.length != 7)
                System.out.println("Invalid message format!");
            else if (split[1].equals("ADMIN"))
                System.out.println("ADMIN: " + split[5]);
            else {
                String response = "@From carrier: " + carrierID
                        + "\t\t@With orderId: " + split[3]
                        + "\t\t@And info: " + "finished service";


                String senderKey = KeyConstant.AGENCY_KEY + split[1];
                System.out.println("\u001B[34m" + "Sent: " + response + "\t\t@To: " + senderKey + "\u001B[0m");
                try {
                    writer.send(response, senderKey, "topic");
                    writer.send(response, "admin", "topic");
                }
                catch (IOException e)
                { e.printStackTrace(); }
            }
        };

        new Thread(new SpaceListener(KeyConstant.CARRIER_KEY + firstService, consumer, true)).start();
        new Thread(new SpaceListener(KeyConstant.CARRIER_KEY + secondService, consumer, true)).start();
        new Thread(new SpaceListener(KeyConstant.ADMIN_CARRIER_KEY, toIgnore -> {}, false)).start();
        new Thread(new SpaceListener(KeyConstant.ADMIN_EVERYONE_KEY, toIgnore -> {}, false)).start();
    }
}
