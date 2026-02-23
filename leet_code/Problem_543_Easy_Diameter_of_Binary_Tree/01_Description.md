# Result for Diameter of Binary Tree
# *Kết quả cho bài toán Đường kính của Cây Nhị phân*

## Description
## *Mô tả*

Given the `root` of a binary tree, return *the length of the **diameter** of the tree*.
*Cho `root` của một cây nhị phân, hãy trả về *độ dài của **đường kính** của cây*.*

The **diameter** of a binary tree is the **length** of the longest path between any two nodes in a tree. This path may or may not pass through the `root`.
***Đường kính** của một cây nhị phân là **độ dài** của đường đi dài nhất giữa bất kỳ hai nút nào trong cây. Đường đi này có thể hoặc không đi qua `root`.*

The **length** of a path between two nodes is represented by the number of edges between them.
***Độ dài** của một đường đi giữa hai nút được biểu thị bằng số lượng cạnh giữa chúng.*

## Example 1:
## *Ví dụ 1:*

**Input:** `root = [1,2,3,4,5]`
**Output:** `3`
**Explanation:** 3 is the length of the path [4,2,1,3] or [5,2,1,3].

## Example 2:
## *Ví dụ 2:*

**Input:** `root = [1,2]`
**Output:** `1`

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[1, 10^4]`.
*   `-100 <= Node.val <= 100`
