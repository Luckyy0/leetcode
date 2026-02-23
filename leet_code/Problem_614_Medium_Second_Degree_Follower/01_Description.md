# Result for Second Degree Follower
# *Kết quả cho bài toán Người theo dõi Bậc hai*

## Description
## *Mô tả*

**SQL Schema**

Table: `Follow`
```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| followee    | varchar |
| follower    | varchar |
+-------------+---------+
(followee, follower) is the primary key column for this table.
Each row of this table indicates that the user follower has followed the user followee.
```

A **second-degree follower** is a user who:
*   follows at least one user, and
*   is followed by at least one user.
* **Người theo dõi bậc hai** là một người dùng:*
*   *theo dõi ít nhất một người dùng, và*
*   *được theo dõi bởi ít nhất một người dùng.*

Write an SQL query to report the second-degree followers and the count of them who follow them.
*Viết một truy vấn SQL để báo cáo các người theo dõi bậc hai và số lượng người đang theo dõi họ.*

Return the result table ordered by `follower` in **alphabetical order**.
*Trả về bảng kết quả được sắp xếp theo `follower` theo thứ tự **bảng chữ cái**.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** 
Follow table:
```
+----------+----------+
| followee | follower |
+----------+----------+
| Alice    | Bob      |
| Bob      | Cena     |
| Bob      | Donald   |
| Donald   | Edward   |
+----------+----------+
```
**Output:** 
```
+----------+-----+
| follower | num |
+----------+-----+
| Bob      | 2   |
| Donald   | 1   |
+----------+-----+
```
**Explanation:** 
- User Bob is a second-degree follower because he follows Alice, and he is followed by Cena and Donald.
- User Donald is a second-degree follower because he follows Bob, and he is followed by Edward.
- User Cena is not a second-degree follower because he only follows Bob, but is not followed by anyone.
- User Alice is not a second-degree follower because she is followed by Bob, but does not follow anyone.

## Constraints:
## *Ràng buộc:*

*   There are no specific constraints.
