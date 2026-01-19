# 222. Count Complete Tree Nodes / Đếm Số Nút Trong Cây Hoàn Chỉnh

## Problem Description / Mô tả bài toán
Given the `root` of a **complete** binary tree, return the number of the nodes in the tree.
Cho `root` của một cây nhị phân **hoàn chỉnh**, hãy trả về số lượng các nút trong cây.

According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between `1` and `2^h` nodes inclusive at the last level `h`.
Theo Wikipedia, mọi cấp độ, ngoại trừ có thể là cấp độ cuối cùng, đều được điền đầy đủ trong một cây nhị phân hoàn chỉnh, và tất cả các nút ở cấp độ cuối cùng đều nằm càng xa về bên trái càng tốt. Nó có thể có từ `1` đến `2^h` nút ở cấp độ cuối cùng `h`.

Design an algorithm that runs in less than `O(n)` time complexity.
Thiết kế một thuật toán chạy với độ phức tạp thời gian ít hơn `O(n)`.

### Example 1:
```text
Input: root = [1,2,3,4,5,6]
Output: 6
```

### Example 2:
```text
Input: root = []
Output: 0
```

### Example 3:
```text
Input: root = [1]
Output: 1
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[0, 5 * 10^4]`.
- `0 <= Node.val <= 5 * 10^4`
- The tree is guaranteed to be complete.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Binary Search (Last Level) / Tìm kiếm Nhị phân (Cấp độ Cuối)
We know calculating the depth `d` of the tree takes `O(d)` time (going left only).
The number of nodes is `2^d - 1` (full tree above last level) + `nodes_in_last_level`.

We can use binary search to determine how many nodes exist in the last level.
The last level can have indices from `0` to `2^d - 1`.
For an index `mid`, check if the node exists in the tree.
Binary search range: `[0, 2^d - 1]`.

OR:

### Recursive Height Comparison / So sánh Chiều cao Đệ quy (Implementation Choice)
1. Calculate `leftHeight` (go all left) and `rightHeight` (go all right? No, standard definition usually compares left and right subtree heights).
2. Efficient Approach:
   - Compute `hLeft` = depth of left subtree.
   - Compute `hRight` = depth of right subtree.
   - If `hLeft == hRight`: The left subtree is a full perfect tree of height `hLeft`. Count = `2^hLeft + countNodes(root.right)`.
   - If `hLeft > hRight`: The right subtree is a full perfect tree of height `hRight`. Count = `2^hRight + countNodes(root.left)`.

This runs in `O((log N)^2)`.

---

## Analysis / Phân tích

### Approach: Recursive Height Check

**Logic**:
- Get height of LEFT and RIGHT children relative to current node.
- `height(node)`: keep going left.
- If `height(node.right) == h - 1`: The left subtree is full.
    - Nodes = `(1 << h) - 1` (left full) + `1` (root) + `count(right)` -> `(1 << h) + count(right)`.
- Else: The right subtree is full (but one level shorter).
    - Nodes = `(1 << (h-1))` (right full) + `count(left)`.

**Complexity / Độ phức tạp**:
- **Time**: O((log N)^2). At each step we compute height (log N), and we recurse log N times.
- **Space**: O(log N) - recursion stack.

---

## Edge Cases / Các trường hợp biên
1.  **Empty**: return 0.
2.  **Leaf**: return 1.
3.  **Perfect Tree**: `hLeft == hRight` recursively satisfied quickly.
