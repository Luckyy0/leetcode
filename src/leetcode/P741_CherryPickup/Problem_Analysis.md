# 741. Cherry Pickup / Thu hoạch Anh đào

## Problem Description / Mô tả bài toán
You are given an `n x n` grid representing a field of cherries, where each cell is one of the following:
Bạn được cho một lưới `n x n` đại diện cho một cánh đồng anh đào, trong đó mỗi ô là một trong những loại sau:

- `0`: Empty.
- `1`: Contains a cherry.
- `*`: Contains a thorn that blocks passage.

Your goal is to collect maximum cherries by:
1. Moving from `(0, 0)` to `(n-1, n-1)` by moving right or down.
2. Moving from `(n-1, n-1)` back to `(0, 0)` by moving left or up.

When you pass through a cell with a cherry, you take it, and the cell becomes empty.
Khi bạn đi qua một ô có anh đào, bạn sẽ lấy nó và ô đó trở nên trống rỗng.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Double Traversal / Quy hoạch Động / Duyệt kép
Moving from end to start is equivalent to two people moving from start to end simultaneously.
Di chuyển từ cuối về đầu tương đương với việc hai người cùng di chuyển từ đầu đến cuối một cách đồng thời.

Let `dp[t][r1][r2]` be the maximum cherries collected after `t` steps, where person 1 is at `(r1, t-r1)` and person 2 is at `(r2, t-r2)`.
Gọi `dp[t][r1][r2]` là số anh đào tối đa thu thập được sau `t` bước, trong đó người 1 ở `(r1, t-r1)` và người 2 ở `(r2, t-r2)`.

Transition:
- A step `t` depends on step `t-1`.
- At each step, each person can move down or right (4 combinations).
- If `r1 == r2`, they are at the same cell; only add the cherry once.

### Complexity / Độ phức tạp
- **Time**: O(N^3) since there are 2N steps and N^2 position combinations.
- **Space**: O(N^2) using space optimization for `t`.

---

## Analysis / Phân tích

### Approach: 3D DP with Path Synchronization
By synchronizing the two paths using the total steps taken, we ensure we calculate the optimal simultaneous occupancy of cells.
Bằng cách đồng bộ hóa hai đường đi bằng tổng số bước đã thực hiện, chúng ta đảm bảo tính toán được mức độ chiếm dụng tối ưu đồng thời của các ô.

---
