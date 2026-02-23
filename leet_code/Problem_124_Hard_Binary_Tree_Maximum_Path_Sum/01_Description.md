# Result for Binary Tree Maximum Path Sum
# *Kết quả cho bài toán Tổng Đường Đi Tối Đa Trên Cây Nhị Phân*

## Description
## *Mô tả*

A **path** in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence **at most once**. Note that the path does not need to pass through the root.
*Một **đường đi** trong một cây nhị phân là một chuỗi các nút trong đó mỗi cặp nút liền kề trong chuỗi có một cạnh nối chúng. Một nút chỉ có thể xuất hiện trong chuỗi **tối đa một lần**. Lưu ý rằng đường đi không nhất thiết phải đi qua gốc.*

The **path sum** of a path is the sum of the node's values in the path.
*Tổng đường đi** của một đường đi là tổng giá trị của các nút trong đường đi đó.*

Given the `root` of a binary tree, return *the maximum **path sum** of any non-empty path*.
*Cho `root` của một cây nhị phân, hãy trả về *tổng đường đi tối đa** của bất kỳ con đường không trống nào.*

## Example 1:
## *Ví dụ 1:*

**Input:** `root = [1,2,3]`
**Output:** `6`
**Explanation:** The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.

## Example 2:
## *Ví dụ 2:*

**Input:** `root = [-10,9,20,null,null,15,7]`
**Output:** `42`
**Explanation:** The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[1, 3 * 10^4]`.
*   `-1000 <= Node.val <= 1000`
