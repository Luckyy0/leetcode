# 92. Reverse Linked List II / Đảo Ngược Danh Sách Liên Kết II

## Problem Description / Mô tả bài toán
Given the `head` of a singly linked list and two integers `left` and `right` where `left <= right`, reverse the nodes of the list from position `left` to position `right`, and return the **reversed list**.
Cho `head` của một danh sách liên kết đơn và hai số nguyên `left` và `right` trong đó `left <= right`, đảo ngược các nút của danh sách từ vị trí `left` đến vị trí `right`, và trả về **danh sách đã đảo ngược**.

### Example 1:
```text
Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
```

### Example 2:
```text
Input: head = [5], left = 1, right = 1
Output: [5]
```

## Constraints / Ràng buộc
- The number of nodes in the list is `n`.
- `1 <= n <= 500`
- `-500 <= Node.val <= 500`
- `1 <= left <= right <= n`

---

## Analysis / Phân tích

### Approach: Iterative Link Reversal / Đảo Ngược Liên Kết Lặp
- **Idea**: Traverse to the node at `left-1`. Then reverse the sublist from `left` to `right`.
- **Ý tưởng**: Duyệt đến nút tại vị trí `left-1`. Sau đó đảo ngược danh sách con từ `left` đến `right`.
- **Steps**:
    1.  Use `dummy` node pointing to `head` (to handle `left=1`).
    2.  Move `prev` pointer to `left-1`.
    3.  `curr` is at `left`.
    4.  Repeat `right - left` times:
        - `next = curr.next`.
        - `curr.next = next.next`.
        - `next.next = prev.next`.
        - `prev.next = next`.
    - This effectively moves `next` to the front of the sublist (after `prev`).
- **Time Complexity**: O(N).
- **Space Complexity**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **left = right**: No change.
2.  **left = 1**: Reverse from head (Handled by dummy).
