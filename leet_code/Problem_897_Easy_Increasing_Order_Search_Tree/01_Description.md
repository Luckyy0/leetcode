# Result for Increasing Order Search Tree
# *Kết quả cho bài toán Cây Tìm kiếm Thứ tự Tăng dần*

## Description
## *Mô tả*

Given the `root` of a binary search tree, rearrange the tree in **in-order** so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child.
*Cho `root` của một cây tìm kiếm nhị phân, hãy sắp xếp lại cây theo **thứ tự giữa (in-order)** sao cho nút trái nhất trong cây bây giờ là gốc của cây, và mỗi nút không có con trái và chỉ có một con phải.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
**Output:** [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

## Example 2:
## *Ví dụ 2:*

**Input:** root = [5,1,7]
**Output:** [1,null,5,null,7]

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the given tree will be in the range `[1, 100]`.
*   `0 <= Node.val <= 1000`
