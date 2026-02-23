# Result for Find Leaves of Binary Tree
# *Kết quả cho bài toán Tìm các Lá của Cây Nhị phân*

## Description
## *Mô tả*

Given the `root` of a binary tree, collect a tree's nodes as if you were doing this:
*Cho một `root` của cây nhị phân, hãy thu thập các nút của cây giống như bạn đang làm như sau:*

- Collect all the leaf nodes.
- Remove all the leaf nodes.
- Repeat until the tree is empty.

## Example 1:
## *Ví dụ 1:*

**Input:** `root = [1,2,3,4,5]`
**Output:** `[[4,5,3],[2],[1]]`
**Explanation:**
1. First, collect the leaf nodes [4,5,3] and remove them. Tree becomes [1,2].
2. Then, collect the leaf nodes [2] and remove it. Tree becomes [1].
3. Finally, collect the leaf node [1] and remove it. Tree is empty.

## Example 2:
## *Ví dụ 2:*

**Input:** `root = [1]`
**Output:** `[[1]]`

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[1, 100]`.
*   `-100 <= Node.val <= 100`
