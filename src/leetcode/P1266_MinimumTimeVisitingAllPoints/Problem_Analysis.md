# 1266. Minimum Time Visiting All Points / Thời gian Tối thiểu Ghé thăm Tất cả các Điểm

## Problem Description / Mô tả bài toán
Points in 2D plane. Visit points in order.
Move: vertical, horizontal, or diagonal (1 unit).
Each step takes 1 second.
Min time to travel from current to next point.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Chebyshev Distance
Distance between `(x1, y1)` and `(x2, y2)` with diagonal moves allowed is `max(|x1 - x2|, |y1 - y2|)`.
This is because we can move diagonally to reduce both coordinates' difference until one matches, then move straight.
Total time = sum of Chebyshev distances between consecutive points.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Chebyshev Distance Summation
The cost to move between two points $(x_1, y_1)$ and $(x_2, y_2)$ allowing horizontal, vertical, and diagonal moves is given by the Chebyshev distance: $\max(|x_1 - x_2|, |y_1 - y_2|)$. Iterate through the sequence of points and sum the distances between adjacent points.
Chi phí để di chuyển giữa hai điểm $(x_1, y_1)$ và $(x_2, y_2)$ cho phép các bước di chuyển ngang, dọc và chéo được xác định bởi khoảng cách Chebyshev: $\max(|x_1 - x_2|, |y_1 - y_2|)$. Lặp lại qua chuỗi các điểm và cộng tổng khoảng cách giữa các điểm liền kề.

---
