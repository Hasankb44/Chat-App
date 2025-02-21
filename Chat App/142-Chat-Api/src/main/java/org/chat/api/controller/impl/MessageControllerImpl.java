package org.chat.api.controller.impl;

import org.chat.api.controller.MessageController;
import org.chat.api.model.Message;
import org.chat.api.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class MessageControllerImpl implements MessageController {

    private MessageService messageService;
public MessageControllerImpl(MessageService messageService) {
    this.messageService = messageService;
}
  /*hey dear developer if you want l can swich return type to MessageDto for security reasons
   if you don't want no problem
   *
   */
    @PostMapping(path = "/send")

    public Message sendMessage(@RequestBody Message message) {
        messageService.sendMessage(message);

        return message;
    } // POST

    @GetMapping(path = "/getAll")
    public List<Message> getAllMessage() {
        return messageService.getAllMessage();
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteMessage(@PathVariable(name = "id") Integer id) {
      messageService.deleteMessage(id);
    } // DELETE
}
