# Result for Binary Tree Pruning
# *Kết quả cho bài toán Cắt tỉa cây nhị phân*

## Description
## *Mô tả*

Given the `root` of a binary tree, return *the same tree where every subtree (of the given tree) not containing a `1` has been removed*.
*Cho `root` của một cây nhị phân, hãy trả về *chính cây đó sau khi mọi cây con (của cây đã cho) không chứa số `1` đã được loại bỏ*.*

A subtree of a node `node` is `node` plus every node that is a descendant of `node`.
*Cây con của một nút `node` là chính nút `node` cùng với tất cả các nút là hậu duệ của `node`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** root = [1,null,0,0,1]
**Output:** [1,null,0,null,1]
**Explanation:** 
Only the red nodes satisfy the property "every subtree not containing a 1".
The diagram on the right represents the answer.

## Example 2:
## *Ví dụ 2:*

**Input:** root = [1,0,1,0,0,0,1]
**Output:** [1,null,1,null,1]

## Example 3:
## *Ví dụ 3:*

**Input:** root = [1,1,0,1,1,0,1,0]
**Output:** [1,1,0,1,1,null,1]

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[1, 200]`.
*   `Node.val` is either `0` or `1`.
