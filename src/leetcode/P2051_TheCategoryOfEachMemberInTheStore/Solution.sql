-- SQL Solution for P2051
WITH Stats AS (
    SELECT 
        m.member_id, 
        m.name,
        COUNT(v.visit_id) AS total_visits,
        COUNT(p.visit_id) AS total_purchases
    FROM Members m
    LEFT JOIN Visits v ON m.member_id = v.member_id
    LEFT JOIN Purchases p ON v.visit_id = p.visit_id
    GROUP BY m.member_id
)
SELECT 
    member_id, 
    name,
    CASE 
        WHEN total_visits = 0 THEN 'Bronze'
        WHEN (100 * total_purchases / total_visits) >= 80 THEN 'Diamond'
        WHEN (100 * total_purchases / total_visits) >= 50 THEN 'Gold'
        ELSE 'Silver'
    END AS category
FROM Stats;
