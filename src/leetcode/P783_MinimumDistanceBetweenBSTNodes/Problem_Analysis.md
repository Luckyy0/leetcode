# 783. Minimum Distance Between BST Nodes / Khoảng cách Cực tiểu giữa các Nút BST

## Problem Description / Mô tả bài toán
Given the `root` of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.
Cho `root` của một cây tìm kiếm nhị phân (BST), hãy trả về hiệu số tối thiểu giữa giá trị của hai nút khác nhau bất kỳ trong cây.

Note: This is the same as LeetCode 530.
Lưu ý: Bài này giống bài LeetCode 530.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### In-order Traversal of BST / Duyệt trung thứ tự trên BST
An in-order traversal of a BST yields values in increasing order.
Phép duyệt trung thứ tự (in-order traversal) trên một BST sẽ cho ra các giá trị theo thứ tự tăng dần.

The minimum difference must occur between two adjacent elements in the sorted sequence.
Hiệu số tối thiểu phải xảy ra giữa hai phần tử liền kề trong dãy đã sắp xếp.

Algorithm:
1. Conduct an in-order traversal.
2. Keep track of the `previous` node's value.
3. Calculate `currentValue - previousValue` and update the global minimum.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H) where H is the height of the tree.

---

## Analysis / Phân tích

### Approach: In-order traversal with state
Standard BST property check. By iterating in order, we only need to compare each element with its immediate successor in the sorted sequence.
Kiểm tra thuộc tính BST tiêu chuẩn. Bằng cách lặp lại theo thứ tự, chúng ta chỉ cần so sánh từng phần tử với phần tử kế tiếp ngay sau nó trong dãy đã sắp xếp.

---
