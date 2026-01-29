# 1261. Find Elements in a Contaminated Binary Tree / Tìm các Phần tử trong Cây Nhị phân Bị nhiễm

## Problem Description / Mô tả bài toán
Binary tree contaminated: all values became -1.
Recover:
- `root.val = 0`.
- `left.val = 2 * parent.val + 1`.
- `right.val = 2 * parent.val + 2`.
Class `FindElements(root)` recovers tree.
`find(target)` returns true if target exists.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Tree Traversal and HashSet
1. Constructor: Recover values using DFS/BFS. Store valid values in `HashSet`.
2. Find: Check `HashSet`.

### Complexity / Độ phức tạp
- **Time**: Constructor O(N), Find O(1).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Restoration via DFS
Traverse the contaminated tree starting from the root (initialize `root.val = 0`). For each node with value `x`, set its left child's value to `2*x + 1` and right child's value to `2*x + 2` (if they exist). Simultaneously, populate a `HashSet` with all recovered values. The `find` operation simply checks for existence in this set.
Duyệt cây bị nhiễm bắt đầu từ gốc (khởi tạo `root.val = 0`). Đối với mỗi nút có giá trị `x`, đặt giá trị con bên trái của nó thành `2*x + 1` và giá trị con bên phải thành `2*x + 2` (nếu chúng tồn tại). Đồng thời, điền vào `HashSet` với tất cả các giá trị được khôi phục. Thao tác `find` chỉ cần kiểm tra sự tồn tại trong tập hợp này.

---
