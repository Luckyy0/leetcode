# Result for Convert Sorted Array to Binary Search Tree
# *Kết quả cho bài toán Chuyển Đổi Mảng Đã Sắp Xếp Thành Cây Tìm Kiếm Nhị Phân*

## Description
## *Mô tả*

Given an integer array `nums` where the elements are sorted in **ascending order**, convert it to a **height-balanced** binary search tree.
*Cho một mảng số nguyên `nums` trong đó các phần tử được sắp xếp theo **thứ tự tăng dần**, hãy chuyển đổi nó thành một cây tìm kiếm nhị phân **cân bằng về chiều cao**.*

A **height-balanced** binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
*Một cây nhị phân **cân bằng về chiều cao** là một cây nhị phân trong đó chiều sâu của hai cây con của mỗi nút không bao giờ chênh lệch quá một.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [-10,-3,0,5,9]`
**Output:** `[0,-3,9,-10,null,5]`
**Explanation:** `[0,-10,5,null,-3,null,9]` is also accepted.

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [1,3]`
**Output:** `[3,1]`
**Explanation:** `[1,null,3]` and `[3,1]` are both height-balanced BSTs.

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 10^4`
*   `-10^4 <= nums[i] <= 10^4`
*   `nums` is sorted in a **strictly increasing** order.
