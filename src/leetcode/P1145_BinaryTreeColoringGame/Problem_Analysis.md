# 1145. Binary Tree Coloring Game / Trò chơi Tô màu Cây Nhị phân

## Problem Description / Mô tả bài toán
Two players play a turn based game on a binary tree.
Player 1 picks a node `x`. Player 2 picks a node `y`.
Players then color their node.
In each turn, a player chooses an uncolored neighbor of their colored nodes and colors it.
Game ends when no more moves. Higher count of colored nodes wins.
Given the tree, `n` nodes, and node `x` picked by Player 1.
Return `true` if Player 2 can chose a node `y` to ensure a win.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Graph Component Sizes / Kích thước Thành phần Đồ thị
Player 1 picks `x`.
This effectively blocks `x`.
The tree is split into 3 components connected to `x`:
1. Left subtree of `x`.
2. Right subtree of `x`.
3. Parent of `x` (rest of the tree).
Player 2 can pick the root of any of these 3 components.
If P2 picks a component, P2 will eventually color that entire component (and potentially others if not blocked by P1, but P1 starts at `x`, and blocks access to other 2 components from P2's component).
So P2 gets: `size(component)`. P1 gets: `n - size(component)`.
Condition to win: `size(component) > n / 2`.
We need to check if ANY of the 3 components has size `> n/2`.

Algorithm:
1. Find node `x`.
2. Count size of left subtree: `L`.
3. Count size of right subtree: `R`.
4. Size of parent component: `P = n - (L + R + 1)`.
5. Check if `max(L, R, P) > n / 2`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H).

---

## Analysis / Phân tích

### Approach: Component Size Analysis
Player 1's choice splits the tree into up to three disconnected components (Left Child Subtree, Right Child Subtree, and the 'Parent' side containing the rest of the tree). Player 2's optimal strategy is to occupy the largest available component immediately, blocking Player 1 from entering it. By calculating the sizes of these three components, we determine if any single component contains more than half the total nodes (`N/2`). If so, Player 2 can guarantee a win.
Lựa chọn của Người chơi 1 chia cây thành tối đa ba thành phần không kết nối (Cây con bên trái, Cây con bên phải và phía 'Cha mẹ' chứa phần còn lại của cây). Chiến lược tối ưu của Người chơi 2 là chiếm thành phần lớn nhất có sẵn ngay lập tức, ngăn Người chơi 1 đi vào đó. Bằng cách tính kích thước của ba thành phần này, chúng ta xác định xem có thành phần đơn lẻ nào chứa hơn một nửa tổng số nút (`N/2`) hay không. Nếu có, Người chơi 2 có thể đảm bảo chiến thắng.

---
