## 🌐 Understanding CORS and Disabling It in Spring Boot

### What is CORS?

**CORS (Cross-Origin Resource Sharing)** is a security feature implemented by web browsers to restrict web pages from making requests to a different domain than the one that served the web page.

For example, if your front-end app (running on `http://localhost:3000`) tries to make an API request to `http://localhost:8080/api/products`, the browser may **block the request** unless the backend explicitly allows it using CORS headers.

### Why does CORS exist?

CORS helps **prevent malicious scripts** from accessing resources they shouldn't. However, during development, it often causes frustration when your API rejects requests from your frontend running on a different port or origin.

---

## 🛑 How to Disable CORS in Spring Boot

⚠️ **Warning:** Disabling CORS is **not recommended in production**, but it can be useful for local development or testing.

### Option 1: Disable CORS Globally using WebMvcConfigurer

```java
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // Allow all origins
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}
```

This disables CORS protection for **all endpoints** in your Spring Boot application.

---

### Option 2: Configure CORS per Controller

```java
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // Allow all origins for this controller
public class ProductController {

    @GetMapping("/products")
    public List<Product> getProducts() {
        // return product list
    }
}
```

This disables CORS **only for specific endpoints or controllers** using `@CrossOrigin`.

---

### Option 3: Disable CORS in Spring Security

If you’re using **Spring Security**, you need to explicitly allow CORS:

```java
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .cors().and() // enable CORS
        .csrf().disable()
        .authorizeHttpRequests()
        .anyRequest().permitAll();

    return http.build();
}

@Bean
public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration config = new CorsConfiguration();
    config.setAllowedOrigins(List.of("*"));
    config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
    config.setAllowedHeaders(List.of("*"));

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", config);
    return source;
}
```

---

## ✅ Summary

| Action             | Use When                                              |
| ------------------ | ----------------------------------------------------- |
| `@CrossOrigin`     | For per-controller or per-method config               |
| `WebMvcConfigurer` | For global CORS configuration                         |
| Spring Security    | If security is enabled, CORS must be handled here too |

---

## 📌 Best Practice

Instead of disabling CORS altogether (`*`), **allow only specific trusted domains** in production, such as:

```java
.allowedOrigins("https://myfrontend.com")
```
