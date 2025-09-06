package com.nakarmi.mcq.controller;

import com.nakarmi.mcq.entity.MessageDocument;
import com.nakarmi.mcq.repository.MessageRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("josephnakarmi")
public class WebsiteController {

    @Autowired
    private MessageRepository messageRepository;

    @PostMapping("message")
    public ResponseEntity<String> postMessage(@RequestBody Map<String, String> request) {
        log.info("postMessage request: {}", request);
        String message = request.get("message");
        String name = request.get("name");
        String email = request.get("email");

        MessageDocument messageDocument = new MessageDocument();
        messageDocument.setName(name);
        messageDocument.setMessage(message);
        messageDocument.setEmail(email);
        messageRepository.save(messageDocument);
        return ResponseEntity.ok("message submitted successfully");
    }
}

