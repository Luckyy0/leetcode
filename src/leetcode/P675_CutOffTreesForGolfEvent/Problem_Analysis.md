# 675. Cut Off Trees for Golf Event / Chặt cây cho sự kiện Golf

## Problem Description / Mô tả bài toán
You are asked to cut off all the trees in a forest for a golf event. The forest is represented as an `m x n` matrix.
Bạn được yêu cầu chặt bỏ toàn bộ cây trong một khu rừng cho một sự kiện chơi golf. Khu rừng được biểu diễn dưới dạng ma trận `m x n`.

In this matrix:
- 0 means the obstacle can't be passed. / 0 có nghĩa là chướng ngại vật không thể vượt qua.
- 1 means the ground can be walked through. / 1 có nghĩa là đất trống có thể đi qua.
- The tree is represented by an integer greater than 1. / Cây được biểu diễn bằng một số nguyên lớn hơn 1.

You must cut off the trees in order from the lowest to the highest tree. You always start at point `(0, 0)`.
Bạn phải chặt cây theo thứ tự từ cây thấp nhất đến cây cao nhất. Bạn luôn bắt đầu tại điểm `(0, 0)`.

Return the minimum steps you need to walk to cut off all trees. If you can't cut off all trees, return -1.
Trả về số bước tối thiểu bạn cần đi để chặt hết cây. Nếu không thể chặt hết cây, hãy trả về -1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### BFS & Sorting / BFS & Sắp xếp
1. Collect all tree locations and sort them based on height.
2. For each consecutive pair of trees (starting from `(0,0)` to the first tree, then first to second, etc.), find the shortest path using BFS.
3. If any target is unreachable, return -1.

### Complexity / Độ phức tạp
- **Time**: O((M * N)^2) because for each tree (up to M*N), we might do a BFS of size M*N.
- **Space**: O(M * N) for distance maps and queue.

---

## Analysis / Phân tích

### Approach: Sequential Shortest Paths
The problem is effectively multiple "shortest path in a grid" subproblems encountered in a specific order. BFS is ideal for finding the shortest path in an unweighted grid.
Bài toán thực chất là nhiều bài toán con "đường đi ngắn nhất trong lưới" gặp phải theo một thứ tự cụ thể. BFS là lý tưởng để tìm đường đi ngắn nhất trong lưới không trọng số.

---
