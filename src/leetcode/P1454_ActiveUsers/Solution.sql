/* Write your T-SQL query statement below */
WITH LoginDates AS (
    SELECT DISTINCT id, login_date
    FROM Logins
),
Ranked AS (
    SELECT 
        id, 
        login_date,
        DATEADD(day, -DENSE_RANK() OVER (PARTITION BY id ORDER BY login_date), login_date) AS grp
    FROM LoginDates
),
ActiveGroups AS (
    SELECT id, grp
    FROM Ranked
    GROUP BY id, grp
    HAVING COUNT(*) >= 5
)
SELECT DISTINCT a.id, a.name
FROM Accounts a
JOIN ActiveGroups g ON a.id = g.id
ORDER BY a.id;
