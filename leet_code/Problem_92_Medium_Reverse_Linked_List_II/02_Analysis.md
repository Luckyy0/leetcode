# Analysis for Reverse Linked List II
# *Phân tích cho bài toán Đảo Ngược Danh Sách Liên Kết II*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Head of linked list, indices `left` and `right`. *Dấu đầu của danh sách liên kết, các chỉ số `left` và `right`.*
*   **Output:** Head of the modified list. *Dấu đầu của danh sách đã được sửa đổi.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Positions are 1-indexed.
*   $1 \le left \le right \le n$.
*   Need to handle cases where `left = 1`.
*   *Vị trí được tính từ 1.*
*   *Phải xử lý các trường hợp `left = 1`.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Iterative One-Pass
### *Hướng tiếp cận: Duyệt một lần*

*   **Logic:**
    1.  Use a `dummy` node to simplify the case where `left = 1`.
    2.  Move a `prev` pointer to the node just before the `left` position (`left - 1` steps).
    3.  Set a `start` pointer to the node at `left` position (`prev.next`).
    4.  Set a `then` pointer to `start.next`.
    5.  For `right - left` times, perform the "insertion" of `then` between `prev` and `prev.next`:
        *   `start.next = then.next`
        *   `then.next = prev.next`
        *   `prev.next = then`
        *   `then = start.next`

*   **Complexity:**
    *   Time: $O(n)$ where $n$ is number of nodes.
    *   Space: $O(1)$.

### Dry Run
### *Chạy thử*
`[1, 2, 3, 4, 5], left = 2, right = 4`
1. `dummy -> 1 -> 2 -> 3 -> 4 -> 5`.
2. `prev` at `1`. `start` at `2`. `then` at `3`.
3. Loop 1 (`right-left = 2`):
   - `2.next = 4`
   - `3.next = 2`
   - `1.next = 3`
   - List: `1 -> 3 -> 2 -> 4 -> 5`. `then = 4`.
4. Loop 2:
   - `2.next = 5`
   - `4.next = 3`
   - `1.next = 4`
   - List: `1 -> 4 -> 3 -> 2 -> 5`. `then = 5`.
Result: `1 -> 4 -> 3 -> 2 -> 5`.
---
*Kỹ thuật chèn nút lên đầu đoạn đảo ngược giúp chúng ta không cần bộ nhớ phụ.*
The technique of inserting nodes at the beginning of the reversed segment allows us to avoid extra memory.
