/* Write your T-SQL query statement below */
WITH MaxSalaries AS (
    SELECT 
        company_id, 
        MAX(salary) as max_sal
    FROM Salaries
    GROUP BY company_id
)
SELECT 
    s.company_id, 
    s.employee_id, 
    s.employee_name, 
    ROUND(
        CASE 
            WHEN m.max_sal < 1000 THEN s.salary
            WHEN m.max_sal <= 10000 THEN s.salary * 0.76
            ELSE s.salary * 0.51
        END, 0
    ) AS salary
FROM Salaries s
JOIN MaxSalaries m ON s.company_id = m.company_id;
