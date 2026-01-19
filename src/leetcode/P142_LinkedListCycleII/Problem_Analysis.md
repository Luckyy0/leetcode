# 142. Linked List Cycle II / Chu trình Danh sách Liên kết II

## Problem Description / Mô tả bài toán
Given the `head` of a linked list, return the node where the cycle begins. If there is no cycle, return `null`.
Cho `head` của một danh sách liên kết, hãy trả về nút nơi chu trình bắt đầu. Nếu không có chu trình, hãy trả về `null`.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the `next` pointer. Internally, `pos` is used to denote the index of the node that tail's `next` pointer is connected to (**0-indexed**). It is `-1` if there is no cycle. **Note that `pos` is not passed as a parameter**.
Một chu trình tồn tại trong danh sách liên kết nếu có một số nút trong danh sách có thể được truy cập lại bằng cách liên tục theo con trỏ `next`. Trong nội bộ, `pos` được sử dụng để biểu thị chỉ số của nút mà con trỏ `next` của nút đuôi được kết nối tới (**chỉ số bắt đầu từ 0**). Nó là `-1` nếu không có chu trình. **Lưu ý rằng `pos` không được truyền dưới dạng tham số**.

**Do not modify** the linked list.
**Không sửa đổi** danh sách liên kết.

### Example 1:
```text
Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
```

### Example 2:
```text
Input: head = [1,2], pos = 0
Output: tail connects to node index 0
```

### Example 3:
```text
Input: head = [1], pos = -1
Output: no cycle
```

## Constraints / Ràng buộc
- The number of the nodes in the list is in the range `[0, 10^4]`.
- `-10^5 <= Node.val <= 10^5`
- `pos` is `-1` or a **valid index** in the linked-list.

**Follow up**: Can you solve it using `O(1)` (i.e. constant) memory?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Detection and Intersection / Phát hiện và Giao điểm
1.  **Phase 1**: Detect cycle using slow/fast pointers.
2.  **Phase 2**: Find the entry point.
    - Let `L1` be the distance from head to the start of the cycle.
    - Let `L2` be the distance from the start of the cycle to the point where they meet.
    - Let `C` be the cycle length.
    - `Slow` moves: `L1 + L2`.
    - `Fast` moves: `L1 + L2 + nC`.
    - Since `Fast` is twice as fast: `2(L1 + L2) = L1 + L2 + nC` → `L1 + L2 = nC` → `L1 = nC - L2`.
    - This means the distance from `head` to the entry point (`L1`) is the same as the distance from the meeting point to the entry point (completing the loops).

---

## Analysis / Phân tích

### Approach: Two Phase Floyd's Algorithm / Thuật toán Floyd Hai Giai đoạn

**Complexity / Độ phức tạp**:
- **Time**: O(N)
- **Space**: O(1)

---

## Edge Cases / Các trường hợp biên
1.  **No cycle**: Fast reaches null.
2.  **Cycle starts at head**: Pointers meet and head is immediately identified.
3.  **Two node cycle**: `1 -> 2 -> 1`.
