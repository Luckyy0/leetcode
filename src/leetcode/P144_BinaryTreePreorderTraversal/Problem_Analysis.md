# 144. Binary Tree Preorder Traversal / Duyệt Cây Nhị Phân Theo Tiền Tự

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, return the **preorder traversal** of its nodes' values.
Cho `root` của một cây nhị phân, hãy trả về **duyệt tiền tự** các giá trị của các nút.

### Example 1:
```text
Input: root = [1,null,2,3]
Output: [1,2,3]
```

### Example 2:
```text
Input: root = []
Output: []
```

### Example 3:
```text
Input: root = [1]
Output: [1]
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[0, 100]`.
- `-100 <= Node.val <= 100`

**Follow up**: Recursive solution is trivial, could you do it iteratively?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Tree Traversal Strategies / Chiến lược Duyệt Cây
1.  **Preorder**: Root -> Left -> Right.
2.  **Inorder**: Left -> Root -> Right.
3.  **Postorder**: Left -> Right -> Root.

### Iterative Preorder / Duyệt Tiền Tự bằng Vòng lặp
To simulate the recursion using an iterative approach, we use a **Stack**:
1.  Push `root` to stack.
2.  While stack is not empty:
    - Pop `node`, add its value to result.
    - Push `node.right` to stack (so it's processed after left).
    - Push `node.left` to stack (so it's processed first).

---

## Analysis / Phân tích

### Approach: Iterative with Stack / Duyệt bằng Vòng lặp sử dụng Ngăn xếp

**Complexity / Độ phức tạp**:
- **Time**: O(N) - visit each node once.
- **Space**: O(H) - where H is the height of the tree for the stack.

---

## Edge Cases / Các trường hợp biên
1.  **Empty tree**: Root is null.
2.  **Single node**.
3.  **Skewed tree** (all left or all right).
