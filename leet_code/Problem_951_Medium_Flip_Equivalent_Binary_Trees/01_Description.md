# Result for Flip Equivalent Binary Trees
# *Kết quả cho bài toán Cây Nhị phân Tương đương Lật*

## Description
## *Mô tả*

For a binary tree `T`, we can define a **flip operation** as follows: choose any node, and swap the left and right child subtrees.
*Đối với cây nhị phân `T`, chúng ta có thể định nghĩa **thao tác lật** như sau: chọn bất kỳ nút nào và hoán đổi cây con con bên trái và bên phải.*

A binary tree `X` is **flip equivalent** to a binary tree `Y` if and only if we can make `X` equal to `Y` after some number of flip operations.
*Cây nhị phân `X` là **tương đương lật** với cây nhị phân `Y` khi và chỉ khi chúng ta có thể làm cho `X` bằng `Y` sau một số thao tác lật.*

Given the roots of two binary trees `root1` and `root2`, return `true` if the two trees are flip equivalent or `false` otherwise.
*Cho gốc của hai cây nhị phân `root1` và `root2`, trả về `true` nếu hai cây là tương đương lật hoặc `false` nếu ngược lại.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
**Output:** true
**Explanation:** We flipped at nodes with values 1, 3, and 5.

## Example 2:
## *Ví dụ 2:*

**Input:** root1 = [], root2 = []
**Output:** true

## Example 3:
## *Ví dụ 3:*

**Input:** root1 = [], root2 = [1]
**Output:** false

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in each tree is in the range `[0, 100]`.
*   Each tree will have **unique node values** in the range `[0, 99]`.
