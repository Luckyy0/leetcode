# Result for Two Sum IV - Input is a BST
# *Kết quả cho bài toán Two Sum IV - Đầu vào là Cây Nhị phân Tìm kiếm*

## Description
## *Mô tả*

Given the `root` of a binary search tree and an integer `k`, return `true` if there exist two elements in the BST such that their sum is equal to the given target `k`, or `false` otherwise.
*Cho gốc `root` của một cây nhị phân tìm kiếm (BST) và một số nguyên `k`, hãy trả về `true` nếu tồn tại hai phần tử trong BST sao cho tổng của chúng bằng mục tiêu `k` đã cho, ngược lại trả về `false`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** root = [5,3,6,2,4,null,7], k = 9
**Output:** true
**Explanation:** 5 + 4 = 9, 3 + 6 = 9.

## Example 2:
## *Ví dụ 2:*

**Input:** root = [5,3,6,2,4,null,7], k = 28
**Output:** false

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[1, 10^4]`.
*   `-10^4 <= Node.val <= 10^4`
*   `root` is guaranteed to be a **valid** binary search tree.
*   `-10^5 <= k <= 10^5`
