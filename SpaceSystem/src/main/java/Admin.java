import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;


public class Admin {

    public static void main(String[] args) throws IOException, TimeoutException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        new Thread(new SpaceListener("admin", toIgnore -> {}, false)).start();

        Map<String, String> recipientsToKeyMap = new HashMap<>();
        recipientsToKeyMap.put("agencies", KeyConstant.ADMIN_AGENCY_KEY);
        recipientsToKeyMap.put("carriers", KeyConstant.ADMIN_CARRIER_KEY);
        recipientsToKeyMap.put("all", KeyConstant.ADMIN_EVERYONE_KEY);

        SpaceWriter writer = new SpaceWriter();

        System.out.println("@@@ ADMIN PANEL @@@");
        System.out.println("\nInfo:\t\tAdmin is ready to work! Waiting for commands ...");
        System.out.println("Recipients:\tagencies/carriers/all");
        System.out.println("Format:\t\trecipient@msg");

        while(true) {
            String input = reader.readLine();
            if ("end".equals(input)) {
                System.out.println("Closing admin...");
                break;
            }

            String[] inputData = input.split("@", 2);
            if (inputData.length != 2) {
                System.out.println("Wrong input format!\nFormat:\trecipient@msg");
                continue;
            }

            String key = recipientsToKeyMap.get(inputData[0]);
            if (key != null) {
                String msg = "@From: 'ADMIN'"
                        + "\t\t@Message: '" + inputData[1] + "'"
                        + "\t\t@With key: '" + key + "'";
                try {
                    writer.send(msg, key, "topic");
                    System.out.println("\u001B[34m" + "Sent: " + msg  + "\u001B[0m");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Wrong input format!\nFormat:\trecipient@msg");
            }


        }
    }
}
