# 369. Plus One Linked List / Cộng Một Vào Danh Sách Liên Kết

## Problem Description / Mô tả bài toán
Given a non-negative integer represented as a linked list of digits, plus one to the integer.
Cho một số nguyên không âm được biểu diễn dưới dạng danh sách liên kết các chữ số, cộng một vào số nguyên đó.

The digits are stored such that the most significant digit is at the head of the list.
Các chữ số được lưu trữ sao cho chữ số quan trọng nhất nằm ở đầu danh sách.

### Example 1:
```text
Input: head = [1,2,3]
Output: [1,2,4]
```

### Example 2:
```text
Input: head = [0]
Output: [1]
```

## Constraints / Ràng buộc
- The number of nodes in the linked list is in the range `[1, 100]`.
- `0 <= Node.val <= 9`
- The number represented by the linked list does not contain leading zeros except for the zero itself.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Recursion (DFS) / Đệ Quy
Traverse to the end. Return carry.
`carry = (val + carry) / 10`.
Update `val = (val + carry) % 10`.
Base case: end of list returns carry 1 (the initial +1).
Wait, typical "plus one" implies adding 1 at the least significant digit (end of list).
So traverse to end. Return `1` from end.
Recursively flow back.
If head returns carry 1, create new node.

### Two Pointers / Hai Con Trỏ
Find the rightmost node not equal to 9. Let's call it `rightMostNonNine`.
- Increment this node by 1.
- Set all nodes after it to 0.
- If no node is not 9 (all 9s), prepend a new node 1, and set all others to 0.
Example: `1 -> 2 -> 9`. `rightMostNonNine` is `2`.
Inc to 3. Nodes after -> 0. Result `1 -> 3 -> 0`. Correct.
Example: `9 -> 9`. `rightMostNonNine` is null (or dummy).
If using dummy head `0 -> 9 -> 9`. `rightMostNonNine` is `0`.
Inc to 1. Others 0. Result `1 -> 0 -> 0`. Correct.

I will implement the **Two Pointers / Rightmost Non-Nine** approach as it is O(N) one pass + one shorter pass, and O(1) space (recursive stack is O(N)).

---

## Analysis / Phân tích

### Approach: Rightmost Not-9

**Algorithm**:
1.  Dummy head `0` pointing to `head`.
2.  `notNine` = dummy.
3.  Iterate `curr = head`:
    - If `curr.val != 9`, `notNine = curr`.
4.  `notNine.val++`.
5.  `curr = notNine.next`.
6.  While `curr != null`:
    - `curr.val = 0`.
    - `curr = curr.next`.
7.  If dummy is still 0 (meaning strict leading zero not used), returns `dummy.next`.
    - Wait. If original was `99`, dummy `0->9->9`. `notNine` is dummy (0). Dummy becomes 1. Next become 0. `1->0->0`. Return dummy.
    - If original `123`, dummy `0->1->2->3`. `notNine` is `2`. `2` becomes `3`. Next (3) logic?
      - Wait. `3 != 9`, so `notNine` becomes `3`.
      - `notNine` becomes 4. Next is null. Loop doesn't run. `0->1->2->4`. Return dummy.next.
    - So logic: Return `dummy.val == 1 ? dummy : dummy.next`.

---
