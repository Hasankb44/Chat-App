package org.chat.api.service.impl;

import org.chat.api.controller.Controller;
import org.chat.api.model.Message;
import org.chat.api.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/message")
public class RestServiceImpl implements RestService {

    @Autowired
    private Controller controller;

    @PostMapping(path = "/send")
    public void sendMessage(@RequestBody Message message) {
        controller.sendMessage(message);
    } // POST

    @GetMapping(path = "/getAll")
    public List<Message> getAllMessage() {
        return controller.getAllMessage();
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteMessage(@PathVariable(name = "id") Integer id) {
        controller.deleteMessage(id);
    } // DELETE
}
