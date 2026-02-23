/*
Problem: 596. Classes More Than 5 Students
Difficulty: Easy
Description: Find classes with at least 5 students.
Approach: Use GROUP BY and HAVING COUNT(*) to filter groups.
*/

SELECT 
    class
FROM 
    Courses
GROUP BY 
    class
HAVING 
    COUNT(student) >= 5;
