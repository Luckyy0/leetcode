# 707. Design Linked List / Thiết kế Danh sách Liên kết

## Problem Description / Mô tả bài toán
Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
Thiết kế triển khai danh sách liên kết của bạn. Bạn có thể chọn sử dụng danh sách liên kết đơn hoặc kép.

Implement the `MyLinkedList` class:
- `get(int index)` Get the value of the `indexth` node in the linked list. If the index is invalid, return -1.
- `addAtHead(int val)` Add a node of value `val` before the first element.
- `addAtTail(int val)` Append a node of value `val` as the last element.
- `addAtIndex(int index, int val)` Add a node of value `val` before the `indexth` node. If `index` equals the length, element will be appended. If `index` is greater than length, the node will not be inserted.
- `deleteAtIndex(int index)` Delete the `indexth` node if the index is valid.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Singly Linked List / Danh sách Liên kết đơn
A node contains a `val` and a `next` pointer.
Một nút chứa một `val` và một con trỏ `next`.

We need to keep track of the `head` and the `size`.
Chúng ta cần theo dõi `head` và `size`.

Methods:
- `get`: Traverse `index` times.
- `addAtHead`: New node points to old head.
- `addAtIndex`: Traverse to `index - 1`, link new node.

### Complexity / Độ phức tạp
- **Time**: O(index) for `get`, `addAtIndex`, `deleteAtIndex`. O(1) for `addAtHead`. O(n) for `addAtTail` (unless we keep a tail pointer).
- **Space**: O(N) to store nodes.

---

## Analysis / Phân tích

### Approach: Singly Linked List with Sentinel Node
Using a sentinel (dummy) node simplifies edge cases (like adding/deleting at head).
Sử dụng một nút giả (dummy) giúp đơn giản hóa các trường hợp biên (như thêm/xóa tại đầu).

---
