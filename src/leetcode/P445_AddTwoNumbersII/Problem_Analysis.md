# 445. Add Two Numbers II / Cộng Hai Số II

## Problem Description / Mô tả bài toán
You are given two **non-empty** linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
Bạn được cho hai danh sách liên kết **không rỗng** đại diện cho hai số nguyên không âm. Chữ số có giá trị lớn nhất đứng đầu và mỗi nút chứa một chữ số duy nhất. Hãy cộng hai số đó và trả về tổng dưới dạng một danh sách liên kết.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Bạn có thể giả định rằng hai số không chứa bất kỳ chữ số 0 nào ở đầu, ngoại trừ chính số 0.

### Example 1:
```text
Input: l1 = [7,2,4,3], l2 = [5,6,4]
Output: [7,8,0,7]
```

### Example 2:
```text
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [8,0,7]
```

### Example 3:
```text
Input: l1 = [0], l2 = [0]
Output: [0]
```

## Constraints / Ràng buộc
- The number of nodes in each linked list is in the range `[1, 100]`.
- `0 <= Node.val <= 9`
- It is guaranteed that the list represents a number that does not have leading zeros.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Stacks for Right-to-Left Addition / Ngăn xếp để cộng từ phải sang trái
Since we need to add from the least significant digit (the end of the lists) but the lists are given in forward order, we can use **Stacks** to reverse the order.

Algorithm:
1. Push all nodes of `l1` into `stack1`.
2. Push all nodes of `l2` into `stack2`.
3. Initialize `carry = 0` and `head = null`.
4. While `stack1`, `stack2` are not empty or `carry != 0`:
   - `sum = carry`.
   - If `stack1` is not empty, `sum += stack1.pop().val`.
   - If `stack2` is not empty, `sum += stack2.pop().val`.
   - Create a new node with value `sum % 10`.
   - **Prepend** this node to the current result list: `newNode.next = head`, `head = newNode`.
   - `carry = sum / 10`.
5. Return `head`.

### Complexity / Độ phức tạp
- **Time**: O(N + M) where N and M are lengths of the lists.
- **Space**: O(N + M) for the stacks.

---

## Analysis / Phân tích

### Approach: Two-Stack Addition

**Algorithm**:
1.  Populate stacks.
2.  Pop and add with carry.
3.  Build resulting list by prepending (head insertion).

---
