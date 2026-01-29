-- SQL Solution for P2010
WITH Seniors AS (
    SELECT employee_id, salary, 
           SUM(salary) OVER (ORDER BY salary, employee_id) AS cum_cost
    FROM Candidates
    WHERE experience = 'Senior'
),
HiredSeniors AS (
    SELECT employee_id, salary, cum_cost
    FROM Seniors
    WHERE cum_cost <= 70000
),
SeniorCost AS (
    SELECT IFNULL(MAX(cum_cost), 0) AS cost FROM HiredSeniors
),
Juniors AS (
    SELECT employee_id, salary,
           SUM(salary) OVER (ORDER BY salary, employee_id) AS cum_cost
    FROM Candidates
    WHERE experience = 'Junior'
)
SELECT employee_id
FROM HiredSeniors
UNION ALL
SELECT employee_id
FROM Juniors
WHERE cum_cost <= 70000 - (SELECT cost FROM SeniorCost);
