# Result for Recover Binary Search Tree
# *Kết quả cho bài toán Khôi Phục Cây Tìm Kiếm Nhị Phân*

## Description
## *Mô tả*

You are given the `root` of a binary search tree (BST), where the values of **exactly two** nodes of the tree were swapped by mistake. *Recover the tree without changing its structure*.
*Cho `root` của một cây tìm kiếm nhị phân (BST), trong đó giá trị của **chính xác hai** nút của cây đã bị tráo đổi nhầm lẫn. Hãy *khôi phục cây mà không làm thay đổi cấu trúc của nó***.*

## Example 1:
## *Ví dụ 1:*

**Input:** `root = [1,3,null,null,2]`
**Output:** `[3,1,null,null,2]`
**Explanation:** 3 and 1 were swapped.

## Example 2:
## *Ví dụ 2:*

**Input:** `root = [3,1,4,null,null,2]`
**Output:** `[2,1,4,null,null,3]`
**Explanation:** 2 and 3 were swapped.

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[2, 1000]`.
*   `-2^31 <= Node.val <= 2^31 - 1`

## Follow up:
*   An $O(n)$ space solution is quite straightforward. Could you devise an $O(1)$ space solution?
