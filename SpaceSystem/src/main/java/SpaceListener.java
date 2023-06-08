import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;

public class SpaceListener implements Runnable {
    private final String EXCHANGE_NAME = "space";
    private final String key;
    private final Consumer<String> msgConsumer;
    private final boolean isQueue;

    public SpaceListener(String key, Consumer<String> msgConsumer, boolean isQueue) {
        this.key = key;
        this.msgConsumer = msgConsumer;
        this.isQueue = isQueue;
    }

    @Override
    public void run() {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            String queueName = "";

            if (isQueue) {
                channel.queueDeclare(key, false, false, false, null);
                channel.basicQos(1);
            } else {
                channel.exchangeDeclare(EXCHANGE_NAME, "topic");
                queueName = channel.queueDeclare().getQueue();
                channel.queueBind(queueName, EXCHANGE_NAME, key);
            }
            com.rabbitmq.client.Consumer consumer = new DefaultConsumer(channel)
            {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) {
                    String msg = new String(body, StandardCharsets.UTF_8);
                    System.out.println("\u001B[33m" + "Received: " + msg + "\u001B[0m");
                    msgConsumer.accept(msg);
                }
            };

            if(isQueue)
                channel.basicConsume(key, true, consumer);
            else
                channel.basicConsume(queueName, true, consumer);
        }
        catch (IOException | TimeoutException e)
        { e.printStackTrace(); }
    }
}
