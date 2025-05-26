# **Relationships in Database Tables**

In a database, **relationships** define how records in different tables are connected. They help maintain data integrity and prevent duplication while making retrieval efficient.

## **Types of Relationships in Databases**

### **1. One-to-One (1:1) Relationship**
Each record in one table is associated with exactly one record in another table.
#### **Example: User & Profile**
- **Users Table**: Each user has a unique ID.
- **Profiles Table**: Each user has a single profile, and each profile belongs to one user.
```sql
CREATE TABLE Users (
    UserID INT PRIMARY KEY,
    Name VARCHAR(100)
);

CREATE TABLE Profiles (
    ProfileID INT PRIMARY KEY,
    UserID INT UNIQUE,
    Bio TEXT,
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
);
```

### **2. One-to-Many (1:M) Relationship**
Each record in one table can be linked to multiple records in another table.
#### **Example: Customers & Orders**
- **Customers Table**: Each customer has a unique ID.
- **Orders Table**: Each order belongs to only one customer, but a customer can have multiple orders.

### **3. Many-to-Many (M:M) Relationship**
Each record in one table can be linked to multiple records in another table, and vice versa. This usually requires a **junction table**.
#### **Example: Students & Courses**
- **Students Table**: Each student can enroll in multiple courses.
- **Courses Table**: Each course can have multiple students.
- **Student_Course Table** (junction table): Stores which student is enrolled in which course.
```sql
CREATE TABLE Students (
    StudentID INT PRIMARY KEY,
    Name VARCHAR(100)
);

CREATE TABLE Courses (
    CourseID INT PRIMARY KEY,
    CourseName VARCHAR(100)
);

CREATE TABLE Student_Course (
    StudentID INT,
    CourseID INT,
    PRIMARY KEY (StudentID, CourseID),
    FOREIGN KEY (StudentID) REFERENCES Students(StudentID),
    FOREIGN KEY (CourseID) REFERENCES Courses(CourseID)
);
```

### **4. Self-Referencing Relationship**
A record in a table can be linked to another record within the same table.
#### **Example: Employees & Managers**
- **Employees Table**: Each employee has a unique ID.
- **ManagerID Column**: Stores the ID of the employee’s manager.
```sql
CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY,
    Name VARCHAR(100),
    ManagerID INT,
    FOREIGN KEY (ManagerID) REFERENCES Employees(EmployeeID)
);
```

### **Why Do You Need Relationships in Databases?**
- **Data Integrity** 🎯  
  - Prevents **orphaned records** (e.g., an order shouldn't exist without a customer).  
- **Avoids Duplication** 🔄  
  - Saves storage and maintains consistency (no need to repeat customer details for each order).  
- **Efficient Queries** ⚡  
  - Enables powerful **JOIN operations** to fetch related data seamlessly.  
- **Better Scalability** 🚀  
  - Well-structured relationships allow databases to **scale efficiently** over time.
