# 206. Reverse Linked List / Đảo Ngược Danh Sách Liên Kết

## Problem Description / Mô tả bài toán
Given the `head` of a singly linked list, reverse the list, and return the reversed list.
Cho `head` của một danh sách liên kết đơn, hãy đảo ngược danh sách và trả về danh sách đã đảo ngược.

### Example 1:
```text
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
```

### Example 2:
```text
Input: head = [1,2]
Output: [2,1]
```

### Example 3:
```text
Input: head = []
Output: []
```

## Constraints / Ràng buộc
- The number of nodes in the list is the range `[0, 5000]`.
- `-5000 <= Node.val <= 5000`

**Follow up**: A linked list can be reversed either iteratively or recursively. Could you implement both?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Iterative Approach (Pointer Manipulation) / Cách tiếp cận Lặp (Thao tác Con trỏ)
To reverse a linked list iteratively, we need to reverse the direction of the `next` pointer for every node.
Để đảo ngược một danh sách liên kết bằng cách lặp, chúng ta cần đảo ngược hướng của con trỏ `next` cho mọi nút.

We need three pointers:
1.  `prev`: Tracks the previous node (initially `null`).
2.  `curr`: Tracks the current node (initially `head`).
3.  `nextTemp`: Temporarily stores the next node before we change the link.

**Steps**:
1. Save `next` node: `nextTemp = curr.next`
2. Reverse pointer: `curr.next = prev`
3. Advance `prev`: `prev = curr`
4. Advance `curr`: `curr = nextTemp`

### Recursive Approach / Cách tiếp cận Đệ quy
The recursive version works by reversing the *rest* of the list first, then fixing the head.
Phiên bản đệ quy hoạt động bằng cách đảo ngược *phần còn lại* của danh sách trước, sau đó sửa lại phần đầu.

Key operation: `head.next.next = head`.
This sets the next node's next pointer back to the current node. Then set `head.next = null`.

---

## Analysis / Phân tích

### Approach: Iterative

**Complexity / Độ phức tạp**:
- **Time**: O(N) - Visit every node once.
- **Space**: O(1) - Constant distinct pointers.

*(Recursive approach uses O(N) stack space).*

---

## Edge Cases / Các trường hợp biên
1.  **Empty list**: Return `null`.
2.  **Single node**: Returns the node itself.
3.  **Two nodes**: Simple swap.
