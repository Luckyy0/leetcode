-- SQL Solution for P1811
WITH Medalists AS (
    SELECT contest_id, gold_medal AS user_id FROM Contests
    UNION ALL
    SELECT contest_id, silver_medal AS user_id FROM Contests
    UNION ALL
    SELECT contest_id, bronze_medal AS user_id FROM Contests
),
ConsecutiveWinners AS (
    SELECT DISTINCT user_id
    FROM (
        SELECT 
            user_id, 
            contest_id, 
            contest_id - ROW_NUMBER() OVER (PARTITION BY user_id ORDER BY contest_id) as grp
        FROM Medalists
    ) t
    GROUP BY user_id, grp
    HAVING COUNT(*) >= 3
),
GoldWinners AS (
    SELECT gold_medal AS user_id
    FROM Contests
    GROUP BY gold_medal
    HAVING COUNT(*) >= 3
)

SELECT u.name, u.mail
FROM Users u
WHERE u.user_id IN (
    SELECT user_id FROM ConsecutiveWinners
    UNION
    SELECT user_id FROM GoldWinners
);
