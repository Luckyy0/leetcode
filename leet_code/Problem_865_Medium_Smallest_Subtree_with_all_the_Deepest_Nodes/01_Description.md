# Result for Smallest Subtree with all the Deepest Nodes
# *Kết quả cho bài toán Cây con Nhỏ nhất chứa Tất cả các Nút Sâu nhất*

## Description
## *Mô tả*

Given the `root` of a binary tree, the depth of each node is the shortest distance to the root.
*Cho `root` của một cây nhị phân, độ sâu của mỗi nút là khoảng cách ngắn nhất đến gốc.*

Return *the smallest subtree such that it contains all the deepest nodes in the original tree*.
*Trả về *cây con nhỏ nhất sao cho nó chứa tất cả các nút sâu nhất trong cây ban đầu*.*

A node is called **deepest** if it has the largest depth possible among any node in the entire tree.
*Một nút được gọi là **sâu nhất** nếu nó có độ sâu lớn nhất có thể trong toàn bộ cây.*

The **subtree** of a node is a tree consisting of that node, plus all of its descendants.
*Cây con (subtree) của một nút là một cây bao gồm nút đó, cộng với tất cả các hậu duệ của nó.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** root = [3,5,1,6,2,0,8,null,null,7,4]
**Output:** [2,7,4]
**Explanation:** The deepest nodes in the tree are 7 and 4. The smallest subtree that contains both is the subtree rooted at 2.

## Example 2:
## *Ví dụ 2:*

**Input:** root = [1]
**Output:** [1]

## Example 3:
## *Ví dụ 3:*

**Input:** root = [0,1,3,null,2]
**Output:** [2]

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree will be in the range `[1, 500]`.
*   `0 <= Node.val <= 500`
*   The values of the nodes in the tree are **unique**.
