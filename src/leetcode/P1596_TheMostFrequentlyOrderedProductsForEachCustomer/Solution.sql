-- SQL Solution for P1596
WITH ProductCounts AS (
    SELECT 
        customer_id, 
        product_id, 
        COUNT(*) as order_count
    FROM Orders
    GROUP BY customer_id, product_id
),
RankedProducts AS (
    SELECT 
        customer_id, 
        product_id, 
        order_count,
        RANK() OVER (PARTITION BY customer_id ORDER BY order_count DESC) as rnk
    FROM ProductCounts
)
SELECT 
    rp.customer_id, 
    rp.product_id, 
    p.product_name
FROM RankedProducts rp
JOIN Products p ON rp.product_id = p.product_id
WHERE rp.rnk = 1;
