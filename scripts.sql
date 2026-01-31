-- 1. Студенты возрастом между 17 и 19
SELECT * FROM student_table WHERE age BETWEEN 17 AND 19;

-- 2. Только имена студентов
SELECT student_name FROM student_table;

-- 3. Студенты, в имени которых есть буква 'О' (или другая)
SELECT * FROM student_table WHERE LOWER(student_name) LIKE '%э%';

-- 4. Студенты, у которых возраст < id
SELECT * FROM student_table WHERE age < id;

-- 5. Студенты, упорядоченные по возрасту
SELECT * FROM student_table ORDER BY age ASC;
