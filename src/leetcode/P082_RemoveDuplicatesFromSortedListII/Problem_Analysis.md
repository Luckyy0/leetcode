# 82. Remove Duplicates from Sorted List II / Loại Bỏ Các Phần Tử Trùng Lặp Khỏi Danh Sách Đã Sắp Xếp II

## Problem Description / Mô tả bài toán
Given the `head` of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
Cho `head` của một danh sách liên kết đã sắp xếp, hãy xóa tất cả các nút có số trùng lặp, chỉ giữ lại các số riêng biệt từ danh sách ban đầu. Trả về danh sách liên kết cũng đã được sắp xếp.

### Example 1:
```text
Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
```

### Example 2:
```text
Input: head = [1,1,1,2,3]
Output: [2,3]
```

## Constraints / Ràng buộc
- The number of nodes in the list is in the range `[0, 300]`.
- `-100 <= Node.val <= 100`
- The list is guaranteed to be sorted in ascending order.

---

## Analysis / Phân tích

### Approach: Sentinel Head + Iteration / Nút Giả + Duyệt Lặp
- **Idea**: Use a dummy head to handle edge cases (e.g., removing the first nodes).
- **Ý tưởng**: Sử dụng nút giả (dummy head) để xử lý các trường hợp biên (ví dụ: xóa các nút đầu tiên).
- **Algorithm**:
    - `sentinel.next = head`.
    - `pred = sentinel`.
    - While `head != null`:
        - If `head.next != null` and `head.val == head.next.val`:
            - Skip all nodes with value `head.val`.
            - `pred.next` will eventually point to the next distinct value.
        - Else:
            - `pred = pred.next`.
        - `head = head.next`.
- **Time Complexity**: O(N).
- **Space Complexity**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **Empty List**: Return null.
2.  **All Duplicates**: Return null (sentinel.next is null).
3.  **No Duplicates**: No change.
