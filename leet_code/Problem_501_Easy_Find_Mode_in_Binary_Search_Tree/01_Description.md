# Result for Find Mode in Binary Search Tree
# *Kết quả cho bài toán Tìm Mode trong Cây Nhị phân Tìm kiếm*

## Description
## *Mô tả*

Given the `root` of a binary search tree (BST) with duplicates, return *all the [mode(s)](https://en.wikipedia.org/wiki/Mode_(statistics)) (i.e., the most frequently occurred element) in it*.
*Cho `root` của một cây nhị phân tìm kiếm (BST) có các phần tử trùng lặp, hãy trả về *tất cả các [mode](https://en.wikipedia.org/wiki/Mode_(statistics)) (tức là phần tử xuất hiện thường xuyên nhất) trong đó*.*

If the tree has more than one mode, return them in **any order**.
*Nếu cây có nhiều hơn một mode, hãy trả về chúng theo **bất kỳ thứ tự nào**.*

Assume a BST is defined as follows:
*Giả sử một BST được định nghĩa như sau:*

*   The left subtree of a node contains only nodes with keys **less than or equal to** the node's key.
    *Cây con bên trái của một nút chỉ chứa các nút có khóa **nhỏ hơn hoặc bằng** khóa của nút đó.*
*   The right subtree of a node contains only nodes with keys **greater than or equal to** the node's key.
    *Cây con bên phải của một nút chỉ chứa các nút có khóa **lớn hơn hoặc bằng** khóa của nút đó.*
*   Both the left and right subtrees must also be binary search trees.
    *Cả cây con bên trái và bên phải cũng phải là cây nhị phân tìm kiếm.*

## Example 1:
## *Ví dụ 1:*

**Input:** `root = [1,null,2,2]`
**Output:** `[2]`

## Example 2:
## *Ví dụ 2:*

**Input:** `root = [0]`
**Output:** `[0]`

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[1, 10^4]`.
*   `-10^5 <= Node.val <= 10^5`

**Follow up:** Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
