# 607. Sales Person / Nhân Viên Bán Hàng

## Problem Description / Mô tả bài toán
Write an SQL query to report the names of all the salespersons who did not have any orders related to the company with the name "RED".
Viết một truy vấn SQL để báo cáo tên của tất cả những người bán hàng không có bất kỳ đơn đặt hàng nào liên quan đến công ty có tên "RED".

Table: `SalesPerson`
```
+----------+------+--------+-----------------+------------+
| sales_id | name | salary | commission_rate | hire_date  |
+----------+------+--------+-----------------+------------+
```
Table: `Company`
```
+--------+--------+----------+
| com_id | name   | city     |
+--------+--------+----------+
```
Table: `Orders`
```
+----------+------------+--------+----------+--------+
| order_id | order_date | com_id | sales_id | amount |
+----------+------------+--------+----------+--------+
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Subquery Filter / NOT IN / Bộ Lọc Truy Vấn Con / NOT IN
1. Find `com_id` for "RED".
2. Find `sales_id` from `Orders` where `com_id` matches "RED" ID.
3. Select `name` from `SalesPerson` where `sales_id` NOT IN the list found in step 2.

Query:
```sql
SELECT name FROM SalesPerson
WHERE sales_id NOT IN (
    SELECT o.sales_id
    FROM Orders o
    JOIN Company c ON o.com_id = c.com_id
    WHERE c.name = 'RED'
)
```

### Complexity / Độ phức tạp
- **Time**: O(N*M).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Exclusion via Subquery

**Algorithm**:
1.  Identify sales IDs that handled orders for 'RED'.
2.  Select names of sales persons whose ID is not in that set.

---
