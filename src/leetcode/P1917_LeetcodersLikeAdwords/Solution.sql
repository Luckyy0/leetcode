-- SQL Solution for P1917 (Placeholder based on title)
-- Assumed structure: Adwords(ad_id, user_id, action)
SELECT 
    ad_id,
    COUNT(DISTINCT user_id) AS unique_users
FROM Adwords
WHERE action = 'Like' -- Or 'Click'
GROUP BY ad_id
ORDER BY ad_id;
