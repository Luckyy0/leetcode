/* Write your T-SQL query statement below */
WITH AllDates AS (
    SELECT fail_date AS date, 'failed' AS period_state
    FROM Failed
    WHERE fail_date BETWEEN '2019-01-01' AND '2019-12-31'
    UNION ALL
    SELECT success_date AS date, 'succeeded' AS period_state
    FROM Succeeded
    WHERE success_date BETWEEN '2019-01-01' AND '2019-12-31'
),
Ranked AS (
    SELECT 
        period_state, 
        date, 
        ROW_NUMBER() OVER (PARTITION BY period_state ORDER BY date) as rn
    FROM AllDates
),
Groups AS (
    SELECT 
        period_state, 
        date, 
        DATEADD(day, -rn, date) as grp
    FROM Ranked
)
SELECT 
    period_state, 
    MIN(date) AS start_date, 
    MAX(date) AS end_date
FROM Groups
GROUP BY period_state, grp
ORDER BY start_date;
