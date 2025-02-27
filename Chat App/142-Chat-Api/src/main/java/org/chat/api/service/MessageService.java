package org.chat.api.service;

import org.chat.api.model.Message;

import java.util.List;

public interface MessageService {
    public Message sendMessage(Message message); // POST

    public List<Message> getAllMessage(); // GET

    public void deleteMessage(Integer id); // DELETE
}
