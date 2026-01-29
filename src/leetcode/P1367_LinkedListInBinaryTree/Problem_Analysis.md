# 1367. Linked List in Binary Tree / Danh sách Liên kết trong Cây Nhị phân

## Problem Description / Mô tả bài toán
Check if linked list `head` corresponds to a downward path in binary tree `root`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### DFS / Recursion
Two recursions:
1. `isSubPath(head, root)`: Check if path starts at `root` OR `isSubPath(head, root.left)` OR `isSubPath(head, root.right)`.
2. `checkPath(head, root)`: Check if `head` matches path starting strictly at `root`.

### Complexity / Độ phức tạp
- **Time**: O(N * L) where N nodes, L list length.
- **Space**: O(H * L) stack depth.

---

## Analysis / Phân tích

### Approach: Dual Recursion
We need to check if there exists any path in the tree that matches the linked list.
The outer funtion traversal `isSubPath` visits every node in the tree. For each node, it calls `checkPath` to see if a matching path starts exactly at that node.
`checkPath(listNode, treeNode)` returns true if:
- `listNode` is null (matched all).
- `treeNode` is null (tree ended before list).
- values differ.
- values match AND (`checkPath(next, left)` OR `checkPath(next, right)`).
Chúng ta cần kiểm tra xem có tồn tại bất kỳ đường dẫn nào trong cây khớp với danh sách liên kết hay không.
Hàm duyệt bên ngoài `isSubPath` truy cập mọi nút trong cây. Đối với mỗi nút, nó gọi `checkPath` để xem liệu một đường dẫn khớp có bắt đầu chính xác tại nút đó hay không.
`checkPath(listNode, treeNode)` trả về true nếu:
- `listNode` là null (đã khớp tất cả).
- `treeNode` là null (cây kết thúc trước danh sách).
- các giá trị khác nhau.
- các giá trị khớp VÀ (`checkPath(next, left)` HOẶC `checkPath(next, right)`).

---
