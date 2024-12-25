package org.chat.api.repositories;

import org.chat.api.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Message, Integer> {
}
