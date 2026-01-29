# 538. Convert BST to Greater Tree / Chuyển Đổi BST Thành Cây Lớn Hơn

## Problem Description / Mô tả bài toán
Given the `root` of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.
Cho `root` của một Cây Tìm Kiếm Nhị Phân (BST), hãy chuyển đổi nó thành một Cây Lớn Hơn sao cho mọi khóa của BST gốc được thay đổi thành khóa gốc cộng với tổng của tất cả các khóa lớn hơn khóa gốc trong BST.

This is exactly the same as Problem 1038.
Bài toán này giống hệt Bài toán 1038.

### Example 1:
```text
Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Reverse In-order Traversal / Duyệt Trung Thứ Tự Ngược
Values greater than the current node are in the **right** subtree or are ancestors visited earlier in a Reverse In-order Traversal (Right -> Root -> Left).

Algorithm:
1. Initialize `sum = 0`.
2. Recursive function `traverse(node)`:
   - If node is null, return.
   - `traverse(node.right)`.
   - `sum += node.val`.
   - `node.val = sum`.
   - `traverse(node.left)`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H).

---

## Analysis / Phân tích

### Approach: Reverse In-Order Accumulation

**Algorithm**:
1.  Traverse Right subtree.
2.  Accumulate running sum.
3.  Update current node.
4.  Traverse Left subtree.

---
