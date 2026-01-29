# 1127. User Purchase Platform / Nền tảng Mua hàng của Người dùng

## Problem Description / Mô tả bài toán
Table `Spending`: `user_id`, `spend_date`, `platform` ('desktop', 'mobile'), `amount`.
Total sales amount of each platform ('desktop', 'mobile', 'both') for each date.
'both' means user spent on both desktop and mobile on that date.
For each date, report total amount and total users for 'desktop', 'mobile', and 'both'.
Table should include all dates present in `Spending` table. even if 0.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Aggregation and Date Unification
1. Categorize each user-day pair into 'desktop', 'mobile', or 'both'.
   - Group by user, date.
   - If count(platform) = 2 -> both.
   - Else take platform.
   - Sum amount.
2. Generate all combinations of (date, platform) for the result.
   - Distinct dates X {desktop, mobile, both}.
3. Right join the categorized spending to this skeleton.
4. Sum up.

---
