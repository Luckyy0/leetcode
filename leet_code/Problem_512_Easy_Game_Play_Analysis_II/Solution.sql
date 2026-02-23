/*
Problem: 512. Game Play Analysis II
Difficulty: Easy
Description: Find the device ID for the first login date for each player.
Algorithm: Subquery with IN clause to filter for (player_id, min_date) tuples.
*/

SELECT 
    player_id, 
    device_id
FROM 
    Activity
WHERE 
    (player_id, event_date) IN (
        SELECT 
            player_id, 
            MIN(event_date)
        FROM 
            Activity
        GROUP BY 
            player_id
    );
