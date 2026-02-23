/*
Problem: 570. Managers with at Least 5 Direct Reports
Difficulty: Medium
Description: Find names of managers who have at least 5 reports.
Approach: Group by managerId and Join with the same table to get names.
*/

SELECT 
    m.name
FROM 
    Employee e
JOIN 
    Employee m ON e.managerId = m.id
GROUP BY 
    m.id, m.name
HAVING 
    COUNT(e.id) >= 5;
