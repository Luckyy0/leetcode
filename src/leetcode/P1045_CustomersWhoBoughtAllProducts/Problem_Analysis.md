# 1045. Customers Who Bought All Products / Khách hàng Đã mua Tất cả Sản phẩm

## Problem Description / Mô tả bài toán
Table: `Customer`
- `customer_id` (int)
- `product_key` (int)

Table: `Product`
- `product_key` (int)

Write a solution to report the customer ids from the `Customer` table that bought all the products in the `Product` table.
Viết giải pháp để báo cáo id khách hàng từ bảng `Customer` đã mua tất cả các sản phẩm trong bảng `Product`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Aggregation / SQL Gộp
We need to group by `customer_id` and count the number of *distinct* products each customer bought.
Count must equal the total count of products in `Product`.

Query Logic:
`SELECT customer_id FROM Customer GROUP BY customer_id HAVING COUNT(DISTINCT product_key) = (SELECT COUNT(*) FROM Product)`

---

## Analysis / Phân tích

### Approach: Group and Count with Subquery Verification
Aggregate purchases by customer. By comparing the count of distinct product keys associated with each customer ID against the global count of available products (obtained via subquery), we filter for completeness.
Tổng hợp các giao dịch mua theo khách hàng. Bằng cách so sánh số lượng khóa sản phẩm riêng biệt được liên kết với mỗi ID khách hàng so với tổng số lượng sản phẩm có sẵn (thu được qua truy vấn con), chúng ta lọc ra sự hoàn chỉnh.

---
