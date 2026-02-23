# Result for Not Boring Movies
# *Kết quả cho bài toán Những bộ Phim không Nhà nhàm chán*

## Description
## *Mô tả*

**SQL Schema**

Table: `cinema`
```
+----------------+----------+
| Column Name    | Type     |
+----------------+----------+
| id             | int      |
| movie          | varchar  |
| description    | varchar  |
| rating         | float    |
+----------------+----------+
id is the primary key column for this table.
Each row contains information about the name of a movie, its description, and its rating.
```

Write an SQL query to report the movies with an odd numbered ID and a description that is not **"boring"**.
*Viết một truy vấn SQL để báo cáo các bộ phim có ID là số lẻ và mô tả không phải là **"boring"**.*

Return the result table ordered by `rating` in **descending order**.
*Trả về bảng kết quả được sắp xếp theo `rating` theo thứ tự **giảm dần**.*

The query result format is in the following example.
*Định dạng kết quả truy vấn theo ví dụ sau.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** 
cinema table:
```
+----+------------+-------------+--------+
| id | movie      | description | rating |
+----+------------+-------------+--------+
| 1  | War        | great 3D    | 8.9    |
| 2  | Science    | fiction     | 8.5    |
| 3  | irish      | boring      | 6.2    |
| 4  | Ice song   | Fantacy     | 8.6    |
| 5  | House card | Interesting | 9.1    |
+----+------------+-------------+--------+
```
**Output:** 
```
+----+------------+-------------+--------+
| id | movie      | description | rating |
+----+------------+-------------+--------+
| 5  | House card | Interesting | 9.1    |
| 1  | War        | great 3D    | 8.9    |
+----+------------+-------------+--------+
```
**Explanation:** 
- We have three movies with odd-numbered IDs: 1, 3, and 5.
- The movie with ID = 3 has the description "boring", so we exclude it.
- Finally, we sort the results by rating in descending order.

## Constraints:
## *Ràng buộc:*

*   There are no specific constraints.
