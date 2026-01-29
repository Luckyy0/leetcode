/* Improved logic */
WITH DailySum AS (
    SELECT visited_on, SUM(amount) as amount
    FROM Customer
    GROUP BY visited_on
),
Stats AS (
    SELECT 
        d1.visited_on, 
        SUM(d2.amount) as amount,
        ROUND(SUM(d2.amount) / 7.0, 2) as average_amount
    FROM DailySum d1, DailySum d2
    WHERE d2.visited_on BETWEEN DATEADD(day, -6, d1.visited_on) AND d1.visited_on
    GROUP BY d1.visited_on
)
SELECT * FROM Stats
WHERE visited_on >= DATEADD(day, 6, (SELECT MIN(visited_on) FROM Customer))
ORDER BY visited_on;
