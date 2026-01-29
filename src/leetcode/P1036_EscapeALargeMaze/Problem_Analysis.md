# 1036. Escape a Large Maze / Thoát khỏi Mê cung Lớn

## Problem Description / Mô tả bài toán
The grid is $10^6 \times 10^6$. You are given a list of `blocked` cells.
Lưới có kích thước $10^6 \times 10^6$. Bạn được cho một danh sách các ô bị chặn `blocked`.
Determine if it is possible to reach `target` from `source`.
Xác định xem có thể đi từ `source` đến `target` hay không.

Note: Number of blocked cells is at most 200.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Bounded BFS / BFS có Giới hạn
The grid is huge, but blocked cells are few.
Lưới rất lớn, nhưng các ô bị chặn rất ít.
With `N = 200` blocks, the maximum enclosed area is roughly `N * (N-1) / 2` (triangular closure in corner) ≈ 20,000 cells.
If the BFS can visit more than ~20,000 cells from the start point without hitting a barrier (or reaching target), it means the start point is NOT enclosed in a small loop of blocks. It has "escaped" to the vast open space.

Algorithm:
1. `canReach(p1, p2)`:
   - BFS from `p1`.
   - If we reach `p2`, return true.
   - If `visited.size() > 20000`, return true (escaped).
   - If queue empties before 20000 and target not reached, return false (trapped).
2. Result: `canReach(source, target) && canReach(target, source)`.
   we need both because source might escape but target might be trapped in a different unconnected loop.

### Complexity / Độ phức tạp
- **Time**: O(N^2), where N is number of blocked cells (limited BFS).
- **Space**: O(N^2) for visited set.

---

## Analysis / Phân tích

### Approach: Finite Enclosure Verification
Since the number of obstacles is small (200), they can only enclose a limited area. If a BFS traversal from either point exceeds this maximum possible enclosed area (approx. 20,000 cells), it guarantees access to the open grid. We verify that both the source and target are not "trapped" in small pockets.
Vì số lượng chướng ngại vật nhỏ (200), chúng chỉ có thể bao quanh một khu vực hạn chế. Nếu một lượt duyệt BFS từ một trong hai điểm vượt quá diện tích bao quanh tối đa có thể này (khoảng 20.000 ô), điều đó đảm bảo việc tiếp cận được lưới mở. Chúng ta xác minh rằng cả nguồn và mục tiêu đều không bị "mắc kẹt" trong các túi nhỏ.

---
