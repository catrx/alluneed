package com.project.alluneed.service;

import com.project.alluneed.model.Message;
import com.project.alluneed.repository.MessageRepository;
import com.project.alluneed.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MessageService {

    private final MessageRepository messageRepository;

    private final UserRepository userRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository, UserRepository usersRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = usersRepository;
    }

    public Optional<Message> postMessage(Long userId, Message message) {
        Optional<Message> _message = userRepository.findById(userId).map(user -> {
            message.setUser(user);
            return messageRepository.save(message);
        });

        return _message;
    }

    public Optional<Message> updateMessage(Long messageId, Message message) {
        Optional<Message> _message = messageRepository.findById(messageId);
        if(_message.isPresent()) {
            _message.get().setContent(message.getContent());
            messageRepository.save(_message.get());
        }
        return _message;
    }

    public void deleteMessage(Long messageId) {
        messageRepository.deleteById(messageId);
    }

    public List<Message> getAllMessages() {
        return this.messageRepository.findAll();
    }
}
