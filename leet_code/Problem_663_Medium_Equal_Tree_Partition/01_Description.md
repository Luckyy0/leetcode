# Result for Equal Tree Partition
# *Kết quả cho bài toán Chia Cây Thành Hai Phần Bằng nhau*

## Description
## *Mô tả*

Given the `root` of a binary tree, return `true` if you can partition the tree into two trees with equal sums of values after removing exactly one edge on the tree.
*Cho gốc `root` của một cây nhị phân, hãy trả về `true` nếu bạn có thể chia cây thành hai cây có tổng giá trị bằng nhau sau khi loại bỏ đúng một cạnh trên cây.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** root = [5,10,10,null,null,2,3]
**Output:** true
**Explanation:** 
Sum of values in the left tree: 5 + 10 = 15.
Sum of values in the right tree: 10 + 2 + 3 = 15.

## Example 2:
## *Ví dụ 2:*

**Input:** root = [1,2,10,null,null,2,20]
**Output:** false
**Explanation:** You cannot partition the tree into two trees with equal sums after removing one edge.

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[1, 10^4]`.
*   `-10^5 <= Node.val <= 10^5`
