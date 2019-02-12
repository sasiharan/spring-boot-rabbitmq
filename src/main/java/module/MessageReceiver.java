package module;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

import model.MQMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    private CountDownLatch latch = new CountDownLatch(1);
    private Queue<MQMessage> queue = new ArrayBlockingQueue<>(100);

    @RabbitListener(queues = "spring-boot-msg")
    public void receiveMessage(MQMessage message) {
        System.out.println("Received <" + message + ">");
        queue.offer(message);
    }

    public List<MQMessage> getMessages() {
        return queue.stream().collect(Collectors.toList());
    }

}