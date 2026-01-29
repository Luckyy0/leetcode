# 1454. Active Users / Người Dùng Hoạt Động

## Problem Description / Mô tả bài toán
Tables `Accounts` (id, name), `Logins` (id, login_date).
Active User: logged in for 5 or more CONSECUTIVE days.
Return id, name. Sort by id.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Gaps and Islands (Consecutive Dates)
1. Distinct dates for each user.
2. Order dates. `lag` or `row_number`.
3. `date - row_number` technique:
   If dates are consecutive, `date - row_number` (in days) is constant "group id".
   Group by `user_id` and `group_id`.
   Count >= 5.

---
