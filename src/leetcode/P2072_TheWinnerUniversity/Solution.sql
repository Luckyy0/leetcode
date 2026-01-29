-- SQL Solution for P2072
WITH NY AS (
    SELECT COUNT(*) as cnt FROM NewYork WHERE score >= 90
),
CA AS (
    SELECT COUNT(*) as cnt FROM California WHERE score >= 90
)
SELECT 
    CASE 
        WHEN ny.cnt > ca.cnt THEN 'New York University'
        WHEN ca.cnt > ny.cnt THEN 'California University'
        ELSE 'No Winner'
    END AS winner
FROM NY, CA;
