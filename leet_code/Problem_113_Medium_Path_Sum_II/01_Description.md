# Result for Path Sum II
# *Kết quả cho bài toán Tổng Đường Đi II*

## Description
## *Mô tả*

Given the `root` of a binary tree and an integer `targetSum`, return *all **root-to-leaf** paths where the sum of the node values in the path equals `targetSum`. Each path should be returned as a list of the node values, not node references*.
*Cho `root` của một cây nhị phân và một số nguyên `targetSum`, hãy trả về *tất cả các đường đi từ **gốc đến lá** sao cho tổng các giá trị nút trong đường đi bằng `targetSum`. Mỗi con đường nên được trả về dưới dạng một danh sách các giá trị nút, không phải là tham chiếu nút**.*

A **leaf** is a node with no children.
*Một nút **lá** là một nút không có nút con.*

## Example 1:
## *Ví dụ 1:*

**Input:** `root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22`
**Output:** `[[5,4,11,2],[5,8,4,5]]`
**Explanation:** There are two paths whose sum equals targetSum:
5 -> 4 -> 11 -> 2 = 22
5 -> 8 -> 4 -> 5 = 22

## Example 2:
## *Ví dụ 2:*

**Input:** `root = [1,2,3], targetSum = 5`
**Output:** `[]`

## Example 3:
## *Ví dụ 3:*

**Input:** `root = [1,2], targetSum = 0`
**Output:** `[]`

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[0, 5000]`.
*   `-1000 <= Node.val <= 1000`
*   `-1000 <= targetSum <= 1000`
