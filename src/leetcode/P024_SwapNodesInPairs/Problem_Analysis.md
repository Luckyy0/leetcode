# 24. Swap Nodes in Pairs / Hoán Đổi Các Nút Theo Cặp

## Problem Description / Mô tả bài toán
Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed).
Cho một danh sách liên kết, hoán đổi hai nút liền kề nhau và trả về head của nó. Bạn phải giải quyết vấn đề mà không thay đổi giá trị trong các nút của danh sách (tức là chỉ các nút mới có thể thay đổi).

### Example 1:
```text
Input: head = [1,2,3,4]
Output: [2,1,4,3]
```

### Example 2:
```text
Input: head = []
Output: []
```

### Example 3:
```text
Input: head = [1]
Output: [1]
```

## Constraints / Ràng buộc
- The number of nodes in the list is in the range `[0, 100]`.
- `0 <= Node.val <= 100`

---

## Analysis / Phân tích

### Approach 1: Iterative / Lặp
- **Idea**: Use a `dummy` node pointing to `head`. Maintain a `prev` pointer.
- **Ý tưởng**: Sử dụng một nút `dummy` trỏ đến `head`. Duy trì một con trỏ `prev`.
    - Iterate while `curr` and `curr.next` exist.
    - `first = curr`
    - `second = curr.next`
    - Perform swap:
        - `prev.next = second`
        - `first.next = second.next`
        - `second.next = first`
    - Update `prev = first` and `curr = first.next`.
- **Time Complexity**: O(n).
- **Space Complexity**: O(1).

### Approach 2: Recursive / Đệ Quy
- **Idea**: `swap(head)` should return `head.next`.
- **Ý tưởng**: `swap(head)` nên trả về `head.next`.
    - `first = head`
    - `second = head.next`
    - `first.next = swap(second.next)`
    - `second.next = first`
    - Return `second`.
- **Time Complexity**: O(n).
- **Space Complexity**: O(n) stack.

---

## Edge Cases / Các trường hợp biên
1.  **Empty List**: `head == null`.
2.  **Single Node**: `head.next == null`.
3.  **Odd Length**: Last node remains unswapped.
