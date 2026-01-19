# 25. Reverse Nodes in k-Group / Đảo Ngược Các Nút Trong Nhóm k

## Problem Description / Mô tả bài toán
Given the `head` of a linked list, reverse the nodes of the list `k` at a time, and return the modified list.
Cho `head` của một danh sách liên kết, đảo ngược các nút của danh sách theo nhóm `k` một lần, và trả về danh sách đã sửa đổi.

`k` is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of `k` then left-out nodes, in the end, should remain as it is.
`k` là một số nguyên dương và nhỏ hơn hoặc bằng độ dài của danh sách liên kết. Nếu số lượng các nút không phải là bội số của `k` thì các nút còn lại ở cuối nên được giữ nguyên.

You may not alter the values in the list's nodes, only nodes themselves may be changed.
Bạn không thể thay đổi giá trị trong các nút của danh sách, chỉ các nút mới có thể thay đổi.

### Example 1:
```text
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
```

### Example 2:
```text
Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
```

## Constraints / Ràng buộc
- The number of nodes in the list is `n`.
- `1 <= k <= n <= 5000`
- `0 <= Node.val <= 1000`

---

## Analysis / Phân tích

### Approach: Iterative / Lặp
- **Idea**: Use `dummy`, `prev`, `curr`. Count `k` nodes. If enough nodes, reverse them. Connect proper pointers.
- **Ý tưởng**: Sử dụng `dummy`, `prev`, `curr`. Đếm `k` nút. Nếu đủ nút, đảo ngược chúng. Kết nối các con trỏ thích hợp.
    1.  Count length of list.
    2.  Loop `i` from `0` to `n/k`: The number of groups to reverse.
    3.  For each group:
        - Reverse `k` nodes.
        - `prev` (end of last reversed group) points to `newHead`.
        - `tail` (start of current group, now end) points to `nextGroup`.
        - Move `prev` to `tail`.
- **Time Complexity**: O(n). Each node is visited twice (once for length check, once for reversal).
- **Space Complexity**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  `k = 1`: No change.
2.  `n < k`: No change.
3.  `n % k != 0`: Last `n % k` nodes remain unchanged.
