# 262. Trips and Users / Chuyến Đi và Người Dùng

## Problem Description / Mô tả bài toán
(Note: This is a Database/SQL problem. Below is the solution/explanation in SQL format, but represented in a markdown file as requested for completeness. The implementation will be a simulated SQL or explanation, as Java execution of SQL requires a DB environment.)
(Lưu ý: Đây là một bài toán Cơ sở dữ liệu/SQL. Dưới đây là giải pháp/giải thích ở định dạng SQL, nhưng được trình bày trong tệp markdown theo yêu cầu để hoàn thiện. Việc triển khai sẽ là mô phỏng hoặc giải thích, vì việc thực thi SQL bằng Java yêu cầu môi trường DB.)

**Table: Trips**
+-------------+----------+
| Column Name | Type     |
+-------------+----------+
| id          | int      |
| client_id   | int      |
| driver_id   | int      |
| city_id     | int      |
| status      | enum     |
| request_at  | date     |
+-------------+----------+
`id` is the primary key.
`status` is an ENUM type of ('completed', 'cancelled_by_driver', 'cancelled_by_client').

**Table: Users**
+-------------+----------+
| Column Name | Type     |
+-------------+----------+
| users_id    | int      |
| banned      | enum     |
| role        | enum     |
+-------------+----------+
`users_id` is the primary key.
`banned` is an ENUM type of ('Yes', 'No').
`role` is an ENUM type of ('client', 'driver', 'partner').

Write a SQL query to find the **cancellation rate** of requests with unbanned users (both client and driver must not be banned) each day between **"2013-10-01"** and **"2013-10-03"**. Round `Cancellation Rate` to two decimal points.

The **cancellation rate** is computed by dividing the number of canceled (by client or driver) requests with unbanned users by the total number of requests with unbanned users on that day.

### Example 1:
```text
Input: 
Trips table:
... (data) ...
Users table:
... (data) ...
Output: 
+------------+-------------------+
| Day        | Cancellation Rate |
+------------+-------------------+
| 2013-10-01 | 0.33              |
| 2013-10-02 | 0.00              |
| 2013-10-03 | 0.50              |
+------------+-------------------+
```

---

## Theoretical Foundation / Cơ sở lý thuyết

### SQL Filtering and Aggregation
1.  **Filter**:
    - Date range: `request_at BETWEEN '2013-10-01' AND '2013-10-03'`.
    - Unbanned Users: Join `Trips` with `Users` (twice, for client and driver) and check `banned = 'No'`. Or use `NOT IN (SELECT users_id FROM Users WHERE banned = 'Yes')`.
2.  **Group By**: `request_at` (Day).
3.  **Aggregate**:
    - Total requests: `COUNT(id)`.
    - Canceled requests: `SUM(CASE WHEN status != 'completed' THEN 1 ELSE 0 END)`.
    - Rate: `ROUND(SUM(...) / COUNT(...), 2)`.

---

## Analysis / Phân tích

### Approach: Standard SQL

**Query Structure**:
```sql
SELECT 
    t.request_at AS Day, 
    ROUND(SUM(CASE WHEN t.status != 'completed' THEN 1 ELSE 0 END) / COUNT(*), 2) AS "Cancellation Rate"
FROM Trips t
WHERE 
    t.request_at BETWEEN '2013-10-01' AND '2013-10-03'
    AND t.client_id NOT IN (SELECT users_id FROM Users WHERE banned = 'Yes')
    AND t.driver_id NOT IN (SELECT users_id FROM Users WHERE banned = 'Yes')
GROUP BY t.request_at
```

**Optimization**:
Using `NOT IN` might be slow. Joining `Users` table is often better for indices.
```sql
FROM Trips t
JOIN Users c ON t.client_id = c.users_id AND c.banned = 'No'
JOIN Users d ON t.driver_id = d.users_id AND d.banned = 'No'
```
However, the problem statement implies checking banned status. If a user is banned, their trips are ignored.

### Complexity / Độ phức tạp
- **Time**: Database engine dependent (O(N log N) or O(N) depending on joins/indices).
- **Space**: O(Groups) for output.

---

## Limitation
Since I am a Java coding assistant, I cannot "run" this SQL. I will provide the SQL solution in a text file or inside the Java file as a comment block/String to satisfy the file structure requirement.
Vì tôi là trợ lý lập trình Java, tôi không thể "chạy" câu lệnh SQL này. Tôi sẽ cung cấp giải pháp SQL trong tệp văn bản hoặc bên trong tệp Java dưới dạng khối chú thích/Chuỗi để đáp ứng yêu cầu cấu trúc tệp.
