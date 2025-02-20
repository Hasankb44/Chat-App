package org.chat.api.controller.impl;

import org.chat.api.controller.MessageController;
import org.chat.api.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class MessageControllerImpl implements MessageController {
    @Autowired
    private MessageController messageController;

    @PostMapping(path = "/send")
    public void sendMessage(@RequestBody Message message) {
        messageController.sendMessage(message);
    } // POST

    @GetMapping(path = "/getAll")
    public List<Message> getAllMessage() {
        return messageController.getAllMessage();
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteMessage(@PathVariable(name = "id") Integer id) {
      messageController.deleteMessage(id);
    } // DELETE
}
