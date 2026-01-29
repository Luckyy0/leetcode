-- SQL Solution for P1613
WITH RECURSIVE Seq AS (
    SELECT 1 AS ids
    UNION ALL
    SELECT ids + 1 
    FROM Seq 
    WHERE ids < (SELECT MAX(customer_id) FROM Customers)
)
SELECT ids 
FROM Seq
WHERE ids NOT IN (SELECT customer_id FROM Customers)
ORDER BY ids;
