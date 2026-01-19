# 83. Remove Duplicates from Sorted List / Loại Bỏ Các Phần Tử Trùng Lặp Khỏi Danh Sách Đã Sắp Xếp

## Problem Description / Mô tả bài toán
Given the `head` of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
Cho `head` của một danh sách liên kết đã sắp xếp, hãy xóa tất cả các phần tử trùng lặp sao cho mỗi phần tử chỉ xuất hiện một lần. Trả về danh sách liên kết cũng đã được sắp xếp.

### Example 1:
```text
Input: head = [1,1,2]
Output: [1,2]
```

### Example 2:
```text
Input: head = [1,1,2,3,3]
Output: [1,2,3]
```

## Constraints / Ràng buộc
- The number of nodes in the list is in the range `[0, 300]`.
- `-100 <= Node.val <= 100`
- The list is guaranteed to be sorted in ascending order.

---

## Analysis / Phân tích

### Approach: Iteration / Duyệt Lặp
- **Idea**: Use a current pointer. If `current.val == current.next.val`, update `current.next` to `current.next.next`.
- **Ý tưởng**: Sử dụng một con trỏ hiện tại. Nếu `current.val == current.next.val`, cập nhật `current.next` thành `current.next.next`.
- **Algorithm**:
    - `curr = head`.
    - While `curr != null` and `curr.next != null`:
        - If `curr.val == curr.next.val`:
            - `curr.next = curr.next.next` (Delete duplicate node).
        - Else:
            - `curr = curr.next` (Move to next distinct node).
- **Time Complexity**: O(N).
- **Space Complexity**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **Empty List**: Return null.
2.  **Single Element**: Return head.
3.  **All Same**: `1->1->1` becomes `1`.
