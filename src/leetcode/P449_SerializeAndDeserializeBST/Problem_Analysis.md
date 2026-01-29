# 449. Serialize and Deserialize BST / Tuần Tự Hóa và Giải Tuần Tự Hóa BST

## Problem Description / Mô tả bài toán
Design an algorithm to serialize and deserialize a **binary search tree**. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.
Hãy thiết kế một thuật toán để tuần tự hóa (serialize) và giải tuần tự hóa (deserialize) một **Cây tìm kiếm nhị phân (BST)**. Không có hạn chế nào về cách thuật toán của bạn hoạt động, miễn là cấu trúc ban đầu có thể được khôi phục.

The encoded string should be as compact as possible.
Chuỗi mã hóa phải càng gọn càng tốt.

### Example 1:
```text
Input: root = [2,1,3]
Output: [2,1,3]
```

### Example 2:
```text
Input: root = []
Output: []
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[0, 10^4]`.
- `0 <= Node.val <= 10^4`
- The input tree is guaranteed to be a binary search tree.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Preorder Traversal for BST / Duyệt Tiền thứ tự cho BST
For a general binary tree, we usually need both inorder and preorder (or markers for null nodes) to reconstruct it. However, for a **BST**, a single **preorder** (or postorder) traversal is sufficient because the inorder sequence is simply the sorted version of the values.

Algorithm:
- **Serialize**:
  1. Perform a preorder traversal.
  2. Join values using a delimiter (e.g., `,`).
- **Deserialize**:
  1. Split the string to get a list of values.
  2. Use the BST property (`lower < val < upper`) to reconstruct the tree recursively.
  3. Start with `lower = -infinity`, `upper = +infinity`.
  4. For the next value in the list:
     - If it falls within `[lower, upper]`, it's a valid node for the current subtree.
     - Recursively build `left` with `(lower, val)` and `right` with `(val, upper)`.

### Complexity / Độ phức tạp
- **Time**: O(N) for both.
- **Space**: O(N) for the string / list of values.

---

## Analysis / Phân tích

### Approach: BST Property Reconstruction

**Algorithm**:
1.  Serialize: `preorder` traversal.
2.  Deserialize: Recursive builder using bounds tracking.

---
