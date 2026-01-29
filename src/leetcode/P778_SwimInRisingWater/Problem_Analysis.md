# 778. Swim in Rising Water / Bơi trong Nước đang dâng

## Problem Description / Mô tả bài toán
You are given an `n x n` integer matrix `grid` where each value `grid[i][j]` represents the elevation at that point `(i, j)`.
Bạn được cho một ma trận số nguyên `n x n` `grid` trong đó mỗi giá trị `grid[i][j]` biểu thị độ cao tại điểm đó `(i, j)`.

The rain starts to fall. At time `t`, the depth of the water everywhere is `t`. You can swim from a square to an adjacent 4-directionally square if and only if the elevation of both squares is at most `t`.
Mưa bắt đầu rơi. Tại thời điểm `t`, độ sâu của nước ở khắp mọi nơi là `t`. Bạn có thể bơi từ một ô sang một ô lân cận theo 4 hướng khi và chỉ khi độ cao của cả hai ô tối đa là `t`.

Return the least time until you can reach the bottom right square `(n-1, n-1)` starting from the top left square `(0, 0)`.
Trả về thời gian ít nhất cho đến khi bạn có thể tiếp cận ô dưới cùng bên phải `(n-1, n-1)` bắt đầu từ ô trên cùng bên trái `(0, 0)`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dijkstra's Algorithm or Binary Search / Thuật toán Dijkstra hoặc Tìm kiếm Nhị phân
This is a shortest path problem on a graph where the "cost" of a path is the maximum elevation encountered along the path.
Đây là bài toán tìm đường đi ngắn nhất trên đồ thị, trong đó "chi phí" của một đường đi là độ cao lớn nhất gặp phải dọc theo đường đi đó.

Algorithm (Dijkstra):
1. Use a PriorityQueue to store `(row, col, time)`.
2. Start with `(0, 0, grid[0][0])`.
3. In each step, poll the square with the minimum time.
4. Update the current time: `currentTime = max(previousTime, nextGridElevation)`.
5. Return time when you hit `(n-1, n-1)`.

### Complexity / Độ phức tạp
- **Time**: O(N^2 log N).
- **Space**: O(N^2).

---

## Analysis / Phân tích

### Approach: Min-Max Dijkstra
The path taken is one that minimizes the peak elevation encountered. Dijkstra's with a priority queue naturally explores these optimal paths first.
Đường đi được chọn là đường đi giảm thiểu độ cao đỉnh gặp phải. Thuật toán Dijkstra với hàng đợi ưu tiên sẽ tự nhiên khám phá các đường đi tối ưu này trước.

---
