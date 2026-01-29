# 407. Trapping Rain Water II / Bẫy Nước Mưa II

## Problem Description / Mô tả bài toán
Given an `m x n` integer matrix `heightMap` representing the height of each unit cell in a 2D elevation map, return the volume of water it can trap after raining.
Cho một ma trận số nguyên `m x n` mang tên `heightMap` đại diện cho chiều cao của mỗi ô đơn vị trong một bản đồ độ cao 2D, hãy trả về thể tích nước mà nó có thể bẫy được sau khi trời mưa.

### Example 1:
```text
Input: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
Output: 4
Explanation: After the rain, water is trapped between the taller blocks.
The total volume of trapped water is 4.
```

### Example 2:
```text
Input: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
Output: 10
```

## Constraints / Ràng buộc
- `m == heightMap.length`
- `n == heightMap[i].length`
- `1 <= m, n <= 200`
- `0 <= heightMap[i][j] <= 2 * 10^4`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Priority Queue + BFS / Ngăn xếp ưu tiên + BFS
The water trapped in any cell is limited by the minimum height of the boundary that surrounds it.

Algorithm:
1.  Initialize a `PriorityQueue` of cells `{row, col, height}` sorted by height in ascending order.
2.  Add all boundary cells of the `heightMap` to the PQ and mark them as `visited`.
3.  While the PQ is not empty:
    - Pop the cell with the minimum height, let's call it `current`.
    - Explore its 4 neighbors:
      - If a neighbor is within bounds and not visited:
        - If `heightMap[neighbor] < current.height`:
          - Add trapped water: `current.height - heightMap[neighbor]`.
          - Update `heightMap[neighbor]` to `current.height` (effectively treating it as a higher boundary).
        - Push the neighbor into PQ and mark as visited.

This approach is similar to Dijkstra's algorithm where the "priority" is the height of the lowest point on the boundary surrounding a region.

### Complexity / Độ phức tạp
- **Time**: O(M * N * log(M * N)) due to Priority Queue operations for each cell.
- **Space**: O(M * N) for the `visited` array and the Priority Queue.

---

## Analysis / Phân tích

### Approach: Boundary Min-Heap BFS

**Algorithm**:
1.  Use a `Cell` class or an array to store coordinates and height.
2.  Populate boundary, then perform the expansion.

---
