package org.chat.api.controller;

import org.chat.api.model.Message;

import java.util.List;

public interface Controller {

    public void sendMessage(Message message); // POST

    public List<Message> getAllMessage(); // GET

    public void deleteMessage(Integer id); // DELETE
}
