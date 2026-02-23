# Actors and Directors Who Cooperated At Least Three Times
# *Tài Tử Và Đạo Diễn Đá Cặp Cùng Nhau Ít Nhất Ba Bộ Phim*

## Description
## *Mô tả*

Table: `ActorDirector`
*Bảng: `ActorDirector`*

```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| actor_id    | int     |
| director_id | int     |
| timestamp   | int     |
+-------------+---------+
timestamp is the primary key (column with unique values) for this table.
timestamp chiếm chức danh Khóa Chính (cột đảm bảo chứa các giá trị độc nhất và không đụng hàng) sử dụng trong bảng này.
```

Write a solution to find all the pairs `(actor_id, director_id)` where the actor has cooperated with the director at least three times.
*Hãy vạch ra một câu lệnh SQL chiết xuất toàn bộ các Cặp bài trùng Duyên nợ `(actor_id, director_id)` – Thể hiện chân dung những Ngôi sao Gương mặt Điện ảnh đã cọ xát và Hợp tác làm việc Khăng khít cùng Vị Đạo diễn Nào Đó Trải Dài Không Dưới Tối Thiểu 3 Bộ Phim.*

Return the result table in **any order**.
*Trả về bảng dữ liệu kết quả theo **tùy ý bất kỳ thứ tự nào**.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** 
ActorDirector table:
```
+-------------+-------------+-------------+
| actor_id    | director_id | timestamp   |
+-------------+-------------+-------------+
| 1           | 1           | 0           |
| 1           | 1           | 1           |
| 1           | 1           | 2           |
| 1           | 2           | 3           |
| 1           | 2           | 4           |
| 2           | 1           | 5           |
| 2           | 1           | 6           |
+-------------+-------------+-------------+
```
**Output:** 
```
+-------------+-------------+
| actor_id    | director_id |
+-------------+-------------+
| 1           | 1           |
+-------------+-------------+
```
**Explanation:** 
*Giải thích:*
The only pair is (1, 1) where they cooperated exactly 3 times.
*Cặp Cạp Dính Nhau Lì Lợm duy nhất rà ra được hệ thống chính là Lão (1, 1). Họ Trói buột làm việc chung đụng Mâm chót lọt Đủ Chỉnh 3 Cuộn Băng nháy thời gian (Timestamp Nhãn 0, 1, 2).*
