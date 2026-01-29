# 872. Leaf-Similar Trees / Các Cây có Lá Tương tự

## Problem Description / Mô tả bài toán
Two binary trees are leaf-similar if their leaf value sequence is the same.
Hai cây nhị phân có lá tương tự nếu chuỗi giá trị lá của chúng giống nhau.

Given the roots of two binary trees `root1` and `root2`, return `true` if they are leaf-similar.
Cho gốc của hai cây nhị phân `root1` và `root2`, trả về `true` nếu chúng có lá tương tự.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Depth First Search (DFS) / Tìm kiếm theo Chiều sâu
Algorithm:
1. Write a function `getLeafSequence(node)` that performs a DFS and adds leaf nodes (nodes with no children) to a list.
2. Compare the lists from both trees.

### Complexity / Độ phức tạp
- **Time**: O(N + M) where N, M are node counts.
- **Space**: O(L1 + L2) for the leaf lists.

---

## Analysis / Phân tích

### Approach: Sequence Extraction and Comparison
Perform a traversal of each tree to isolate the "leaf frontier". Once the ordered sequences are obtained, a simple equality check determines if the trees satisfy the leafy similarity condition.
Thực hiện duyệt từng cây để tách "biên giới lá". Sau khi thu được các chuỗi có thứ tự, việc kiểm tra bằng nhau đơn giản sẽ xác định xem các cây có thỏa mãn điều kiện tương tự về lá hay không.

---
