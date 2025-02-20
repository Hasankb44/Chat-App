package org.chat.api.service.impl;

import org.chat.api.model.Message;
import org.chat.api.repositories.MessageRepository;
import org.chat.api.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MessageServiceImpl implements MessageService {
   private final MessageRepository messageRepository;
   public MessageServiceImpl(MessageRepository messageRepository) {
       this.messageRepository = messageRepository;
   }

    @Override
    public Message sendMessage(Message message) {
       return messageRepository.save(message);
    }

    @Override
    public List<Message> getAllMessage() {
        return messageRepository.findAll();
    }

    @Override
    public void deleteMessage(Integer id) {
        messageRepository.deleteById(id);
    }
}
