/* Write your T-SQL query statement below */
SELECT 
    employee_id,
    COUNT(employee_id) OVER (PARTITION BY team_id) as team_size
FROM Employee;
