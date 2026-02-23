# Analysis for Patching Array
# *Phân tích cho bài toán Vá Mảng*

## 1. Problem Essence & Greedy
## *1. Bản chất vấn đề & Tham lam*

### The Range
### *Phạm vi*
Suppose we can form all sums in `[1, miss)`. (i.e., `1` to `miss - 1`).
We want to extend this range.
Next available number in `nums` is `x`.
- If `x <= miss`:
  We can now form `[1, miss)` AND `[1+x, miss+x)`.
  Since `x <= miss`, these intervals overlap/touch.
  New range: `[1, miss + x)`.
  Update `miss = miss + x`. consume `x`.
- If `x > miss` (or no numbers left):
  We cannot form `miss`. We must patch.
  Best patch? Add `miss` itself.
  Why? Adding `miss` extends range to `[1, miss + miss)`.
  This is the largest possible extension without gaps.
  Update `miss = miss + miss`. `patches++`.

### Strategy: Greedy Range Extension
### *Chiến lược: Mở rộng Phạm vi Tham lam*
Loop while `miss <= n`.
Check `nums[i]`.
Apply logic above.
Note: use `long` for `miss` to avoid overflow as `n` is int max.

---

## 2. Approach: Greedy
## *2. Hướng tiếp cận: Tham lam*

### Logic
### *Logic*
(See above).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Optimal Patches:** Always doubling the range guarantees minimum patches for gaps.
    *Bản vá tối ưu: Luôn nhân đôi phạm vi đảm bảo số bản vá tối thiểu cho các khoảng trống.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M + \log N)$. $M$ is nums length. $\log N$ because `miss` doubles.
    *Độ phức tạp thời gian: $O(M + \log N)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[1, 5, 10]`, n=20.
`miss` = 1.
1. `nums[0]=1 <= 1`. New miss = 1+1=2. Range [1, 2). i++.
2. `nums[1]=5 > 2`. Patch 2. New miss = 2+2=4. Range [1, 4). Patches=1.
3. `nums[1]=5 > 4`. Patch 4. New miss = 4+4=8. Range [1, 8). Patches=2.
4. `nums[1]=5 <= 8`. New miss = 8+5=13. Range [1, 13). i++.
5. `nums[2]=10 <= 13`. New miss = 13+10=23. Range [1, 23). i++.
6. `miss 23 > 20`. Stop.
Result: 2.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Greedy algorithm focusing on "missing" sum.
*Thuật toán tham lam tập trung vào tổng "còn thiếu".*
---
*Khi đối mặt với khoảng trống (missing value), cách tốt nhất (greedy) không phải là lấp đầy một cách ngẫu nhiên, mà là bổ sung chính thứ ta đang thiếu hụt nhất để nhân đôi khả năng (double the range) của bản thân.*
When facing a gap (missing value), the best way (greedy) is not to fill it randomly, but to supplement exactly what we are missing most to double our capabilities (double the range).
