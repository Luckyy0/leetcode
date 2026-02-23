# Analysis for Trips and Users
# *Phân tích cho bài toán Chuyến đi và Người dùng*

## 1. Problem Essence & Filtering
## *1. Bản chất vấn đề & Lọc dữ liệu*

### The Constraints
### *Ràng buộc*
1.  **Date Range:** `2013-10-01` to `2013-10-03`.
2.  **Unbanned:** Both `client_id` AND `driver_id` must NOT be banned.
3.  **Cancellation Rate:** `Count(Cancelled) / Count(Total)`.

### Logic
### *Logic*
1.  Filter `Trips` table based on `request_at` range.
2.  Join `Users` table twice (once for client, once for driver) to check `banned` status.
    - Or use `WHERE client_id NOT IN (SELECT users_id FROM Users WHERE banned = 'Yes')` and similarly for driver.
3.  Group by `request_at` (Day).
4.  Calculate Rate:
    - `SUM(CASE WHEN status LIKE 'cancelled%' THEN 1 ELSE 0 END)` -> Cancelled Count.
    - `COUNT(*)` -> Total Count.
    - `ROUND(Cancelled / Total, 2)`.

---

## 2. Approach: SQL Group By
## *2. Hướng tiếp cận: SQL Group By*

### Query Structure
### *Cấu trúc truy vấn*
```sql
SELECT 
    request_at AS Day, 
    ROUND(SUM(CASE WHEN status != 'completed' THEN 1 ELSE 0 END) / COUNT(*), 2) AS 'Cancellation Rate'
FROM Trips t
WHERE 
    request_at BETWEEN '2013-10-01' AND '2013-10-03'
    AND client_id NOT IN (SELECT users_id FROM Users WHERE banned = 'Yes')
    AND driver_id NOT IN (SELECT users_id FROM Users WHERE banned = 'Yes')
GROUP BY request_at
```

### Note on Performance
### *Lưu ý hiệu suất*
Using `NOT IN` is simple. Using `JOIN` might be faster on huge datasets but `NOT IN` is readable and correct for standard constraints.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Conditional Aggregation:** Using `SUM(CASE WHEN ...)` inside aggregation handles the numerator condition cleanly.
    *Tổng hợp có điều kiện: Dùng CASE WHEN trong hàm tổng hợp xử lý tử số gọn gàng.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** Depends on DB engine. Index on `request_at` and `banned` helps.
*   **Space Complexity:** Output size.

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Data:**
1 Oct: 4 trips.
- Trip 1: Client banned. Ignored.
- Trip 2: Driver banned. Ignored.
- Trip 3: Valid. Cancelled.
- Trip 4: Valid. Completed.
Unbanned Trips: 2. Cancelled: 1. Rate: 0.50.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Filtering logic is the key part. Ensure 'cancelled' includes both types.
*Logic lọc là phần quan trọng nhất. Đảm bảo 'cancelled' bao gồm cả hai loại.*
---
*Đôi khi việc loại bỏ những yếu tố tiêu cực (banned users) là bước đầu tiên để tính toán chính xác giá trị thực sự (cancellation rate) của một hệ thống.*
Sometimes removing negative elements (banned users) is the first step to accurately calculating the true value (cancellation rate) of a system.
