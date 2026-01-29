/* Write your T-SQL query statement below */
WITH FirstOrders AS (
    SELECT customer_id, MIN(order_date) as first_order_date
    FROM Delivery
    GROUP BY customer_id
)
SELECT ROUND(
    CAST(SUM(CASE WHEN d.order_date = d.customer_pref_delivery_date THEN 1 ELSE 0 END) AS FLOAT) 
    * 100.0 
    / COUNT(*), 
    2
) AS immediate_percentage
FROM FirstOrders f
JOIN Delivery d ON f.customer_id = d.customer_id AND f.first_order_date = d.order_date;
