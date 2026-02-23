# Analysis for Beautiful Arrangement
# *Phân tích cho bài toán Sắp xếp Đẹp*

## 1. Problem Essence & Backtracking
## *1. Bản chất vấn đề & Quay lui*

### The Challenge
### *Thách thức*
Counting permutations satisfying divisibility constraints.
- $N$ is small (up to 15).
- Constraints: `val % index == 0` OR `index % val == 0`.

### Strategy: Backtracking with Pruning
### *Chiến lược: Quay lui với Cắt tỉa*

1.  **State:** `index` (current position to fill, 1 to N), `visited` (boolean array or bitmask).
2.  **Recursion:**
    - Try putting each available number `num` at `index`.
    - Check condition. Recurse if valid.
    - If `index > n`, we found one arrangement. Return 1.

---

## 2. Approach: Simple Backtracking
## *2. Hướng tiếp cận: Quay lui Đơn giản*

### Logic
### *Logic*
(See above).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Small N:** Allows exponential DFS.
    *N nhỏ: Cho phép DFS mũ.*
*   **Bitmask:** Can use integer bitmask for `visited` to be slightly faster, but array is fine for N=15.
    *Bitmask: Có thể dùng bitmask số nguyên cho `visited` để nhanh hơn, nhưng mảng cũng ổn cho N=15.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(k)$, where $k$ is number of valid permutations. Loose bound $O(N!)$.
    *Độ phức tạp thời gian: $O(k)$.*
*   **Space Complexity:** $O(N)$ for recursion stack.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `N=2`
- `idx=1`:
    - Try `num=1`: `1%1==0`. OK. Recurse `idx=2`.
        - `idx=2`: Try `num=2`: `2%2==0`. OK. Recurse `idx=3`. Count++.
        - Backtrack.
    - Try `num=2`: `2%1==0`. OK. Recurse `idx=2`.
        - `idx=2`: Try `num=1`: `2%1==0`. OK. Recurse `idx=3`. Count++.
        - Backtrack.
Result: 2.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Backtracking with visited array.
*Quay lui với mảng đã thăm.*
---
*Vẻ đẹp (beauty) không chỉ là sự tự do vô hạn, mà là sự hài hòa trong khuôn khổ (constraints). Khi mỗi cá nhân (number) tìm được vị trí (index) phù hợp với bản chất của mình (divisibility), cả hệ thống sẽ tạo nên một sự sắp xếp hoàn mỹ (beautiful arrangement).*
Beauty (Beauty) is not only infinite freedom, but harmony within the framework (Constraints). When each individual (number) finds a position (Index) suitable for their nature (Divisibility), the whole system will create a beautiful arrangement.
