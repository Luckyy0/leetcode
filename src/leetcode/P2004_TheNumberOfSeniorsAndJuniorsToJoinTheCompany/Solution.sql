-- SQL Solution for P2004
WITH Seniors AS (
    SELECT employee_id, salary, 
           SUM(salary) OVER (ORDER BY salary, employee_id) AS cum_cost
    FROM Candidates
    WHERE experience = 'Senior'
),
HiredSeniors AS (
    SELECT COUNT(*) AS hires, IFNULL(MAX(cum_cost), 0) AS cost
    FROM Seniors
    WHERE cum_cost <= 70000
),
Juniors AS (
    SELECT employee_id, salary,
           SUM(salary) OVER (ORDER BY salary, employee_id) AS cum_cost
    FROM Candidates
    WHERE experience = 'Junior'
)
SELECT 'Senior' AS experience, hires AS accepted_candidates FROM HiredSeniors
UNION ALL
SELECT 'Junior' AS experience, COUNT(*) AS accepted_candidates
FROM Juniors
WHERE cum_cost <= 70000 - (SELECT cost FROM HiredSeniors);
