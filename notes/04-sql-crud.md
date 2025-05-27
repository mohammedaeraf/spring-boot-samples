## 🔍 **SQL Tutorial: CRUD with `fla.courses` Table**

### 🗂 Table Structure

```sql
CREATE TABLE fla.courses (
  id INT NOT NULL,
  title VARCHAR(100) NOT NULL,
  duration INT NOT NULL, -- in hours
  description VARCHAR(300),
  PRIMARY KEY (id)
);
```

---

## ✅ **1. INSERT (Create)**

Insert new records into the `fla.courses` table:

```sql
INSERT INTO fla.courses (id, title, duration, description)
VALUES
(101, 'Java Full Stack', 120, 'Covers Java, Spring Boot, Angular, MySQL'),
(102, 'Python for Data Science', 100, 'Python, Pandas, NumPy, ML basics'),
(103, 'AWS Cloud Basics', 40, 'Intro to AWS services'),
(104, 'Canva Graphic Design', 30, 'Design social media graphics using Canva');
```

---

## 🔍 **2. SELECT (Read)**

Retrieve all records from the table:

```sql
SELECT * FROM fla.courses;
```

Retrieve specific columns:

```sql
SELECT id, title, duration FROM fla.courses;
```

---

## 🔎 **3. WHERE Clause (Filter Data)**

Filter courses with duration greater than 50 hours:

```sql
SELECT * FROM fla.courses
WHERE duration > 50;
```

Filter a course by title:

```sql
SELECT * FROM fla.courses
WHERE title = 'AWS Cloud Basics';
```

---

## 📝 **4. UPDATE (Modify Data)**

Update the duration of a course:

```sql
UPDATE fla.courses
SET duration = 45
WHERE id = 103;
```

Update description:

```sql
UPDATE fla.courses
SET description = 'Beginner-level AWS course'
WHERE title = 'AWS Cloud Basics';
```

---

## 🗑️ **5. DELETE (Remove Data)**

Delete a course by `id`:

```sql
DELETE FROM fla.courses
WHERE id = 104;
```

Delete all courses with duration less than 40 hours:

```sql
DELETE FROM fla.courses
WHERE duration < 40;
```

---

## 📊 **6. ORDER BY (Sort Data)**

Sort courses by duration (ascending):

```sql
SELECT * FROM fla.courses
ORDER BY duration ASC;
```

Sort by title (descending):

```sql
SELECT * FROM fla.courses
ORDER BY title DESC;
```

---

## ✅ Summary of Keywords Used

| Operation | SQL Keyword(s)              |
| --------- | --------------------------- |
| Create    | `INSERT INTO`               |
| Read      | `SELECT`, `WHERE`           |
| Update    | `UPDATE`, `SET`, `WHERE`    |
| Delete    | `DELETE FROM`, `WHERE`      |
| Sort      | `ORDER BY`                  |
| Filter    | `WHERE`, logical conditions |
