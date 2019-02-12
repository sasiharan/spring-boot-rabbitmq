package service;

import model.MQMessage;
import module.Application;
import module.MessageReceiver;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService implements IMessageService {
    private final RabbitTemplate rabbitTemplate;
    private final MessageReceiver receiver;
    public MessageService(RabbitTemplate rabbitTemplate, MessageReceiver receiver) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public List<MQMessage> getMessages(String name) {
        return receiver.getMessages();
    }

    @Override
    public void sendMessage(MQMessage message) {
        rabbitTemplate.convertAndSend(Application.topicExchangeName, "foo.bar.baz", message);
    }
}
