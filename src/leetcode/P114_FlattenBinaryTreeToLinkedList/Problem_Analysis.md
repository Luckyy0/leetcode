# 114. Flatten Binary Tree to Linked List / Làm Phẳng Cây Nhị Phân Thành Danh Sách Liên Kết

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, flatten the tree into a "linked list":
Cho `root` của một cây nhị phân, làm phẳng cây thành một "danh sách liên kết":

- The "linked list" should use the same `TreeNode` class where the `right` child pointer points to the next node in the list and the `left` child pointer is always `null`.
- "Danh sách liên kết" nên sử dụng cùng lớp `TreeNode` trong đó con trỏ con `right` trỏ đến nút tiếp theo trong danh sách và con trỏ con `left` luôn là `null`.
- The "linked list" should be in the same order as a **preorder traversal** of the binary tree.
- "Danh sách liên kết" nên theo cùng thứ tự như **duyệt tiền tự** của cây nhị phân.

### Example 1:
```text
Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]
```

### Example 2:
```text
Input: root = []
Output: []
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[0, 2000]`.
- `-100 <= Node.val <= 100`

**Follow up**: Can you flatten the tree in-place (with O(1) extra space)?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Preorder Traversal Order / Thứ tự Duyệt Tiền Tự
Preorder: **Root → Left → Right**

For tree `[1,2,5,3,4,null,6]`:
```
    1
   / \
  2   5
 / \   \
3   4   6

Preorder: 1 -> 2 -> 3 -> 4 -> 5 -> 6
```

The flattened list follows this order, connected via `right` pointers.

### In-Place Transformation Insight / Hiểu biết về Biến đổi Tại chỗ
For each node:
Đối với mỗi nút:
1.  If it has a left subtree, that subtree goes between the node and its right subtree.
    Nếu nó có cây con trái, cây con đó đi giữa nút và cây con phải của nó.
2.  The **rightmost node of the left subtree** should connect to the **original right subtree**.
    **Nút phải nhất của cây con trái** nên kết nối với **cây con phải gốc**.

```
Before:          After:
    1               1
   / \               \
  2   5     ->        2
 / \   \               \
3   4   6               3
                         \
                          4
                           \
                            5
                             \
                              6
```

---

## Analysis / Phân tích

### Approach 1: Recursion (Postorder-like) / Đệ Quy (Giống Hậu Tự)
- Process right subtree first, then left, then current.
- Keep track of previously processed node (which becomes the `right` child).
- **Time**: O(N), **Space**: O(H).

### Approach 2: Morris-like In-Place / Tại chỗ kiểu Morris
- For each node with left child:
    1.  Find the rightmost node in left subtree.
    2.  Connect it to current node's right child.
    3.  Move left subtree to right.
    4.  Set left to null.
    5.  Move to right child.
- **Time**: O(N), **Space**: O(1).

### Approach 3: Iterative with Stack / Lặp với Ngăn Xếp
- Simulate preorder with stack.
- Connect nodes as we pop them.
- **Time**: O(N), **Space**: O(N).

---

## Edge Cases / Các trường hợp biên
1.  **Empty tree**: Do nothing.
2.  **Single node**: Already flattened.
3.  **Right-skewed**: Already flattened.
4.  **Left-skewed**: All nodes move to right chain.
