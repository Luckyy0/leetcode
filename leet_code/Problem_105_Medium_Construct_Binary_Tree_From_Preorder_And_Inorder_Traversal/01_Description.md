# Result for Construct Binary Tree from Preorder and Inorder Traversal
# *Kết quả cho bài toán Xây Dựng Cây Nhị Phân Từ Thứ Tự Trước và Thứ Tự Giữa*

## Description
## *Mô tả*

Given two integer arrays `preorder` and `inorder` where `preorder` is the preorder traversal of a binary tree and `inorder` is the inorder traversal of the same tree, construct and return *the binary tree*.
*Cho hai mảng số nguyên `preorder` và `inorder`, trong đó `preorder` là phép duyệt theo thứ tự trước và `inorder` là phép duyệt theo thứ tự giữa của cùng một cây nhị phân, hãy xây dựng và trả về *cây nhị phân đó***.*

## Example 1:
## *Ví dụ 1:*

**Input:** `preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]`
**Output:** `[3,9,20,null,null,15,7]`

## Example 2:
## *Ví dụ 2:*

**Input:** `preorder = [-1], inorder = [-1]`
**Output:** `[-1]`

## Constraints:
## *Ràng buộc:*

*   `1 <= preorder.length <= 3000`
*   `inorder.length == preorder.length`
*   `-3000 <= preorder[i], inorder[i] <= 3000`
*   `preorder` and `inorder` consist of **unique** values.
*   Each value of `inorder` also appears in `preorder`.
*   `preorder` is **guaranteed** to be the preorder traversal of the tree.
*   `inorder` is **guaranteed** to be the inorder traversal of the tree.
