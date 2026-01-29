# 426. Convert Binary Search Tree to Sorted Doubly Linked List / Chuyển Đổi Cây Tìm Kiếm Nhị Phân Thành Danh Sách Liên Kết Đôi

## Problem Description / Mô tả bài toán
Convert a **Binary Search Tree** to a sorted **circular doubly linked list** in-place.
Hãy chuyển đổi một **Cây tìm kiếm nhị phân (BST)** thành một **danh sách liên kết đôi xoay vòng** được sắp xếp ngay tại chỗ (in-place).

You can think of the left and right pointers as synonymous to the predecessor and successor pointers in a doubly-linked list. For a circular doubly-linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.
Bạn có thể coi các con trỏ `left` và `right` tương ứng với các con trỏ `predecessor` (phía trước) và `successor` (phía sau) trong một danh sách liên kết đôi. Đối với danh sách liên kết đôi xoay vòng, phần tử đứng trước phần tử đầu tiên là phần tử cuối cùng, và phần tử đứng sau phần tử cuối cùng là phần tử đầu tiên.

We want to do the transformation **in-place**. After the transformation, the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor.
Chúng ta muốn thực hiện việc chuyển đổi này **tại chỗ**. Sau khi chuyển đổi, con trỏ trái của mỗi nút sẽ trỏ đến nút đứng ngay trước nó, và con trỏ phải trỏ đến nút đứng ngay sau nó.

### Example 1:
```text
Input: root = [4,2,5,1,3]
Output: [1,2,3,4,5] (as a circular doubly linked list)
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[0, 2000]`.
- `-1000 <= Node.val <= 1000`

---

## Theoretical Foundation / Cơ sở lý thuyết

### In-order Traversal / Duyệt Cây Thứ Tự Giữa
In a BST, an in-order traversal visits nodes in non-decreasing order. This is perfect for constructing the sorted list.

Algorithm:
1. Maintain two tracking variables: `first` (the smallest node) and `last` (the most recently visited node).
2. Recursively traverse the `left` subtree.
3. Handle the **current node**:
   - If `last` is not null, connect `last.right = current` and `current.left = last`.
   - If `last` is null, it means we are at the smallest node. Set `first = current`.
   - Update `last = current`.
4. Recursively traverse the `right` subtree.
5. After the entire traversal, connect the `first` and `last` nodes to make the list circular: `last.right = first` and `first.left = last`.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the number of nodes.
- **Space**: O(H) where H is the height of the tree (recursion stack depth).

---

## Analysis / Phân tích

### Approach: In-order Recursion

**Algorithm**:
1.  Global/Member variables `first` and `last`.
2.  In-order traversal logic.
3.  Circular link creation at the end.

---
