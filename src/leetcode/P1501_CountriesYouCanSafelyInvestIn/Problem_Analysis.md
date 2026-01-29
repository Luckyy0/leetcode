# 1501. Countries You Can Safely Invest In / Các Quốc gia Bạn Có thể Đầu tư An toàn

## Problem Description / Mô tả bài toán
Tables: `Person` (id, name, phone_number), `Country` (name, country_code), `Calls` (caller_id, callee_id, duration).
Country code is first 3 digits of phone number.
Safe Country: Average call duration of calls involving this country's citizens > Global Average call duration.
Return country names.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Aggregation and JOIN
1. Determine country for each person from `phone_number`.
2. Determine country for each call (caller and callee).
3. Compute global average duration.
4. Compute average per country.
   - For a call between A and B, duration contributes to A's average and B's average.
   - Union ALL `(caller, duration)` and `(callee, duration)` to get all involvements.
5. Join with country code. Group by country.
6. Filter `AVG > Global Avg`.

---
