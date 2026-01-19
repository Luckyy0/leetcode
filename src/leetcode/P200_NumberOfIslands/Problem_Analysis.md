# 200. Number of Islands / Số lượng Đảo

## Problem Description / Mô tả bài toán
Given an `m x n` 2D binary grid `grid` which represents a map of `'1'`s (land) and `'0'`s (water), return the number of islands.
Cho một lưới nhị phân 2D `grid` kích thước `m x n` đại diện cho bản đồ các số `'1'` (đất) và `'0'` (nước), hãy trả về số lượng các hòn đảo.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
Một hòn đảo được bao quanh bởi nước và được hình thành bằng cách kết nối các vùng đất liền kề theo chiều ngang hoặc chiều dọc. Bạn có thể giả định rằng tất cả bốn cạnh của lưới đều được bao quanh bởi nước.

### Example 1:
```text
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
```

### Example 2:
```text
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
```

## Constraints / Ràng buộc
- `m == grid.length`
- `n == grid[i].length`
- `1 <= m, n <= 300`
- `grid[i][j]` is `'0'` or `'1'`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Depth First Search (DFS) / Tìm kiếm theo chiều sâu
This problem is a classic connected components problem in a graph. Each '1' can be seen as a node, and adjacent '1's have edges between them.
Bài toán này là một bài toán tìm các thành phần liên thông kinh điển trong đồ thị. Mỗi số '1' có thể được coi là một nút, và các số '1' liền kề có các cạnh giữa chúng.

1.  Iterate through each cell in the grid.
2.  If we find a '1', we have found a new island.
3.  Perform DFS starting from this cell to mark all connected '1's as visited (e.g., change them to '0').
4.  Increment the island count.

---

## Analysis / Phân tích

### Approach: Depth First Search (DFS)

**Complexity / Độ phức tạp**:
- **Time**: O(M * N) - we visit each cell once.
- **Space**: O(M * N) - in the worst case (the grid is all land), the recursion stack could reach M * N.

---

## Edge Cases / Các trường hợp biên
1.  **Grid is all '0'**: Result is 0.
2.  **Grid is all '1'**: Result is 1.
3.  **Disconnected islands**.
4.  **Islands at the borders**.
