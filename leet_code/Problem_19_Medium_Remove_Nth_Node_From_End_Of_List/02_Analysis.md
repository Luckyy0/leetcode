# Analysis for Remove Nth Node From End of List
# *Phân tích cho bài toán Xóa Nút Thứ N Từ Cuối Danh Sách*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** LinkedList `head`, Integer `n`. *Danh sách liên kết `head`, Số nguyên `n`.*
*   **Output:** LinkedList `head`. *Danh sách liên kết `head`.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Size `sz` up to 30. Very small.
*   One pass is preferred.
    *Một lần duyệt được ưu tiên.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Two Pointers (One Pass)
### *Hướng tiếp cận: Hai Con Trỏ (Một Lần Duyệt)*

*   **Intuition:** We can maintain a gap of `n` nodes between two pointers `first` and `second`.
    *Ý tưởng: Chúng ta có thể duy trì một khoảng cách `n` nút giữa hai con trỏ `first` và `second`.*
*   **Algorithm Steps:**
    1.  Create a `dummy` node pointing to `head`. (Handles edge case removing head).
        *Tạo một nút `dummy` trỏ đến `head` (Xử lý trường hợp biên xóa nút đầu).*
    2.  `first` = `dummy`, `second` = `dummy`.
    3.  Move `first` forward `n + 1` times.
        *Di chuyển `first` về phía trước `n + 1` lần.*
    4.  Move both `first` and `second` until `first` reaches end (null).
        *Di chuyển cả `first` và `second` cho đến khi `first` đến cuối (null).*
    5.  Now `second` is just before the node to be removed.
        *Lúc này `second` đang ở ngay trước nút cần xóa.*
    6.  `second.next = second.next.next`.
    7.  Return `dummy.next`.

*   **Complexity:**
    *   Time: $O(L)$ (One pass).
    *   Space: $O(1)$.

### Dry Run
### *Chạy thử*
`1->2->3->4->5`, `n=2`.
1.  Dummy->1. `first`, `second` at Dummy.
2.  Move `first` 3 times (n+1). `first` at 3.
3.  Move both.
    *   `first` at 4, `second` at Dummy. (Wait, `first` started at Dummy).
    Let's trace carefully.
    `first` at Dummy. Move 3 times: 1->2->3. `first` at 3.
    Move:
    *   `first`->4, `second`->1.
    *   `first`->5, `second`->2.
    *   `first`->null, `second`->3.
    `second` is at 3. Remove next (4). Result 1->2->3->5. Correct.

*Wait code trace correction*: If we want to remove 4 (2nd from end).
List: 1, 2, 3, 4, 5. Length 5.
Indices: 1(0), 2(1), 3(2), 4(3), 5(4).
Target remove: 4. Index 3. 5 - 2 = 3.
Gap logic:
Move first `n+1` steps.
Dummy(0) -> 1(1) -> 2(2) -> 3(3) -> 4(4) -> 5(5) -> Null.
Start First at Dummy. Move 3 steps -> First is at 3 (Value 3 is at pos 3 relative to dummy if dummy is 0). No, First moves: Dummy->1->2->3.
Move both until First null.
1. First->4, Second->1
2. First->5, Second->2
3. First->null, Second->3.
Safe.
