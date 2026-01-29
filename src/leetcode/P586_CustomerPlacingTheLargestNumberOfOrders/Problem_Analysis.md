# 586. Customer Placing the Largest Number of Orders / Khách Hàng Đặt Nhiều Đơn Hàng Nhất

## Problem Description / Mô tả bài toán
Write an SQL query to find the `customer_number` for the customer who has placed the largest number of orders.
Viết một truy vấn SQL để tìm `customer_number` cho khách hàng đã đặt số lượng đơn hàng lớn nhất.

The test cases are generated so that **exactly one customer** will have placed more orders than any other customer.
Các trường hợp thử nghiệm được tạo sao cho **chính xác một khách hàng** sẽ đặt nhiều đơn hàng hơn bất kỳ khách hàng nào khác.

Table: `Orders`
```
+-----------------+----------+
| order_number    | customer_number |
+-----------------+----------+
| 1               | 1        |
| 2               | 2        |
| 3               | 3        |
| 4               | 3        |
+-----------------+----------+
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Group By + Order By Limit / Nhóm + Sắp Xếp Giới Hạn
1. Group by `customer_number`.
2. Count orders.
3. Order by count descending.
4. Limit 1.

Query:
```sql
SELECT customer_number
FROM Orders
GROUP BY customer_number
ORDER BY COUNT(*) DESC
LIMIT 1
```

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Aggregation and Sorting

**Algorithm**:
1.  Group orders by customer.
2.  Count number of orders per customer.
3.  Sort customers based on order count.
4.  Pick the top one.

---
