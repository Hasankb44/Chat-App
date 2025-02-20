package org.chat.api.repositories;

import org.chat.api.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}
