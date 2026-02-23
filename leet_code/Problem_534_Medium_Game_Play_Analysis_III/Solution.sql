/*
Problem: 534. Game Play Analysis III
Difficulty: Medium
Description: Calculate cumulative sum of games played for each player ordered by date.
Algorithm: Window Function SUM() OVER().
*/

SELECT 
    player_id, 
    event_date, 
    SUM(games_played) OVER (
        PARTITION BY player_id 
        ORDER BY event_date
    ) AS games_played_so_far
FROM 
    Activity;
