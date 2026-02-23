# Analysis for Teemo Attacking
# *Phân tích cho bài toán Teemo Tấn công*

## 1. Problem Essence & Interval Merging
## *1. Bản chất vấn đề & Hợp nhất Khoảng*

### The Challenge
### *Thách thức*
Calculating the union of intervals `[t, t + duration - 1]`. Since `timeSeries` is sorted, we can iterate linearly.

### Strategy: One Scan
### *Chiến lược: Mot lần quét*

1.  **Iterate:** For each attack at `timeSeries[i]`, compare it with the previous attack at `timeSeries[i-1]`.
2.  **Overlap:** The previous attack ends at `timeSeries[i-1] + duration`.
    - If `timeSeries[i] < timeSeries[i-1] + duration`, then the actual poisoned time from the *previous* attack is cut short to `timeSeries[i] - timeSeries[i-1]`.
    - If no overlap, the previous attack contributed full `duration`.
3.  **Last Attack:** The last attack always contributes full `duration`.

---

## 2. Approach: Simple Iteration
## *2. Hướng tiếp cận: Lặp đơn giản*

### Logic
### *Logic*
(See above).
`total = 0`.
Loop `i` from 0 to `n-2`:
  `total += min(duration, timeSeries[i+1] - timeSeries[i])`.
`total += duration` (for the last one).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Sorted Input:** No need to sort, simplifies merging.
    *Đầu vào đã sắp xếp: Không cần sắp xếp, đơn giản hóa việc hợp nhất.*
*   **O(N) Time:** Single pass.
    *Thời gian O(N): Một lần duyệt.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[1, 2]`, duration=2
1. `i=0`: `next=2`, `curr=1`. `diff=1`. `min(2, 1) = 1`. Total=1.
2. End loop.
3. Add `duration` (2). Total = 3.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Accumulate `min(duration, gap)` between consecutive attacks.
*Tích lũy `min(duration, gap)` giữa các lần tấn công liên tiếp.*
---
*Đừng để quá khứ (previous attack) kéo dài quá mức nếu hiện tại (new attack) đã bắt đầu một chương mới. Hiệu quả thực sự (poisoned time) nằm ở việc biết cắt đứt đúng lúc những tàn dư cũ để nhường chỗ cho tác động mới mạnh mẽ hơn.*
Do not let the past (Previous Attack) last too long if the present (New Attack) has started a new chapter. The true efficiency (Poisoned Time) lies in knowing how to cut off the old remnants at the right time to make room for stronger new impacts.
