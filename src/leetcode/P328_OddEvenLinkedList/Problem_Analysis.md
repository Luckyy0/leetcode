# 328. Odd Even Linked List / Danh Sách Liên Kết Lẻ Chẵn

## Problem Description / Mô tả bài toán
Given the `head` of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
Cho `head` của một danh sách liên kết đơn, nhóm tất cả các nút có chỉ số lẻ lại với nhau, sau đó là các nút có chỉ số chẵn và trả về danh sách đã sắp xếp lại.

The first node is considered **odd**, and the second node is **even**, and so on.
Nút đầu tiên được coi là **lẻ**, nút thứ hai là **chẵn**, v.v.

Note that the relative order inside both the even and odd groups should remain as it was in the input.
Lưu ý rằng thứ tự tương đối bên trong cả hai nhóm chẵn và lẻ phải được giữ nguyên như trong đầu vào.

You must solve the problem in `O(1)` extra space complexity and `O(n)` time complexity.

### Example 1:
```text
Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]
```

### Example 2:
```text
Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]
```

## Constraints / Ràng buộc
- The number of nodes in the linked list is in the range `[0, 10^4]`.
- `-10^6 <= Node.val <= 10^6`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Two Pointers (List Splitting) / Hai Con Trỏ
We can maintain two separate linked lists: one for odd nodes and one for even nodes.
- `odd` pointer tracks tail of odd list.
- `even` pointer tracks tail of even list.
- `evenHead` stores the head of the even list (to attach later).

Initialization:
- `odd = head`
- `even = head.next`
- `evenHead = even`

Iteration:
- While `even != null && even.next != null`:
    - `odd.next = even.next`
    - `odd = odd.next`
    - `even.next = odd.next`
    - `even = even.next`

Final:
- `odd.next = evenHead`

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Two Pointers

**Edge Cases**:
1.  Empty list: `head == null`. Return null.
2.  List size 1: `head.next == null`. Return head.
3.  List size 2: `odd` stays at 1, `even` at 2, loop doesn't run. `odd.next = evenHead`. 1->2. Correct.

---
