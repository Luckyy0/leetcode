# 427. Construct Quad Tree / Xây Dựng Cây Tứ Phân

## Problem Description / Mô tả bài toán
Given a `n x n` binary `grid`, implement a function that constructs a **Quad Tree** to represent this grid.
Cho một `grid` nhị phân kích thước `n x n`, hãy triển khai một hàm để xây dựng một **Cây tứ phân (Quad Tree)** đại diện cho mạng lưới này.

A Quad Tree is a tree data structure in which each internal node has exactly four children: `topLeft`, `topRight`, `bottomLeft`, and `bottomRight`.
Cây tứ phân là một cấu trúc dữ liệu cây trong đó mỗi nút nội bộ có đúng bốn nút con: `topLeft`, `topRight`, `bottomLeft`, và `bottomRight`.

- `isLeaf`: True if the node is a leaf node (all values in the represented grid are the same), or False otherwise.
- `val`: The value of the node. True if the represented grid contains 1s, and False if it contains 0s.

If the `isLeaf` flag is True, `topLeft`, `topRight`, `bottomLeft`, and `bottomRight` should be `null`.
Nếu cờ `isLeaf` là True, các nút con phải là `null`.

### Example 1:
```text
Input: grid = [[0,1],[1,0]]
Output: [[0,1],[1,0],[1,1],[1,1],[1,0]]
Explanation: The grid isn't all the same value, so we divide it into 4 parts.
Top Left: 0 (Leaf)
Top Right: 1 (Leaf)
Bottom Left: 1 (Leaf)
Bottom Right: 0 (Leaf)
```

## Constraints / Ràng buộc
- `n == grid.length == grid[i].length`
- `n == 2^x` where `0 <= x <= 6`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Divide and Conquer / Chia để trị
This problem is solved by recursively checking segments of the grid.

Algorithm:
1. Define a recursive function `build(r1, c1, r2, c2)` that builds a Quad Tree for the subgrid `grid[r1...r2][c1...c2]`.
2. Check if all cells in the current subgrid have the same value:
   - If yes: Return a leaf node with that value.
   - If no: 
     - Create an internal node (`isLeaf = false`).
     - Calculate midpoints to split the subgrid into four quadrants.
     - Recursively call `build` for Each of the four quadrants and assign them as children.
3. Return the root node.

### Complexity / Độ phức tạp
- **Time**: O(N^2 * log N). In each level of division (log N levels), we might scan N^2 total cells. 
- **Space**: O(log N) recursion depth.

---

## Analysis / Phân tích

### Approach: Recursive Splitting

**Algorithm**:
1.  Check uniformity of subgrid.
2.  Recursive calls for 4 quadrants.

---
