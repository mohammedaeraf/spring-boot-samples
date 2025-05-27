-- DDL (Data Definition Language)
-- Create the 'courses' table in the 'fla' schema
CREATE TABLE `fla`.`courses` (
  `id` INT NOT NULL,
  `title` VARCHAR(100) NOT NULL,
  `duration` INT NOT NULL,
  `description` VARCHAR(300) NULL,
  PRIMARY KEY (`id`)
);

-- DML (Data Manipulation Language)
-- Insert sample course records into the 'courses' table

INSERT INTO fla.courses (id, title, duration, description) 
VALUES 
  (1, 'React Frontend', 60, 'Frontend Web Development using React and JavaScript');

INSERT INTO fla.courses (id, title, duration, description) 
VALUES 
  (2, 'Advanced Excel', 30, 'Advanced Excel');

INSERT INTO fla.courses (id, title, duration) 
VALUES 
  (3, 'Advanced Web Design', 60);

INSERT INTO fla.courses (id, title, duration) 
VALUES 
  (4, 'ChatGPT', 30);

INSERT INTO fla.courses (id, title, duration) 
VALUES 
  (5, 'Graphic Design using Canva', 30);

-- Update an existing course
-- Change the duration and title for the course with id = 1
UPDATE fla.courses 
SET 
  duration = 70, 
  title = 'Frontend Web Development with React JS'
WHERE id = 1;

-- Delete a course
-- Remove the course with id = 4 from the table
DELETE FROM fla.courses 
WHERE id = 4;

-- Queries (DQL - Data Query Language)

-- 1. Select all columns from all courses
SELECT * FROM fla.courses;

-- 2. Select courses with duration greater than 30
SELECT id, title, duration 
FROM fla.courses 
WHERE duration > 30;

-- 3. Select courses with 'Design' in the title and duration greater than 30
SELECT id, title, duration 
FROM fla.courses 
WHERE title LIKE '%Design%' AND duration > 30;

-- 4. Select courses with duration between 30 and 60 (inclusive) using >= and <=
SELECT id, title, duration 
FROM fla.courses 
WHERE duration >= 30 AND duration <= 60;

-- 5. Select courses with duration between 30 and 60 (inclusive) using BETWEEN
SELECT id, title, duration 
FROM fla.courses 
WHERE duration BETWEEN 30 AND 60;

-- 6. Select courses with specific ids (1, 2, or 4)
SELECT id, title, duration 
FROM fla.courses 
WHERE id IN (1, 2, 4);