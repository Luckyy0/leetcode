# Result for Complete Binary Tree Inserter
# *Kết quả cho bài toán Trình chèn Cây Nhị phân Hoàn chỉnh*

## Description
## *Mô tả*

A **complete binary tree** is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.
*Một **cây nhị phân hoàn chỉnh** là một cây nhị phân trong đó mọi mức, ngoại trừ có thể là mức cuối cùng, đều được lấp đầy hoàn toàn và tất cả các nút đều ở vị trí xa nhất về phía bên trái.*

Design an algorithm to insert a new node to a complete binary tree keeping it complete after the insertion.
*Thiết kế một thuật toán để chèn một nút mới vào cây nhị phân hoàn chỉnh, giữ cho nó hoàn chỉnh sau khi chèn.*

Implement the `CBTInserter` class:
*Triển khai lớp `CBTInserter`:*

*   `CBTInserter(TreeNode root)` Initializes the data structure with the `root` of the complete binary tree.
    *   `CBTInserter(TreeNode root)` Khởi tạo cấu trúc dữ liệu với `root` của cây nhị phân hoàn chỉnh.*
*   `int insert(int v)` Inserts a `TreeNode` into the tree with value `Node.val == v` so that the tree remains complete, and returns the value of the parent of the inserted `TreeNode`.
    *   `int insert(int v)` Chèn một `TreeNode` vào cây với giá trị `Node.val == v` sao cho cây vẫn hoàn chỉnh, và trả về giá trị của nút cha của `TreeNode` được chèn.*
*   `TreeNode get_root()` Returns the root node of the tree.
    *   `TreeNode get_root()` Trả về nút gốc của cây.*

---

## Example 1:
## *Ví dụ 1:*

**Input**
["CBTInserter", "insert", "insert", "get_root"]
[[[1, 2]], [3], [4], []]
**Output**
[null, 1, 2, [1, 2, 3, 4]]

**Explanation**
CBTInserter cBTInserter = new CBTInserter([1, 2]);
cBTInserter.insert(3);  // return 1
cBTInserter.insert(4);  // return 2
cBTInserter.get_root(); // return [1, 2, 3, 4]

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree will be in the range `[1, 1000]`.
*   `0 <= Node.val <= 5000`
*   `root` is a complete binary tree.
*   `0 <= v <= 5000`
*   At most `10^4` calls will be made to `insert` and `get_root`.
