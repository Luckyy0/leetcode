# 669. Trim a Binary Search Tree / Cắt tỉa Cây Tìm kiếm Nhị phân

## Problem Description / Mô tả bài toán
Given the `root` of a binary search tree and the lowest and highest boundaries as `low` and `high`, trim the tree so that all its elements lies in `[low, high]`.
Cho `root` của một cây tìm kiếm nhị phân và các ranh giới thấp nhất và cao nhất là `low` và `high`, hãy cắt tỉa cây sao cho tất cả các phần tử của nó nằm trong `[low, high]`.

Trimming the tree should **not** change the relative structure of the elements that will remain in the tree (i.e., any node's descendant should remain a descendant).
Việc cắt tỉa cây **không** được thay đổi cấu trúc tương đối của các phần tử sẽ còn lại trong cây (tức là hậu duệ của bất kỳ nút nào cũng phải vẫn là hậu duệ).

Return the root of the trimmed binary search tree.
Trả về gốc của cây tìm kiếm nhị phân đã được cắt tỉa.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### BST Property & Recursion / Thuộc tính BST & Đệ quy
In a BST:
- If `node.val < low`, then the entire left subtree is also `< low`. We only need to trim the right subtree.
Nếu `node.val < low`, thì toàn bộ cây con bên trái cũng `< low`. Chúng ta chỉ cần cắt tỉa cây con bên phải.
- If `node.val > high`, then the entire right subtree is also `> high`. We only need to trim the left subtree.
Nếu `node.val > high`, thì toàn bộ cây con bên phải cũng `> high`. Chúng ta chỉ cần cắt tỉa cây con bên trái.

If `low <= node.val <= high`, we trim both subtrees.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the number of nodes.
- **Space**: O(H) where H is the height of the tree (recursion stack).

---

## Analysis / Phân tích

### Approach: Recursive Re-assignment
Apply the BST properties recursively to return the valid subtree root at each step.
Áp dụng các thuộc tính BST một cách đệ quy để trả về gốc cây con hợp lệ ở mỗi bước.

---
