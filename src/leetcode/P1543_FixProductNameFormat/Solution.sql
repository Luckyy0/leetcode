/* Write your T-SQL query statement below */
SELECT 
    LOWER(TRIM(product_name)) AS product_name,
    LEFT(CAST(sale_date AS VARCHAR), 7) AS sale_date,
    COUNT(sale_id) AS total
FROM Sales
GROUP BY LOWER(TRIM(product_name)), LEFT(CAST(sale_date AS VARCHAR), 7)
ORDER BY product_name ASC, sale_date ASC;
