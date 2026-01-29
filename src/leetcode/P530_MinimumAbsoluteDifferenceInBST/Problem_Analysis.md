# 530. Minimum Absolute Difference in BST / Chênh Lệch Tuyệt Đối Nhỏ Nhất Trong BST

## Problem Description / Mô tả bài toán
Given the `root` of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.
Cho `root` của một Cây Tìm Kiếm Nhị Phân (BST), hãy trả về chênh lệch tuyệt đối nhỏ nhất giữa giá trị của bất kỳ hai nút khác nhau nào trong cây.

### Example 1:
```text
Input: root = [4,2,6,1,3]
Output: 1
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[2, 10^4]`.
- `0 <= Node.val <= 10^5`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### In-order Traversal Property / Tính chất Duyệt Trung Thứ Tự
The most critical property of a BST is that an **in-order traversal** yields sorted values.
The minimum absolute difference must occur between two adjacent elements in the sorted sequence.

Algorithm:
1. Initialize `minDiff = MAX_INT`, `prev = null`.
2. Perform In-order Traversal (Left, Node, Right).
3. At each node:
   - If `prev` is not null, `minDiff = min(minDiff, node.val - prev.val)`.
   - Update `prev = node`.
4. Return `minDiff`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H) for stack.

---

## Analysis / Phân tích

### Approach: In-order Sequential Difference

**Algorithm**:
1.  Recursively traverse in-order.
2.  Maintain pointer to previous node value.
3.  Calculate difference with current node.
4.  Track global minimum.

---
