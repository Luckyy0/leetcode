# 234. Palindrome Linked List / Danh Sách Liên Kết Đối Xứng

## Problem Description / Mô tả bài toán
Given the `head` of a singly linked list, return `true` if it is a palindrome or `false` otherwise.
Cho `head` của một danh sách liên kết đơn, hãy trả về `true` nếu nó là một danh sách đối xứng hoặc `false` nếu không.

### Example 1:
```text
Input: head = [1,2,2,1]
Output: true
```

### Example 2:
```text
Input: head = [1,2]
Output: false
```

## Constraints / Ràng buộc
- The number of nodes in the list is in the range `[1, 10^5]`.
- `0 <= Node.val <= 9`

**Follow up**: Could you do it in `O(n)` time and `O(1)` space?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Find Middle and Reverse / Tìm Giữa và Đảo Ngược
To check for palindrome in O(1) space, we can modify the list (and optionally restore it).

1.  **Find Middle**: Use Fast and Slow pointers.
    - `slow` moves 1 step, `fast` moves 2 steps.
    - When `fast` reaches end, `slow` is at the middle.
2.  **Reverse Second Half**:
    - Reverse the list starting from `slow`.
3.  **Compare**:
    - Compare matching nodes from the start (`head`) and the reversed second half (`reversedHead`).
4.  **Restore (Optional)**: Reverse the second half again to restore original list.

Note:
- Odd length: Middle element is ignored (or shared). `[1,2,3,2,1]` -> First half `1->2`, Second `1->2` (reversed from `2->1`).
- Even length: `[1,2,2,1]` -> First `1->2`, Second `1->2` (reversed from `2->1`).

---

## Analysis / Phân tích

### Approach: Fast/Slow Pointer + Reverse

**Algorithm**:
1.  Check trivial cases (null, single node).
2.  `slow = head`, `fast = head`.
3.  Find middle: `while fast != null && fast.next != null`.
4.  Reverse from `slow`. Helper function `reverse(node)`.
5.  Check symmetry loop.
6.  Return result.

### Complexity / Độ phức tạp
- **Time**: O(N) (Find mid O(N), Reverse O(N), Compare O(N)).
- **Space**: O(1) iterative modification.

---

## Edge Cases / Các trường hợp biên
1.  **Single node**: True.
2.  **Two nodes**: Check val equality.
3.  **Odd vs Even length**: Fast pointer logic handles this.
