# Analysis for Rotate List
# *Phân tích cho bài toán Xoay Danh Sách*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Head of linked list, integer `k`. *Đầu của danh sách liên kết, số nguyên `k`.*
*   **Output:** Head of the rotated list. *Đầu của danh sách đã xoay.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `k` can be much larger than the list length. Use `k % length`.
*   Empty list or single node should be handled.
*   *`k` có thể lớn hơn nhiều so với độ dài danh sách. Sử dụng `k % length`.*
*   *Cần xử lý danh sách rỗng hoặc danh sách chỉ có một nút.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Circular List
### *Hướng tiếp cận: Danh sách Vòng*

*   **Intuition:** Connect the tail of the list to the head to make it circular. Then, find the new tail and break the connection. The new head will be the node following the new tail.
*   *Ý tưởng: Nối phần đuôi của danh sách với phần đầu để tạo thành một vòng tròn. Sau đó, tìm phần đuôi mới và ngắt kết nối. Phần đầu mới sẽ là nút theo sau phần đuôi mới.*

*   **Algorithm Steps:**
    1.  If `head` is null or `head.next` is null, return `head`.
    2.  Calculate the length of the list and find the actual tail.
    3.  Connect `tail.next = head` to form a circle.
    4.  Calculate `k = k % length`. The number of steps from the old head to the new tail is `length - k - 1`.
    5.  Move `head` to that position.
    6.  Identify the `new_head = head.next`, set `head.next = null` to break the circle.
    7.  Return `new_head`.

*   **Complexity:**
    *   Time: $O(N)$ (one pass to find length, another to find split point).
    *   Space: $O(1)$.

### Dry Run
### *Chạy thử*
`[1, 2, 3, 4, 5], k = 2`
1. Length = 5. Tail at 5.
2. Circle: `5 -> 1`.
3. `k = 2 % 5 = 2`. Steps to new tail: `5 - 2 - 1 = 2`.
4. Move 2 steps from 1: 1 -> 2 -> 3. New tail is 3.
5. New head is 4. Break `3 -> 4`.
Result: `[4, 5, 1, 2, 3]`. Correct.
---
*Việc chuyển đổi thành danh sách vòng giúp đơn giản hóa việc tìm điểm ngắt.*
Converting to a circular list simplifies finding the break point.
