# 701. Insert into a Binary Search Tree / Chèn vào Cây Tìm kiếm Nhị phân

## Problem Description / Mô tả bài toán
You are given the `root` node of a binary search tree (BST) and a `value` to insert into the tree. Return the `root` node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
Bạn được cho nút `root` của một cây tìm kiếm nhị phân (BST) và một `value` để chèn vào cây. Trả về nút `root` của BST sau khi chèn. Đảm bảo rằng giá trị mới không tồn tại trong BST ban đầu.

Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
Lưu ý rằng có thể tồn tại nhiều cách chèn hợp lệ, miễn là cây vẫn là BST sau khi chèn. Bạn có thể trả về bất kỳ cách nào trong số đó.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### BST Insertion Property / Thuộc tính Chèn BST
In a BST, for any node:
- If `value < node.val`, the appropriate spot for insertion is in the left subtree.
- If `value > node.val`, the appropriate spot for insertion is in the right subtree.

We traverse down to a `null` position and create a new node there.

### Complexity / Độ phức tạp
- **Time**: O(H) where H is the height of the tree. In the worst case (skewed tree), O(N).
- **Space**: O(H) for recursion stack or O(1) for iterative approach.

---

## Analysis / Phân tích

### Approach: Recursive Insertion
Compare the value with the current node. Navigate left or right. When a null child is reached, replace it with a new `TreeNode(val)`.
So sánh giá trị với nút hiện tại. Điều hướng sang trái hoặc phải. Khi gặp một con là null, hãy thay thế nó bằng một `TreeNode(val)` mới.

---
