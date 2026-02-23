# Result for Binary Tree Vertical Order Traversal
# *Kết quả cho bài toán Duyệt Cây Nhị phân theo Thứ tự Dọc*

## Description
## *Mô tả*

Given the `root` of a binary tree, return *the vertical order traversal of its nodes' values*. (i.e., from top to bottom, column by column).
*Cho `root` của một cây nhị phân, trả về *kết quả duyệt các giá trị nút theo thứ tự dọc*. (tức là, từ trên xuống dưới, từng cột một).*

If two nodes are in the same row and column, the order should be from **left to right**.
*Nếu hai nút nằm trong cùng một hàng và cột, thứ tự phải là từ **trái sang phải**.*

## Example 1:
## *Ví dụ 1:*

**Input:** `root = [3,9,20,null,null,15,7]`
**Output:** `[[9],[3,15],[20],[7]]`
**Explanation:**
Column -1: 9
Column 0: 3, 15
Column 1: 20
Column 2: 7

## Example 2:
## *Ví dụ 2:*

**Input:** `root = [3,9,8,4,0,1,7]`
**Output:** `[[4],[9],[3,0,1],[8],[7]]`
**Explanation:**
Column -2: 4
Column -1: 9
Column 0: 3, 0, 1
Column 1: 8
Column 2: 7

## Example 3:
## *Ví dụ 3:*

**Input:** `root = [3,9,8,4,0,1,7,null,null,null,2,5]`
**Output:** `[[4],[9,5],[3,0,1],[8,2],[7]]`

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[0, 100]`.
*   `-100 <= Node.val <= 100`
