-- SQL Solution for P1709
SELECT user_id, MAX(diff) AS biggest_window
FROM (
    SELECT 
        user_id, 
        DATEDIFF(
            IFNULL(LEAD(visit_date) OVER (PARTITION BY user_id ORDER BY visit_date), '2021-01-01'), 
            visit_date
        ) AS diff
    FROM UserVisits
) t
GROUP BY user_id
ORDER BY user_id;
