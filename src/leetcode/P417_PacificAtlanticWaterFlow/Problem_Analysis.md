# 417. Pacific Atlantic Water Flow / Dòng Chảy Thái Bình Dương và Đại Tây Dương

## Problem Description / Mô tả bài toán
There is an `m x n` rectangular island that borders both the Pacific Ocean and the Atlantic Ocean. The **Pacific Ocean** touches the island's left and top edges, and the **Atlantic Ocean** touches the island's right and bottom edges.
Có một hòn đảo hình chữ nhật `m x n` tiếp giáp với cả Thái Bình Dương và Đại Tây Dương. Thái Bình Dương tiếp giáp với các cạnh trái và trên, còn Đại Tây Dương tiếp giáp với các cạnh phải và dưới.

The island is partitioned into a grid of square cells. You are given an `m x n` integer matrix `heights` where `heights[r][c]` represents the height above sea level of the cell at coordinate `(r, c)`.
Hòn đảo được chia thành một mạng lưới các ô. Bạn được cho một ma trận `heights` trong đó `heights[r][c]` đại diện cho độ cao của ô đó.

Water can flow in 4 directions (up, down, left, right) from a cell to an adjacent one with an equal or lower height. Water can also flow from any cell adjacent to an ocean into the ocean.
Nước có thể chảy theo 4 hướng từ một ô sang ô lân cận có độ cao bằng hoặc thấp hơn. Nước cũng có thể chảy từ ô tiếp giáp biển vào biển.

Return a 2D list of coordinates `result` where `result[i] = [ri, ci]` means that rain water can flow from cell `(ri, ci)` to **both** the Pacific and Atlantic oceans.
Hãy trả về một danh sách các tọa độ nơi nước mưa có thể chảy từ ô đó đến **cả hai** đại dương.

### Example 1:
```text
Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
```

### Example 2:
```text
Input: heights = [[1]]
Output: [[0,0]]
```

## Constraints / Ràng buộc
- `m == heights.length`
- `n == heights[r].length`
- `1 <= m, n <= 200`
- `0 <= heights[r][c] <= 10^5`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Reverse Flow BFS/DFS / Duyệt ngược từ các đại dương
Checking every cell to see if it can reach both oceans would be O((MN)^2). A more efficient approach is to start from the oceans and flow "uphill" to mark reachable cells.

Algorithm:
1. Create two boolean matrices: `pacificReachable` and `atlanticReachable`.
2. Perform DFS/BFS starting from all cells bordering the Pacific Ocean (top row and left column). During this traversal, move from `current` to `neighbor` only if `heights[neighbor] >= heights[current]`. Mark visited cells in `pacificReachable`.
3. Perform a second DFS/BFS starting from all cells bordering the Atlantic Ocean (bottom row and right column). Mark visited cells in `atlanticReachable`.
4. Iterate through all cells. If a cell is marked in both matrices, add its coordinates to the result.

### Complexity / Độ phức tạp
- **Time**: O(M * N) as we visit each cell at most twice.
- **Space**: O(M * N) for the reachability matrices.

---

## Analysis / Phân tích

### Approach: BFS from Boundaries

**Algorithm**:
1.  Initialize queues for Pacific and Atlantic BFS.
2.  Populate queues with boundary cells.
3.  Implement BFS helper to mark reachable cells.
4.  Find intersection.

---
