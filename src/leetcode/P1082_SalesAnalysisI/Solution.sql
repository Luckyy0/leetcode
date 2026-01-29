/* Write your T-SQL query statement below */
SELECT seller_id
FROM Sales
GROUP BY seller_id
HAVING SUM(price) = (
    SELECT TOP 1 SUM(price) as total_sales
    FROM Sales
    GROUP BY seller_id
    ORDER BY total_sales DESC
);
