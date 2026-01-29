# 1305. All Elements in Two Binary Search Trees / Tất cả các Phần tử trong Hai Cây Tìm kiếm Nhị phân

## Problem Description / Mô tả bài toán
Two BSTs `root1`, `root2`.
Return list of all integers from both trees sorted ascending.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Inorder Traversal + Merge
1. Inorder traversal of BST gives sorted list.
2. Get `list1` from `root1` (sorted), `list2` from `root2` (sorted).
3. Merge two sorted lists (Two pointers).

### Complexity / Độ phức tạp
- **Time**: O(N + M).
- **Space**: O(N + M).

---

## Analysis / Phân tích

### Approach: Inorder and Merge
Perform an in-order traversal on both BSTs to obtain two sorted lists of values. Since in-order traversal of a BST yields sorted elements, we just need to merge two sorted lists using the standard two-pointer technique.
Thực hiện duyệt theo thứ tự trung gian trên cả hai BST để có được hai danh sách giá trị được sắp xếp. Vì duyệt theo thứ tự trung gian của BST mang lại các phần tử được sắp xếp, chúng ta chỉ cần hợp nhất hai danh sách được sắp xếp bằng kỹ thuật hai con trỏ tiêu chuẩn.

---
