/* Write your T-SQL query statement below */
WITH UserSpending AS (
    SELECT spend_date, user_id, 
           CASE 
               WHEN COUNT(DISTINCT platform) = 2 THEN 'both'
               ELSE MAX(platform) 
           END AS platform,
           SUM(amount) AS total_amount
    FROM Spending
    GROUP BY spend_date, user_id
),
AllDates AS (
    SELECT DISTINCT spend_date FROM Spending
),
AllPlatforms AS (
    SELECT 'desktop' AS platform UNION SELECT 'mobile' UNION SELECT 'both'
),
Skeleton AS (
    SELECT d.spend_date, p.platform
    FROM AllDates d CROSS JOIN AllPlatforms p
)
SELECT 
    s.spend_date, 
    s.platform, 
    ISNULL(SUM(u.total_amount), 0) AS total_amount, 
    COUNT(u.user_id) AS total_users
FROM Skeleton s
LEFT JOIN UserSpending u 
    ON s.spend_date = u.spend_date AND s.platform = u.platform
GROUP BY s.spend_date, s.platform;
