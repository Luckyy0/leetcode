/*
# 580. Count Student Number in Departments

Table: Student
+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| student_id   | int     |
| student_name | varchar |
| gender       | varchar |
| dept_id      | int     |
+--------------+---------+
student_id is the primary key column for this table.
dept_id is a foreign key to dept_id in the Department tables.
Each row of this table indicates the name of a student, their gender, and the id of their department.

Table: Department
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| dept_id     | int     |
| dept_name   | varchar |
+-------------+---------+
dept_id is the primary key column for this table.
Each row of this table contains the id and the name of a department.

Write an SQL query to report the respective department name and number of students majoring in each department for all departments in the Department table (even ones with no students).
*/

/*
SELECT 
    D.dept_name, 
    COUNT(S.student_id) AS student_number
FROM 
    Department D
LEFT JOIN 
    Student S 
ON 
    D.dept_id = S.dept_id
GROUP BY 
    D.dept_name
ORDER BY 
    student_number DESC, 
    D.dept_name ASC;
*/
