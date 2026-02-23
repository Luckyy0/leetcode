# Result for Second Minimum Node In a Binary Tree
# *Kết quả cho bài toán Nút nhỏ thứ hai trong Cây Nhị phân*

## Description
## *Mô tả*

Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the minimum value among its two sub-nodes. More formally, `root.val = min(root.left.val, root.right.val)`.
*Cho một cây nhị phân đặc biệt không rỗng bao gồm các nút có giá trị không âm, trong đó mỗi nút trong cây này có đúng hai hoặc không có nút con nào. Nếu nút đó có hai nút con, thì giá trị của nút này là giá trị nhỏ nhất trong số hai nút con của nó. Chính xác hơn, `root.val = min(root.left.val, root.right.val)`.*

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
*Cho một cây nhị phân như vậy, bạn cần đưa ra giá trị nhỏ thứ hai trong tập hợp tất cả các giá trị của các nút trong toàn bộ cây.*

If no such second minimum value exists, output -1 instead.
*Nếu không tồn tại giá trị nhỏ thứ hai như vậy, hãy xuất ra -1.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** root = [2,2,5,null,null,5,7]
**Output:** 5
**Explanation:** The smallest value is 2, the second smallest value is 5.

## Example 2:
## *Ví dụ 2:*

**Input:** root = [2,2,2]
**Output:** -1
**Explanation:** The smallest value is 2, but there isn't any second smallest value.

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[1, 25]`.
*   `1 <= Node.val <= 2^31 - 1`
*   `root.val = min(root.left.val, root.right.val)` for each internal node of the tree.
