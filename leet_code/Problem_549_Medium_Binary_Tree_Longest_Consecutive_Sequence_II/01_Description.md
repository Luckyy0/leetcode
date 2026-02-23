# Result for Binary Tree Longest Consecutive Sequence II
# *Kết quả cho bài toán Chuỗi Liên tiếp Dài nhất trên Cây Nhị phân II*

## Description
## *Mô tả*

Given the `root` of a binary tree, return *the length of the longest consecutive path in the tree*.
*Cho `root` của một cây nhị phân, hãy trả về *độ dài của chuỗi liên tiếp dài nhất trong cây*.*

A consecutive path is a path where the values of every node in the path go up or down by `1`. For example, `[1,2,3,4]` and `[4,3,2,1]` are both consecutive paths, but `[1,2,4,3]` is not.
*Một chuỗi liên tiếp là một đường dẫn mà giá trị của mỗi nút trong đường dẫn tăng hoặc giảm đi `1`. Ví dụ, `[1,2,3,4]` và `[4,3,2,1]` đều là các chuỗi liên tiếp, nhưng `[1,2,4,3]` thì không.*

On the other hand, the path can be in the child-Parent-child order, where not necessarily be parent-child order.
*Mặt khác, đường dẫn có thể theo thứ tự con-Cha-con, không nhất thiết phải theo thứ tự cha-con.*

## Example 1:
## *Ví dụ 1:*

**Input:** `root = [1,2,3]`
**Output:** `2`
**Explanation:** The longest consecutive path is [1, 2] or [2, 1].

## Example 2:
## *Ví dụ 2:*

**Input:** `root = [2,1,3]`
**Output:** `3`
**Explanation:** The longest consecutive path is [1, 2, 3] or [3, 2, 1].

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[1, 3 * 10^4]`.
*   `-3 * 10^4 <= Node.val <= 3 * 10^4`
