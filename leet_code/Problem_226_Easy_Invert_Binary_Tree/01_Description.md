# Result for Invert Binary Tree
# *Kết quả cho bài toán Đảo ngược cây nhị phân*

## Description
## *Mô tả*

Given the `root` of a binary tree, invert the tree, and return its root.
*Cho `root` của một cây nhị phân, hãy đảo ngược cây, và trả về root của nó.*

## Example 1:
## *Ví dụ 1:*

**Input:** `root = [4,2,7,1,3,6,9]`
**Output:** `[4,7,2,9,6,3,1]`
**Explanation:**
     4
   /   \
  2     7
 / \   / \
1   3 6   9
becomes
     4
   /   \
  7     2
 / \   / \
9   6 3   1

## Example 2:
## *Ví dụ 2:*

**Input:** `root = [2,1,3]`
**Output:** `[2,3,1]`

## Example 3:
## *Ví dụ 3:*

**Input:** `root = []`
**Output:** `[]`

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[0, 100]`.
*   `-100 <= Node.val <= 100`
