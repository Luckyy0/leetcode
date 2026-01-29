# 1284. Minimum Number of Flips to Convert Binary Matrix to Zero Matrix / Số lần Lật tối thiểu để Chuyển Ma trận Nhị phân thành Ma trận Không

## Problem Description / Mô tả bài toán
`m x n` binary matrix. 0 or 1.
Move: choose cell `(i, j)`, flip it and all 4 neighbors.
Goal: all 0s.
Min moves. Or -1.
Constraints: m, n <= 3.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### BFS on State (Bitmask)
Since `m*n <= 9` (3x3), the total number of states is `2^9 = 512`.
We can use BFS to find the shortest path from initial configuration to state 0.
Represent matrix as an integer (bitmask).
Transitions: Trying flipping each cell `(i, j)`.
For 3x3, trying every possible move from every state is small enough.
Possible pruning: don't revisit states.

### Complexity / Độ phức tạp
- **Time**: O(2^(MN) * MN). 512 * 9 operations. Very fast.
- **Space**: O(2^(MN)).

---

## Analysis / Phân tích

### Approach: BFS with Bitmask
The matrix dimensions are very small (`m, n <= 3`), so the total number of cells is at most 9. This allows representing the entire matrix state as a bitmask (integer). Use BFS to find the minimum number of flips to reach state 0 (all zeros). Start from the initial state bitmask. In each step, generate all possible next states by applying the flip operation at each of the `m*n` positions. Keep track of visited states to avoid cycles and redundant work.
Kích thước ma trận rất nhỏ (`m, n <= 3`), vì vậy tổng số ô tối đa là 9. Điều này cho phép biểu diễn toàn bộ trạng thái ma trận dưới dạng bitmask (số nguyên). Sử dụng BFS để tìm số lần lật tối thiểu để đạt đến trạng thái 0 (tất cả các số 0). Bắt đầu từ bitmask trạng thái ban đầu. Trong mỗi bước, tạo tất cả các trạng thái tiếp theo có thể bằng cách áp dụng thao tác lật tại mỗi vị trí trong số `m*n` vị trí. Theo dõi các trạng thái đã truy cập để tránh chu kỳ và công việc dư thừa.

---
