-- 1045. Customers Who Bought All Products
-- Write a solution to report the customer ids from the Customer table that bought all the products in the Product table.

-- Phân tích tối ưu: 
-- Gom nhóm khách hàng theo customer_id.
-- Đếm tổng số lượng SẢN PHẨM KHÁC NHAU (DISTINCT product_key) mà mỗi khách hàng đó đã mua.
-- So sánh xem con số đếm đó có bằng ĐÚNG tổng số sản phẩm tồn tại trong cái kho tổng (bảng Product) hay không.
-- (Bấm số đếm tổng kho: SELECT COUNT(*) FROM Product)

SELECT 
    customer_id 
FROM 
    Customer
GROUP BY 
    customer_id
HAVING 
    COUNT(DISTINCT product_key) = (SELECT COUNT(*) FROM Product);
