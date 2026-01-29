# 1474. Delete N Nodes After M Nodes of a Linked List / Xóa N Nút Sau M Nút của Danh sách Liên kết

## Problem Description / Mô tả bài toán
Linked List. Keep M nodes, delete N nodes. Repeat.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Simulation with Pointers
Two loops inside main loop:
1. Move `curr` M-1 times (Keep M nodes).
2. Mark `lastKept = curr`.
3. Move `curr` N+1 times (Skip N nodes). To find next node to connect.
4. `lastKept.next = curr`.
Handle nulls carefully.

### Complexity / Độ phức tạp
- **Time**: O(L).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Linear Traversal
Iterate through the list. Maintain a pointer.
Loop while pointer not null:
1. Traverse M-1 steps to find end of "keep" segment. Save this node.
2. From there, traverse N+1 steps to skip N nodes.
3. Link the saved node to the node found after skipping.
4. Continue from the linked node.
Lặp qua danh sách.
1. Duyệt M-1 bước để giữ.
2. Duyệt N+1 bước để bỏ qua.
3. Liên kết nút đã lưu với nút tìm thấy sau khi bỏ qua.

---
