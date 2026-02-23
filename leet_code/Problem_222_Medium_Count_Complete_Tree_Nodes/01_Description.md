# Result for Count Complete Tree Nodes
# *Kết quả cho bài toán Đếm số nút của cây hoàn chỉnh*

## Description
## *Mô tả*

Given the `root` of a **complete** binary tree, return the number of the nodes in the tree.
*Cho `root` của một cây nhị phân **hoàn chỉnh**, trả về số lượng các nút trong cây.*

According to **[Wikipedia](http://en.wikipedia.org/wiki/Binary_tree#Types_of_binary_trees)**, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between `1` and `2^h` nodes inclusive at the last level `h`.
*Theo **[Wikipedia](http://en.wikipedia.org/wiki/Binary_tree#Types_of_binary_trees)**, mọi tầng, ngoại trừ có thể là tầng cuối cùng, đều được lấp đầy hoàn toàn trong một cây nhị phân hoàn chỉnh, và tất cả các nút ở tầng cuối cùng đều nằm ở phía bên trái nhất có thể. Nó có thể có từ `1` đến `2^h` nút bao gồm ở tầng cuối cùng `h`.*

Design an algorithm that runs in less than `O(n)` time complexity.
*Thiết kế một thuật toán chạy với độ phức tạp thời gian nhỏ hơn `O(n)`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `root = [1,2,3,4,5,6]`
**Output:** `6`

## Example 2:
## *Ví dụ 2:*

**Input:** `root = []`
**Output:** `0`

## Example 3:
## *Ví dụ 3:*

**Input:** `root = [1]`
**Output:** `1`

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[0, 5 * 10^4]`.
*   `0 <= Node.val <= 5 * 10^4`
*   The tree is guaranteed to be **complete**.
