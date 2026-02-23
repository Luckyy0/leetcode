# Analysis for Bomb Enemy
# *Phân tích cho bài toán Đặt bom Kẻ địch*

## 1. Problem Essence & Dynamic Recomputation
## *1. Bản chất vấn đề & Tính toán lại Năng động*

### The Challenge
### *Thách thức*
Calculating the number of enemies in a row and column segment reachable from an empty cell. Since segments are defined by walls, multiple cells in the same row/column might share the same segment count.

### Strategy: Caching Segment Totals
### *Chiến lược: Lưu trữ Tổng số Phân đoạn*
1.  **Row Count:** For each cell $(i, j)$, if it's at the start of a row or the previous cell was a wall, calculate the number of enemies in the current row segment until the next wall or row end. Cache this `rowCnt`.
2.  **Column Count:** Similarly, maintain an array `colCnt[n]` to store the number of enemies in the current column segment for each column $j$. Update `colCnt[j]` only when at the start of a column or when the previous cell in that column was a wall.
3.  **Maximum Check:** If the current cell is empty (`'0'`), the total enemies killed is `rowCnt + colCnt[j]`. Update the global maximum.

---

## 2. Approach: Iterative Pass with Caching
## *2. Hướng tiếp cận: Duyệt Lặp với Bộ nhớ đệm*

### Logic
### *Logic*
(See above). We iterate through the grid row by row. This ensures $O(MN)$ complexity as each cell's contribution to row/col counts is calculated only once per segment.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(MN) Efficiency:** Total time is linear with respect to the number of cells.
    *Hiệu quả O(MN): Thời gian tuyến tính so với số lượng ô.*
*   **Minimal Space:** We only need an array of size $N$ for column counts.
    *Không gian tối thiểu: Chỉ cần một mảng kích thước N cho các cột.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \times N)$.
    *Độ phức tạp thời gian: $O(M \times N)$.*
*   **Space Complexity:** $O(N)$ for `colCnt` array.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[["0","E","W"]]`
1. Row 0, Cell 0: Start of row. Calculate rowCnt = 1 (until W at index 2).
2. Row 0, Cell 0: colCnt[0] calculated.
3. If cell is '0', max = rowCnt + colCnt[0].
4. Move to next cell.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Segment-based caching is the optimal way.
*Lưu trữ theo phân đoạn là cách tối ưu nhất.*
---
*Đôi khi chúng ta không cần phải bắt đầu lại từ đầu cho mỗi bước đi (every cell). Bằng cách nhận ra những ranh giới (walls) và tận dụng thành quả của những bước trước đó (cached counts), ta có thể đạt được hiệu quả tối đa với chi phí thấp nhất.*
Sometimes we don't need to start over for every step (every cell). By recognizing boundaries (walls) and utilizing the achievements of previous steps (cached counts), we can achieve maximum efficiency with minimal cost.
