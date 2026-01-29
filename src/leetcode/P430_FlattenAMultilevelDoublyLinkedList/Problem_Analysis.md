# 430. Flatten a Multilevel Doubly Linked List / Làm Phẳng Danh Sách Liên Kết Đôi Nhiều Cấp

## Problem Description / Mô tả bài toán
You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure.
Bạn được cho một danh sách liên kết đôi có thêm con trỏ `child`. Con trỏ này có thể trỏ đến một danh sách liên kết đôi riêng biệt. Các danh sách con này cũng có thể có con riêng, tạo thành cấu trúc nhiều cấp.

Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.
Hãy làm phẳng danh sách để tất cả các nút xuất hiện trong một danh sách liên kết đôi duy nhất.

### Example 1:
```text
Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
Output: [1,2,3,7,8,11,12,9,10,4,5,6]
```

## Constraints / Ràng buộc
- The number of nodes in the list is in the range `[0, 1000]`.
- `1 <= Node.val <= 10^5`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Depth-First Search (DFS) / Duyệt theo chiều sâu (DFS)
Flattening a multilevel list where children are prioritized over next nodes is equivalent to a pre-order traversal of a tree.

Algorithm (Iterative):
1. Start with the `head` node.
2. Traverse the list using a `curr` pointer.
3. If `curr` has a `child`:
   - If `curr` also has a `next` node, push the `next` node onto a `Stack`.
   - Connect `curr.next` to `curr.child` and set `curr.child.prev` to `curr`.
   - Set `curr.child = null`.
4. If `curr.next` is null and the stack is not empty:
   - Pop the `next` node from the stack.
   - Connect `curr.next` to the popped node and set `poppedNode.prev` to `curr`.
5. Move `curr` to `curr.next`.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the total number of nodes.
- **Space**: O(D) where D is the maximum depth of children (stack space).

---

## Analysis / Phân tích

### Approach: Iterative Stack DFS

**Algorithm**:
1.  Initialize stack and traverse.
2.  Handle child pointer: rewire and push old next.
3.  Handle end of current sublist: pop from stack.

---
