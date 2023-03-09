package com.project.alluneed.controller;

import com.project.alluneed.api.MessageApi;
import com.project.alluneed.exception.ResourceNotFoundException;
import com.project.alluneed.model.Message;
import com.project.alluneed.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MessageController implements MessageApi {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public ResponseEntity<List<Message>> getAllMessages() {
        return ResponseEntity.ok(messageService.getAllMessages());
    }

    @Override
    public ResponseEntity<Message> addMessage(Long userId, Message message) {
        Optional<Message> _message = messageService.postMessage(userId, message);
        Message newMessage = _message.orElseThrow(() -> new ResourceNotFoundException("User not found with id = " + userId));
        return ResponseEntity.ok(newMessage);
    }

    @Override
    public ResponseEntity<Message> updateMessage(Long messageId, Message message) {
        Optional<Message> _message = messageService.updateMessage(messageId, message);
        Message newMessage = _message.orElseThrow(() -> new ResourceNotFoundException("Message not found with id = " + messageId));
        return ResponseEntity.ok(newMessage);
    }

    @Override
    public ResponseEntity<HttpStatus> deleteMessage(Long messageId) {
        messageService.deleteMessage(messageId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
