# 145. Binary Tree Postorder Traversal / Duyệt Cây Nhị Phân Theo Hậu Tự

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, return the **postorder traversal** of its nodes' values.
Cho `root` của một cây nhị phân, hãy trả về **duyệt hậu tự** các giá trị của các nút.

### Example 1:
```text
Input: root = [1,null,2,3]
Output: [3,2,1]
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
- The number of the nodes in the tree is in the range `[0, 100]`.
- `-100 <= Node.val <= 100`

**Follow up**: Recursive solution is trivial, could you do it iteratively?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Tree Traversal Strategies / Chiến lược Duyệt Cây
1.  **Postorder**: Left -> Right -> Root.

### Iterative Postorder / Duyệt Hậu Tự bằng Vòng lặp
Iterative postorder is slightly trickier than preorder. There are two common ways:
1.  **Two Stacks**: Standard approach.
2.  **Reverse Preorder Logic**: 
    - Preorder is `Root -> Left -> Right`.
    - Modified Preorder: `Root -> Right -> Left`.
    - Reverse of `Root -> Right -> Left` is `Left -> Right -> Root` (Postorder!).

**Algorithm (Modified Preorder + Reverse)**:
1.  Use a stack to traverse `Root -> Right -> Left`.
2.  Add values to the front of a list (effectively reversing).
3.  Return the list.

---

## Analysis / Phân tích

### Approach: Iterative with LinkedList (Modified Preorder + Reverse) / Duyệt bằng Vòng lặp sử dụng LinkedList

**Complexity / Độ phức tạp**:
- **Time**: O(N) - visit each node once.
- **Space**: O(H) - for the stack.

---

## Edge Cases / Các trường hợp biên
1.  **Empty tree**: Root is null.
2.  **Single node**.
3.  **Skewed tree**.
