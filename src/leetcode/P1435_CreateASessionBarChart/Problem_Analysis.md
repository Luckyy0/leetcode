# 1435. Create a Session Bar Chart / Tạo Biểu đồ Thanh Phiên

## Problem Description / Mô tả bài toán
Table `Sessions` (session_id, duration).
Group durations into bins:
- [0-5> (0 <= d < 300) "0-5 minutes" ? No, usually duration in seconds. Problem says convert to minutes?]
- "[0-5>" minutes: duration [0, 5*60).
- "[5-10>" minutes: duration [300, 600).
- "[10-15>" minutes.
- "15 or more" minutes.
Output `bin`, `total`. Show all bins (even if 0).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Bins and Union/Case
Method 1: CASE to label bins. Then group by. But missing bins won't show.
Method 2: Create a fixed table of bins (CTE/Union), left join with aggregated data.
Union 4 select statements with hardcoded bin labels and counts.
`SELECT '[0-5>' as bin, COUNT(*) FROM ... WHERE ...`
`UNION ALL` ...

---
