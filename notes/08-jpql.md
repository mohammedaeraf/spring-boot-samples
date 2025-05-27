## **JPQL**

JPQL is a query language used in JPA (Java Persistence API) for interacting with databases. It is object-oriented and works with entity objects rather than directly dealing with database tables. JPQL queries resemble SQL, but instead of referring to table names and columns, they reference entity names and their attributes.

### **Key Features of JPQL**

1. **Object-Oriented**: Queries are written based on entity objects, not tables.
2. **Portable**: Works across different databases as it is not tied to SQL dialects.
3. **Powerful**: Supports joins, filtering, grouping, and sorting.
4. **Type-Safe**: Parameters in JPQL queries can use Java types.

---

### **Basic Syntax of JPQL**

A typical JPQL query consists of:

- **SELECT Clause**: Specifies the fields to retrieve.
- **FROM Clause**: Refers to entity objects.
- **WHERE Clause**: Filters results.
- **ORDER BY Clause**: Specifies sorting.

Example:

```java
SELECT e FROM Employee e WHERE e.salary > 50000

```

Here, `Employee` is the entity, and `e.salary` is its attribute.

---

### **JPQL Examples**

### 1. **Basic SELECT Query**

Fetch all employees:

```java
SELECT e FROM Employee e

```

Fetch specific fields:

```java
SELECT e.name, e.salary FROM Employee e

```

---

### 2. **WHERE Clause**

Filter employees with a salary greater than 50,000:

```java
SELECT e FROM Employee e WHERE e.salary > 50000

```

---

### 3. **JOIN Query**

Fetch all departments along with their employees:

```java
SELECT d FROM Department d JOIN d.employees e

```

---

### 4. **ORDER BY Clause**

Sort employees by salary in descending order:

```java
SELECT e FROM Employee e ORDER BY e.salary DESC

```

---

### 5. **LIKE and BETWEEN**

Find employees whose name starts with 'J':

```java
SELECT e FROM Employee e WHERE e.name LIKE 'J%'

```

Find employees with salaries between 30,000 and 60,000:

```java
SELECT e FROM Employee e WHERE e.salary BETWEEN 30000 AND 60000

```

**Find Products of a particular brand and within a price range**

```java
    @Query("SELECT p FROM Product p WHERE p.brand = :brand AND p.price BETWEEN :minPrice AND :maxPrice ORDER BY p.price")
    List<Product> getProductsByBrandPrice(String brand, int minPrice, int maxPrice);
```

---

### **JPQL vs SQL**

| Aspect | JPQL | SQL |
| --- | --- | --- |
| Operates on | Entity objects | Database tables |
| Query example | `SELECT e FROM Employee e` | `SELECT * FROM employee` |
| Object-Oriented | Yes | No |
| Parameters | Java types | Database-specific types
 |