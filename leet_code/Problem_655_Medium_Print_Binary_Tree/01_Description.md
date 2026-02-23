# Result for Print Binary Tree
# *Kết quả cho bài toán In Cây Nhị phân*

## Description
## *Mô tả*

Given the `root` of a binary tree, construct a **0-indexed** `m x n` string matrix `res` that represents a **formatted layout** of the tree. The binary tree should be printed out through the following rules:
*Cho gốc `root` của một cây nhị phân, hãy xây dựng một ma trận chuỗi `res` kích thước `m x n` biểu diễn **bố cục định dạng** của cây. Cây nhị phân nên được in ra theo các quy luật sau:*

1.  The height of the tree is `height` and the number of rows `m` should be equal to `height + 1`.
    *   *Chiều cao của cây là `height` và số hàng `m` phải bằng `height + 1`.*
2.  The number of columns `n` should be equal to `2^(height+1) - 1`.
    *   *Số cột `n` phải bằng `2^(height+1) - 1`.*
3.  Place the **root node** in the **middle** of the **top row** (row `0`, column `(n-1)/2`).
    *   *Đặt **nút gốc** ở **giữa** của **hàng trên cùng** (hàng `0`, cột `(n-1)/2`).*
4.  For any node that has been placed at `res[r][c]`, place its **left child** at `res[r+1][c - 2^(height-r-1)]` and its **right child** at `res[r+1][c + 2^(height-r-1)]`.
    *   *Đối với bất kỳ nút nào đã được đặt tại `res[r][c]`, hãy đặt **nút con bên trái** của nó tại `res[r+1][c - 2^(height-r-1)]` và **nút con bên phải** của nó tại `res[r+1][c + 2^(height-r-1)]`.*
5.  All the empty cells should be filled with empty strings `""`.
    *   *Tất cả các ô trống nên được điền bằng chuỗi rỗng `""`.*

Return the constructed matrix `res`.
*Hãy trả về ma trận `res` đã xây dựng.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** root = [1,2]
**Output:** [["","1",""], ["2","",""]]

## Example 2:
## *Ví dụ 2:*

**Input:** root = [1,2,3,null,4]
**Output:** [["","","","1","","",""], ["","2","","","","3",""], ["","","4","","","",""]]

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[1, 2^10]`.
*   `-99 <= Node.val <= 99`
*   The depth of the tree will be in the range `[1, 10]`.
