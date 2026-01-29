-- Problem 511: Game Play Analysis I
-- Approach: Group by and Minimum Aggregate

SELECT 
    player_id, 
    MIN(event_date) AS first_login
FROM 
    Activity
GROUP BY 
    player_id;
