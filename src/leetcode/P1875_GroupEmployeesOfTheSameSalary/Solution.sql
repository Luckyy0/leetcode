-- SQL Solution for P1875
WITH SalaryCounts AS (
    SELECT salary, COUNT(*) as cnt
    FROM Employees
    GROUP BY salary
)
SELECT 
    e.employee_id,
    e.name,
    e.salary,
    DENSE_RANK() OVER (ORDER BY e.salary) as team_id
FROM Employees e
JOIN SalaryCounts sc ON e.salary = sc.salary
WHERE sc.cnt > 1
ORDER BY team_id, e.employee_id;
