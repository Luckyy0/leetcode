-- SQL Solution for P1919
SELECT DISTINCT user_id
FROM Adwords
WHERE action = 'Like'
GROUP BY user_id
HAVING COUNT(DISTINCT ad_id) > 1;
