# Result for Binary Tree Longest Consecutive Sequence
# *Kết quả cho bài toán Chuỗi liên tiếp dài nhất trong Cây nhị phân*

## Description
## *Mô tả*

Given the `root` of a binary tree, return *the length of the longest consecutive sequence path*.
*Cho `root` của một cây nhị phân, hãy trả về *độ dài của đường dẫn chuỗi liên tiếp dài nhất*.*

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
*Đường dẫn đề cập đến bất kỳ chuỗi nút nào từ một nút bắt đầu nào đó đến bất kỳ nút nào trong cây dọc theo các kết nối cha-con. Đường dẫn liên tiếp dài nhất cần phải từ cha đến con (không thể ngược lại).*

## Example 1:
## *Ví dụ 1:*

**Input:** `root = [1,null,3,2,4,null,null,null,5]`
**Output:** `3`
**Explanation:** Longest consecutive sequence path is 3-4-5, so return 3.

## Example 2:
## *Ví dụ 2:*

**Input:** `root = [2,null,3,2,null,1]`
**Output:** `2`
**Explanation:** Longest consecutive sequence path is 2-3, not 3-2-1, so return 2.

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[1, 3 * 10^4]`.
*   `-3 * 10^4 <= Node.val <= 3 * 10^4`
