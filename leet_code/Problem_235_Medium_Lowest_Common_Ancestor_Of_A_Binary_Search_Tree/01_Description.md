# Result for Lowest Common Ancestor of a Binary Search Tree
# *Kết quả cho bài toán Tổ tiên chung thấp nhất của Cây tìm kiếm nhị phân (BST)*

## Description
## *Mô tả*

Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
*Cho một cây tìm kiếm nhị phân (BST), hãy tìm nút tổ tiên chung thấp nhất (LCA) của hai nút đã cho trong BST.*

According to the [definition of LCA on Wikipedia](https://en.wikipedia.org/wiki/Lowest_common_ancestor): “The lowest common ancestor is defined between two nodes `p` and `q` as the lowest node in `T` that has both `p` and `q` as descendants (where we allow **a node to be a descendant of itself**).”
*Theo [định nghĩa của LCA trên Wikipedia](https://en.wikipedia.org/wiki/Lowest_common_ancestor): “Tổ tiên chung thấp nhất được định nghĩa giữa hai nút `p` và `q` là nút thấp nhất trong `T` có cả `p` và `q` là hậu duệ (trong đó chúng ta cho phép **một nút là hậu duệ của chính nó**).”*

## Example 1:
## *Ví dụ 1:*

**Input:** `root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8`
**Output:** `6`
**Explanation:** The LCA of nodes 2 and 8 is 6.

## Example 2:
## *Ví dụ 2:*

**Input:** `root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4`
**Output:** `2`
**Explanation:** The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

## Example 3:
## *Ví dụ 3:*

**Input:** `root = [2,1], p = 2, q = 1`
**Output:** `2`

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[2, 10^5]`.
*   `-10^9 <= Node.val <= 10^9`
*   All `Node.val` are **unique**.
*   `p != q`
*   `p` and `q` will exist in the BST.
