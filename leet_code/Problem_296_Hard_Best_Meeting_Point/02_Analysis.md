# Analysis for Best Meeting Point
# *Phân tích cho bài toán Điểm Gặp gỡ Tốt nhất*

## 1. Problem Essence & Median
## *1. Bản chất vấn đề & Trung vị*

### The Metric
### *Thước đo*
Manhattan Distance: $|x_1 - x_2| + |y_1 - y_2|$.
We want to minimize $\sum (|fx_i - mx| + |fy_i - my|)$.
This can be separated into two independent problems:
1.  Minimize $\sum |fx_i - mx|$ for X coordinate.
2.  Minimize $\sum |fy_i - my|$ for Y coordinate.
Total Sum = Min(X-dist) + Min(Y-dist).

### 1D Problem: Minimize Total Distance
### *Bài toán 1D: Giảm thiểu Tổng Khoảng cách*
Given points on a line, find point $M$ that minimizes sum of distances.
This is a classic property: **The Median minimizes the sum of absolute differences.**
- If odd count: Median is the middle element.
- If even count: Any point between the two middle elements (inclusive) works.

So, we just need to collect all row indices, sort them, find median. Collect all col indices, sort them, find median.
Then compute sum of distances.

### Optimizing Collection
### *Tối ưu hóa việc thu thập*
- Rows: Iterate `i` from 0 to `m`, `j` from 0 to `n`. If `grid[i][j]==1`, add `i` to `rows`. Since we iterate `i` in order, `rows` is *already sorted*.
- Cols: Iterate `j` from 0 to `n`, `i` from 0 to `m`. If `grid[i][j]==1`, add `j` to `cols`. Since we iterate `j` in outer loop, `cols` is *already sorted*.
Sorting step avoided!

---

## 2. Approach: Median Separated Coordinates
## *2. Hướng tiếp cận: Tọa độ phân tách theo Trung vị*

### Logic
### *Logic*
1.  Collect `rows` list (Already sorted if scanned row by row).
2.  Collect `cols` list (Scan col by col to get sorted).
3.  Calculate `getMinDist(rows)`.
    - Two pointers: `left=0`, `right=size-1`.
    - `dist += list[right] - list[left]`. `left++`, `right--`.
    - This implicitly calculates distance to median.
    - Example: `[0, 4, 2]` -> sorted `[0, 2, 4]`. Median 2. Dist $|0-2| + |2-2| + |4-2| = 2+0+2 = 4$.
    - Formula `(4-0)` covers the outer pair's contribution to reaching the median. `(2-2)` covers inner.
    - Correct: `sum(right - left)`.
4.  Total = `distRows + distCols`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Independence:** Breaking 2D Manhattan into two 1D problems greatly simplifies complexity.
    *Tính độc lập: Chia Manhattan 2D thành hai bài toán 1D đơn giản hóa độ phức tạp rất nhiều.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \cdot N)$ to scan grid.
    *Độ phức tạp thời gian: $O(M \cdot N)$.*
*   **Space Complexity:** $O(M + N)$ to store coordinates.
    *Độ phức tạp không gian: $O(M + N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** (0,0), (0,4), (2,2)
Rows: `[0, 0, 2]`. Median 0.
Dist: $|0-0| + |0-0| + |2-0| = 2$.
Alternatively 2-ptr: `2 - 0 = 2`. `left`, `right` meet. Res 2.

Cols: `(0,0), (0,4), (2,2)` -> Indices: `0, 4, 2`.
Sorted Cols: `[0, 2, 4]`. Median 2.
Dist: $|0-2| + |2-2| + |4-2| = 2+0+2 = 4$.
Alternatively 2-ptr: `4 - 0`. Res 4.

Total: 2 + 4 = 6. Correct.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Separating dimensions is the key insight for Manhattan distance minimization.
*Tách chiều là điểm mấu chốt để tối thiểu hóa khoảng cách Manhattan.*
---
*Để tìm điểm cân bằng tốt nhất (best meeting point), hãy giải quyết từng vấn đề một cách độc lập (tách tọa độ). Sự chia tách đôi khi dẫn đến sự thống nhất tối ưu.*
To find the best equilibrium (best meeting point), solve each problem independently (separate coordinates). Division sometimes leads to optimal unity.
