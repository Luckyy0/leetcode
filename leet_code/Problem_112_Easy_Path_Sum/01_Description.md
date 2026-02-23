# Result for Path Sum
# *Kết quả cho bài toán Tổng Đường Đi*

## Description
## *Mô tả*

Given the `root` of a binary tree and an integer `targetSum`, return `true` if the tree has a **root-to-leaf** path such that adding up all the values along the path equals `targetSum`.
*Cho `root` của một cây nhị phân và một số nguyên `targetSum`, hãy trả về `true` nếu cây có một đường đi từ **gốc đến lá** sao cho tổng tất cả các giá trị dọc theo đường đi bằng `targetSum`.*

A **leaf** is a node with no children.
*Một nút **lá** là một nút không có nút con.*

## Example 1:
## *Ví dụ 1:*

**Input:** `root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22`
**Output:** `true`
**Explanation:** The root-to-leaf path with the target sum is shown. (5 -> 4 -> 11 -> 2)

## Example 2:
## *Ví dụ 2:*

**Input:** `root = [1,2,3], targetSum = 5`
**Output:** `false`
**Explanation:** There are two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.

## Example 3:
## *Ví dụ 3:*

**Input:** `root = [], targetSum = 0`
**Output:** `false`
**Explanation:** Since the tree is empty, there are no root-to-leaf paths.

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[0, 5000]`.
*   `-1000 <= Node.val <= 1000`
*   `-1000 <= targetSum <= 1000`
