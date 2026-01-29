# 1290. Convert Binary Number in a Linked List to Integer / Chuyển Đổi Số Nhị Phân trong Danh Sách Liên Kết thành Số Nguyên

## Problem Description / Mô tả bài toán
Given `head` of linked list with 0s and 1s.
Return decimal value.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Bit Manipulation
Initial `ans = 0`.
Traverse list.
`ans = (ans << 1) | head.val`.
Or `ans = ans * 2 + head.val`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Accumulation
Traverse the linked list. Maintain an accumulator `ans`. For each node, shift `ans` left by 1 (multiply by 2) and add the node's value. This reconstructs the integer from its binary representation.
Duyệt danh sách liên kết. Duy trì một bộ tích lũy `ans`. Đối với mỗi nút, dịch chuyển `ans` sang trái 1 (nhân với 2) và cộng giá trị của nút. Điều này tái tạo số nguyên từ biểu diễn nhị phân của nó.

---
