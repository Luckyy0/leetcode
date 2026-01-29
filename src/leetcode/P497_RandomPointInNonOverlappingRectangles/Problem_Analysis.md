# 497. Random Point in Non-overlapping Rectangles / Điểm Ngẫu Nhiên Trong Các Hình Chữ Nhật Không Chồng Lấn

## Problem Description / Mô tả bài toán
You are given an array of non-overlapping axis-aligned rectangles `rects` where `rects[i] = [ai, bi, xi, yi]` indicates that `(ai, bi)` is the bottom-left corner and `(xi, yi)` is the top-right corner of the `i-th` rectangle. 
Bạn được cho một mảng các hình chữ nhật không chồng lấn `rects` trong đó `rects[i] = [ai, bi, xi, yi]` cho biết `(ai, bi)` là góc dưới bên trái và `(xi, yi)` là góc trên bên phải của hình chữ nhật thứ `i`.

Design an algorithm to pick a random integer point inside the space covered by one of the given rectangles. A point on the boundary of a rectangle is included. In the space covered by the rectangles, each integer point should be equally likely to be sampled.
Hãy thiết kế một thuật toán để chọn một điểm nguyên ngẫu nhiên bên trong không gian được bao phủ bởi các hình chữ nhật. Mỗi điểm nguyên nên có xác suất được chọn như nhau.

Implement the `Solution` class:
- `Solution(int[][] rects)` Initializes the object with the given rectangles `rects`.
- `pick()` Returns a random integer point `[u, v]` inside the space covered by one of the given rectangles.

### Example 1:
```text
Input: ["Solution","pick","pick","pick"]
[[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[]]
Output: [null,[-1,-2],[2,0],[-2,-1]]
```

## Constraints / Ràng buộc
- `1 <= rects.length <= 100`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Weighted Sampling (Prefix Sum + Binary Search) / Lấy mẫu có trọng số (Tổng tiền tố + Tìm kiếm nhị phân)
Since each **integer point** must have an equal probability, we should first pick a rectangle with probability proportional to the **number of integer points** it contains, then pick a random point within that rectangle.

Algorithm:
1. For each rectangle `[x1, y1, x2, y2]`:
   - Number of points is `(x2 - x1 + 1) * (y2 - y1 + 1)`.
2. Compute the **prefix sum** of these point counts.
3. To `pick()`:
   - Generate a random number `r` in `[1, totalPoints]`.
   - Use **binary search** on the prefix sums to find which rectangle the `r-th` point belongs to.
   - Once a rectangle is selected, pick a random `x` in `[x1, x2]` and random `y` in `[y1, y2]`.

### Complexity / Độ phức tạp
- **Initialization**: O(N) where N is the number of rectangles.
- **Pick**: O(log N) for binary search.
- **Space**: O(N) for the prefix sums.

---

## Analysis / Phân tích

### Approach: Area-Weighted Rectangle Selection

**Algorithm**:
1.  Map rectangles to discrete point ranges.
2.  Random target within total point count.
3.  Binary search to select rectangle.
4.  Local uniform point generation.

---
