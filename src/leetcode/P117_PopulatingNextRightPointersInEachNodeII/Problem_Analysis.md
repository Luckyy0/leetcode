# 117. Populating Next Right Pointers in Each Node II / Điền Con Trỏ Phải Tiếp Theo Trong Mỗi Nút II

## Problem Description / Mô tả bài toán
Given a binary tree (not necessarily perfect), populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to `NULL`.
Cho một cây nhị phân (không nhất thiết hoàn hảo), điền mỗi con trỏ next để trỏ đến nút phải tiếp theo của nó. Nếu không có nút phải tiếp theo, con trỏ next nên được đặt thành `NULL`.

Initially, all next pointers are set to `NULL`.
Ban đầu, tất cả các con trỏ next được đặt thành `NULL`.

### Example 1:
```text
Input: root = [1,2,3,4,5,null,7]
Output: [1,#,2,3,#,4,5,7,#]
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[0, 6000]`.
- `-100 <= Node.val <= 100`

**Follow-up**: You may only use constant extra space.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Difference from Problem 116 / Khác biệt với Bài toán 116

| Aspect | Problem 116 | Problem 117 |
|--------|-------------|-------------|
| Tree Type | **Perfect** binary tree | **Any** binary tree |
| Assumption | All nodes have 0 or 2 children | Nodes can have 0, 1, or 2 children |
| Complexity | Simpler logic | Need to handle missing children |

### Challenge: Non-Perfect Tree / Thách thức: Cây Không Hoàn Hảo
```
Problem 116:          Problem 117:
    1                     1
   / \                   / \
  2   3                 2   3
 / \ / \               / \   \
4  5 6  7             4   5   7

Level 3 P116: 4→5→6→7   Level 3 P117: 4→5→7 (no 6!)
```

### Solution Strategy / Chiến lược Giải quyết
Use a **dummy node** as head of next level:
Sử dụng một **nút giả** làm đầu của tầng tiếp theo:

1.  Create dummy node `nextLevelHead`.
2.  Use `tail` pointer to track last node added to next level.
3.  Traverse current level using `next` pointers.
4.  For each node, add its children (if any) to the next level list.
5.  Move to next level: `head = nextLevelHead.next`.

---

## Analysis / Phân tích

### Approach: Level-by-Level with Dummy Node / Theo Từng Tầng với Nút Giả

**Algorithm**:
```
curr = root
while curr != null:
    dummy = new Node(0)
    tail = dummy
    
    while curr != null:  // Traverse current level
        if curr.left != null:
            tail.next = curr.left
            tail = tail.next
        if curr.right != null:
            tail.next = curr.right
            tail = tail.next
        curr = curr.next
    
    curr = dummy.next  // Move to next level
```

### Why Dummy Node? / Tại sao Dùng Nút Giả?
- We don't know which node will be the first in the next level.
- Dummy node provides a consistent starting point.
- `dummy.next` gives us the actual first node of next level.

### Complexity / Độ phức tạp
- **Time**: O(N) - visit each node once.
- **Space**: O(1) - only dummy node (constant).

---

## Edge Cases / Các trường hợp biên
1.  **Empty tree**: Return null.
2.  **Single node**: No next connections.
3.  **Skewed tree**: Handle correctly.
