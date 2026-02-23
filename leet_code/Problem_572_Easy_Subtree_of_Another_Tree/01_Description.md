# Result for Subtree of Another Tree
# *Kết quả cho bài toán Cây con của một Cây khác*

## Description
## *Mô tả*

Given the roots of two binary trees `root` and `subRoot`, return `true` if there is a subtree of `root` with the same structure and node values of `subRoot` and `false` otherwise.
*Cho gốc của hai cây nhị phân `root` và `subRoot`, trả về `true` nếu có một cây con của `root` có cùng cấu trúc và giá trị các nút với `subRoot`, ngược lại trả về `false`.*

A subtree of a binary tree `tree` is a tree that consists of a node in `tree` and all of this node's descendants. The tree `tree` could also be considered as a subtree of itself.
*Một cây con của một cây nhị phân `tree` là một cây bao gồm một nút trong `tree` và tất cả các nút con cháu của nút này. Bản thân cây `tree` cũng có thể được coi là một cây con của chính nó.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** root = [3,4,5,1,2], subRoot = [4,1,2]
**Output:** true

## Example 2:
## *Ví dụ 2:*

**Input:** root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
**Output:** false

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the `root` tree is in the range `[1, 2000]`.
*   The number of nodes in the `subRoot` tree is in the range `[1, 1000]`.
*   `-104 <= root.val <= 104`
*   `-104 <= subRoot.val <= 104`
