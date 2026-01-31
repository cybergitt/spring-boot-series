# Spring Boot Logging

This project contains basic Spring Boot logging practices with **SLF4J** as an abstraction layer and **Logback** as the **default logging** implementation, advanced techniques like AOP and MDC, and performance optimization strategies. We also implement the use of the **Log4j2** library without significantly changing the underlying application code.

## Key Differences and Comparison

| **Feature** | **Spring Boot Default (Logback)** | **Log4j2** |
|---|---|---|
| **Default in Spring Boot?** | Yes, included by default in all starter POMs. | No, requires explicit configuration to enable. |
| **Performance** | Good for general use, but slower under high load compared to Log4j2. | Superior, especially for asynchronous logging, due to the use of the LMAX Disruptor library, offering higher throughput and lower latency. |
| **Configuration** | Simple configuration via `application.properties` or `logback-spring.xml`. | Highly flexible, supports various formats (XML, JSON, YAML) and automatic reloading. |
| **Appenders** | Standard appenders (console, file). | Wide range of appenders available (HTTP, Kafka, Cassandra, etc.). |
| **Lazy Logging** | Supports lazy evaluation of log statements, but Log4j2's implementation is often cited for its efficiency. | Offers lazy evaluation with lambda expressions and a garbage-free mode to minimize garbage collection overhead. |

## When to Choose Which?

- **Stick with the default Logback** for most general-purpose applications where simplicity and zero-configuration are preferred. The default setup works well and is sufficient for typical logging needs.
- **Switch to Log4j2** if logging performance is critical for your application (e.g., high-throughput systems), or if you need advanced features like asynchronous loggers, specific appenders, or JSON-based configuration.

## How to Switch to Log4j2

To use Log4j2 in a Spring Boot project, you need to exclude the default logging dependency (`spring-boot-starter-logging`) and include the Log4j2 starter instead: 
1. **Exclude** `spring-boot-starter-logging` from your main `spring-boot-starter-web` or other starter dependencies.
2. **Add** the `spring-boot-starter-log4j2` dependency to your `pom.xml` or `build.gradle` file. 