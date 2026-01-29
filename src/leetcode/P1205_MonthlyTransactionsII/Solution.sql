/* Write your T-SQL query statement below */
WITH Approved AS (
    SELECT 
        FORMAT(trans_date, 'yyyy-MM') AS month,
        country,
        1 AS approved_count,
        amount AS approved_amount,
        0 AS chargeback_count,
        0 AS chargeback_amount
    FROM Transactions
    WHERE state = 'approved'
),
ChargebacksInfo AS (
    SELECT 
        FORMAT(c.trans_date, 'yyyy-MM') AS month,
        t.country,
        0 AS approved_count,
        0 AS approved_amount,
        1 AS chargeback_count,
        t.amount AS chargeback_amount
    FROM Chargebacks c
    JOIN Transactions t ON c.trans_id = t.id
)
SELECT 
    month, 
    country, 
    SUM(approved_count) AS approved_count,
    SUM(approved_amount) AS approved_amount,
    SUM(chargeback_count) AS chargeback_count,
    SUM(chargeback_amount) AS chargeback_amount
FROM (
    SELECT * FROM Approved
    UNION ALL
    SELECT * FROM ChargebacksInfo
) Combined
GROUP BY month, country
HAVING SUM(approved_count) > 0 OR SUM(chargeback_count) > 0 OR SUM(approved_amount) > 0 OR SUM(chargeback_amount) > 0;
