# Result for Check Completeness of a Binary Tree
# *Kết quả cho bài toán Kiểm tra Tính hoàn chỉnh của Cây Nhị phân*

## Description
## *Mô tả*

Given the `root` of a binary tree, determine if it is a *complete binary tree*.
*Cho `gốc` của một cây nhị phân, hãy xác định xem nó có phải là một *cây nhị phân hoàn chỉnh* hay không.*

In a **complete binary tree**, every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between `1` and `2^h` nodes inclusive at the last level `h`.
*Trong một **cây nhị phân hoàn chỉnh**, mỗi tầng, ngoại trừ có thể là tầng cuối cùng, đều được lấp đầy hoàn toàn, và tất cả các nút ở tầng cuối cùng đều nằm xa nhất về phía bên trái có thể. Nó có thể có từ `1` đến `2^h` nút bao gồm cả ở tầng cuối cùng `h`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** root = [1,2,3,4,5,6]
**Output:** true
**Explanation:** Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as possible.

## Example 2:
## *Ví dụ 2:*

**Input:** root = [1,2,3,4,5,null,7]
**Output:** false
**Explanation:** The node with value 7 isn't as far left as possible.

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[1, 100]`.
*   `1 <= Node.val <= 1000`
