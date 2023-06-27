package com.example.pubsub.publisher.infrastructure;

import com.example.pubsub.publisher.repository.PublisherRepository;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class PublisherImpl implements PublisherRepository {

    @Value("${pubsub.topics.pubsub-publisher}")
    String topicId;

    @Autowired
    private PubSubTemplate pubSubTemplate;

    @Override
    public void send(String message) {
        //Publisher.newBuilder(topicId).setEnableMessageOrdering(true);
        pubSubTemplate.publish(topicId, message);
    }
}
