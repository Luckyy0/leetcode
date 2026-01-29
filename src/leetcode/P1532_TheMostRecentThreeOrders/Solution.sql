/* Write your T-SQL query statement below */
WITH RankedOrders AS (
    SELECT 
        customer_id, 
        order_id, 
        order_date,
        ROW_NUMBER() OVER (PARTITION BY customer_id ORDER BY order_date DESC) as rn
    FROM Orders
)
SELECT 
    c.name AS customer_name,
    c.customer_id,
    r.order_id,
    r.order_date
FROM RankedOrders r
JOIN Customers c ON r.customer_id = c.customer_id
WHERE r.rn <= 3
ORDER BY c.name ASC, c.customer_id ASC, r.order_date DESC;
