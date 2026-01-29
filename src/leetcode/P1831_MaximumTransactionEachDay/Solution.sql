-- SQL Solution for P1831
WITH Ranked AS (
    SELECT 
        transaction_id,
        RANK() OVER (PARTITION BY DATE(day) ORDER BY amount DESC) as rk
    FROM Transactions
)
SELECT transaction_id
FROM Ranked
WHERE rk = 1
ORDER BY transaction_id;
