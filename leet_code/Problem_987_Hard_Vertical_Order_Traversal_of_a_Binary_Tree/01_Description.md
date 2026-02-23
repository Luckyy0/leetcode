# Result for Vertical Order Traversal of a Binary Tree
# *Kết quả cho bài toán Duyệt cây nhị phân theo Chiều dọc*

## Description
## *Mô tả*

Given the `root` of a binary tree, calculate the **vertical order traversal** of the binary tree.
*Cho `gốc` của một cây nhị phân, tính toán **duyệt theo chiều dọc** của cây nhị phân đó.*

For each node at position `(row, col)`, its left and right children will be at positions `(row + 1, col - 1)` and `(row + 1, col + 1)` respectively. The root of the tree is at `(0, 0)`.
*Đối với mỗi nút ở vị trí `(row, col)`, các nút con cái trái và phải của nó sẽ ở vị trí `(row + 1, col - 1)` và `(row + 1, col + 1)` tương ứng. Gốc của cây nằm ở `(0, 0)`.*

The **vertical order traversal** of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.
*Mảng **duyệt theo chiều dọc** của cây nhị phân là một danh sách các sắp xếp từ trên xuống dưới cho mỗi chỉ số cột bắt đầu từ cột ngoài cùng bên trái và kết thúc ở cột ngoài cùng bên phải. Có thể có nhiều nút ở cùng một hàng và cùng một cột. Trong trường hợp đó, sắp xếp các nút này theo giá trị của chúng.*

Return *the **vertical order traversal** of the binary tree*.
*Trả về *danh sách **duyệt theo chiều dọc** của cây nhị phân*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** root = [3,9,20,null,null,15,7]
**Output:** [[9],[3,15],[20],[7]]
**Explanation:** 
Column -1: Only node 9 is in this column.
Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
Column 1: Only node 20 is in this column.
Column 2: Only node 7 is in this column.

## Example 2:
## *Ví dụ 2:*

**Input:** root = [1,2,3,4,5,6,7]
**Output:** [[4],[2],[1,5,6],[3],[7]]
**Explanation:** 
Column -2: Only node 4 is in this column.
Column -1: Only node 2 is in this column.
Column 0: Nodes 1, 5, and 6 are in this column.
  1 is at (0, 0), so it comes first.
  5 and 6 are at (2, 0), so we sort them by their value, resulting in 5 then 6.
Column 1: Only node 3 is in this column.
Column 2: Only node 7 is in this column.

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[1, 1000]`.
*   `0 <= Node.val <= 1000`
