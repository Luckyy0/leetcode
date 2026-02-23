/*
Problem: 511. Game Play Analysis I
Difficulty: Easy
Description: Find the first login date for each player.
Algorithm: GROUP BY with MIN function.
*/

SELECT 
    player_id, 
    MIN(event_date) AS first_login
FROM 
    Activity
GROUP BY 
    player_id;
