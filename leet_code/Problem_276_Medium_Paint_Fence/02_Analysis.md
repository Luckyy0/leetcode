# Analysis for Paint Fence
# *Phân tích cho bài toán Sơn hàng rào*

## 1. Problem Essence & DP
## *1. Bản chất vấn đề & Quy hoạch động*

### The Constraint
### *Ràng buộc*
"No 3 consecutive posts have same color".
Let `i` be the current post.
Color of `i` can be:
1.  **Same** as `i-1`: This is valid ONLY if `i-1` was DIFFERENT from `i-2`.
2.  **Different** from `i-1`: This is always valid regardless of `i-1` vs `i-2`.

### DP State
### *Trạng thái DP*
Let `same[i]` = ways to paint `i` same color as `i-1`.
Let `diff[i]` = ways to paint `i` different color from `i-1`.
Total ways at `i` = `same[i] + diff[i]`.

### Transitions
### *Chuyển đổi*
1.  **To get Same color at `i`:**
    - `i` matches `i-1`.
    - Constraint: No 3 same. So `i-1` MUST NOT match `i-2`.
    - So `same[i]` comes from `diff[i-1]`.
    - How many choices? Only 1 (the same color as `i-1`).
    - `same[i] = diff[i-1] * 1`.

2.  **To get Diff color at `i`:**
    - `i` acts differently from `i-1`.
    - Previous state could be `same[i-1]` OR `diff[i-1]`.
    - How many choices? `k-1` colors.
    - `diff[i] = (same[i-1] + diff[i-1]) * (k-1)`.
    - `diff[i] = total[i-1] * (k-1)`.

Total `total[i] = same[i] + diff[i]`.

### Base Cases
### *Trường hợp cơ sở*
`n=1`: `total[1] = k`. (`same=0` because no prev, `diff=k`).
`n=2`:
- `same[2] = k * 1`. (Two posts same color).
- `diff[2] = k * (k-1)`. (Two posts diff color).
- `total[2] = k + k*(k-1) = k*k`.

---

## 2. Approach: Iterative DP (Space Optimized)
## *2. Hướng tiếp cận: DP Lặp (Tối ưu không gian)*

### Logic
### *Logic*
If `n=1` return `k`.
If `n=2` return `k*k`.
`same = k`.
`diff = k * (k-1)`.
Loop `i` from 3 to `n`:
- `prevSame = same`
- `prevDiff = diff`
- `same = prevDiff`
- `diff = (prevSame + prevDiff) * (k-1)`
Return `same + diff`.

Simplified:
`total[i] = (total[i-1] + total[i-2]) * (k-1)`. Wait?
Let's check.
`same[i] = diff[i-1] = total[i-2] * (k-1)`.
`diff[i] = total[i-1] * (k-1)`.
So `total[i] = total[i-2]*(k-1) + total[i-1]*(k-1)`.
Yes! `total[i] = (k-1) * (total[i-1] + total[i-2])`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Recursion:** Similar to Python characteristic equation sequence.
    *Đệ quy: Tương tự dãy phương trình đặc trưng.*

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

**Input:** `n=3, k=2`.
1.  `n=1`: Total 2.
2.  `n=2`: Total `2*2 = 4`.
3.  `n=3`: `(2-1) * (4 + 2) = 1 * 6 = 6`.
Possibilities:
- 001, 010, 011
- 110, 101, 100
(Total 6). Valid.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Simple recurrence.
*Công thức truy hồi đơn giản.*
---
*Đừng bao giờ lặp lại chính mình quá hai lần (no 3 consecutive). Sự thay đổi (different color) mang lại nhiều cơ hội hơn sự lặp lại (same color).*
Never repeat yourself more than twice (no 3 consecutive). Change (different color) offers more opportunities than repetition (same color).
