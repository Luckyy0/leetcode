# 614. Second Degree Follower / Người Theo Dõi Cấp Hai

## Problem Description / Mô tả bài toán
Write an SQL query to report the second-degree followers of each user.
Viết một truy vấn SQL để báo cáo những người theo dõi cấp hai của mỗi người dùng.

A user's **second-degree follower** is a user who follows a user who follows them? No.
Usually "Second Degree Follower" implies finding users who have followers, and counting how many followers they have.
Checking Problem Definition:
"In facebook, a user A is a 2nd-degree follower of user B if A follows C, and C follows B."
Wait, looking at generic Leetcode description for 614:
"Report the number of followers of each user who also follows someone else."
So, "A user who follows someone" AND "Has followers".
Output `follower` (the user name) and `num` (count of their followers).
Order by `follower`.

Table: `Follow`
```
+----------+----------+
| followee | follower |
+----------+----------+
| A        | B        |
| B        | C        |
| B        | D        |
| D        | E        |
+----------+----------+
```
B follows A. C follows B. D follows B. E follows D.
Users who follow someone: B (follows A), C (follows B), D (follows B), E (follows D).
Users who have followers: A (1), B (2), D (1).
Intersection: B (follows A, has 2 followers), D (follows B, has 1 follower).
Output:
B, 2
D, 1

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Subquery Filter / Aggregation
1. Filter users who follow someone (exist in `follower` column).
2. Count their followers (count in `followee` column).

Query:
```sql
SELECT f1.followee AS follower, COUNT(DISTINCT f1.follower) AS num
FROM Follow f1
WHERE f1.followee IN (SELECT follower FROM Follow)
GROUP BY f1.followee
ORDER BY f1.followee
```

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Filtered Aggregation

**Algorithm**:
1.  Identify set of users who are followers (follow someone).
2.  Group Follow table by followee.
3.  Filter groups where followee is in the set identified in step 1.
4.  Count followers.

---
