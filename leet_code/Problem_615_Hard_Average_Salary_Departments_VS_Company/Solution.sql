/*
Problem: 615. Average Salary: Departments VS Company
Difficulty: Hard
Description: Compare monthly department average salary with monthly company average salary.
Approach: Use window functions to compute dept_avg and company_avg in one pass.
*/

WITH SalaryData AS (
    SELECT 
        s.amount,
        DATE_FORMAT(s.pay_date, '%Y-%m') AS pay_month,
        e.department_id
    FROM 
        Salary s
    JOIN 
        Employee e ON s.employee_id = e.employee_id
),
Averages AS (
    SELECT DISTINCT
        pay_month,
        department_id,
        -- Average for the department in that month
        AVG(amount) OVER(PARTITION BY pay_month, department_id) AS dept_avg,
        -- Average for the whole company in that month
        AVG(amount) OVER(PARTITION BY pay_month) AS company_avg
    FROM 
        SalaryData
)
SELECT 
    pay_month,
    department_id,
    CASE 
        WHEN dept_avg > company_avg THEN 'higher'
        WHEN dept_avg < company_avg THEN 'lower'
        ELSE 'same'
    END AS comparison
FROM 
    Averages
ORDER BY 
    pay_month DESC, department_id;
