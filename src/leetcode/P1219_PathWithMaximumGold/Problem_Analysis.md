# 1219. Path with Maximum Gold / Đường đi với Vàng Tối đa

## Problem Description / Mô tả bài toán
Grid `m x n` has gold. `grid[i][j]` is amount. 0 is empty.
Miners starts at any cell with gold.
Can move up, down, left, right to cells with gold.
Cannot visit same cell twice.
Find max gold.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Backtracking (DFS) / Quay lui (DFS)
Try starting from every cell with gold.
Run DFS. Mark visited (set to 0 temporarily).
Backtrack (restore value).
Grid size is small (up to 15x15, max 25 cells with gold).
Constraints: At most 25 cells have gold.
This small constraint makes simple backtracking viable.

### Complexity / Độ phức tạp
- **Time**: O(K * 3^K) where K is number of gold cells. Starting from K cells, path length K, branching factor 3.
- **Space**: O(K) recursion depth.

---

## Analysis / Phân tích

### Approach: Backtracking from Each Gold Cell
Since the number of gold cells is small (at most 25), we can try starting a path from every cell containing gold. For each start, use Depth First Search (DFS) to explore all possible paths. While traversing, mark the current cell as visited (e.g., set its value to 0) to prevent cycles, and unmark it (backtrack) when returning. Accumulate the gold collected and track the global maximum.
Vì số lượng ô vàng nhỏ (tối đa 25), chúng ta có thể thử bắt đầu một đường đi từ mọi ô chứa vàng. Đối với mỗi điểm bắt đầu, sử dụng Tìm kiếm theo Chiều sâu (DFS) để khám phá tất cả các đường đi có thể. Trong khi duyệt, hãy đánh dấu ô hiện tại là đã truy cập (ví dụ: đặt giá trị của nó thành 0) để ngăn chặn các chu kỳ và bỏ đánh dấu nó (quay lui) khi quay lại. Tích lũy số vàng thu được và theo dõi mức tối đa toàn cầu.

---
