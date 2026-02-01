# Spring Boot Message Broker

This project contains basic Spring Boot practices with **RabbitMQ**, **Apache Kafka** and **Apache ActiveMQ** as message broker technologies that are well known and widely used by many Spring Boot developers.

## Key Considerations for Choosing

| **Feature** | **Traditional Brokers** | **Streaming Platforms** |
|---|---|---|
| **Communication Pattern** | Primarily used for asynchronous point-to-point (queues) and publish/subscribe messaging. | Optimized for log-based, fault-tolerant data streams and event sourcing. |
| **Message Durability** | Messages are typically removed from the queue once consumed by a consumer. | Data is persisted in logs for a configurable retention period, allowing multiple consumers to re-read the history of events. |
| **Use Cases** | Task queues, inter-service communication in microservices, reliable delivery of critical messages. | Real-time data processing, event sourcing, log aggregation, and large-scale data ingestion. |

## Spring Boot Integration

Spring Boot simplifies integration with these brokers through dedicated "starters" and auto-configuration. Developers can use specific annotations like `@RabbitListener` or `@KafkaListener` to create message consumers easily, and templates like `RabbitTemplate` or `KafkaTemplate` to send messages. 

For real-time web applications (like chat), Spring Boot also provides native support for **WebSockets** and the **STOMP** (Simple Text Oriented Messaging Protocol) for messaging between clients and the broker. 