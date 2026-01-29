# 1315. Sum of Nodes with Even-Valued Grandparent / Tổng các Nút có Ông/Bà có Giá trị Chẵn

## Problem Description / Mô tả bài toán
Binary Tree. Sum of values of nodes with even-valued grandparent.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### DFS with Parent/Grandparent Info
Pass `parentVal` and `grandparentVal` in recursion.
Initial call: `dfs(root, -1, -1)`.
If `grandparentVal % 2 == 0`, add `node.val` to sum.
Recurse: `dfs(child, node.val, parentVal)`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H).

---

## Analysis / Phân tích

### Approach: DFS with Ancestor State
Perform a DFS traversal. Keep track of the parent and grandparent values as arguments in the recursive function. For the root, assume parent and grandparent are odd (or simply handle null checks). At each node, check if the grandparent value is even; if so, add the current node's value to the global sum. Recurse to children, passing the current node as parent and the current parent as grandparent.
Thực hiện duyệt DFS. Theo dõi giá trị cha và ông/bà làm đối số trong hàm đệ quy. Đối với gốc, giả sử cha và ông/bà là số lẻ (hoặc chỉ cần xử lý kiểm tra null). Tại mỗi nút, kiểm tra xem giá trị ông/bà có chẵn không; nếu có, cộng giá trị nút hiện tại vào tổng chung. Đệ quy cho các con, chuyển nút hiện tại làm cha và cha hiện tại làm ông/bà.

---
