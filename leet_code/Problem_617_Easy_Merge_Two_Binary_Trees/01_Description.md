# Result for Merge Two Binary Trees
# *Kết quả cho bài toán Hợp nhất Hai Cây Nhị phân*

## Description
## *Mô tả*

You are given two binary trees `root1` and `root2`.
*Bạn được cho hai cây nhị phân `root1` và `root2`.*

Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.
*Hãy tưởng tượng rằng khi bạn đặt cây này chồng lên cây kia, một số nút của hai cây bị chồng lấp trong khi những nút khác thì không. Bạn cần hợp nhất hai cây thành một cây nhị phân mới. Quy tắc hợp nhất là nếu hai nút chồng lấp nhau, thì hãy cộng các giá trị của chúng lại để làm giá trị mới của nút hợp nhất. Ngược lại, nút không null sẽ được sử dụng làm nút của cây mới.*

Return the merged tree.
*Trả về cây đã hợp nhất.*

Note: The merging process must start from the root nodes of both trees.
*Lưu ý: Quá trình hợp nhất phải bắt đầu từ các nút gốc của cả hai cây.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
**Output:** [3,4,5,5,4,null,7]

## Example 2:
## *Ví dụ 2:*

**Input:** root1 = [1], root2 = [1,2]
**Output:** [2,2]

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in both trees is in the range `[0, 2000]`.
*   `-10^4 <= Node.val <= 10^4`
