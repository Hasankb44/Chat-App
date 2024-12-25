package org.chat.api.controller.impl;

import org.chat.api.controller.Controller;
import org.chat.api.model.Message;
import org.chat.api.repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@org.springframework.stereotype.Controller
public class ControllerImpl implements Controller {

    @Autowired
    private Repository repository;

    @Override
    public void sendMessage(Message message) {
        repository.save(message);
    }

    @Override
    public List<Message> getAllMessage() {

        return repository.findAll();
    }

    @Override
    public void deleteMessage(Integer id) {
        repository.deleteById(id);
    }
}
