# 979. Distribute Coins in Binary Tree / Phân phối Tiền trong Cây Nhị phân

## Problem Description / Mô tả bài toán
You are given the `root` of a binary tree with `n` nodes where each node in the tree has `node.val` coins. There are `n` coins in total throughout the whole tree.
Bạn được cho `root` của một cây nhị phân có `n` nút, trong đó mỗi nút có `node.val` đồng xu. Có tổng cộng `n` đồng xu trong toàn bộ cây.

In one move, we may choose two adjacent nodes and move one coin from one node to another.
Trong một bước, chúng ta có thể chọn hai nút liền kề và chuyển một đồng xu từ nút này sang nút khác.

Return the minimum number of moves required to make every node have exactly one coin.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Tree DFS with Flow Balance / DFS Cây với Cân bằng Luồng
Algorithm:
1. `dfs(node)`: returns the "excess" coins at this node (can be negative).
2. Excess = `node.val - 1 + dfs(left) + dfs(right)`.
3. The number of moves needed at this node is `abs(dfs(left)) + abs(dfs(right))`.

The total number of moves is the sum of these absolute excesses across all edges.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H).

---

## Analysis / Phân tích

### Approach: Recursive Imbalance Summation
Calculate the surplus or deficit for each subtree. Every coin that must enter or leave a subtree contributes to the total move count. By summing the absolute magnitude of these necessary cross-boundary shifts, we derive the minimum total work.
Tính toán sự dư thừa hoặc thiếu hụt cho mỗi cây con. Mỗi đồng xu phải đi vào hoặc rời khỏi một cây con đều đóng góp vào tổng số bước di chuyển. Bằng cách cộng giá trị tuyệt đối của các lần chuyển đổi xuyên biên giới cần thiết này, chúng ta tính ra tổng công việc tối thiểu.

---
