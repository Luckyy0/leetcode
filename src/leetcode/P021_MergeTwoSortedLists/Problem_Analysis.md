# 21. Merge Two Sorted Lists / Hợp Nhất Hai Danh Sách Đã Sắp Xếp

## Problem Description / Mô tả bài toán
You are given the heads of two sorted linked lists `list1` and `list2`.
Bạn được cho các đầu của hai danh sách liên kết đã sắp xếp `list1` và `list2`.

Merge the two lists into one **sorted** list. The list should be made by splicing together the nodes of the first two lists.
Hợp nhất hai danh sách thành một danh sách **đã sắp xếp**. Danh sách nên được tạo bằng cách nối các nút của hai danh sách đầu tiên lại với nhau.

Return the head of the merged linked list.
Trả về đầu của danh sách liên kết đã hợp nhất.

### Example 1:
```text
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
```

### Example 2:
```text
Input: list1 = [], list2 = []
Output: []
```

### Example 3:
```text
Input: list1 = [], list2 = [0]
Output: [0]
```

## Constraints / Ràng buộc
- The number of nodes in both lists is in the range `[0, 50]`.
- `-100 <= Node.val <= 100`
- Both `list1` and `list2` are sorted in **non-decreasing** order.

---

## Analysis / Phân tích

### Approach 1: Recursive / Đệ Quy
- **Idea**:
    - If `list1` is null, return `list2`.
    - If `list2` is null, return `list1`.
    - If `list1.val < list2.val`: `list1.next = merge(list1.next, list2)`, return `list1`.
    - Else: `list2.next = merge(list1, list2.next)`, return `list2`.
- **Time Complexity**: O(n + m).
- **Space Complexity**: O(n + m) for recursion stack.

### Approach 2: Iterative / Lặp
- **Idea**: Use a dummy head. Loop while both are not null, attaching the smaller node to `curr.next`. Finally attach the remaining list.
- **Ý tưởng**: Sử dụng một đầu giả (dummy head). Lặp trong khi cả hai danh sách chưa null, gắn nút nhỏ hơn vào `curr.next`. Cuối cùng gắn danh sách còn lại.
- **Time Complexity**: O(n + m).
- **Space Complexity**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **Both Empty**: `[]`, `[]` -> `[]`.
2.  **One Empty**: `[]`, `[0]` -> `[0]`.
3.  **Identical**: `[1]`, `[1]` -> `[1, 1]`.
