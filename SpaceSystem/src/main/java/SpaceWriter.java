import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class SpaceWriter {
    private Channel channel;
    private String key;
    private final String EXCHANGE_NAME;

    // queue writer
    public SpaceWriter(String key) throws IOException, TimeoutException {
        EXCHANGE_NAME = "";
        this.key = key;
        createConnection();
        channel.queueDeclare(this.key, false, false, false, null);
    }

    // topic
    public SpaceWriter() throws IOException, TimeoutException {
        EXCHANGE_NAME = "space";
        createConnection();
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
    }

    private void createConnection() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        this.channel = connection.createChannel();
    }


    // topic
    public void send(String msg, String k, String type) throws IOException {
        switch(type) {
            case "queue":
                channel.basicPublish(
                        EXCHANGE_NAME,
                        key,
                        null,
                        msg.getBytes());
                break;
            case "topic":
                channel.basicPublish(
                        EXCHANGE_NAME,
                        k,
                        null,
                        msg.getBytes(StandardCharsets.UTF_8));
                break;
            default:
                System.out.println("Invalid type");
        }

    }

}
