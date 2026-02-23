# Result for Delete Node in a BST
# *Kết quả cho bài toán Xóa Nút trong BST*

## Description
## *Mô tả*

Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
*Cho tham chiếu nút gốc của một cây BST và một giá trị `key`, hãy xóa nút có giá trị `key` đó trong cây BST. Trả về tham chiếu đến nút gốc (có thể đã được cập nhật) của cây BST.*

Basically, the deletion can be divided into two stages:
1. Search for a node to remove.
2. If the node is found, delete the node.

## Example 1:
## *Ví dụ 1:*

**Input:** `root = [5,3,6,2,4,null,7], key = 3`
**Output:** `[5,4,6,2,null,null,7]`
**Explanation:** Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above figure.
Another valid answer is [5,2,6,null,4,null,7].

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[0, 10^{4}]`.
*   `-10^{5} <= Node.val <= 10^{5}`
*   Each node has a **unique** value.
*   `root` is a valid binary search tree.
*   `-10^{5} <= key <= 10^{5}`
