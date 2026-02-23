# Result for Search in a Binary Search Tree
# *Kết quả cho bài toán Tìm kiếm trong Cây Nhị phân Tìm kiếm*

## Description
## *Mô tả*

You are given the `root` of a binary search tree (BST) and an integer `val`.
*Bạn được cho `root` của một cây nhị phân tìm kiếm (BST) và một số nguyên `val`.*

Find the node in the BST that the node's value equals `val` and return the subtree rooted with that node. If such a node does not exist, return `null`.
*Hãy tìm nút trong BST có giá trị bằng `val` và trả về cây con có gốc là nút đó. Nếu nút đó không tồn tại, hãy trả về `null`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** root = [4,2,7,1,3], val = 2
**Output:** [2,1,3]

## Example 2:
## *Ví dụ 2:*

**Input:** root = [4,2,7,1,3], val = 5
**Output:** []

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[1, 5000]`.
*   `1 <= Node.val <= 10^7`
*   `root` is a binary search tree.
*   `1 <= val <= 10^7`
