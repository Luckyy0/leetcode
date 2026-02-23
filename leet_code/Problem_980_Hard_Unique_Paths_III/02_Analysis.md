# Analysis for Unique Paths III
# *Phân tích cho bài toán Các Đường đi Duy nhất III*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find paths from Start to End visiting every non-obstacle cell exactly once (Hamiltonian Path).
*Tìm đường đi từ điểm đầu đến điểm cuối đi qua đúng một lần tất cả các ô hợp lệ (Đường đi Hamilton).*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Grid size is small ($M \times N \le 20$).
- Backtracking (DFS) is feasible.
- Count the number of zeros (`empty`) to determine the length of the required path.
- The path must have length `empty + 2` (start + zeros + end).
- DFS state: `(r, c, remaining_zeros)`.
- Base case:
  - If reach `End` (`2`): check if `remaining_zeros == 0` (all visited). If yes, return 1, else 0.
- Recursive step:
  - Mark `grid[r][c] = -1` (visited).
  - Recurse 4 directions.
  - Backtrack: `grid[r][c] = 0` (unmark).
- Start from `Start` (`1`).
*DFS Backtracking. Đếm số lượng ô 0 trước. Khi DFS, đánh dấu ô đã đi qua. Nếu đến đích và đã đi hết số ô 0 cần thiết -> +1 đường đi.*

---

## 2. Strategy: Backtracking DFS
## *2. Chiến lược: DFS Quay lui*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Init:** Scan grid. Find `start_r`, `start_c`. Count `empty` cells (0s). Actually count non-obstacles (0s and 1) or just 0s. Let's count 0s.
    *   **Khởi tạo:** Tìm điểm bắt đầu và đếm số ô trống.*

2.  **DFS(r, c, zeros_left):**
    - Check bounds and obstacles (`grid[r][c] == -1`). Return 0.
    - If `grid[r][c] == 2`: Return `zeros_left == -1` ? 1 : 0. (Why -1? Because we decrement when entering a cell. Start is not 0, so entering start decrements nothing? Or simply, count total walk-able cells - 1).
    - Logic:
      - Better: Count total non-obstacle cells `count`.
      - DFS decrements count.
      - At End, check if `count == 1` (only End remaining) or `count == 0` (if updated after visit).
    - Let's use `zeros` count.
      - Init `zeros` = count of 0s.
      - Start DFS at `1`.
      - In DFS:
        - If `2`: return `zeros == -1` ? 1 : 0. (Because we visited start but didn't decrement zeros for it. But we decrement for every 0 visited. The last step to 2 doesn't decrement zero count).
        - Mark `grid[r][c] = -1`.
        - `zeros--`.
        - Loop neighbors. `total += dfs(nr, nc, zeros)`.
        - Backtrack: `grid[r][c] = 0`. `zeros++`.
        - Return `total`.
    *   **DFS:** Đệ quy, đánh dấu, quay lui.*

3.  **Return:** Result from DFS.
    *   **Trả về:** Kết quả.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public class Solution {
    int rows, cols;
    int totalPaths = 0;
    
    public int uniquePathsIII(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int emptyCells = 0;
        int startR = 0, startC = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != -1) {
                    emptyCells++; // Count all non-obstacles
                }
                if (grid[i][j] == 1) {
                    startR = i;
                    startC = j;
                }
            }
        }
        
        // DFS starting from start node
        // Visited count starts at 1 (the start node itself)
        dfs(grid, startR, startC, 1, emptyCells);
        
        return totalPaths;
    }
    
    private void dfs(int[][] grid, int r, int c, int visitedCount, int targetCount) {
        // Check bounds and obstacles
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == -1) {
            return;
        }
        
        // If reached end
        if (grid[r][c] == 2) {
            if (visitedCount == targetCount) {
                totalPaths++;
            }
            return;
        }
        
        // Mark as visited (temporarily changing to -1)
        int temp = grid[r][c];
        grid[r][c] = -1;
        
        // Explore 4 directions
        dfs(grid, r + 1, c, visitedCount + 1, targetCount);
        dfs(grid, r - 1, c, visitedCount + 1, targetCount);
        dfs(grid, r, c + 1, visitedCount + 1, targetCount);
        dfs(grid, r, c - 1, visitedCount + 1, targetCount);
        
        // Backtrack
        grid[r][c] = temp;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(3^N)$ where N is number of empty cells. Branching factor 3 (don't go back). Small $N \le 20$.
    *   **Độ phức tạp thời gian:** $O(3^N)$.*
*   **Space Complexity:** $O(N)$ for recursion stack.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Standard backtracking for Hamiltonian path on grid. Small constraints make it efficient.
*Quay lui chuẩn cho bài toán đường đi Hamilton trên lưới.*
