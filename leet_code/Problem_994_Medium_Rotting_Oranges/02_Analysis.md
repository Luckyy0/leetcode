# Analysis for Rotting Oranges
# *Phân tích cho bài toán Cam hỏng*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find the minimum time to rot all fresh oranges given multiple initial sources of rotting.
*Tìm thời gian tối thiểu để làm hỏng toàn bộ cam tươi từ nhiều nguồn cam hỏng ban đầu.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- The rotting process spreads out radially from multiple sources at once. This is a classic case for **Multi-source Breadth-First Search (BFS)**.
- We need to enqueue ALL initially rotten oranges (cells with value `2`) at minute `0`.
- We also must track the total number of fresh oranges (cells with value `1`) so we can know if any are left at the end (for the `-1` case).
- In each step of BFS (each minute), we process all oranges at the current level. For each orange, we check its 4 neighbors. If a neighbor is a fresh orange, it becomes rotten, we decrement the fresh orange counter, and we enqueue its coordinates for the next minute.
- Once BFS finishes, if the fresh counter is 0, we return the minutes elapsed (subtract 1 if we increment at the end of every loop, being careful with minute counting). If > 0, return -1.
*Sử dụng BFS từ nhiều nguồn cùng lúc. Bỏ hết cam hỏng vào hàng đợi, Đếm số cam tươi. Duyệt BFS từng phút một. Mỗi khi làm hỏng cam tươi, giảm bộ đếm. Cuối cùng nếu bộ đếm > 0 nghĩa là có quả không thể hỏng.*

---

## 2. Strategy: Multi-source BFS
## *2. Chiến lược: Tuyến tính BFS Đa Nguồn*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize:** Create empty `Queue<int[]> queue`, `freshCount = 0`, `minutes = 0`.
    *   **Khởi tạo:** Hàng đợi queue, biến đếm cam tươi, biến đếm thời gian.*

2.  **Scan Grid:** Scan grid `r` and `c`. If `grid[r][c] == 2`, enqueue `[r, c]`. If `grid[r][c] == 1`, `freshCount++`.
    *   **Quét Lưới:** Lấy vị trí cam hỏng đưa vào hàng đợi, đếm số cam tươi.*

3.  **Process BFS:** While `queue` is not empty.
    - Let `size = queue.size()`.
    - If `freshCount == 0` (or after processing, see logic), break.
    - Loop `size` times (process current level):
      - Poll `[r, c]`. Find 4 valid neighbors.
      - If a neighbor `[nr, nc]` is a fresh orange (`1`), make it rotten (`2`), decrement `freshCount`, and enqueue `[nr, nc]`.
    - `minutes++` after finishing the level, but only if we enqueued anything or if `freshCount` was decremented. Or standard: if `queue` not empty after loop, `minutes++`.
    *   **Bắt đầu BFS:** Duyệt từng lớp (tương đương 1 phút). Thêm cam mới hỏng vào hàng đợi tiếp theo.*

4.  **Return Data:** If `freshCount == 0`, return `minutes`. Else return `-1`.
    *   **Trả về Dữ liệu:** `minutes` nếu hết cam tươi, `-1` nếu còn.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.*;

public class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        
        if (freshCount == 0) return 0; // Already zero
        
        int minutes = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int r = pos[0], c = pos[1];
                
                for (int[] d : dirs) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        freshCount--;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
            minutes++;
        }
        
        return freshCount == 0 ? minutes : -1;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \cdot N)$ where $M$ is the number of rows and $N$ is the number of columns. We visit each cell at most once.
    *   **Độ phức tạp thời gian:** $O(M \cdot N)$.*
*   **Space Complexity:** $O(M \cdot N)$ in the worst case for the queue.
    *   **Độ phức tạp không gian:** $O(M \cdot N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Multi-source Breadth-First search calculates distances perfectly when there are multiple starting points propagating uniformly.
*Khám phá BFS đa nguồn tính toán khoảng cách hoàn hảo khi có nhiều điểm khởi đầu lây lan một cách đồng đều.*
