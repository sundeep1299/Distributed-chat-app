package com.example.chatapp.service;

import com.example.chatapp.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private KafkaTemplate<String, ChatMessage> kafkaTemplate;

    public void sendMessage(ChatMessage message) {
        kafkaTemplate.send("chat-messages", message);
    }

    @KafkaListener(topics = "chat-messages", groupId = "chat-group")
    public void receiveMessage(ChatMessage message) {
        // Process received message (e.g., save to database, send notification)
        System.out.println("Received message: " + message.getContent() + " from " + message.getSender() + " to "
                + message.getRecipient());
    }
}