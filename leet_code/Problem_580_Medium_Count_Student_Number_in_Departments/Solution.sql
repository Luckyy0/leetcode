/*
Problem: 580. Count Student Number in Departments
Difficulty: Medium
Description: Count students per department, including those with zero students.
Approach: Use LEFT JOIN from Department to Student and COUNT(student_id).
*/

SELECT 
    d.dept_name, 
    COUNT(s.student_id) as student_number
FROM 
    Department d
LEFT JOIN 
    Student s ON d.dept_id = s.dept_id
GROUP BY 
    d.dept_id, d.dept_name
ORDER BY 
    student_number DESC, 
    d.dept_name ASC;
