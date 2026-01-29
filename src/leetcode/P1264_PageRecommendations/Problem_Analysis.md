# 1264. Page Recommendations / Đề xuất Trang

## Problem Description / Mô tả bài toán
Tables `Friendship` (user1_id, user2_id) and `Likes` (user_id, page_id).
Recommend pages to `user_id = 1`.
Recommendations are pages liked by friends of user 1, but NOT liked by user 1.
Result: `recommended_page`. Distinct, any order.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Subqueries
1. Find friends of user 1. (Select user2 where user1=1 UNION Select user1 where user2=1).
2. Find pages liked by these friends.
3. Exclude pages liked by user 1.
4. Select Distinct.

---
