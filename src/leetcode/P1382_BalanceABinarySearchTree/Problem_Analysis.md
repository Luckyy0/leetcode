# 1382. Balance a Binary Search Tree / Cân bằng Cây Tìm kiếm Nhị phân

## Problem Description / Mô tả bài toán
Given root of BST. Return a balanced BST with same values.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Inorder Traversal + Construct
1. Inorder traversal to get sorted list of values.
2. Build balanced BST from sorted list (choose middle as root, recurse).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Rebuild Tree
Perform an in-order traversal of the BST to store all node values in a sorted list. Then, construct a new height-balanced BST from this sorted list by recursively picking the middle element as the root of the current subtree.
Thực hiện duyệt theo thứ tự trung gian của BST để lưu trữ tất cả các giá trị nút trong một danh sách được sắp xếp. Sau đó, xây dựng một BST cân bằng chiều cao mới từ danh sách được sắp xếp này bằng cách chọn đệ quy phần tử ở giữa làm gốc của cây con hiện tại.

---
