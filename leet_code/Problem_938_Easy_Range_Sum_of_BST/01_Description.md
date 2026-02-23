# Result for Range Sum of BST
# *Kết quả cho bài toán Tổng Phạm vi của Cây Nhị phân Tìm kiếm*

## Description
## *Mô tả*

Given the `root` node of a binary search tree and two integers `low` and `high`, return *the sum of values of all nodes with a value in the **inclusive** range `[low, high]`*.
*Cho nút `root` của cây nhị phân tìm kiếm và hai số nguyên `low` và `high`, hãy trả về *tổng giá trị của tất cả các nút có giá trị trong khoảng **bao gồm** `[low, high]`*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** root = [10,5,15,3,7,null,18], low = 7, high = 15
**Output:** 32
**Explanation:** Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.

## Example 2:
## *Ví dụ 2:*

**Input:** root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
**Output:** 23
**Explanation:** Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[1, 2 * 10^4]`.
*   `1 <= Node.val <= 10^5`
*   `1 <= low <= high <= 10^5`
*   All `Node.val` are **unique**.
