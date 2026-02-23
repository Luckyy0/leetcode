# Analysis for Reverse Nodes in k-Group
# *Phân tích cho bài toán Đảo Ngược Các Nút trong Nhóm k*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Linked List `head`, Integer `k`. *Danh sách liên kết `head`, Số nguyên `k`.*
*   **Output:** Linked List (reversed in groups). *Danh sách liên kết (đảo ngược theo nhóm).*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   $N \le 5000$.
*   $O(1)$ extra memory is preferred (Recusion uses stack space, so Iterative is better).
    *Bộ nhớ dôi dư $O(1)$ được ưu tiên (Đệ quy sử dụng không gian stack, nên Lặp tốt hơn).*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Iterative
### *Hướng tiếp cận: Lặp*

*   **Intuition:**
    1.  Count total length.
    2.  Loop `n // k` times.
    3.  In each iteration, reverse `k` nodes.
    4.  Connect the `prev` group to the new head of this group.
    5.  Connect the tail of this group to the next group.
    6.  Update pointers.

*   **Algorithm Steps:**
    1.  Count `n`.
    2.  `dummy -> head`. `prev = dummy`, `curr = head`.
    3.  Loop `i` from 0 to `n / k`:
        *   Keep `tail = curr`.
        *   Reverse `k` nodes starting from `curr`. (Standard reversal).
        *   After reverse, `curr` will be pointing to the `(k+1)-th` node (start of next group).
        *   `prev.next` (end of old group) should point to `newHead` of reversed group.
        *   `tail.next` (end of new group) point to `curr` (start of next group).
        *   `prev = tail`.

*   **Reverse Logic (k nodes):**
    *   `prevNode = null`, `nextNode = null`.
    *   Repeat k times:
        *   `nextNode = curr.next`
        *   `curr.next = prevNode`
        *   `prevNode = curr`
        *   `curr = nextNode`
    *   Return `prevNode` (new head of group), and `curr` is effectively updated to next group start.

*   **Complexity:**
    *   Time: $O(N)$.
    *   Space: $O(1)$.

### Dry Run
### *Chạy thử*
`1->2->3->4->5`, `k=2`.
1.  Len=5. Rounds = 2.
2.  Round 1: `curr=1`. Rev 2 nodes (1, 2). `2->1`. `curr` becomes 3. `newHead=2`.
    *   Connect `dummy->2`.
    *   Connect `1->3`.
    *   `prev` becomes 1. `tail` was 1.
    *   List: `Dummy->2->1->3->4->5`.
3.  Round 2: `curr=3`. Rev 2 nodes (3, 4). `4->3`. `curr` becomes 5. `newHead=4`.
    *   Connect `1->4`.
    *   Connect `3->5`.
    *   `prev` becomes 3.
    *   List: `Dummy->2->1->4->3->5`.
4.  Stop.
