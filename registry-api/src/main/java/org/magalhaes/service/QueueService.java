package org.magalhaes.service;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.reactive.messaging.rabbitmq.OutgoingRabbitMQMetadata;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.eclipse.microprofile.reactive.messaging.Metadata;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.magalhaes.entity.Brand;

import java.time.ZonedDateTime;
import java.util.List;

@ApplicationScoped
public class QueueService {

    @Outgoing("brands")
    @Blocking
    @Transactional
    public Message<List<Brand>> sendBrandsToQueue(List<Brand> brands) {
        final OutgoingRabbitMQMetadata metadata = OutgoingRabbitMQMetadata.builder()
                .withHeader("sender", "registry-api")
                .withRoutingKey("urgent")
                .withTimestamp(ZonedDateTime.now())
                .build();

        return Message.of(brands, Metadata.of(metadata));
    }
}
