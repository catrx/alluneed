package com.project.alluneed.api;

import com.project.alluneed.model.Message;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping()
public interface MessageApi {

    @GetMapping("/messages")
    ResponseEntity<List<Message>> getAllMessages() throws ParseException;

    @PostMapping("/users/{userId}/messages")
    ResponseEntity<Message> addMessage(@PathVariable("userId") Long userId, @RequestBody Message message) throws ParseException;

    @PutMapping("/messages/{messageId}")
    ResponseEntity<Message> updateMessage(@PathVariable("messageId") Long messageId, @RequestBody Message message) throws ParseException;

    @DeleteMapping("/messages/{messageId}")
    ResponseEntity<HttpStatus> deleteMessage(@PathVariable("messageId") Long messageId) throws ParseException;
}
