# 116. Populating Next Right Pointers in Each Node / Điền Con Trỏ Phải Tiếp Theo Trong Mỗi Nút

## Problem Description / Mô tả bài toán
You are given a **perfect binary tree** where all leaves are on the same level, and every parent has two children. The tree node has the following definition:
Bạn được cho một **cây nhị phân hoàn hảo** trong đó tất cả các lá đều ở cùng một tầng, và mọi nút cha đều có hai con. Định nghĩa nút cây như sau:

```
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
```

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to `NULL`.
Điền mỗi con trỏ next để trỏ đến nút phải tiếp theo của nó. Nếu không có nút phải tiếp theo, con trỏ next nên được đặt thành `NULL`.

Initially, all next pointers are set to `NULL`.
Ban đầu, tất cả các con trỏ next được đặt thành `NULL`.

### Example 1:
```text
Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[0, 2^12 - 1]`.
- `-1000 <= Node.val <= 1000`

**Follow-up**: You may only use constant extra space.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Perfect Binary Tree Properties / Thuộc tính Cây Nhị Phân Hoàn Hảo
- All internal nodes have exactly 2 children.
- Tất cả các nút bên trong có chính xác 2 con.
- All leaves are at the same depth.
- Tất cả các lá đều ở cùng độ sâu.
- For N nodes: `N = 2^h - 1` where h is height.

### Next Pointer Logic / Logic Con Trỏ Next
For a node `n`:
Đối với một nút `n`:
1.  `n.left.next = n.right` (left child → right child, same parent)
2.  `n.right.next = n.next.left` (right child → left child of parent's next)
    - Only if `n.next` exists.

```
Level 1:        1
               /|\
Level 2:      2→→3
             /|\ /|\
Level 3:    4→5→6→7
```

### BFS Approach vs O(1) Space Approach / Phương pháp BFS vs Phương pháp O(1) Không gian

**BFS (O(N) space)**: Use queue to process level by level.
**O(1) space**: Use the `next` pointers we've already established to traverse each level!

---

## Analysis / Phân tích

### Approach: Level-by-Level using Next Pointers / Theo Từng Tầng sử dụng Con Trỏ Next

**Key Insight / Điểm quan trọng**: 
- Process level N-1 to establish connections for level N.
- Use `next` pointers to move horizontally at each level.

**Algorithm**:
```
leftmost = root
while leftmost.left != null:  // While there's a next level
    head = leftmost
    while head != null:       // Traverse current level using next
        head.left.next = head.right
        if head.next != null:
            head.right.next = head.next.left
        head = head.next
    leftmost = leftmost.left  // Move to next level
```

### Complexity / Độ phức tạp
- **Time**: O(N) - visit each node once.
- **Space**: O(1) - only using existing pointers.

---

## Edge Cases / Các trường hợp biên
1.  **Empty tree**: Do nothing.
2.  **Single node**: No connections needed.
