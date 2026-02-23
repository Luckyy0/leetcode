# Analysis for Partition List
# *Phân tích cho bài toán Phân Tách Danh Sách*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Head of a linked list and a pivot value `x`. *Đầu của một danh sách liên kết và một giá trị chốt `x`.*
*   **Output:** Head of the partitioned linked list. *Đầu của danh sách liên kết đã được phân tách.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Preserve relative order.
*   In-place or using dummy nodes.
*   Number of nodes up to 200.
*   *Giữ nguyên thứ tự tương đối.*
*   *Thực hiện tại chỗ hoặc sử dụng các nút dummy.*
*   *Số lượng nút lên tới 200.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Two Queues (using Dummy Nodes)
### *Hướng tiếp cận: Hai hàng đợi (Sử dụng các nút Dummy)*

*   **Logic:**
    1.  Create two separate lists: one for nodes less than `x` and one for nodes greater than or equal to `x`.
    2.  Use two dummy nodes, `beforeHead` and `afterHead`, to manage these lists easily.
    3.  Iterate through the original list and append each node to the appropriate list.
    4.  Connect the end of the "before" list to the start of the "after" list.
    5.  Set the next pointer of the last node in the "after" list to null to avoid cycles.

*   **Algorithm Steps:**
    1.  Initialize `beforeHead = new ListNode(0)`, `afterHead = new ListNode(0)`.
    2.  Pointers `before = beforeHead`, `after = afterHead`.
    3.  While `head != null`:
        *   If `head.val < x`: `before.next = head`, `before = before.next`.
        *   Else: `after.next = head`, `after = after.next`.
        *   `head = head.next`.
    4.  `after.next = null`.
    5.  `before.next = afterHead.next`.
    6.  Return `beforeHead.next`.

*   **Complexity:**
    *   Time: $O(n)$ (single pass).
    *   Space: $O(1)$ (only pointers used).

### Dry Run
### *Chạy thử*
`head = [1, 4, 3, 2], x = 3`
1. `head = 1`: `before -> 1`, `before = 1`.
2. `head = 4`: `after -> 4`, `after = 4`.
3. `head = 3`: `after -> 4 -> 3`, `after = 3`.
4. `head = 2`: `before -> 1 -> 2`, `before = 2`.
5. `after.next = null`.
6. `before.next = afterHead.next` (which is 4).
Result: `1 -> 2 -> 4 -> 3`.
---
*Việc sử dụng hai danh sách riêng biệt giúp đảm bảo thứ tự tương đối được giữ nguyên một cách dễ dàng.*
Using two separate lists ensures the relative order is preserved easily.
