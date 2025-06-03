## Hashing and Bcrypt

**Hashing** is a process in which a function (called a hash function) takes an input (or "message") and returns a fixed-size string of bytes. The output is typically a "digest" that is unique to each unique input. Hashing is commonly used in security to verify the integrity of data, ensuring that the data hasn't been altered.

### Simple Example of Hashing:

Imagine you have a box of files, each labeled with a unique code (hash). When you want to retrieve a specific file, instead of checking every file, you use the code to find it directly.

Let’s say you have a password, “MyPassword123.” You can apply a hash function to it:

1. **Input**: “MyPassword123”
2. **Hash Function**: A mathematical algorithm that processes the input.
3. **Output (Hash)**: A string like “2c1743a391305fbf367df8e4f069f9f9” (this is the hash).

If you later want to check the password, you hash the input again and compare the result with the stored hash. If they match, the password is correct.

### Types of Hashing Algorithms:

1. **MD5 (Message Digest Algorithm 5)**:
    - Produces a 128-bit hash value.
    - Widely used but considered cryptographically broken and unsuitable for further use due to vulnerabilities.
2. **SHA-1 (Secure Hash Algorithm 1)**:
    - Produces a 160-bit hash value.
    - More secure than MD5, but also has been compromised and is no longer recommended for secure applications.
3. **SHA-2 (Secure Hash Algorithm 2)**:
    - Includes SHA-224, SHA-256, SHA-384, and SHA-512.
    - Produces hash values of different lengths (224, 256, 384, and 512 bits).
    - Currently considered secure and widely used in various security protocols.
4. **SHA-3**:
    - A newer standard that provides a similar level of security to SHA-2.
    - Uses a different underlying structure (Keccak).
5. **bcrypt**:
    - Specifically designed for hashing passwords.
    - Includes a work factor to make it computationally expensive, increasing security.
6. **scrypt**:
    - Also used for password hashing.
    - Memory-intensive to prevent attacks using specialized hardware.
7. **Blake2**:
    - Faster than MD5, SHA-1, and SHA-2 while providing security similar to SHA-3.

Hashing is essential in many areas like password storage, data integrity checks, and digital signatures.

Here's a short and practical **tutorial on BCrypt hashing**, including a **minimal code snippet** to demonstrate how it works in a Spring Boot application.

---

## 🔐 BCrypt Hashing 

### ✅ What is BCrypt?

**BCrypt** is a robust, adaptive hashing algorithm for storing passwords securely. It’s part of the **Spring Security** framework and is widely used due to its ability to:

* Add **salt** automatically (to prevent rainbow table attacks)
* Be **slow and computationally expensive** (which protects against brute-force attacks)
* Support a **work factor/strength** parameter to increase complexity over time

---

## 📦 Where is BCrypt used?

* When you **register** a user, you hash the password using BCrypt before saving it in the database.
* During **login**, you hash the incoming password and compare it to the stored hash.

---

## 🧪 Code Example – BCrypt in Action

Add this dependency (if not using Spring Boot Starter Security already):

```xml
<!-- spring-security-core gives access to BCryptPasswordEncoder -->
<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-core</artifactId>
</dependency>
```

### 📌 Password Hashing with BCrypt

```java
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashingExample {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String rawPassword = "mySecret123";
        String hashedPassword = encoder.encode(rawPassword);

        System.out.println("Hashed Password: " + hashedPassword);

        // Verifying the password
        boolean match = encoder.matches("mySecret123", hashedPassword);
        System.out.println("Password match: " + match);
    }
}
```

### 🧠 How Does BCrypt Work?

A typical BCrypt hash looks like this:

```
$2a$10$q4vEeVjYzwxyM3rgY0HbD.aqX0uK/bzgGwwDDbDyPUljvD4rLQX9y
```

**Breakdown:**

* `$2a$` → Algorithm version
* `10$` → Cost factor (2^10 = 1024 iterations)
* The rest → Salt + hashed password

---

## 🛡️ Best Practices

* Always store **hashed passwords**, never raw.
* Set a reasonable strength (e.g., 10–12) depending on system performance.
* Use `matches()` instead of comparing hashes manually.

