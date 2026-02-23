# Result for Minimum Depth of Binary Tree
# *Kết quả cho bài toán Chiều Sâu Tối Thiểu của Cây Nhị Phân*

## Description
## *Mô tả*

Given a binary tree, find its minimum depth.
*Cho một cây nhị phân, hãy tìm chiều sâu tối thiểu của nó.*

The **minimum depth** is the number of nodes along the shortest path from the root node down to the nearest leaf node.
*Chiều sâu tối thiểu** là số lượng nút dọc theo đường đi ngắn nhất từ nút gốc xuống nút lá gần nhất.*

**Note:** A leaf is a node with no children.
*Lưu ý: Một nút lá là một nút không có nút con.*

## Example 1:
## *Ví dụ 1:*

**Input:** `root = [3,9,20,null,null,15,7]`
**Output:** `2`
**Explanation:** The shortest path is `3 -> 9`.

## Example 2:
## *Ví dụ 2:*

**Input:** `root = [2,null,3,null,4,null,5,null,6]`
**Output:** `5`
**Explanation:** The path is `2 -> 3 -> 4 -> 5 -> 6`.

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[0, 10^5]`.
*   `-1000 <= Node.val <= 1000`
