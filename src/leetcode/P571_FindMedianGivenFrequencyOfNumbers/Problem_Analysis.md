# 571. Find Median Given Frequency of Numbers / Tìm Trung Vị Với Tần Suất Của Các Số

## Problem Description / Mô tả bài toán
The `Numbers` table keeps the value of number and the frequency of its occurrence.
Bảng `Numbers` lưu trữ giá trị của số và tần suất xuất hiện của nó.

```
+----------+-------------+
|  Number  |  Frequency  |
+----------+-------------+
|  0       |  7          |
|  1       |  1          |
|  2       |  3          |
|  3       |  1          |
+----------+-------------+
```

Write an SQL query to find the median of all numbers and report it as the result.
Viết một truy vấn SQL để tìm trung vị của tất cả các số và báo cáo nó là kết quả.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Cumulative Frequency / Tần Suất Tích Lũy
The total number of elements `S = SUM(Frequency)`.
The median is the average of elements at positions `floor((S-1)/2)` and `ceil((S-1)/2)` (0-indexed).
Essentially, a number `n` is part of the median if its cumulative frequency range `[cum_freq - freq, cum_freq]` overlaps with `[S/2, S/2]`.

Constraint:
`abs(cumulative_asc - cumulative_desc) <= frequency`.
If `Frequency` is large, we cannot expand rows. We must calculate running sums.

Algorithm:
1. `Sum` total frequency.
2. `Ascending Cumulative Sum` for each number.
3. `Descending Cumulative Sum` for each number.
4. Select number where `Ascending >= Total/2` AND `Descending >= Total/2`.
   - Actually simpler: `Total/2` falls within the range covered by the number.
   - Condition: `CumFreq` represents the last index of this number. `PrevCum` is start.
   - We want `S/2` index.
   - `Asc >= S/2` AN `Desc >= S/2` covers the middle element(s).

### Complexity / Độ phức tạp
- **Time**: O(N log N) for sorting/window functions.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Running Sum Overlap

**Algorithm**:
1.  Compute running sum of frequencies (Ascending).
2.  Compute running sum of frequencies (Descending).
3.  Compute total sum.
4.  Filter rows where both running sums are greater than or equal to `Total / 2`.
5.  Average the values if multiple rows returned (for even total count scenarios).

---
