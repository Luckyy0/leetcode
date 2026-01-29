# 1369. Get the Second Most Recent Activity / Nhận Hoạt động Gần đây Thứ hai

## Problem Description / Mô tả bài toán
Table `UserActivity` (username, activity, startDate, endDate).
Show second most recent activity of each user.
If user has only 1, show that 1.
Order by username.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Window Function (RANK)
Rank activities by `startDate` DESC per user.
Select where rank = 2.
Union with users having count = 1.
Or clearer:
CTE `Ranked` as (Rank() over (partition by user order by start desc)).
Select * where rank = 2.
Union Select * where rank = 1 AND count(user) = 1.

Actually efficient logic:
If Count=1, return Rank=1.
Else, return Rank=2.

---
