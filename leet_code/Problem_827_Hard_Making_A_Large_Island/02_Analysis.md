# Analysis for Making A Large Island
# *Phân tích cho bài toán Tạo một Hòn đảo Lớn*

## 1. Problem Essence & Connection Logic
## *1. Bản chất vấn đề & Logic Kết nối*

### THE CHALLENGE
### *Thách thức*
We need to find the maximum possible island area by flipping at most one `0` to `1`.
A naive approach (flipping each zero and running DFS) would be $O(N^4)$, which is too slow for $N=500$.
A better approach is to pre-calculate all existing island areas and then see which islands can be merged by flipping a `0`.
*Chúng ta cần tìm diện tích hòn đảo lớn nhất có thể có bằng cách chuyển tối đa một số `0` thành `1`. Cách tiếp cận thô (đổi từng số 0 rồi chạy DFS) sẽ mất $O(N^4)$, quá chậm. Cách tốt hơn là tính trước diện tích các hòn đảo hiện có và xem những hòn đảo nào có thể gộp lại khi đổi một số `0`.*

---

## 2. Strategy: Island Labeling & Area Mapping
## *2. Chiến lược: Đánh nhãn Đảo & Bản đồ Diện tích*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Iterate and Label:**
    - Traverse the grid. For each unvisited `1`, run a DFS/BFS to find all connected `1`s.
    - Give this island a unique ID (starting from 2, since 0 and 1 are already used).
    - Store the island's area in a `Map<Integer, Integer>` where key is ID and value is area.
    - Mark all cells of this island in the grid with its ID.
    *   **Duyệt và Đánh nhãn:** Duyệt ma trận. Với mỗi số `1` chưa thăm, chạy DFS để tìm các số `1` kết nối. Gán cho hòn đảo này một ID duy nhất. Lưu diện tích vào `Map`. Đánh dấu các ô của đảo này bằng ID của nó.*

2.  **Evaluate Each '0':**
    - Traverse the grid again. For each `0`:
        - Look at its 4 neighbors (up, down, left, right).
        - Collect the unique island IDs of these neighbors.
        - The potential area is `1 + sum of areas of these unique islands`.
    - Keep track of the maximum area found.
    *   **Đánh giá từng số '0':** Duyệt lại ma trận. Với mỗi số `0`: Nhìn 4 ô láng giềng. Tập hợp các ID đảo duy nhất của các láng giềng này. Diện tích tiềm năng là `1 + tổng diện tích các đảo này`. Tìm diện tích lớn nhất.*

3.  **Edge Case:** If the grid is all `1`s, the answer is $N^2$.
    *   **Trường hợp đặc biệt:** Nếu ma trận toàn số `1`, đáp án là $N^2$.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int largestIsland(int[][] grid) {
    int n = grid.length;
    Map<Integer, Integer> islandArea = new HashMap<>();
    int islandId = 2;
    int maxArea = 0;
    
    // Step 1: Label islands and store areas
    for (int r = 0; r < n; r++) {
        for (int c = 0; c < n; c++) {
            if (grid[r][c] == 1) {
                int area = dfs(grid, r, c, islandId);
                islandArea.put(islandId, area);
                maxArea = Math.max(maxArea, area);
                islandId++;
            }
        }
    }
    
    // Step 2: Try flipping each 0
    for (int r = 0; r < n; r++) {
        for (int c = 0; c < n; c++) {
            if (grid[r][c] == 0) {
                Set<Integer> uniqueIslands = new HashSet<>();
                for (int[] d : new int[][]{{1,0},{-1,0},{0,1},{0,-1}}) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] > 1) {
                        uniqueIslands.add(grid[nr][nc]);
                    }
                }
                int currentArea = 1;
                for (int id : uniqueIslands) currentArea += islandArea.get(id);
                maxArea = Math.max(maxArea, currentArea);
            }
        }
    }
    return maxArea;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2)$, where $N$ is the side length of the grid. Each cell is visited a constant number of times.
    *   **Độ phức tạp thời gian:** $O(N^2)$, vì mỗi ô được duyệt qua một số lần cố định.*
*   **Space Complexity:** $O(N^2)$, for the recursion stack and to store island labels in the grid itself.
    *   **Độ phức tạp không gian:** $O(N^2)$ cho ngăn xếp đệ quy và lưu nhãn đảo.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `grid = [[1, 0], [0, 1]]`
1. Step 1:
   - Island 2 at (0,0), area 1. `Map: {2: 1}`. Grid becomes `[[2, 0], [0, 1]]`.
   - Island 3 at (1,1), area 1. `Map: {2: 1, 3: 1}`. Grid becomes `[[2, 0], [0, 3]]`.
2. Step 2 (Check 0 at (0,1)):
   - Neighbors: Up(none), Down(3), Left(2), Right(none).
   - Unique IDs: {2, 3}.
   - Area = 1 + Map[2] + Map[3] = 1 + 1 + 1 = 3.
**Result:** 3.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Identification of components and then merging them at points of intersection is the optimal way to solve connectivity modification problems. Labeling the grid cells with their island IDs directly avoids the need for a separate `visited` array.
*Nhận dạng các thành phần và sau đó gộp chúng tại các điểm giao nhau là cách tối ưu để giải quyết các bài toán về sửa đổi tính kết nối. Đánh nhãn các ô lưới bằng ID đảo trực tiếp giúp tránh việc sử dụng mảng `visited` riêng biệt.*
