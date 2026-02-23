# Analysis for Remove Duplicates from Sorted List
# *Phân tích cho bài toán Loại Bỏ Phần Tử Trùng Lặp Khỏi Danh Sách Đã Sắp Xếp*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Head of a sorted linked list. *Đầu của một danh sách liên kết đã được sắp xếp.*
*   **Output:** Head of the list with unique elements (one instance of each). *Đầu của danh sách với các phần tử duy nhất (mỗi phần tử một bản).*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   List size up to 300.
*   Values are small.
*   *Kích thước danh sách nhỏ.*
*   *Giá trị nhỏ.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Linear Pass
### *Hướng tiếp cận: Duyệt Tuyến tính*

*   **Logic:**
    1.  Start with `current = head`.
    2.  While `current` and `current.next` are not null:
        *   If `current.val == current.next.val`: 
            *   Skip `current.next` by setting `current.next = current.next.next`.
        *   Else:
            *   Move `current` forward: `current = current.next`.
    3.  Return `head`.

*   **Complexity:**
    *   Time: $O(n)$.
    *   Space: $O(1)$.

### Dry Run
### *Chạy thử*
`[1, 1, 2]`
1. `current` at first `1`. `next.val` is also `1`.
2. `current.next = current.next.next` (which is `2`). `[1, 2]`.
3. `current` (at `1`) vs `next` (at `2`). Not equal.
4. `current` moves to `2`.
5. `current.next` is null. Stop.
Result: `[1, 2]`.
---
*Bài toán này đơn giản hơn bài 82 vì chúng ta chỉ cần giữ lại một bản sao của mỗi giá trị.*
This problem is simpler than problem 82 because we only need to keep one copy of each value.
