package service;

import model.MQMessage;

import java.util.List;

public interface IMessageService {
    public List<MQMessage> getMessages(String name);
    public void sendMessage(MQMessage message);
}
