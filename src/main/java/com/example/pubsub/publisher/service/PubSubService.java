package com.example.pubsub.publisher.service;

import com.example.pubsub.publisher.domain.PubSubMessage;
import com.example.pubsub.publisher.repository.PublisherRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PubSubService {

    @Autowired
    private PublisherRepository publisherRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    public void sendMessage(PubSubMessage message) {
        try {
            publisherRepository.send(objectMapper.writeValueAsString(message));
        } catch (JsonProcessingException e) {
            log.error("..: sendMessage erro na conversão do json", e);
        }
    }
}
