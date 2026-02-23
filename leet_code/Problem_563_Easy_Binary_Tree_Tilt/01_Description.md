# Result for Binary Tree Tilt
# *Kết quả cho bài toán Độ nghiêng của Cây Nhị phân*

## Description
## *Mô tả*

Given the `root` of a binary tree, return *the sum of every tree node's **tilt***.
*Cho `root` của một cây nhị phân, hãy trả về *tổng **độ nghiêng** của mọi nút trong cây*.*

The **tilt** of a tree node is the **absolute difference** between the sum of all left subtree node values and all right subtree node values. If a node does not have a left child, then the sum of the left subtree node values is `0`. The rule is similar if the node does not have a right child.
***Độ nghiêng** của một nút cây là **giá trị tuyệt đối của hiệu** giữa tổng giá trị các nút của cây con bên trái và tổng giá trị các nút của cây con bên phải. Nếu một nút không có con trái, thì tổng giá trị cây con trái là `0`. Quy tắc tương tự nếu nút không có con phải.*

## Example 1:
## *Ví dụ 1:*

**Input:** `root = [1,2,3]`
**Output:** `1`
**Explanation:** 
Tilt of node 2 : |0-0| = 0
Tilt of node 3 : |0-0| = 0
Tilt of node 1 : |2-3| = 1
Sum of every tilt : 0 + 0 + 1 = 1

## Example 2:
## *Ví dụ 2:*

**Input:** `root = [4,2,9,3,5,null,7]`
**Output:** `15`

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[0, 10^4]`.
*   `-1000 <= Node.val <= 1000`
