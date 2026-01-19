# 94. Binary Tree Inorder Traversal / Duyệt Cây Nhị Phân Theo Thứ Tự Giữa

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, return the **inorder traversal** of its nodes' values.
Cho `root` của một cây nhị phân, trả về **duyệt theo thứ tự giữa** các giá trị của các nút.

### Example 1:
```text
Input: root = [1,null,2,3]
Output: [1,3,2]
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

---

## Analysis / Phân tích

### Approach 1: Recursion / Đệ Quy
- **Idea**: Visit Left -> Visit Root -> Visit Right.
- **Ý tưởng**: Duyệt Trái -> Duyệt Gốc -> Duyệt Phải.
- **Time/Space**: O(N) / O(H).

### Approach 2: Iteration (Stack) / Lặp (Ngăn Xếp)
- **Idea**: Push all left children to stack. Pop, visit, then move to right child.
- **Algorithm**:
    - `stack` S.
    - `curr` = root.
    - While `curr != null` or `!stack.isEmpty()`:
        - While `curr != null`:
            - Push `curr`.
            - `curr = curr.left`.
        - `curr = stack.pop()`.
        - Add `curr.val` to result.
        - `curr = curr.right`.
- **Time/Space**: O(N) / O(H).

### Approach 3: Morris Traversal / Duyệt Morris
- **Idea**: Use threading (threaded binary tree) to achieve O(1) space.
- **Time/Space**: O(N) / O(1).

---

## Edge Cases / Các trường hợp biên
1.  **Empty**: [].
2.  **Single Node**: [1].
