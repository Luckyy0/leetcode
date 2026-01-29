-- SQL Solution for P2084
SELECT order_id, customer_id, order_type
FROM Orders
WHERE order_type = 0 
   OR (order_type = 1 AND customer_id NOT IN (
       SELECT customer_id FROM Orders WHERE order_type = 0
   ));
