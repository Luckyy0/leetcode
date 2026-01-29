-- SQL Solution for P1867
WITH OrderStats AS (
    SELECT 
        order_id,
        MAX(quantity) as max_qty,
        SUM(quantity) / COUNT(product_id) as avg_qty
    FROM OrdersDetails
    GROUP BY order_id
)
SELECT order_id
FROM OrderStats
WHERE max_qty > (SELECT MAX(avg_qty) FROM OrderStats);
