# Spring Boot Data Access

This project contains basic Spring Boot data access practices with **Spring Data JPA** and **MyBatis** as frameworks that are well known and widely used by many Spring Boot developers.

## Key Differences and Comparison

| **Feature** | **Spring Data JPA** | **MyBatis** |
|---|---|---|
| **Approach** | Object-centric (ORM) | SQL-centric (Data Mapper) |
| **SQL Generation** | Automatically generates SQL based on entity mappings and method names | Requires developers to write and manage SQL manually in XML or annotations |
| **Boilerplate Code** | Greatly reduced; provides built-in CRUD operations via repository interfaces | More manual configuration and code is needed, though less than plain JDBC |
| **Control** | Less direct control over generated SQL | Full, fine-grained control over SQL queries, which is beneficial for complex scenarios and performance tuning |
| **Learning Curve** | Easier for standard CRUD operations; concepts like persistence context and entity management require deeper understanding for complex scenarios | Potentially steeper for basic CRUD but straightforward for those who prefer working directly with SQL |
| **Mapping** | Maps Java objects to database tables using annotations (e.g., `@Entity`, `@Id`) | Maps SQL statements to Java objects (POJOs) using XML files or annotations |

## When to use which

**Spring Data JPA is generally the better choice for:** 
- **Standard CRUD operations** and simple queries.
- Applications where developers prefer working with objects and do not want to manage SQL manually.
- Projects aiming to reduce boilerplate code and speed up initial development.
- Enterprise applications where a consistent, high-level abstraction is valuable. 

**MyBatis is often preferred for:**
- **Complex or performance-critical queries** where precise SQL tuning is necessary.
- Working with legacy systems that rely on existing, intricate SQL or stored procedures.
- Teams that prefer keeping SQL separate from Java code (in XML files) and have strong SQL expertise.
- Scenarios where only specific fields need to be selected, optimizing performance for large datasets. 

Ultimately, the best approach for many real-world applications is a **hybrid strategy**, using Spring Data JPA for standard entity management and basic queries, and MyBatis for the complex, performance-critical database operations.