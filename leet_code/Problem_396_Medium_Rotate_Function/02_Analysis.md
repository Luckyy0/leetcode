# Analysis for Rotate Function
# *Phân tích cho bài toán Hàm Xoay*

## 1. Problem Essence & Math Derivation
## *1. Bản chất vấn đề & Suy luận Toán học*

### The Challenge
### *Thách thức*
Calculating $F(k)$ for all $k \in [0, n-1]$ efficiently. A naive approach would take $O(n^2)$.

### Strategy: Difference Observation
### *Chiến lược: Quan sát sự khác biệt*
Let $S = \sum_{i=0}^{n-1} A[i]$.

Consider $F(k-1)$ and $F(k)$:
$F(0) = 0 \cdot A[0] + 1 \cdot A[1] + \dots + (n-2) \cdot A[n-2] + (n-1) \cdot A[n-1]$
$F(1) = 0 \cdot A[n-1] + 1 \cdot A[0] + \dots + (n-2) \cdot A[n-3] + (n-1) \cdot A[n-2]$

Difference:
$F(1) - F(0) = (A[0] + A[1] + \dots + A[n-2]) - (n-1) \cdot A[n-1]$
$F(1) - F(0) = (S - A[n-1]) - (n-1) \cdot A[n-1]$
$F(1) - F(0) = S - n \cdot A[n-1]$

General Formula:
$F(k) = F(k-1) + S - n \cdot A[n-k]$

---

## 2. Approach: Iterative Math
## *2. Hướng tiếp cận: Toán học Lặp*

### Logic
### *Logic*
1.  Calculate total sum $S$.
2.  Calculate $F(0)$.
3.  Iteratively calculate $F(k)$ using the formula above.
4.  Update the maximum value.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Complexity:** Only requires two linear passes.
    *Hiệu quả O(N): Chỉ yêu cầu hai lần duyệt tuyến tính.*
*   **Constant Space:** No extra arrays needed.
    *Không gian hằng số: Không cần mảng bổ sung.*

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

**Input:** `[4, 3, 2, 6]`
- $S = 4+3+2+6 = 15$.
- $F(0) = 0 \cdot 4 + 1 \cdot 3 + 2 \cdot 2 + 3 \cdot 6 = 25$.
- $F(1) = 25 + 15 - 4 \cdot 6 = 25 + 15 - 24 = 16$.
- $F(2) = 16 + 15 - 4 \cdot 2 = 16 + 15 - 8 = 23$.
- $F(3) = 23 + 15 - 4 \cdot 3 = 23 + 15 - 12 = 26$.
Max result: 26.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Mathematical transition formula.
*Công thức chuyển đổi toán học.*
---
*Xoay chuyển (rotation) không nhất thiết có nghĩa là bắt đầu lại từ đầu. Bằng cách quan sát mối quan hệ giữa cái cũ (F[k-1]) và cái mới, ta có thể tìm thấy một con đường tắt (formula) để đạt được kết quả nhanh hơn gấp ngàn lần. Sự thông thái nằm ở việc nhìn ra quy luật của sự thay đổi.*
Rotation does not necessarily mean starting over from the beginning. By observing the relationship between the old (F[k-1]) and the new, we can find a shortcut (formula) to achieve results thousands of times faster. Wisdom lies in seeing the rules of change.
