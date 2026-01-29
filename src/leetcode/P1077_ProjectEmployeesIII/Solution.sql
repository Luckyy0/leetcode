/* Write your T-SQL query statement below */
WITH RankedEmployees AS (
    SELECT p.project_id, p.employee_id,
           RANK() OVER (PARTITION BY p.project_id ORDER BY e.experience_years DESC) as rnk
    FROM Project p
    JOIN Employee e ON p.employee_id = e.employee_id
)
SELECT project_id, employee_id
FROM RankedEmployees
WHERE rnk = 1;
