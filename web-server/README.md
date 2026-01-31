# Spring Boot Web Server

This project contains basic Spring Boot web server practices with **Tomcat** as the **default web server** implementation, **Jetty** and **Undertow** as embedded web servers that are well known and widely used by many Spring Boot developers.

The main comparison points generally revolve around performance, footprint, stability, and concurrency model.

## Key Differences and Comparison

| **Feature** | **Tomcat** | **Jetty** | **Undertow** |
|---|---|---|
| **Concurrency Model** | Thread-per-request (traditional) | Event-driven (hybrid) | Event-driven (non-blocking I/O) |
| **Performance** | Reliable, good all-around performance. | Generally good, slightly slower at low load in some tests. | Excellent, especially under high, concurrent loads with virtual threads. |
| **Stability** | Highly stable, mature, and widely adopted; a very safe choice. | Stable and widely used. | Stable, but less battle-tested than Tomcat in some contexts. |
| **Footprint** | Average. | Slightly larger artifact size by default due to JSP compiler. | Very lightweight and small footprint. |
| **Default in Spring Boot** | Yes (default for `spring-boot-starter-web`) | No | No (and not supported in Spring Boot 4+) |

## Detailed Breakdown

- **Tomcat**: The default and most common choice for Spring Boot applications. It is exceptionally stable and widely documented, making it a "just works" option for most general use cases. Its traditional thread-per-request model is straightforward but can be less efficient than event-driven models under extreme loads.
- **Jetty**: Known for being lightweight and embeddable. While its default artifact size can be slightly larger due to bundled JSP support, it offers a solid balance of stability and performance. It uses a hybrid concurrency model.
- **Undertow**: Stands out for its performance, especially in high-concurrency scenarios. It uses a non-blocking, event-driven model which can efficiently handle thousands of connections with a small number of threads.
  - Note: As of Spring Boot 4, Undertow support has been dropped because it is not yet compatible with the required Servlet 6.1 baseline. 

## Which to Choose?

For most applications, the default **Tomcat** server is an excellent, reliable choice. 

If you are building an application with extreme performance or resource constraints (e.g., in a microservice environment where startup time is critical) and are using a Spring Boot version that supports it, **Undertow** might offer performance benefits. 

Spring Boot makes it very easy to switch between them by simply excluding the default Tomcat dependency and including the desired alternative in your Maven or Gradle configuration. 