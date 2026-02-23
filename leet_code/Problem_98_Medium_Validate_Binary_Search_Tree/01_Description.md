# Result for Validate Binary Search Tree
# *Kết quả cho bài toán Xác Minh Cây Tìm Kiếm Nhị Phân*

## Description
## *Mô tả*

Given the `root` of a binary tree, *determine if it is a valid binary search tree (BST)*.
*Cho `root` của một cây nhị phân, hãy *xác định xem nó có phải là một cây tìm kiếm nhị phân (BST) hợp lệ hay không***.*

A **valid BST** is defined as follows:
*Một **BST hợp lệ** được định nghĩa như sau:*

*   The left subtree of a node contains only nodes with keys **less than** the node's key.
*   The right subtree of a node contains only nodes with keys **greater than** the node's key.
*   Both the left and right subtrees must also be binary search trees.

*   *Cây con bên trái của một nút chỉ chứa các nút có khóa **nhỏ hơn** khóa của nút đó.*
*   *Cây con bên phải của một nút chỉ chứa các nút có khóa **lớn hơn** khóa của nút đó.*
*   *Cả cây con bên trái và bên phải cũng phải là cây tìm kiếm nhị phân.*

## Example 1:
## *Ví dụ 1:*

**Input:** `root = [2,1,3]`
**Output:** `true`

## Example 2:
## *Ví dụ 2:*

**Input:** `root = [5,1,4,null,null,3,6]`
**Output:** `false`
**Explanation:** The root node's value is 5 but its right child's value is 4.

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[1, 104]`.
*   `-2^31 <= Node.val <= 2^31 - 1`
