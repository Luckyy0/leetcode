# 109. Convert Sorted List to Binary Search Tree / Chuyển Đổi Danh Sách Liên Kết Đã Sắp Xếp Thành Cây Tìm Kiếm Nhị Phân

## Problem Description / Mô tả bài toán
Given the `head` of a singly linked list where elements are sorted in **ascending order**, convert it to a **height-balanced** BST.
Cho `head` của một danh sách liên kết đơn trong đó các phần tử được sắp xếp theo **thứ tự tăng dần**, hãy chuyển đổi nó thành một **BST cân bằng chiều cao**.

### Example 1:
```text
Input: head = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
```

### Example 2:
```text
Input: head = []
Output: []
```

## Constraints / Ràng buộc
- The number of nodes in `head` is in the range `[0, 2 * 10^4]`.
- `-10^5 <= Node.val <= 10^5`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Comparison with Problem 108 / So sánh với Bài toán 108

| Aspect | Problem 108 (Array) | Problem 109 (Linked List) |
|--------|---------------------|---------------------------|
| Data Structure | Array | Linked List |
| Mid Access | O(1) random access | O(N) traversal needed |
| Key Challenge | Simple | Finding middle efficiently |

### The Middle Element Problem / Vấn đề Phần tử Giữa
- Arrays: `mid = (left + right) / 2` is O(1).
- Linked Lists: No random access, finding middle requires traversal.

### Finding Middle of Linked List / Tìm Phần tử Giữa của Danh Sách Liên Kết
Use **Slow-Fast Pointer Technique (Floyd's Tortoise and Hare)**:
Sử dụng **Kỹ thuật Con trỏ Chậm-Nhanh (Rùa và Thỏ Floyd)**:
- `slow` moves 1 step at a time.
- `fast` moves 2 steps at a time.
- When `fast` reaches end, `slow` is at middle.

```
[-10] -> [-3] -> [0] -> [5] -> [9]
  s        f
  
[-10] -> [-3] -> [0] -> [5] -> [9]
           s            f
           
[-10] -> [-3] -> [0] -> [5] -> [9]
                  s             f (end)
                  ↑
                 MID
```

---

## Analysis / Phân tích

### Approach 1: Convert to Array First / Chuyển đổi thành Mảng trước
- Traverse list once to build array.
- Apply Problem 108 solution.
- **Time**: O(N), **Space**: O(N).

### Approach 2: Slow-Fast Pointer + Recursion / Con trỏ Chậm-Nhanh + Đệ Quy
**Algorithm**:
```
sortedListToBST(head):
    if head == null: return null
    if head.next == null: return new TreeNode(head.val)
    
    // Find middle and previous node
    prev = null, slow = head, fast = head
    while fast != null and fast.next != null:
        prev = slow
        slow = slow.next
        fast = fast.next.next
    
    // slow is now the middle
    root = new TreeNode(slow.val)
    
    // Disconnect left half
    if prev != null: prev.next = null
    
    // Recursively build
    root.left = sortedListToBST(head if prev != null else null)
    root.right = sortedListToBST(slow.next)
    
    return root
```

### Approach 3: Inorder Simulation / Mô phỏng Duyệt Trung Tự
- Most optimal for linked lists.
- Simulate inorder traversal: build nodes in the order they appear in the list.
- **Time**: O(N), **Space**: O(log N).

### Complexity for Approach 2 / Độ phức tạp cho Phương pháp 2
- **Time**: O(N log N) - each level traverses all nodes to find middles.
- **Space**: O(log N) for recursion stack.

---

## Edge Cases / Các trường hợp biên
1.  **Empty list**: Return null.
2.  **Single node**: Return single TreeNode.
3.  **Two nodes**: One becomes root, other becomes child.
