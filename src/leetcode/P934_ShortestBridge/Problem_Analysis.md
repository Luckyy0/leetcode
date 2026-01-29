# 934. Shortest Bridge / Cây cầu Ngắn nhất

## Problem Description / Mô tả bài toán
You are given an `n x n` binary matrix `grid` where `1` represents land and `0` represents water. An island is a 4-directionally connected group of `1`s. There are exactly two islands in `grid`.
Bạn được cho một ma trận nhị phân `n x n` `grid` trong đó `1` đại diện cho đất liền và `0` đại diện cho nước. Một hòn đảo là một nhóm các số `1` được kết nối theo 4 hướng. Có chính xác hai hòn đảo trong `grid`.

You can change `0`s to `1`s to connect the two islands into one. Return the smallest number of `0`s you must flip.
Bạn có thể thay đổi số `0` thành số `1` để kết nối hai hòn đảo thành một. Hãy trả về số lượng số `0` ít nhất cần lật.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Multi-source BFS / BFS Đa nguồn
Algorithm:
1. Find the first island using DFS and mark all its cells as visited. Add them to a `Queue`.
2. Perform BFS starting from all cells of the first island simultaneously.
3. The BFS level represents the distance (number of 0s flipped).
4. As soon as the BFS reaches a cell with value `1` (which must belong to the second island), return the current level.

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(N^2).

---

## Analysis / Phân tích

### Approach: Radial expansion
Isolate one island to act as the starting frontier. Expand this frontier outward into the surrounding water using BFS, effectively measuring the shortest gap until the second island is encountered.
Cô lập một hòn đảo để đóng vai trò là biên giới bắt đầu. Mở rộng biên giới này ra vùng nước xung quanh bằng BFS, đo lường khoảng cách ngắn nhất một cách hiệu quả cho đến khi gặp hòn đảo thứ hai.

---
