# 19. Remove Nth Node From End of List / Xóa Nút Thứ N Từ Cuối Danh Sách

## Problem Description / Mô tả bài toán
Given the `head` of a linked list, remove the `n`-th node from the end of the list and return its head.
Cho `head` của một danh sách liên kết, hãy xóa nút thứ `n` từ cuối danh sách và trả về `head` của nó.

### Example 1:
```text
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
```

### Example 2:
```text
Input: head = [1], n = 1
Output: []
```

### Example 3:
```text
Input: head = [1,2], n = 1
Output: [1]
```

## Constraints / Ràng buộc
- The number of nodes in the list is `sz`.
- `1 <= sz <= 30`
- `0 <= Node.val <= 100`
- `1 <= n <= sz`

---

## Analysis / Phân tích

### Approach 1: Two Pass / Hai Lần Duyệt
- **Idea**: First pass to find length `L`. Second pass to move `L-n` steps to find the node before the target.
- **Ý tưởng**: Lần duyệt đầu tiên tìm độ dài `L`. Lần duyệt thứ hai di chuyển `L-n` bước để tìm nút trước nút mục tiêu.
- **Time Complexity**: O(2L) = O(L).
- **Space Complexity**: O(1).

### Approach 2: One Pass (Two Pointers) / Một Lần Duyệt (Hai Con Trỏ)
- **Idea**: Use two pointers `fast` and `slow`.
- **Ý tưởng**: Sử dụng hai con trỏ `fast` và `slow`.
    1.  Move `fast` `n` steps ahead.
    2.  If `fast` is `null`, it means we need to remove the `head` (since `n` equals the list length). Return `head.next`.
    3.  Move both `fast` and `slow` one step at a time until `fast.next` is `null`.
    4.  `slow` will be pointing to the `(n+1)`-th node from the end (the node before the one to remove).
    5.  `slow.next = slow.next.next`.
- **Time Complexity**: O(L).
- **Space Complexity**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **Remove Head**: `n == length`. `fast` goes to null after n steps.
2.  **Remove Tail**: `n == 1`.
3.  **Single Node List**: `head = [1], n = 1`. Returns `[]`.
