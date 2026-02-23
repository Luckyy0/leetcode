# Result for Lowest Common Ancestor of a Binary Tree
# *Kết quả cho bài toán Tổ tiên chung thấp nhất của Cây nhị phân*

## Description
## *Mô tả*

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
*Cho một cây nhị phân, hãy tìm tổ tiên chung thấp nhất (LCA) của hai nút đã cho trong cây.*

According to the [definition of LCA on Wikipedia](https://en.wikipedia.org/wiki/Lowest_common_ancestor): “The lowest common ancestor is defined between two nodes `p` and `q` as the lowest node in `T` that has both `p` and `q` as descendants (where we allow **a node to be a descendant of itself**).”
*Theo [định nghĩa của LCA trên Wikipedia](https://en.wikipedia.org/wiki/Lowest_common_ancestor): “Tổ tiên chung thấp nhất được định nghĩa giữa hai nút `p` và `q` là nút thấp nhất trong `T` có cả `p` và `q` là hậu duệ (trong đó chúng ta cho phép **một nút là hậu duệ của chính nó**).”*

## Example 1:
## *Ví dụ 1:*

**Input:** `root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1`
**Output:** `3`
**Explanation:** The LCA of nodes 5 and 1 is 3.

## Example 2:
## *Ví dụ 2:*

**Input:** `root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4`
**Output:** `5`
**Explanation:** The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

## Example 3:
## *Ví dụ 3:*

**Input:** `root = [1,2], p = 1, q = 2`
**Output:** `1`

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[2, 10^5]`.
*   `-10^9 <= Node.val <= 10^9`
*   All `Node.val` are **unique**.
*   `p != q`
*   `p` and `q` will exist in the tree.
