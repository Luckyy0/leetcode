# Analysis for Swap Nodes in Pairs
# *Phân tích cho bài toán Hoán Đổi Các Nút Theo Cặp*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Linked List `head`. *Danh sách liên kết `head`.*
*   **Output:** Linked List (swapped). *Danh sách liên kết (đã hoán đổi).*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Nodes up to 100.
*   **Requirement:** Do not swap values. Swap nodes.
*   *Yêu cầu: Không hoán đổi giá trị. Hoán đổi các nút.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Iterative with Dummy Node
### *Hướng tiếp cận: Lặp với Nút Giả*

*   **Intuition:** We need to change pointers.
    *Ý tưởng: Chúng ta cần thay đổi các con trỏ.*
    *   Original: `prev -> first -> second -> nextNode`.
    *   Goal: `prev -> second -> first -> nextNode`.
*   **Algorithm Steps:**
    1.  Create `dummy` pointing to `head`. `prev = dummy`.
    2.  While `prev.next` and `prev.next.next` exist:
        *   `first = prev.next`.
        *   `second = prev.next.next`.
        *   `prev.next = second`.
        *   `first.next = second.next`.
        *   `second.next = first`.
        *   `prev = first`. (Move forward).
    3.  Return `dummy.next`.

*   **Complexity:**
    *   Time: $O(N)$.
    *   Space: $O(1)$.

### Dry Run
### *Chạy thử*
`1 -> 2 -> 3 -> 4`. Dummy -> 1.
1.  Prev=Dummy. First=1. Second=2.
    *   Dummy->2.
    *   1->3.
    *   2->1.
    *   List: Dummy->2->1->3->4.
    *   Prev moves to 1.
2.  Prev=1. First=3. Second=4.
    *   1->4.
    *   3->null.
    *   4->3.
    *   List: Dummy->2->1->4->3.
    *   Prev moves to 3.
Stop.
