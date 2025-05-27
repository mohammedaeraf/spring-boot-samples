## Annotations in Spring Boot

Spring Boot uses various annotations that simplify the configuration, development, and management of Spring applications. Here’s a list of important annotations used in Spring Boot along with their explanations:

### 1. **Core Annotations**

- **`@SpringBootApplication`**
    - Combines `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan` annotations.
    - It marks the main class of a Spring Boot application and triggers the auto-configuration, component scanning, and bean configuration.
- **`@Configuration`**
    - Indicates that the class has `@Bean` definitions and serves as a source of bean definitions for the Spring IoC container.
- **`@ComponentScan`**
    - Tells Spring to scan the package of the annotated class for Spring components like `@Controller`, `@Service`, `@Repository`, etc.
- **`@EnableAutoConfiguration`**
    - Enables Spring Boot’s auto-configuration feature, which automatically configures beans based on the dependencies in the classpath.

### 2. **Stereotype Annotations**

- **`@Component`**
    - Marks a class as a Spring-managed component. It is the most generic stereotype annotation used to define Spring beans.
- **`@Service`**
    - A specialization of `@Component`, used to indicate that a class holds business logic. It is typically used in the service layer.
- **`@Repository`**
    - A specialization of `@Component`, it is used to indicate that the class is a DAO (Data Access Object). It also provides automatic translation of exceptions.
- **`@Controller`**
    - Marks a class as a Spring MVC controller. It is typically used in the presentation layer to handle web requests.
- **`@RestController`**
    - Combines `@Controller` and `@ResponseBody`. It is used to create RESTful web services and returns data directly in the response body.

### 3. **Dependency Injection Annotations**

- **`@Autowired`**
    - Marks a constructor, field, or setter method for dependency injection. Spring automatically injects the required beans into the marked components.
- **`@Qualifier`**
    - Used with `@Autowired` to resolve ambiguity when multiple beans of the same type are present. It helps in specifying which bean should be injected.
- **`@Primary`**
    - Used to mark a bean as the primary bean when multiple beans of the same type exist and are candidates for autowiring.

### 4. **Data Access and JPA Annotations**

- **`@Entity`**
    - Specifies that a class is an entity and is mapped to a database table.
- **`@Table`**
    - Used to specify the table name in the database that the entity is mapped to.
- **`@Id`**
    - Marks a field as the primary key of an entity.
- **`@GeneratedValue`**
    - Specifies how the primary key should be generated, such as using auto-increment or sequences.
- **`@Column`**
    - Specifies the details of the column to which a field should be mapped. It allows customization of column names, nullable constraints, lengths, etc.
- **`@Repository`**
    - Used to define a repository interface that handles data access in Spring Data JPA.

### 5. **Transaction Management Annotations**

- **`@Transactional`**
    - Manages transactions at the method or class level. It ensures that a series of operations occur within a transactional context.

### 6. **Validation Annotations**

- **`@Valid`**
    - Used to validate the annotated object. Typically used in the controller layer to validate request bodies.
- **`@NotNull`, `@Size`, `@Min`, `@Max`, etc.**
    - These are part of the Bean Validation API and are used for validating the fields of a model class.

### 7. **Web and REST Annotations**

- **`@RequestMapping`**
    - Used to map HTTP requests to handler methods of MVC and REST controllers. It can be used at the class level or method level.
- **`@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`**
    - Specialized versions of `@RequestMapping` for handling specific HTTP methods.
- **`@PathVariable`**
    - Binds a method parameter to a URI template variable.
- **`@RequestParam`**
    - Binds a method parameter to a query parameter.
- **`@RequestBody`**
    - Binds the body of the HTTP request to a method parameter.
- **`@ResponseBody`**
    - Indicates that the return value of a method should be written directly to the HTTP response body as JSON or XML.

### 8. **Miscellaneous Annotations**

- **`@Value`**
    - Used to inject values into fields from a property file, environment variables, or command-line arguments.
- **`@Profile`**
    - Used to define beans that should be active only in specific profiles (e.g., `dev`, `test`, `prod`).
- **`@Bean`**
    - Indicates that a method produces a Spring bean to be managed by the Spring container.
- **`@ConditionalOnProperty`, `@ConditionalOnMissingBean`, etc.**
    - These annotations are used for conditional bean registration based on certain conditions, allowing for advanced configuration in Spring Boot applications.

### Conclusion

These annotations allow developers to build Spring Boot applications with minimal configuration and high maintainability. By understanding and using these annotations effectively, you can build robust and scalable applications in Spring Boot.