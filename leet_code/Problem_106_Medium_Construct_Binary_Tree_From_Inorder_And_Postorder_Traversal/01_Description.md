# Result for Construct Binary Tree from Inorder and Postorder Traversal
# *Kết quả cho bài toán Xây Dựng Cây Nhị Phân Từ Thứ Tự Giữa và Thứ Tự Sau*

## Description
## *Mô tả*

Given two integer arrays `inorder` and `postorder` where `inorder` is the inorder traversal of a binary tree and `postorder` is the postorder traversal of the same tree, construct and return *the binary tree*.
*Cho hai mảng số nguyên `inorder` và `postorder`, trong đó `inorder` là phép duyệt theo thứ tự giữa và `postorder` là phép duyệt theo thứ tự sau của cùng một cây nhị phân, hãy xây dựng và trả về *cây nhị phân đó***.*

## Example 1:
## *Ví dụ 1:*

**Input:** `inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]`
**Output:** `[3,9,20,null,null,15,7]`

## Example 2:
## *Ví dụ 2:*

**Input:** `inorder = [-1], postorder = [-1]`
**Output:** `[-1]`

## Constraints:
## *Ràng buộc:*

*   `1 <= inorder.length <= 3000`
*   `postorder.length == inorder.length`
*   `-3000 <= inorder[i], postorder[i] <= 3000`
*   `inorder` and `postorder` consist of **unique** values.
*   Each value of `postorder` also appears in `inorder`.
*   `inorder` is **guaranteed** to be the inorder traversal of the tree.
*   `postorder` is **guaranteed** to be the postorder traversal of the tree.
