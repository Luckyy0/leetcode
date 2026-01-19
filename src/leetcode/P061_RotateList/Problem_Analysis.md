# 61. Rotate List / Xoay Danh Sách Liên Kết

## Problem Description / Mô tả bài toán
Given the `head` of a linked list, rotate the list to the right by `k` places.
Cho `head` của một danh sách liên kết, hãy xoay danh sách sang phải `k` vị trí.

### Example 1:
```text
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
```

### Example 2:
```text
Input: head = [0,1,2], k = 4
Output: [2,0,1]
```

## Constraints / Ràng buộc
- The number of nodes in the list is in the range `[0, 500]`.
- `-100 <= Node.val <= 100`
- `0 <= k <= 2 * 10^9`

---

## Analysis / Phân tích

### Approach: Cycle and Break / Tạo Vòng và Ngắt
- **Idea**: Link the tail to the head to form a cycle, then find the new tail and break the cycle.
- **Ý tưởng**: Nối đuôi với đầu để tạo thành một vòng lặp, sau đó tìm đuôi mới và ngắt vòng lặp.
- **Steps**:
    1.  Traverse to find length `n` and the old tail.
    2.  If `n == 0` or `k % n == 0`, return head (no change).
    3.  Connect old tail to head (`oldTail.next = head`).
    4.  Find new tail index: `n - (k % n)`.
    5.  Move `newTail` pointer to that index.
    6.  `newHead = newTail.next`.
    7.  `newTail.next = null` (Break cycle).
- **Time Complexity**: O(n).
- **Space Complexity**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **Empty List**: Return null.
2.  **k = 0**: Return head.
3.  **k > n**: Use `k % n`.
