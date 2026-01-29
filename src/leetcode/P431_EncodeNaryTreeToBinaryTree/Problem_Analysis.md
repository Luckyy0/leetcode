# 431. Encode N-ary Tree to Binary Tree / Mã Hóa Cây N-Phân Thành Cây Nhị Phân

## Problem Description / Mô tả bài toán
Design an algorithm to encode an **N-ary tree** into a **binary tree** and decode the binary tree to get the original N-ary tree.
Thiết kế một thuật toán để mã hóa một **Cây N-phân** thành một **Cây nhị phân** và giải mã cây nhị phân để lấy lại cây N-phân ban đầu.

An N-ary tree is a rooted tree in which each node has at most N children. A binary tree is a rooted tree in which each node has at most 2 children. There is no restriction on how your encoding/decoding algorithm should work.
Cây N-phân là cây có tối đa N nút con, còn cây nhị phân có tối đa 2 nút con. Không có hạn chế về cách thức mã hóa/giải mã.

### Example 1:
```text
Input: root = [1,null,3,2,4,null,5,6]
Output: Binary tree (using Left-Child Right-Sibling representation)
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[0, 10^4]`.
- `0 <= Node.val <= 10^4`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Left-Child Right-Sibling (LCRS) Representation / Biểu diễn nút con trái - nút anh em phải
This is a classic technique to represent any rooted tree as a binary tree.
- For a node `P` in the N-ary tree:
  - The `left` pointer in the Binary Tree points to `P`'s **first child**.
  - The `right` pointer in the Binary Tree points to `P`'s **next sibling**.

Algorithm:
- **Encode**:
  1. Create a binary node `bNode` with `root.val`.
  2. If `root` has children, encode the first child and set it as `bNode.left`.
  3. Iterate through the subsequent children and link them as the `right` child of the previous child in the binary tree.
- **Decode**:
  1. Create an N-ary node `nNode` with `bRoot.val`.
  2. Start from `bRoot.left`. This is the first child.
  3. While a `curr` node exists:
     - Recursively decode `curr` and add it to `nNode.children`.
     - Move to `curr.right` (the next sibling).

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the total number of nodes.
- **Space**: O(H) recursion depth.

---

## Analysis / Phân tích

### Approach: Recursive LCRS

**Algorithm**:
1.  Encode children as a chain of right pointers starting from the leftmost child.
2.  Reverse the process during decoding.

---
