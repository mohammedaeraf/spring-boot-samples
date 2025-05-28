## Bidirectional Relationships in Spring Boot / Spring Data JPA

This tutorial demonstrates how to implement and manage a **bidirectional relationship** between `Employee` and `Department` entities in a Spring Boot application. It includes an explanation of the key annotations, their usage, and considerations for performance and serialization.

---

### **Overview**

- **Bidirectional Relationship**: Both entities have references to each other.
  - `Employee` references `Department`.
  - `Department` references a list of `Employee` entities.
- Use cases:
  - Fetch `Department` along with its `Employee`s.
  - Fetch an `Employee` and its associated `Department`.

---

### **Step-by-Step Implementation**

### 1. **Project Setup**

Include the following dependencies in your `pom.xml` or `build.gradle`:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
</dependency>

```

---

### 2. **Database Configuration**

Use an in-memory H2 database for testing. Add the following in `application.properties`:

```
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true

```

---

### 3. **Entities**

### **Department Entity**

```java
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Employee> employees;

    // Getters and Setters
}

```

**Explanation of Annotations:**

1. **`@Entity`**: Marks this class as a JPA entity.
2. **`@Id` & `@GeneratedValue`**: Denote the primary key and auto-generate its value.
3. **`@OneToMany(mappedBy = "department")`**:
   - Specifies the **one-to-many relationship**.
   - `mappedBy` indicates the field in the `Employee` entity that maps this relationship.
4. **`cascade = CascadeType.ALL`**: Propagates operations like persist, merge, and remove to associated `Employee` entities.
5. **`orphanRemoval = true`**: Deletes orphaned `Employee` entities when removed from the list.
6. **`@JsonManagedReference`**:
   - Prevents circular reference issues during JSON serialization.
   - Indicates the parent side of the relationship.

---

### **Employee Entity**

```java
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    @JsonBackReference
    private Department department;

    // Getters and Setters
}

```

**Explanation of Annotations:**

1. **`@ManyToOne(fetch = FetchType.LAZY)`**:
   - Specifies the **many-to-one relationship**.
   - `FetchType.LAZY`: Fetches the associated `Department` only when explicitly accessed.
2. **`@JoinColumn(name = "department_id")`**:
   - Maps this field to the `department_id` column in the database.
   - Ensures a foreign key constraint in the `Employee` table.
3. **`@JsonBackReference`**:
   - Prevents JSON serialization of the `department` field.
   - Indicates the child side of the relationship.

---

### 4. **Repository Layer**

```java
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

```

---

### 5. **Service Layer**

```java
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
}

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}

```

---

### 6. **Controller Layer**

```java
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }
}

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}

```

---

### **Testing the API**

### **Adding Data**

1. Create a department using the `/api/departments` POST endpoint.

   ```json
   {
     "name": "IT"
   }
   ```

2. Create employees using the `/api/employees` POST endpoint:

   ```json
   {
     "name": "John Doe",
     "department": {
       "id": 1
     }
   }
   ```

### **Fetching Data**

- Fetch all departments with their employees: `/api/departments`.
- Fetch all employees with their department: `/api/employees`.

---

### **Key Considerations**

- Use `FetchType.LAZY` to prevent unnecessary data loading.
- Ensure proper cascade settings for relationship management.
- Handle circular references in JSON using `@JsonManagedReference` and `@JsonBackReference`.

This setup provides a robust and efficient bidirectional relationship between `Employee` and `Department.`
