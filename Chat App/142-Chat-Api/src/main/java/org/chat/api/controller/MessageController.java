package org.chat.api.controller;

import org.chat.api.model.Message;

import java.util.List;

public interface MessageController {

    void sendMessage(Message message); // POST

    List<Message> getAllMessage(); // GET

    void deleteMessage(Integer id); // DELETE
}
