# Result for Count Univalue Subtrees
# *Kết quả cho bài toán Đếm cây con đơn trị*

## Description
## *Mô tả*

Given the `root` of a binary tree, return *the number of **uni-value** subtrees*.
*Cho `root` của một cây nhị phân, hãy trả về *số lượng **cây con đơn trị***.*

A **uni-value subtree** means all nodes of the subtree have the same value.
*Một **cây con đơn trị** nghĩa là tất cả các nút của cây con đều có cùng giá trị.*

## Example 1:
## *Ví dụ 1:*

**Input:** `root = [5,1,5,5,5,null,5]`
**Output:** `4`
**Explanation:**
     5
   /   \
  1     5
 / \     \
5   5     5
The uni-value subtrees are:
- Leaf 5 (left-left)
- Leaf 5 (left-right)
- Leaf 5 (right-right)
- The subtree rooted at Right 5 (Right child of root, with its right child 5).
Wait, the example structure is:
      5
     / \
    1   5
   / \   \
  5   5   5
Left subtree (rooted at 1) is NOT univalue (1 != 5).
Right subtree (rooted at 5) keys: 5, 5. IS univalue.
Leaves 5, 5, 5 are univalue.
Total: 3 leaves + 1 right subtree = 4.

## Example 2:
## *Ví dụ 2:*

**Input:** `root = []`
**Output:** `0`

## Example 3:
## *Ví dụ 3:*

**Input:** `root = [5,5,5,5,5,null,5]`
**Output:** `6`

## Constraints:
## *Ràng buộc:*

*   The number of the node in the tree will be in the range `[0, 1000]`.
*   `-1000 <= Node.val <= 1000`
