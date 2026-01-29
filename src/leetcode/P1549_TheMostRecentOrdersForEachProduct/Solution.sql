/* Write your T-SQL query statement below */
WITH RankedOrders AS (
    SELECT 
        p.product_name,
        o.product_id,
        o.order_id,
        o.order_date,
        RANK() OVER (PARTITION BY o.product_id ORDER BY o.order_date DESC) as rnk
    FROM Orders o
    JOIN Products p ON o.product_id = p.product_id
)
SELECT product_name, product_id, order_id, order_date
FROM RankedOrders
WHERE rnk = 1
ORDER BY product_name ASC, product_id ASC, order_id ASC;
