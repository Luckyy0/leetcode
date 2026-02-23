/*
Problem: 550. Game Play Analysis IV
Difficulty: Medium
Description: Calculate the fraction of players who logged in again on the day after their first login.
Algorithm: Subquery to find first login, then Join to check for +1 day.
*/

SELECT
    ROUND(
        COUNT(DISTINCT a.player_id) / (SELECT COUNT(DISTINCT player_id) FROM Activity), 
        2
    ) AS fraction
FROM
    Activity a
JOIN (
    SELECT 
        player_id, 
        MIN(event_date) AS first_login
    FROM 
        Activity
    GROUP BY 
        player_id
) b ON a.player_id = b.player_id 
    AND DATEDIFF(a.event_date, b.first_login) = 1;
