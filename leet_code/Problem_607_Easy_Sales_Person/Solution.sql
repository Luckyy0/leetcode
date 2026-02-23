/*
Problem: 607. Sales Person
Difficulty: Easy
Description: Find names of salespersons who have no orders for company "RED".
Approach: Use NOT IN with a subquery that finds all salesperson IDs associated with "RED".
*/

SELECT 
    name
FROM 
    SalesPerson
WHERE 
    sales_id NOT IN (
        -- Subquery: find all salespeople who HAD an order with company 'RED'
        SELECT 
            o.sales_id
        FROM 
            Orders o
        JOIN 
            Company c ON o.com_id = c.com_id
        WHERE 
            c.name = 'RED'
    );

/*
-- Alternative Approach (NOT EXISTS):
-- This can be more efficient if the subquery returns many duplicates.
-- Giải pháp thay thế (NOT EXISTS): Có thể hiệu quả hơn nếu truy vấn con trả về nhiều kết quả trùng lặp.

SELECT s.name
FROM SalesPerson s
WHERE NOT EXISTS (
    SELECT 1 
    FROM Orders o
    JOIN Company c ON o.com_id = c.com_id
    WHERE o.sales_id = s.sales_id AND c.name = 'RED'
);
*/
