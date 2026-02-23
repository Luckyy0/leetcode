# Result for Cousins in Binary Tree
# *Kết quả cho bài toán Anh em họ trong Cây nhị phân*

## Description
## *Mô tả*

Given the `root` of a binary tree with unique values and the values of two different nodes of the tree `x` and `y`, return `true` *if the nodes corresponding to the values* `x` *and* `y` *are cousins, or* `false` *otherwise.*
*Cho `gốc` của một cây nhị phân có các giá trị duy nhất và giá trị của hai nút khác nhau của cây là `x` và `y`, trả về `true` *nếu các nút tương ứng với giá trị* `x` *và* `y` *là anh em họ, hoặc* `false` *nếu ngược lại.*.*

Two nodes of a binary tree are **cousins** if they have the same depth with different parents.
*Hai nút của một cây nhị phân là **anh em họ** nếu chúng có cùng độ sâu và khác cha mẹ.*

Note that in a binary tree, the root node is at the depth `0`, and children of each depth `k` node are at the depth `k + 1`.
*Lưu ý rằng trong một cây nhị phân, nút gốc ở độ sâu `0` và các nút con của mỗi nút có độ sâu `k` ở độ sâu `k + 1`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** root = [1,2,3,4], x = 4, y = 3
**Output:** false

## Example 2:
## *Ví dụ 2:*

**Input:** root = [1,2,3,null,4,null,5], x = 5, y = 4
**Output:** true

## Example 3:
## *Ví dụ 3:*

**Input:** root = [1,2,3,null,4], x = 2, y = 3
**Output:** false

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[2, 100]`.
*   `1 <= Node.val <= 100`
*   Each node has a **unique** value.
*   `x != y`
*   `x` and `y` are exist in the tree.
