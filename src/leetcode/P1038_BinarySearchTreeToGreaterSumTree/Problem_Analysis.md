# 1038. Binary Search Tree to Greater Sum Tree / Cây Tìm kiếm Nhị phân thành Cây Tổng Lớn hơn

## Problem Description / Mô tả bài toán
Given the `root` of a BST, convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
Cho `root` của một BST, hãy chuyển đổi nó thành Cây Lớn hơn sao cho mọi khóa của BST ban đầu được thay đổi thành khóa ban đầu cộng với tổng của tất cả các khóa lớn hơn khóa ban đầu trong BST.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Reverse Inorder Traversal / Duyệt Inorder Ngược
Standard BST property: Inorder is sorted ascending.
Thuộc tính BST tiêu chuẩn: Inorder được sắp xếp tăng dần.
Reverse Inorder (Right -> Root -> Left) visits nodes in descending order.

Algorithm:
1. Maintain a running `sum`.
2. Traverse: `Right` subtree first.
3. Update `sum += node.val`.
4. Update `node.val = sum`.
5. Traverse `Left` subtree.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H).

---

## Analysis / Phân tích

### Approach: Global Accumulator
Traverse the tree in descending order of values (Right $\to$ Root $\to$ Left). Keep a running sum of all visited nodes. As each node is visited, its value is updated to the current running sum, effectively adding all greater values to it.
Duyệt cây theo thứ tự giá trị giảm dần (Phải $\to$ Gốc $\to$ Trái). Giữ một tổng chạy của tất cả các nút đã truy cập. Khi mỗi nút được truy cập, giá trị của nó được cập nhật thành tổng chạy hiện tại, về cơ bản là cộng tất cả các giá trị lớn hơn vào nó.

---
