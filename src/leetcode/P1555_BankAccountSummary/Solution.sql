-- SQL Solution for P1555
SELECT 
    u.user_id,
    u.user_name,
    (u.credit + IFNULL(t.balance_change, 0)) AS credit,
    CASE 
        WHEN (u.credit + IFNULL(t.balance_change, 0)) < 0 THEN 'Yes' 
        ELSE 'No' 
    END AS credit_limit_breached
FROM 
    Users u
LEFT JOIN (
    SELECT user_id, SUM(change_amount) AS balance_change
    FROM (
        SELECT paid_by AS user_id, -amount AS change_amount FROM Transactions
        UNION ALL
        SELECT paid_to AS user_id, amount AS change_amount FROM Transactions
    ) trans_union
    GROUP BY user_id
) t ON u.user_id = t.user_id;
