# Analysis for Search a 2D Matrix II
# *Phân tích cho bài toán Tìm kiếm trong Ma trận 2D II*

## 1. Problem Essence & The Walk
## *1. Bản chất vấn đề & Cuộc dạo chơi*

### The Matrix Property
### *Tính chất Ma trận*
- Sorted Left to Right.
- Sorted Top to Bottom.
This looks like a BST structure if you squint.

### The Problem
### *Vấn đề*
A standard binary search works on 1D arrays or fully sorted 2D arrays (like Problem 74). Here the rows are sorted, cols are sorted, but `matrix[i][last]` is NOT necessarily `< matrix[i+1][0]`.

### The Solution: Top-Right Corner
### *Giải pháp: Góc Trên-Phải*
If we start at Top-Right `(0, n-1)`:
- Left neighbor is Smaller.
- Bottom neighbor is Larger.
This gives us a clear decision tree.
- If `curr > target`: Go Left (to find smaller).
- If `curr < target`: Go Down (to find larger).
- If `curr == target`: Found.

We can also start at Bottom-Left. (But NOT Top-Left or Bottom-Right, where both neighbors are larger or smaller respectively).
*Bắt đầu từ góc Trên-Phải. Nếu lớn hơn đích -> Qua trái. Nếu nhỏ hơn đích -> Xuống dưới.*

---

## 2. Approach: Staircase Search
## *2. Hướng tiếp cận: Tìm kiếm bậc thang*

### Algorithm
### *Thuật toán*
1.  Initialize `row = 0`, `col = n - 1`.
2.  While `row < m` and `col >= 0`:
    - `val = matrix[row][col]`.
    - If `val == target`: Return `true`.
    - If `val > target`: `col--` (Eliminate current column).
    - If `val < target`: `row++` (Eliminate current row).
3.  Return `false`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Linear Time:** In each step, we either increment row or decrement col. We never backtrack. So max steps is $M + N$.
    *Thời gian tuyến tính: Mỗi bước ta loại bỏ một hàng hoặc một cột. Tổng bước tối đa M + N.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M + N)$.
    *Độ phức tạp thời gian: $O(M + N)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** Target 5. Top-Right = 15.
1.  `(0, 4)` Val 15. `15 > 5`. Go Left.
2.  `(0, 3)` Val 11. `11 > 5`. Go Left.
3.  `(0, 2)` Val 7. `7 > 5`. Go Left.
4.  `(0, 1)` Val 4. `4 < 5`. Go Down.
5.  `(1, 1)` Val 5. `5 == 5`. Found.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

This is the optimal solution for this specific matrix structure. It is often called the "Staircase Search" or "Saddleback Search".
*Đây là giải pháp tối ưu. Nó thường được gọi là "Tìm kiếm bậc thang".*
---
*Đôi khi vị trí quyền lực nhất để quan sát (và tìm kiếm) không phải là trung tâm, mà là góc nhìn nơi bạn có thể phân loại mọi thứ một cách rõ ràng (Góc trên phải).*
Sometimes the most powerful position to observe (and search) is not the center, but the corner where you can clearly categorize everything (Top-Right).
