# 450. Delete Node in a BST / Xóa Nút Trong Cây Tìm Kiếm Nhị Phân

## Problem Description / Mô tả bài toán
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
Cho một nút gốc của một BST và một giá trị `key`, hãy xóa nút có giá trị `key` đó trong BST. Trả về nút gốc (có thể đã bị thay đổi) của BST.

Basically, the deletion can be divided into two stages:
1. Search for a node to remove.
2. If the node is found, delete the node.

### Example 1:
```text
Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]
Explanation: Given key to delete is 3. So we find node 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above figure.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[0, 10^4]`.
- `-10^5 <= Node.val <= 10^5`.
- Each node has a unique value.
- `key` is an integer.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Subtree Recursive Replacement / Thay thế cây con bằng đệ quy
Deleting a node from a BST requires handling different cases based on the number of children the target node has:

Algorithm:
1. If `root` is null, return null.
2. If `key < root.val`: Search in the left subtree. `root.left = deleteNode(root.left, key)`.
3. If `key > root.val`: Search in the right subtree. `root.right = deleteNode(root.right, key)`.
4. If `key == root.val`:
   - **Case 1: No child or 1 child**. If `left` is null, return `right`. If `right` is null, return `left`.
   - **Case 2: 2 children**. 
     - Find the **inorder successor** (the smallest node in the right subtree).
     - Replace `root.val` with the successor's value.
     - Delete the successor from the right subtree: `root.right = deleteNode(root.right, root.val)`.

### Complexity / Độ phức tạp
- **Time**: O(H) where H is the height of the tree (search + successor find).
- **Space**: O(H) for recursion stack.

---

## Analysis / Phân tích

### Approach: Standard BST Deletion Logic

**Algorithm**:
1.  Search.
2.  Choose replacement (predecessor or successor) for 2-child case.
3.  Recursive link updates.

---
