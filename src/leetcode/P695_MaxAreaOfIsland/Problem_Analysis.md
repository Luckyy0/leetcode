# 695. Max Area of Island / Diện tích Lớn nhất của Đảo

## Problem Description / Mô tả bài toán
You are given an `m x n` binary matrix `grid`. An island is a group of `1`s (representing land) connected **4-directionally** (horizontal or vertical.)
Bạn được cho một ma trận nhị phân `m x n` `grid`. Một hòn đảo là một nhóm các số `1` (đại diện cho đất) được kết nối theo **4 hướng** (ngang hoặc dọc).

The **area** of an island is the number of cells with value `1` in the island.
**Diện tích** của một hòn đảo là số lượng ô có giá trị `1` trong hòn đảo đó.

Return the maximum **area** of an island in `grid`. If there is no island, return 0.
Trả về **diện tích lớn nhất** của một hòn đảo trong `grid`. Nếu không có đảo, hãy trả về 0.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Flood Fill / DFS / BFS / Thuật toán Loang
This problem asks for the size of the largest connected component in a grid.
Bài toán này yêu cầu tìm kích thước của thành phần được kết nối lớn nhất trong lưới.

For each cell that is part of an unvisited island:
1. Start a DFS exploration.
2. Count the number of cells reached.
3. Update the global maximum area.
4. Mark visited cells to avoid recounting.

### Complexity / Độ phức tạp
- **Time**: O(M * N) since each cell is processed once.
- **Space**: O(M * N) for the recursion stack in the worst case (e.g., all 1s).

---

## Analysis / Phân tích

### Approach: Standard DFS Exploration
Iterate through the grid. When a `1` is found, call a recursive `getArea` function that marks the cell and its neighbors as visited and returns the total area.
Lặp lại qua lưới. Khi tìm thấy số `1`, hãy gọi hàm `getArea` đệ quy đánh dấu ô và các ô lân cận của nó là đã truy cập và trả về tổng diện tích.

---
