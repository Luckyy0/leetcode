# 141. Linked List Cycle / Chu trình Danh sách Liên kết

## Problem Description / Mô tả bài toán
Given `head`, the head of a linked list, determine if the linked list has a cycle in it.
Cho `head`, đầu của một danh sách liên kết, hãy xác định xem danh sách liên kết có chu trình trong đó hay không.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the `next` pointer. Internally, `pos` is used to denote the index of the node that tail's `next` pointer is connected to. **Note that `pos` is not passed as a parameter**.
Một chu trình tồn tại trong danh sách liên kết nếu có một số nút trong danh sách có thể được truy cập lại bằng cách liên tục theo con trỏ `next`. Trong nội bộ, `pos` được sử dụng để biểu thị chỉ số của nút mà con trỏ `next` của nút đuôi được kết nối tới. **Lưu ý rằng `pos` không được truyền dưới dạng tham số**.

Return `true` if there is a cycle in the linked list. Otherwise, return `false`.
Trả về `true` nếu có chu trình trong danh sách liên kết. Nếu không, trả về `false`.

### Example 1:
```text
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
```

### Example 2:
```text
Input: head = [1,2], pos = 0
Output: true
```

### Example 3:
```text
Input: head = [1], pos = -1
Output: false
```

## Constraints / Ràng buộc
- The number of the nodes in the list is in the range `[0, 10^4]`.
- `-10^5 <= Node.val <= 10^5`
- `pos` is `-1` or a **valid index** in the linked-list.

**Follow up**: Can you solve it using `O(1)` (i.e. constant) memory?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Floyd's Cycle-Finding Algorithm (Tortoise and Hare) / Thuật toán Tìm chu trình của Floyd (Rùa và Thỏ)
This is the standard algorithm for cycle detection:
Đây là thuật toán tiêu chuẩn để phát hiện chu trình:
1.  Initialize two pointers, `slow` and `fast`, both at the `head`.
2.  Move `slow` one step at a time (`slow = slow.next`).
3.  Move `fast` two steps at a time (`fast = fast.next.next`).
4.  If the list has a cycle, the `fast` pointer will eventually catch up to the `slow` pointer (`slow == fast`).
5.  If the list has no cycle, the `fast` pointer will reach the end (`null`).

---

## Analysis / Phân tích

### Approach: Two Pointers (Slow and Fast) / Hai Con trỏ (Chậm và Nhanh)

**Complexity / Độ phức tạp**:
- **Time**: O(N) - In the worst case, the fast pointer travels twice the length of the list before catching the slow pointer.
- **Space**: O(1) - constant memory.

---

## Edge Cases / Các trường hợp biên
1.  **Empty List**: Head is `null` → return `false`.
2.  **Single Node**: No `next` → return `false`.
3.  **Two Nodes with Cycle**: `1 -> 2 -> 1` → return `true`.
4.  **Very Long List**: Linear complexity ensures safety.
