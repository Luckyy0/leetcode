# 1225. Report Contiguous Dates / Báo cáo Ngày Liên tiếp

## Problem Description / Mô tả bài toán
Tables `Failed` (fail_date) and `Succeeded` (success_date).
Report periods of "succeeded" and "failed" states.
Period is contiguous sequence of days with same state.
Result: `period_state`, `start_date`, `end_date`.
Order by `start_date`.
Filters dates from `2019-01-01` to `2019-12-31`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Gaps and Islands Problem
1. Union Failed and Succeeded tables with a 'state' column. Filter dates.
2. We have a list of dates and states.
3. Assign Row Number within each state.
4. Calculate `Group Identifier = Date - Row Number`. Or `Date - State-specific Row Number`.
   - If dates are contiguous `d, d+1, d+2`, and row numbers are `1, 2, 3`, then `d-1, d+1-2` are constant.
   - Wait, `date` minus `int`. SQL Server supports `DATEADD(day, -rn, date)`.
5. Group by `state` and the calculated identifier.
6. `MIN(date)` as start, `MAX(date)` as end.

---
