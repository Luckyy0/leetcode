# Analysis for Shortest Bridge
# *Phân tích cho bài toán Cây Cầu Ngắn nhất*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find the shortest path of `0`s between two distinct islands of `1`s.
*Tìm đường đi ngắn nhất của các số `0` nối giữa hai hòn đảo riêng biệt của các số `1`.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- There are exactly two islands.
- We need to find the minimum distance between any cell of Island A and any cell of Island B.
- Strategy:
  1. Find the first island (using DFS/BFS).
  2. Mark all cells of the first island (e.g., change `1` to `2`) and add them to a Queue.
  3. Start a Multi-source BFS from all cells of the first island.
  4. Expand layer by layer into the water (`0`).
  5. The first time we encounter a `1` (which belongs to the second island), the number of steps taken is the answer.
*Có đúng 2 hòn đảo. Tìm khoảng cách ngắn nhất giữa chúng. 1. Tìm đảo đầu tiên (DFS). 2. Đánh dấu và thêm tất cả ô đảo 1 vào Queue. 3. BFS đa nguồn từ đảo 1 lan ra nước. 4. Gặp đảo 2 thì trả về số bước.*

---

## 2. Strategy: DFS + Multi-source BFS
## *2. Chiến lược: DFS + BFS Đa nguồn*

### Algorithm Steps
### *Các bước thuật toán*

1.  **DFS to find 1st Island:**
    - Scan grid. Find first `1`.
    - Run DFS from there. Change all connected `1`s to `2`.
    - Collect all these coordinates into a `queue` for BFS.
    *   **DFS tìm đảo 1:** Duyệt tìm số 1 đầu tiên. DFS đổi thành 2. Lưu vào `queue`.*

2.  **BFS to find shortest path:**
    - Initialize `steps = 0`.
    - While `queue` not empty:
        - Process level (`size = queue.size()`).
        - For each cell, check neighbors.
        - If neighbor is `1`: It's the 2nd island! Return `steps`.
        - If neighbor is `0`: Change to `2` (mark visited) and add to `queue`.
        - If neighbor is `2`: Ignore.
    - Increment `steps`.
    *   **BFS tìm đường ngắn nhất:** Duyệt BFS từng lớp. Gặp 1 -> xong. Gặp 0 -> đổi thành 2, thêm vào queue.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.*;

public class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        boolean found = false;
        
        // 1. DFS to find the first island and add to queue
        for (int i = 0; i < n; i++) {
            if (found) break;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, n, q);
                    found = true;
                    break;
                }
            }
        }
        
        // 2. BFS to find the second island
        int steps = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                
                for (int[] d : dirs) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                        if (grid[nr][nc] == 1) {
                            return steps; // Found the second island
                        } else if (grid[nr][nc] == 0) {
                            grid[nr][nc] = 2; // Mark as visited
                            q.offer(new int[]{nr, nc});
                        }
                    }
                }
            }
            steps++;
        }
        
        return -1; // Should not reach here
    }
    
    private void dfs(int[][] grid, int r, int c, int n, Queue<int[]> q) {
        if (r < 0 || r >= n || c < 0 || c >= n || grid[r][c] != 1) return;
        
        grid[r][c] = 2; // Mark as part of first island/visited
        q.offer(new int[]{r, c});
        
        dfs(grid, r + 1, c, n, q);
        dfs(grid, r - 1, c, n, q);
        dfs(grid, r, c + 1, n, q);
        dfs(grid, r, c - 1, n, q);
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2)$. We visit each cell at most once during DFS and at most once during BFS.
    *   **Độ phức tạp thời gian:** $O(N^2)$.*
*   **Space Complexity:** $O(N^2)$ for queue and recursion stack.
    *   **Độ phức tạp không gian:** $O(N^2)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Using DFS to identify the source set and BFS to expand layer-by-layer is the standard optimal approach for shortest path between components.
*Sử dụng DFS để xác định tập nguồn và BFS để mở rộng theo từng lớp là phương pháp tối ưu tiêu chuẩn cho đường đi ngắn nhất giữa các thành phần.*
