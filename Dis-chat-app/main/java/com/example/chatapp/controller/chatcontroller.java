package com.example.chatapp.controller;

import com.example.chatapp.model.ChatMessage;
import com.example.chatapp.model.LoginRequest;
import com.example.chatapp.model.User;
import com.example.chatapp.model.UserRegistrationRequest;
import com.example.chatapp.service.MessageService;
import com.example.chatapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserRegistrationRequest request) {
        User user = userService.registerUser(request.getUsername(), request.getPassword());
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        User user = userService.authenticateUser(request.getUsername(), request.getPassword());
        if (user != null) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }

    @PostMapping("/send")
    public ResponseEntity<Void> sendMessage(@RequestBody ChatMessage message) {
        messageService.sendMessage(message);
        return ResponseEntity.ok().build();
    }
}