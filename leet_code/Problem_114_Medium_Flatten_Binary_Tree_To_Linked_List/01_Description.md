# Result for Flatten Binary Tree to Linked List
# *Kết quả cho bài toán Làm Phẳng Cây Nhị Phân Thành Danh Sách Liên Kết*

## Description
## *Mô tả*

Given the `root` of a binary tree, flatten the tree into a "linked list":
*Cho `root` của một cây nhị phân, hãy làm phẳng cây thành một "danh sách liên kết":*

*   The "linked list" should use the same `TreeNode` class where the `right` child pointer points to the next node in the list and the `left` child pointer is always `null`.
    *Cái "danh sách liên kết" này nên sử dụng cùng một lớp `TreeNode` trong đó con trỏ con bên `phải` trỏ đến nút tiếp theo trong danh sách và con trỏ con bên `trái` luôn là `null`.*
*   The "linked list" should be in the same order as a **pre-order traversal** of the binary tree.
    *Cái "danh sách liên kết" này nên có cùng thứ tự với phép duyệt **theo thứ tự trước** của cây nhị phân.*

## Example 1:
## *Ví dụ 1:*

**Input:** `root = [1,2,5,3,4,null,6]`
**Output:** `[1,null,2,null,3,null,4,null,5,null,6]`

## Example 2:
## *Ví dụ 2:*

**Input:** `root = []`
**Output:** `[]`

## Example 3:
## *Ví dụ 3:*

**Input:** `root = [0]`
**Output:** `[0]`

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[0, 2000]`.
*   `-100 <= Node.val <= 100`

## Follow up:
*   Can you flatten the tree in-place (with $O(1)$ extra space)?
