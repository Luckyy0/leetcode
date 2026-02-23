# Result for Construct Binary Search Tree from Preorder Traversal
# *Kết quả cho bài toán Xây dựng Cây tìm kiếm nhị phân từ duyệt tiền thứ tự (Preorder)*

## Description
## *Mô tả*

Given an array of integers preorder, which represents the **preorder traversal** of a BST (i.e., **binary search tree**), construct the tree and return *its root*.
*Cho một mảng các số nguyên preorder, đại diện cho quá trình **duyệt tiền thứ tự** của một BST (tức là **cây tìm kiếm nhị phân**), hãy xây dựng cây và trả về gốc của nó.*

It is **guaranteed** that there is always possible to find a binary search tree with the given requirements for the given test cases.
*Điều này được **đảm bảo** rằng luôn luôn có thể tìm được một cây tìm kiếm nhị phân thảo mãn yêu cầu đối với các bộ kiểm thử đã cho.*

A **binary search tree** is a binary tree where for every node, any descendant of `Node.left` has a value **strictly less than** `Node.val`, and any descendant of `Node.right` has a value **strictly greater than** `Node.val`.
*Một cây tìm kiếm nhị phân là một cây nhị phân mà ở mọi node, bất kỳ hậu duệ nào của cây con trái đều nằm **hoàn toàn nhỏ hơn** giá trị node đó, và ngược lại hậu duệ bên phải có giá trị **hoàn toàn lớn hơn**.*

A **preorder traversal** of a binary tree displays the value of the node first, then traverses `Node.left`, then traverses `Node.right`.
*Một phép **duyệt tiền thứ tự** của cây nhị phân sẽ in ra giá trị Node trước, sau đó duyệt nhánh con bên trái, rồi nhánh con bên phải.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** preorder = [8,5,1,7,10,12]
**Output:** [8,5,10,1,7,null,12]
**Explanation:** 
`    8
   / \
  5   10
 / \    \
1   7   12`

## Example 2:
## *Ví dụ 2:*

**Input:** preorder = [1,3]
**Output:** [1,null,3]

---

## Constraints:
## *Ràng buộc:*

*   `1 <= preorder.length <= 100`
*   `1 <= preorder[i] <= 10^8`
*   All the values of `preorder` are **unique**.
