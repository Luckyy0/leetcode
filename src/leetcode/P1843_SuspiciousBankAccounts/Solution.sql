-- SQL Solution for P1843
WITH MonthlyIncome AS (
    SELECT 
        t.account_id,
        MIN(day) as month_start, -- Just to order
        DATE_FORMAT(day, '%Y%m') as month_id,
        SUM(amount) as total_income
    FROM Transactions t
    WHERE t.type = 'Creditor'
    GROUP BY t.account_id, DATE_FORMAT(day, '%Y%m')
),
FlaggedMonths AS (
    SELECT 
        m.account_id,
        m.month_start,
        m.month_id
    FROM MonthlyIncome m
    JOIN Accounts a ON m.account_id = a.account_id
    WHERE m.total_income > a.max_income
),
ConsecutiveCheck AS (
    SELECT 
        account_id,
        month_id,
        LEAD(month_id) OVER (PARTITION BY account_id ORDER BY month_id) as next_month_id
    FROM FlaggedMonths
)
SELECT DISTINCT account_id
FROM ConsecutiveCheck
WHERE PERIOD_DIFF(next_month_id, month_id) = 1;
