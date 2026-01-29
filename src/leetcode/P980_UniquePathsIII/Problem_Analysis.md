# 980. Unique Paths III / Đường đi Duy nhất III

## Problem Description / Mô tả bài toán
You are given an `m x n` integer array `grid` where:
- `1`: Starting square.
- `2`: Ending square.
- `0`: Empty square.
- `-1`: Obstacle.

Return the number of 4-directional walks from the starting square to the ending square, that walk over **every non-obstacle square exactly once**.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Backtracking with Path Constraints / Backtracking với các Ràng buộc Đường đi
Algorithm:
1. Count the total number of empty squares `emptyCount`.
2. Find starting coordinates `(sx, sy)`.
3. Perform DFS/Backtracking from `(sx, sy)`:
   - Mark current cell as `-1` (visited).
   - If we reach the end and `visitedCount == emptyCount + 1`, count as one valid path.
   - Recurse in 4 directions.
   - Backtrack: unmark current cell.

### Complexity / Độ phức tạp
- **Time**: O(3^{M * N}) worst case, but heavily pruned.
- **Space**: O(M * N).

---

## Analysis / Phân tích

### Approach: Exhaustive Hamiltonian Path
Explore all possible routes that touch every valid floor tile. The strict requirement of visiting every empty square exactly once allows us to use an "empty count" as a progress tracker, ensuring that we only count paths that are structurally complete.
Khám phá tất cả các tuyến đường có thể có mà đi qua mọi ô sàn hợp lệ. Yêu cầu khắt khe về việc truy cập mọi ô trống một lần duy nhất cho phép chúng ta sử dụng "số lượng ô trống" như một công cụ theo dõi tiến trình, đảm bảo rằng chúng ta chỉ đếm các con đường hoàn chỉnh về mặt cấu trúc.

---
