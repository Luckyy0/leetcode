# Analysis for Non-overlapping Intervals
# *Phân tích cho bài toán Khoảng không Chồng lấn*

## 1. Problem Essence & Greedy Strategy
## *1. Bản chất vấn đề & Chiến lược Tham lam*

### The Challenge
### *Thách thức*
Selecting the maximum number of non-overlapping intervals from a set. The "minimum removals" is simply `Total - MaxNonOverlapping`. This is the classic **Interval Scheduling Problem**.

### Strategy: Greedy by End Time
### *Chiến lược: Tham lam theo Thời điểm kết thúc*

1.  **Sort:** Sort all intervals by their **end times** in ascending order.
2.  **Selection:** 
    - Pick the first interval.
    - For the next interval, if its `start` is greater than or equal to the `end` of the previously picked interval, keep it (they don't overlap).
    - Update the current `end` time to the `end` of this new interval.
    - Otherwise, this interval overlaps and must be removed.

---

## 2. Approach: Sorting and Single Pass
## *2. Hướng tiếp cận: Sắp xếp và Duyệt một lần*

### Logic
### *Logic*
(See above). Sorting by end time is optimal because it leaves as much room as possible for future intervals. If we sorted by start time, a very long interval starting early could block many others.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Mathematical Optimality:** Sorting by end time is a proven greedy strategy for maximum resource utilization.
    *Tính tối ưu toán học: Sắp xếp theo thời điểm kết thúc là chiến lược tham lam đã được chứng minh cho việc sử dụng tài nguyên tối đa.*
*   **Simple Implementation:** Sorting followed by a linear scan.
    *Triển khai đơn giản: Sắp xếp kết hợp với duyệt tuyến tính.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$ due to sorting. The subsequent pass is $O(N)$.
    *Độ phức tạp thời gian: $O(N \log N)$.*
*   **Space Complexity:** $O(1)$ additional space (ignoring sorting recursion stack).
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[[1,2], [2,3], [3,4], [1,3]]`
1. Sort by end time: `[[1,2], [2,3], [1,3], [3,4]]` $\to$ wait, `[1,3]` vs `[3,4]`?
    Sorted: `[1,2], [2,3], [1,3], [3,4]`? No, correct order: `[1,2], [2,3], [1,3]` (end at 3), `[3,4]` (end at 4).
    Let's re-sort carefully:
    - [1, 2] (End 2)
    - [2, 3] (End 3)
    - [1, 3] (End 3)
    - [3, 4] (End 4)
2. Pick `[1,2]`. Current end = 2.
3. Check `[2,3]`: `start(2) >= end(2)`. Keep. Current end = 3.
4. Check `[1,3]`: `start(1) < end(3)`. Overlap! **Remove**.
5. Check `[3,4]`: `start(3) >= end(3)`. Keep. Current end = 4.
Total removed: 1.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Greedy selection by sorting by end time.
*Lựa chọn tham lam bằng cách sắp xếp theo thời điểm kết thúc.*
---
*Cuộc sống là một chuỗi các sự kiện nối tiếp nhau. Để đạt được nhiều điều nhất (maximum intervals), ta không nhất thiết phải bắt đầu sớm nhất, mà phải biết cách kết thúc sớm nhất (end time) để nhường chỗ cho những cơ hội tiếp theo. Sự tỉnh táo trong việc loại bỏ những thứ chồng chéo (removals) sẽ giúp quỹ thời gian của chúng ta trở nên mạch lạc và hiệu quả.*
Life is a series of successive events. To achieve the most (maximum intervals), we do not necessarily have to start earliest, but must know how to finish earliest (end time) to make room for next opportunities. Alertness in eliminating overlapping things (removals) will help our time fund become coherent and effective.
