# Analysis for Minimum Time Difference
# *Phân tích cho bài toán Hiệu Thời gian Nhỏ nhất*

## 1. Problem Essence & Circular Time
## *1. Bản chất vấn đề & Thời gian Vòng tròn*

### The Challenge
### *Thách thức*
Finding min difference in a circular 24-hour cycle.
- "00:00" is equivalent to 0 minutes.
- "23:59" is equivalent to $24 \times 60 - 1 = 1439$ minutes.
- Difference between 0 and 1439 is 1 minute (via midnight).

### Strategy: Convert to Minutes & Sort
### *Chiến lược: Chuyển đổi sang Phút & Sắp xếp*

1.  **Conversion:** Convert each "HH:MM" to `minutes = H*60 + M`.
2.  **Sorting:** Sort the minutes array.
3.  **Linear Scan:** Calculate `diff = time[i] - time[i-1]`. Update min.
4.  **Wrap-around Check:** Compare `first` and `last`. `diff = (first + 1440) - last`.

### Optimization: Bucket Sort
### *Tối ưu hóa: Sắp xếp theo Bucket*
- Total distinct minutes possible: $24 \times 60 = 1440$.
- If `N > 1440`, by Pigeonhole Principle, difference is 0.
- We can use a boolean array `seen[1440]` to sort in $O(1440)$ time (constant).

---

## 2. Approach: Bucket Sort / Boolean Array
## *2. Hướng tiếp cận: Sắp xếp Bucket / Mảng Boolean*

### Logic
### *Logic*
(See above). Create `boolean[1440]`. Iterate 0 to 1439. Track `prev` index. Compute diffs. Don't forget last `prev` with `first` + 1440.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Bounded Input:** Input values are strictly within [0, 1439].
    *Đầu vào bị giới hạn: Giá trị đầu vào nằm hoàn toàn trong [0, 1439].*
*   **Constant Time Sort:** $O(1)$ effectively (or $O(N)$ to parse).
    *Sắp xếp thời gian hằng số: Hiệu quả $O(1)$ (hoặc $O(N)$ để phân tích).*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N + 1440)$.
    *Độ phức tạp thời gian: $O(N + 1440)$.*
*   **Space Complexity:** $O(1440) = O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `["23:59", "00:00"]`
1. Mins: `1439`, `0`.
2. Sort: `0, 1439`.
3. Diff: `1439 - 0 = 1439`. (Too huge).
4. Circular: `(0 + 1440) - 1439 = 1`.
5. Min = 1.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Convert to minutes, sort (buckets preferred), check adjacent and wraparound.
*Chuyển đổi sang phút, sắp xếp (ưu tiên bucket), kiểm tra liền kề và vòng lặp.*
---
*Thời gian (Time) là một vòng tròn khép kín. Khoảng cách xa nhất đôi khi lại là khoảng cách gần nhất nếu ta biết bước qua ranh giới của ngày cũ và ngày mới (midnight).*
Time is a closed circle. The farthest distance is sometimes the closest distance if we know how to cross the boundary of the old day and the new day (Midnight).
