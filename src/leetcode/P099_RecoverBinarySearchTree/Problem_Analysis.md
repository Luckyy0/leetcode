# 99. Recover Binary Search Tree / Khôi Phục Cây Tìm Kiếm Nhị Phân

## Problem Description / Mô tả bài toán
You are given the `root` of a binary search tree (BST), where the values of **exactly two** nodes of the tree were **swapped by mistake**. Recover the tree without changing its structure.
Bạn được cho `root` của một cây tìm kiếm nhị phân (BST), trong đó các giá trị của **chính xác hai** nút của cây đã bị **hoán đổi nhầm**. Khôi phục cây mà không thay đổi cấu trúc của nó.

### Example 1:
```text
Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
```

### Example 2:
```text
Input: root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[2, 1000]`.
- `-2^31 <= Node.val <= 2^31 - 1`

**Follow up**: A solution using O(n) space is pretty straight-forward. Could you devise a constant O(1) space solution?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Inorder Traversal of BST / Duyệt Trung Tự của BST
- **Key Property**: Inorder traversal of a valid BST produces a **strictly increasing** sequence.
- **Thuộc tính chính**: Duyệt trung tự của một BST hợp lệ tạo ra một dãy **tăng nghiêm ngặt**.

### Detecting Swapped Nodes / Phát hiện các nút bị hoán đổi
When two nodes are swapped in a BST, the inorder sequence will have **inversions** (places where the order decreases instead of increases).
Khi hai nút bị hoán đổi trong BST, dãy trung tự sẽ có các **đảo ngược** (nơi thứ tự giảm thay vì tăng).

**Two Cases / Hai trường hợp:**

1.  **Adjacent Swap (Hoán đổi liền kề)**: If the two swapped nodes are adjacent in inorder sequence:
    - Example: `[1, 2, 3, 4]` becomes `[1, 3, 2, 4]` (3 and 2 swapped).
    - We find **ONE inversion**: `3 > 2`.
    - First wrong node = 3 (the larger of the pair).
    - Second wrong node = 2 (the smaller of the pair).

2.  **Non-Adjacent Swap (Hoán đổi không liền kề)**: If the two swapped nodes are NOT adjacent:
    - Example: `[1, 2, 3, 4]` becomes `[1, 4, 3, 2]` (2 and 4 swapped).
    - We find **TWO inversions**: `4 > 3` and `3 > 2`.
    - First wrong node = 4 (the larger node in the FIRST inversion).
    - Second wrong node = 2 (the smaller node in the SECOND inversion).

### Algorithm / Thuật toán
1.  Perform inorder traversal.
2.  Track `prev` node (last visited).
3.  When `prev.val > curr.val` (inversion found):
    - If `first == null`: `first = prev`, `second = curr`.
    - Else: `second = curr` (update second for the case of two inversions).
4.  After traversal: Swap values of `first` and `second`.

---

## Analysis / Phân tích

### Approach 1: Inorder Traversal with O(H) Stack / Duyệt Trung Tự với Ngăn Xếp O(H)
- **Implementation**: Use iterative inorder traversal with an explicit stack.
- **Time Complexity**: O(N).
- **Space Complexity**: O(H) for the stack.

### Approach 2: Morris Traversal - O(1) Space / Duyệt Morris - O(1) Không Gian
- **Idea**: Use Morris Inorder Traversal which modifies tree temporarily to achieve O(1) space by threading.
- **Ý tưởng**: Sử dụng Duyệt Trung Tự Morris, tạm thời sửa đổi cây để đạt được không gian O(1) bằng cách tạo luồng.
- **Morris Traversal Key Concept**:
    - For current node, find the **inorder predecessor** in the left subtree.
    - If predecessor's right is null, make it point to current (create thread), go left.
    - If predecessor's right is current (thread exists), remove thread, process current, go right.
- **Time Complexity**: O(N).
- **Space Complexity**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **Root is one of the swapped nodes**.
2.  **Adjacent nodes in inorder are swapped**: Only one inversion.
3.  **Nodes at different depths are swapped**: Two inversions.
