# 203. Remove Linked List Elements / Xóa Phần Tử Trong Danh Sách Liên Kết

## Problem Description / Mô tả bài toán
Given the `head` of a linked list and an integer `val`, remove all the nodes of the linked list that has `Node.val == val`, and return the new head.
Cho `head` của một danh sách liên kết và một số nguyên `val`, hãy xóa tất cả các nút của danh sách liên kết có `Node.val == val`, và trả về `head` mới.

### Example 1:
```text
Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]
```

### Example 2:
```text
Input: head = [], val = 1
Output: []
```

### Example 3:
```text
Input: head = [7,7,7,7], val = 7
Output: []
```

## Constraints / Ràng buộc
- The number of nodes in the list is in the range `[0, 10^4]`.
- `1 <= Node.val <= 50`
- `0 <= val <= 50`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Dummy Node Strategy / Chiến lược Nút Giả
Usually, removing the head node requires special handling because the `head` pointer itself changes.
Normally, to delete a node, we need access to its **predecessor** (`prev.next = current.next`). The head has no predecessor.
By creating a **dummy node** that points to the head, every node (including the original head) has a predecessor.

---

## Analysis / Phân tích

### Approach: Iteration with Dummy Head

**Algorithm**:
1.  Create `dummy` node, `dummy.next = head`.
2.  Initialize `current = dummy`.
3.  While `current.next != null`:
    - If `current.next.val == val`:
        - Skip the node: `current.next = current.next.next`.
    - Else:
        - Move forward: `current = current.next`.
4.  Return `dummy.next`.

### Complexity / Độ phức tạp
- **Time**: O(N) - single pass.
- **Space**: O(1) - auxiliary pointers.

---

## Edge Cases / Các trường hợp biên
1.  **Empty list**: Returns null.
2.  **Head needs removal**: Dummy handles this.
3.  **All nodes need removal**: Dummy handles this.
4.  **Tail needs removal**: Handled.
