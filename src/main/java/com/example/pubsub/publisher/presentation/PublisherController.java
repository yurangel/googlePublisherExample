package com.example.pubsub.publisher.presentation;

import com.example.pubsub.publisher.domain.PubSubMessage;
import com.example.pubsub.publisher.service.PubSubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherController {

    @Autowired
    private PubSubService pubSubService;

    @PostMapping("/pubsub")
    public ResponseEntity<Void> sendMessage(@RequestBody PubSubMessage message) {
        pubSubService.sendMessage(message);
        return ResponseEntity.ok().build();
    }
}
