# Analysis for Shortest Path to Get All Keys
# *Phân tích cho bài toán Đường đi Ngắn nhất để Lấy Tất cả các Chìa khóa*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
We need to find the shortest path in a grid to collect all keys. We can revisit cells if our state (the collection of keys we have) changes. This is a BFS problem, but the state is not just the $(x, y)$ coordinate.
*Chúng ta cần tìm đường đi ngắn nhất trong lưới để thu thập tất cả các chìa khóa. Chúng ta có thể ghé thăm lại các ô nếu trạng thái của mình (tập hợp các chìa khóa đang có) thay đổi. Đây là bài toán BFS, nhưng trạng thái không chỉ là tọa độ $(x, y)$.*

---

## 2. Strategy: BFS with Bitmask State
## *2. Chiến lược: BFS với trạng thái Bitmask*

### Defining the State
### *Định nghĩa trạng thái*
The state can be uniquely identified by $(r, c, mask)$, where:
- $(r, c)$ is the current row and column.
- $mask$ is a bitmask where the $i$-th bit is 1 if we have the $i$-th key.
*Trạng thái có thể được xác định duy nhất bằng $(r, c, mask)$, trong đó: $(r, c)$ là hàng và cột hiện tại, $mask$ là mặt nạ bit trong đó bit thứ $i$ là 1 nếu chúng ta có chìa khóa thứ $i$.*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Preprocessing:** Scan the grid to find the start position `'@'` and the total number of keys.
    *   **Tiền xử lý:** Quét lưới để tìm vị trí bắt đầu '@' và tổng số chìa khóa.*

2.  **Initialize BFS:**
    - Queue stores `[r, c, mask]`.
    - `visited[row][col][mask]` boolean array to avoid cycles.
    *   **Khởi tạo BFS:** Hàng đợi lưu trữ `[r, c, mask]`. Mảng `visited[row][col][mask]` để tránh chu trình.*

3.  **Breadth-First Search:**
    - For each step, try moving in 4 directions.
    - If hit a wall `'#'`, skip.
    - If hit a lock `'A'-'F'`, only pass if `(mask & (1 << (lock - 'A')))` is true.
    - If hit a key `'a'-'f'`, update new mask: `newMask = mask | (1 << (key - 'a'))`.
    - If `newMask == (1 << totalKeys) - 1`, we found all keys! Return steps.
    *   **Tìm kiếm theo chiều rộng (BFS):** Với mỗi bước, thử di chuyển theo 4 hướng. Nếu gặp tường '#', bỏ qua. Nếu gặp ổ khóa 'A'-'F', chỉ đi qua nếu bit tương ứng trong mask là 1. Nếu gặp chìa khóa 'a'-'f', cập nhật mask mới. Nếu mask đạt đủ các bit của tổng số chìa khóa, trả về số bước.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int shortestPathAllKeys(String[] grid) {
    int m = grid.length, n = grid[0].length();
    int startR = -1, startC = -1, totalKeys = 0;
    for (int r = 0; r < m; r++) {
        for (int c = 0; c < n; c++) {
            char ch = grid[r].charAt(c);
            if (ch == '@') { startR = r; startC = c; }
            if (ch >= 'a' && ch <= 'f') totalKeys++;
        }
    }
    
    int finalState = (1 << totalKeys) - 1;
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{startR, startC, 0});
    boolean[][][] visited = new boolean[m][n][1 << totalKeys];
    visited[startR][startC][0] = true;
    
    int steps = 0;
    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    while (!queue.isEmpty()) {
        int size = queue.size();
        while (size-- > 0) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1], mask = curr[2];
            if (mask == finalState) return steps;
            
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                char ch = grid[nr].charAt(nc);
                if (ch == '#') continue;
                if (ch >= 'A' && ch <= 'F' && (mask & (1 << (ch - 'A'))) == 0) continue;
                
                int nMask = mask;
                if (ch >= 'a' && ch <= 'f') nMask |= (1 << (ch - 'a'));
                if (!visited[nr][nc][nMask]) {
                    visited[nr][nc][nMask] = true;
                    queue.offer(new int[]{nr, nc, nMask});
                }
            }
        }
        steps++;
    }
    return -1;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \cdot N \cdot 2^K)$, where $K$ is the number of keys (up to 6).
    *   **Độ phức tạp thời gian:** $O(M \cdot N \cdot 2^K)$, với $K$ là số lượng chìa khóa (tối đa 6).*
*   **Space Complexity:** $O(M \cdot N \cdot 2^K)$ for the visited array.
    *   **Độ phức tạp không gian:** $O(M \cdot N \cdot 2^K)$ cho mảng đánh dấu.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Bitmasking is essential for state-based BFS where "possessions" or "visited sets" determine the future availability of nodes. $K=6$ is small enough for $2^K = 64$.
*Bitmasking là yếu tố cốt yếu cho BFS dựa trên trạng thái khi vật phẩm sở hữu hoặc tập hợp các nút đã ghé thăm quyết định khả năng truy cập các nút trong tương lai.*
