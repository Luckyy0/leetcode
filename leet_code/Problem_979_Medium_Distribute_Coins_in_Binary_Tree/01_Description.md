# Result for Distribute Coins in Binary Tree
# *Kết quả cho bài toán Phân phối Tiền xu trong Cây Nhị phân*

## Description
## *Mô tả*

You are given the `root` of a binary tree with `n` nodes where each `node` in the tree has `node.val` coins. There are `n` coins in total throughout the whole tree.
*Bạn được cho `gốc` của một cây nhị phân với `n` nút, trong đó mỗi `nút` trong cây có `node.val` đồng xu. Có tổng cộng `n` đồng xu trong toàn bộ cây.*

In one move, we may choose two adjacent nodes and move one coin from one node to another. A move may be from parent to child, or from child to parent.
*Trong một lần di chuyển, chúng ta có thể chọn hai nút liền kề và chuyển một đồng xu từ nút này sang nút khác. Một lần di chuyển có thể từ cha sang con hoặc từ con sang cha.*

Return *the minimum number of moves required to make every node have exactly one coin*.
*Trả về *số lần di chuyển tối thiểu cần thiết để mỗi nút có đúng một đồng xu*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** root = [3,0,0]
**Output:** 2
**Explanation:** From the root of the tree, we move one coin to its left child, and one coin to its right child.

## Example 2:
## *Ví dụ 2:*

**Input:** root = [0,3,0]
**Output:** 3
**Explanation:** From the left child of the root, we move two coins to the root [taking two moves]. Then, we move one coin from the root of the tree to the right child.

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is `n`.
*   `1 <= n <= 100`
*   `0 <= Node.val <= n`
*   The sum of all `Node.val` is `n`.
