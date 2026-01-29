# 876. Middle of the Linked List / Giữa Danh sách Liên kết

## Problem Description / Mô tả bài toán
Given the `head` of a singly linked list, return the middle node of the linked list.
Cho `head` của một danh sách liên kết đơn, hãy trả về nút ở giữa của danh sách.

If there are two middle nodes, return the second middle node.
Nếu có hai nút ở giữa, hãy trả về nút thứ hai.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Fast and Slow Pointers / Con trỏ Nhanh và Chậm
Algorithm:
1. Initialize two pointers `slow` and `fast` both at `head`.
2. Move `slow` by 1 step and `fast` by 2 steps.
3. When `fast` reaches the end (`fast == null` or `fast.next == null`), `slow` will be at the middle.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Proportional Travel
By moving one pointer twice as fast as the other, we ensure that when the leader strikes the finish line, the follower is exactly at the midpoint.
Bằng cách di chuyển một con trỏ nhanh gấp đôi con trỏ kia, chúng ta đảm bảo rằng khi con trỏ dẫn đầu chạm đích, con trỏ đi sau sẽ nằm chính xác ở điểm giữa.

---
