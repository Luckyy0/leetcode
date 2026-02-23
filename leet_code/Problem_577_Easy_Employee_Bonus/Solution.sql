/*
Problem: 577. Employee Bonus
Difficulty: Easy
Description: Find employees with bonus < 1000 or no bonus.
Approach: Use LEFT JOIN and handle NULL cases explicitly.
*/

SELECT 
    e.name, 
    b.bonus
FROM 
    Employee e
LEFT JOIN 
    Bonus b ON e.empId = b.empId
WHERE 
    b.bonus < 1000 
    OR b.bonus IS NULL;
