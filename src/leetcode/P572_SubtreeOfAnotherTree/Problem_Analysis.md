# 572. Subtree of Another Tree / Cây Con Của Một Cây Khác

## Problem Description / Mô tả bài toán
Given the roots of two binary trees `root` and `subRoot`, return `true` if there is a subtree of `root` with the same structure and node values of `subRoot` and `false` otherwise.
Cho các gốc của hai cây nhị phân `root` và `subRoot`, trả về `true` nếu có một cây con của `root` có cấu trúc và giá trị nút giống hệt `subRoot` và `false` nếu ngược lại.

A subtree of a binary tree `tree` is a tree that consists of a node in `tree` and all of this node's descendants. The tree `tree` could also be considered as a subtree of itself.
Một cây con của cây nhị phân `tree` là một cây bao gồm một nút trong `tree` và tất cả các hậu duệ của nút này. Cây `tree` cũng có thể được coi là một cây con của chính nó.

### Example 1:
```text
Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Tree Traversal + Equality Check / Duyệt Cây + Kiểm Tra Bằng Nhau
Algorithm:
1. Iterate through every node in `root`.
2. For each node, check if the tree starting at this node is identical to `subRoot`.
3. `isSameTree(p, q)` helper:
   - If both null, true.
   - If one null, false.
   - If vals differ, false.
   - Recurse `isSameTree(left, left) && isSameTree(right, right)`.

### Complexity / Độ phức tạp
- **Time**: O(M * N) in worst case (e.g., skewed trees). O(M + N) with Merkle Hashing / String serialization.
- **Space**: O(H).

---

## Analysis / Phân tích

### Approach: Recursive Matching

**Algorithm**:
1.  Traverse main tree `root`.
2.  At each node, call `isIdentical` with `subRoot`.
3.  `isIdentical` checks for structural and value equality recursively.
4.  Return true if any node comparison returns true.

---
