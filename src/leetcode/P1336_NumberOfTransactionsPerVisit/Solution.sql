/* Write your T-SQL query statement below */
WITH VisitTrans AS (
    SELECT 
        v.user_id,
        v.visit_date,
        COUNT(t.transaction_date) AS trans_count
    FROM Visits v
    LEFT JOIN Transactions t 
        ON v.user_id = t.user_id AND v.visit_date = t.transaction_date
    GROUP BY v.user_id, v.visit_date
),
MaxTrans AS (
    SELECT MAX(trans_count) as max_c FROM VisitTrans
),
Sequence AS (
    SELECT 0 as num
    UNION ALL
    SELECT num + 1 FROM Sequence
    WHERE num < (SELECT ISNULL(max_c, 0) FROM MaxTrans)
)
SELECT 
    s.num AS transactions_count,
    COUNT(vt.trans_count) AS visits_count
FROM Sequence s
LEFT JOIN VisitTrans vt ON s.num = vt.trans_count
GROUP BY s.num
ORDER BY s.num;
