# Result for Inorder Successor in BST II
# *Kết quả cho bài toán Kế vị trong cây BST II*

## Description
## *Mô tả*

Given a `node` in a binary search tree, return *the in-order successor of that node in the BST*. If that node has no in-order successor, return `null`.
*Cho một `node` trong cây nhị phân tìm kiếm, hãy trả về *phần tử kế vị theo thứ tự (in-order successor) của nút đó trong BST*. Nếu nút đó không có phần tử kế vị theo thứ tự, trả về `null`.*

The successor of a `node` is the node with the smallest key greater than `node.val`.
*Phần tử kế vị của một `node` là nút có khóa nhỏ nhất lớn hơn `node.val`.*

You will have direct access to the node but not to the root of the tree. Each node will have a reference to its parent node. Below is the definition for `Node`:
*Bạn sẽ có quyền truy cập trực tiếp vào nút nhưng không có quyền truy cập vào gốc của cây. Mỗi nút sẽ có một tham chiếu đến nút cha của nó. Dưới đây là định nghĩa cho `Node`:*

```java
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
}
```

## Example 1:
## *Ví dụ 1:*

**Input:** `tree = [2,1,3], node = 1`
**Output:** `2`
**Explanation:** 1's in-order successor node is 2. Note that this is a different Node definition with parent pointers.

## Example 2:
## *Ví dụ 2:*

**Input:** `tree = [5,3,6,2,4,null,null,1], node = 6`
**Output:** `null`
**Explanation:** There is no in-order successor of the current node.

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[1, 10^4]`.
*   `-10^5 <= Node.val <= 10^5`
*   All Node.val are unique.
