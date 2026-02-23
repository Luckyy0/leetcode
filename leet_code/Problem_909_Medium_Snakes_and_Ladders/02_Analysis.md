# Analysis for Snakes and Ladders
# *Phân tích cho bài toán Rắn và Thang*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find the minimum number of moves to go from square 1 to $N^2$. This is a shortest path problem on an unweighted graph.
*Tìm số bước tối thiểu để đi từ ô 1 đến $N^2$. Đây là bài toán đường đi ngắn nhất trên đồ thị không có trọng số.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- The board layout is boustrophedon (snake-like). We need a utility function to convert a square number `s` to `(row, col)` coordinates.
- Each move from `curr` can land on `curr + 1` to `curr + 6`.
- If the landing square has a snake/ladder, we **immediately** jump to its destination. This counts as **part of the same move**.
- The graph nodes are the squares $1 \dots N^2$. Edges are determined by dice rolls and snakes/ladders.
- Since edge weights are all 1 (1 move), **BFS** is the optimal algorithm.
*Bố cục bàn cờ là kiểu boustrophedon (giống con rắn). Cần hàm tiện ích để chuyển đổi số ô `s` sang tọa độ `(row, col)`. Mỗi bước di chuyển từ `curr` có thể đến `curr + 1` ... `curr + 6`. Nếu ô đến có rắn/thang, nhảy ngay lập tức. Đây vẫn tính là cùng một bước. Đồ thị có các nút $1 \dots N^2$, cạnh trọng số 1 -> dùng BFS.*

---

## 2. Strategy: BFS
## *2. Chiến lược: BFS*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Coordinate Conversion:**
    - Square `s` (1-indexed).
    - `row` index from bottom is `(s-1) / n`. Actual row index `r = n - 1 - (s-1)/n`.
    - `col` index depends on row parity.
      - If `(n - 1 - r)` is even (rows 0, 2 from bottom): `c = (s-1) % n`.
      - If odd: `c = n - 1 - (s-1) % n`.
    *   **Chuyển đổi tọa độ:** Tính hàng và cột dựa trên chỉ số `s`.*

2.  **BFS Initialization:**
    - Queue `q`. Push `1`.
    - `dist` array (or visited set) initialized to -1 (or unseen). `dist[1] = 0`.
    *   **Khởi tạo BFS:** Queue chứa 1. Mảng khoảng cách.*

3.  **BFS Loop:**
    - Pop `curr`. Check if `curr == n*n`. Return `dist[curr]`.
    - Loop `next` from `curr + 1` to `min(curr + 6, n*n)`.
    - Get `(r, c)` for `next`.
    - Determine `dest`:
        - If `board[r][c] != -1`, `dest = board[r][c]`.
        - Else, `dest = next`.
    - If `dest` not visited:
        - `dist[dest] = dist[curr] + 1`.
        - Push `dest`.
    *   **Vòng lặp BFS:** Pop `curr`. Duyệt các nước đi tiếp theo. Kiểm tra rắn/thang. Nếu đích chưa thăm, cập nhật khoảng cách và push.*

4.  **Impossible:** return -1.
    *   **Không thể:** trả về -1.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int snakesAndLadders(int[][] board) {
    int n = board.length;
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(1);
    boolean[] visited = new boolean[n * n + 1];
    visited[1] = true;
    int moves = 0;
    
    while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int curr = queue.poll();
            if (curr == n * n) return moves;
            
            for (int k = 1; k <= 6; k++) {
                int next = curr + k;
                if (next > n * n) break;
                
                int[] pos = getCoordinates(next, n);
                int r = pos[0];
                int c = pos[1];
                
                int dest = next;
                if (board[r][c] != -1) {
                    dest = board[r][c];
                }
                
                if (!visited[dest]) {
                    visited[dest] = true;
                    queue.offer(dest);
                }
            }
        }
        moves++;
    }
    
    return -1;
}

private int[] getCoordinates(int s, int n) {
    int rFromBottom = (s - 1) / n;
    int r = n - 1 - rFromBottom;
    int c = (s - 1) % n;
    if (rFromBottom % 2 == 1) {
        c = n - 1 - c;
    }
    return new int[]{r, c};
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2)$. Each square is visited at most once.
    *   **Độ phức tạp thời gian:** $O(N^2)$.*
*   **Space Complexity:** $O(N^2)$ for queue and visited array.
    *   **Độ phức tạp không gian:** $O(N^2)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

The coordinate mapping is the trickiest part; ensure the boustrophedon logic is correct (alternating rows). BFS guarantees the shortest path.
*Việc ánh xạ tọa độ là phần lắt léo nhất; đảm bảo logic boustrophedon (hàng xen kẽ) là chính xác. BFS đảm bảo đường đi ngắn nhất.*
