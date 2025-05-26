-- Part 1: Many-to-Many (M:M) Relationship

-- 1. Create Tables
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

-- 2. Populate Tables
INSERT INTO Students VALUES (1, 'Alice'), (2, 'Bob'), (3, 'Charlie');
INSERT INTO Courses VALUES (101, 'Math'), (102, 'Science'), (103, 'History');
INSERT INTO Student_Course VALUES
    (1, 101), (1, 102),
    (2, 101), (2, 103),
    (3, 102), (3, 103);

-- 3. JOIN Queries

-- List all students with the courses they are enrolled in
SELECT s.Name AS Student, c.CourseName AS Course
FROM Students s
JOIN Student_Course sc ON s.StudentID = sc.StudentID
JOIN Courses c ON sc.CourseID = c.CourseID
ORDER BY s.Name;

-- List all courses with the students enrolled in each course
SELECT c.CourseName AS Course, s.Name AS Student
FROM Courses c
JOIN Student_Course sc ON c.CourseID = sc.CourseID
JOIN Students s ON sc.StudentID = s.StudentID
ORDER BY c.CourseName;

-- Part 2: Self-Referencing Relationship

-- 1. Create Table
CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY,
    Name VARCHAR(100),
    ManagerID INT,
    FOREIGN KEY (ManagerID) REFERENCES Employees(EmployeeID)
);

-- 2. Populate Table
INSERT INTO Employees VALUES
    (1, 'Emma', NULL),      -- Top-level manager
    (2, 'Liam', 1),
    (3, 'Olivia', 1),
    (4, 'Noah', 2),
    (5, 'Ava', 2);

-- 3. JOIN Queries

-- List all employees with their manager's name
SELECT e.Name AS Employee, m.Name AS Manager
FROM Employees e
LEFT JOIN Employees m ON e.ManagerID = m.EmployeeID;

-- List all managers and the employees who report to them
SELECT m.Name AS Manager, e.Name AS Employee
FROM Employees m
JOIN Employees e ON e.ManagerID = m.EmployeeID
ORDER BY m.Name;