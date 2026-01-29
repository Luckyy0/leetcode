# 1373. Maximum Sum BST in Binary Tree / Tổng BST Tối đa trong Cây Nhị phân

## Problem Description / Mô tả bài toán
Binary Tree. Find subtree that is a BST and has maximum sum of nodes.
Return max sum.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Post-Order Traversal with Info
Traverse bottom-up. Each node returns:
- `isBST`: boolean.
- `min`: min value in subtree.
- `max`: max value in subtree.
- `sum`: sum of subtree.
Parent checks:
- Left child is BST (or null).
- Right child is BST (or null).
- `left.max < node.val`.
- `right.min > node.val`.
If valid, compute `sum = left.sum + right.sum + node.val`. Update global max. Return info.
Else, return `isBST=false`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H).

---

## Analysis / Phân tích

### Approach: Post-Order DFS
Use a helper class or array to return 4 values from each recursive call: `{isBST (1/0), min, max, sum}`.
Base case (null): `{1, MAX_INT, MIN_INT, 0}`.
At each node:
Get left and right results.
If `left.isBST` AND `right.isBST` AND `left.max < node.val` AND `right.min > node.val`:
- It's a BST.
- `currSum = left.sum + right.sum + val`.
- `currMin = min(node.val, left.min)`.
- `currMax = max(node.val, right.max)`.
- Update global max sum.
- Return valid info.
Else return `{0, 0, 0, 0}`.
Sử dụng một lớp trợ giúp hoặc mảng để trả về 4 giá trị từ mỗi cuộc gọi đệ quy: `{isBST (1/0), min, max, sum}`.
Trường hợp cơ sở (null): `{1, MAX_INT, MIN_INT, 0}`.
Tại mỗi nút:
Lấy kết quả trái và phải.
Nếu `left.isBST` VÀ `right.isBST` VÀ `left.max < node.val` VÀ `right.min > node.val`:
- Đó là một BST.
- `currSum = left.sum + right.sum + val`.
- `currMin = min(node.val, left.min)`.
- `currMax = max(node.val, right.max)`.
- Cập nhật tổng tối đa toàn cục.
- Trả về thông tin hợp lệ.
Ngược lại trả về `{0, 0, 0, 0}`.

---
