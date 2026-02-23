/*
Problem: 586. Customer Placing the Largest Number of Orders
Difficulty: Easy
Description: Find the customer_number who placed the most orders.
Approach: Group by customer_number, count orders, sort descending, and limit 1.
*/

SELECT 
    customer_number
FROM 
    Orders
GROUP BY 
    customer_number
ORDER BY 
    COUNT(*) DESC
LIMIT 1;

/*
-- Follow up: If ties should be included, use RANK() or a subquery:
-- Giải pháp mở rộng: Nếu cần bao gồm cả những người bằng điểm:

SELECT customer_number
FROM (
    SELECT customer_number, COUNT(*) as cnt
    FROM Orders
    GROUP BY customer_number
) t
WHERE cnt = (
    SELECT MAX(cnt) 
    FROM (SELECT COUNT(*) as cnt FROM Orders GROUP BY customer_number) t2
);
*/
