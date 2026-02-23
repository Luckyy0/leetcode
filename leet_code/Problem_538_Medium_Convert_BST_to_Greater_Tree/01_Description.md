# Result for Convert BST to Greater Tree
# *Kết quả cho bài toán Chuyển đổi BST thành Cây Lớn hơn*

## Description
## *Mô tả*

Given the `root` of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.
*Cho `root` của một Cây Nhị phân Tìm kiếm (BST), hãy chuyển đổi nó thành Cây Lớn hơn sao cho mỗi khóa của BST ban đầu được thay đổi thành khóa ban đầu cộng với tổng của tất cả các khóa lớn hơn khóa ban đầu trong BST.*

As a reminder, a *binary search tree* is a tree that satisfies these constraints:
*Xin nhắc lại, *cây nhị phân tìm kiếm* là một cây thỏa mãn các ràng buộc sau:*

*   The left subtree of a node contains only nodes with keys **less than** the node's key.
    *Cây con bên trái của một nút chỉ chứa các nút có khóa **nhỏ hơn** khóa của nút đó.*
*   The right subtree of a node contains only nodes with keys **greater than** the node's key.
    *Cây con bên phải của một nút chỉ chứa các nút có khóa **lớn hơn** khóa của nút đó.*
*   Both the left and right subtrees must also be binary search trees.
    *Cả cây con bên trái và bên phải cũng phải là cây nhị phân tìm kiếm.*

## Example 1:
## *Ví dụ 1:*

**Input:** `root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]`
**Output:** `[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]`

## Example 2:
## *Ví dụ 2:*

**Input:** `root = [0,null,1]`
**Output:** `[1,null,1]`

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[0, 10^4]`.
*   `-10^4 <= Node.val <= 10^4`
*   All the values in the tree are **unique**.
*   `root` is guaranteed to be a valid BST.
