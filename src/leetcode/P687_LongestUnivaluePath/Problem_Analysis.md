# 687. Longest Univalue Path / Đường đi cùng Giá trị Dài nhất

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, return the length of the longest path, where each node in the path has the same value. This path may or may not pass through the root.
Cho `root` của một cây nhị phân, hãy trả về độ dài của đường đi dài nhất mà mỗi nút trong đường đi có cùng giá trị. Đường đi này có thể hoặc không đi qua gốc.

The length of the path between two nodes is represented by the number of edges between them.
Độ dài của đường đi giữa hai nút được biểu diễn bằng số cạnh giữa chúng.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Depth First Search (DFS) / Tìm kiếm theo Chiều sâu
For each node, the longest univalue path passing through it is the sum of:
1. Longest univalue path extending to the left.
2. Longest univalue path extending to the right.

Recursive function `dfs(node)`:
- Returns the length of the longest univalue path starting from `node` and extending into its subtrees.
- Updates a global `ans` with `left_path + right_path`.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the number of nodes.
- **Space**: O(H) recursion stack.

---

## Analysis / Phân tích

### Approach: Bottom-up Path Extension
As we move up the tree, we check if the current node has the same value as its children. If it does, we can extend the path from that child by 1.
Khi chúng ta di chuyển lên cây, chúng ta kiểm tra xem nút hiện tại có cùng giá trị với các con của nó hay không. Nếu có, chúng ta có thể kéo dài đường đi từ con đó thêm 1.

---
