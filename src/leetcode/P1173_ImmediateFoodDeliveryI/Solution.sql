/* Write your T-SQL query statement below */
SELECT ROUND(
    CAST(SUM(CASE WHEN order_date = customer_pref_delivery_date THEN 1 ELSE 0 END) AS FLOAT) 
    * 100.0 
    / COUNT(*), 
    2
) AS immediate_percentage
FROM Delivery;
