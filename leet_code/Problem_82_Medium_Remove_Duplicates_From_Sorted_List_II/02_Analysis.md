# Analysis for Remove Duplicates from Sorted List II
# *Phân tích cho bài toán Loại Bỏ Phần Tử Trùng Lặp Khỏi Danh Sách Đã Sắp Xếp II*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Head of a sorted linked list. *Đầu của một danh sách liên kết đã được sắp xếp.*
*   **Output:** Head of the list with only unique elements. *Đầu của danh sách chỉ chứa các phần tử duy nhất.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   List size up to 300.
*   Values are small (-100 to 100).
*   *Kích thước danh sách lên tới 300.*
*   *Giá trị trong khoảng nhỏ (-100 đến 100).*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Sentinel (Dummy) Node + Iteration
### *Hướng tiếp cận: Nút canh gác (Dummy) + Duyệt*

*   **Logic:**
    1.  Create a `dummy` node pointing to `head`. This helps when the head itself needs to be removed.
    2.  Use a pointer `prev` to keep track of the last node that is confirmed to be distinct.
    3.  Iterate through the list using `head`.
    4.  Whenever `head` points to a node that has duplicates (check `head.val == head.next.val`):
        *   Find the end of the duplicate sequence.
        *   Link `prev.next` to the node after the duplicate sequence.
    5.  If no duplicates are found for `head`, update `prev` to `head`.
    6.  Move `head` to `head.next`.

*   **Complexity:**
    *   Time: $O(n)$ (single pass).
    *   Space: $O(1)$.

### Dry Run
### *Chạy thử*
`[1, 1, 1, 2, 3]`
1. `dummy -> 1 -> 1 -> 1 -> 2 -> 3`. `prev = dummy`.
2. `head` at first `1`. `head.next.val` is also `1`. Duplicate found.
3. Skip all `1`s. `head` moves to the last `1`.
4. `prev.next = head.next` (which is `2`). `dummy -> 2 -> 3`.
5. `head` moves to `2`. No duplicate with `2.next=3`.
6. `prev = 2`.
7. `head` moves to `3`. No duplicate.
8. `prev = 3`.
Result: `[2, 3]`.
---
*Nút Dummy là kỹ thuật cực kỳ hữu ích khi thao tác với danh sách liên kết, giúp tránh các trường hợp đặc biệt tại Head.*
The Dummy Node is an extremely useful technique when working with linked lists, helping to avoid special cases at the Head.
