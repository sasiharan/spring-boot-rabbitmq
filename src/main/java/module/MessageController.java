package module;

import model.MQMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.IMessageService;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private IMessageService messageService;

    @GetMapping(value = "/{name}")
    public List<MQMessage> getMessages(@PathVariable("name") final String name) {
       return messageService.getMessages(name);
    }

    @PostMapping(path = "send", consumes = "application/json")
    public void addMessage(@RequestBody MQMessage message) {
      messageService.sendMessage(message);
    }

}
