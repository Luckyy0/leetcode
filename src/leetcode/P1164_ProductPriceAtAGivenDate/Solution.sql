/* Write your T-SQL query statement below */
WITH LastChange AS (
    SELECT product_id, MAX(change_date) as last_date
    FROM Products
    WHERE change_date <= '2019-08-16'
    GROUP BY product_id
)
SELECT p.product_id, p.new_price as price
FROM Products p
JOIN LastChange lc ON p.product_id = lc.product_id AND p.change_date = lc.last_date
UNION ALL
SELECT DISTINCT product_id, 10 as price
FROM Products
WHERE product_id NOT IN (SELECT product_id FROM LastChange);
