# Result for Split BST
# *Kết quả cho bài toán Chia Cây Tìm kiếm Nhị phân*

## Description
## *Mô tả*

Given the `root` of a Binary Search Tree (BST) and an integer `target`, split the tree into two subtrees: one where all nodes are smaller than or equal to the `target`, and the other where all nodes are greater than the `target`.
*Cho `root` của một Cây Tìm kiếm Nhị phân (BST) và một số nguyên `target`, hãy chia cây thành hai cây con: một cây chứa tất cả các nút nhỏ hơn hoặc bằng `target`, và cây kia chứa tất cả các nút lớn hơn `target`.*

Return *an array of the two roots of the two subtrees*.
*Trả về *một mảng chứa hai nút gốc của hai cây con*.*

Note:
*   The BST definition holds: left subtree nodes < root, right subtree nodes > root.
*   The solution should preserve the relative structure of the nodes in the split subtrees.

*Lưu ý:*
*   *Định nghĩa BST vẫn giữ nguyên: các nút cây con trái < gốc, các nút cây con phải > gốc.*
*   *Giải pháp nên bảo tồn cấu trúc tương đối của các nút trong các cây con đã chia.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** root = [4,2,6,1,3,5,7], target = 2
**Output:** [[2,1],[4,3,6,null,null,5,7]]
**Explanation:**
Original tree:
      4
    /   \
   2     6
  / \   / \
 1   3 5   7

Split at target=2.
Less Equal: [2, 1] (Roots: 2, children: 1. 3 is > 2 so it moves to Greater).
Wait, 3 is > 2. It should go to the Greater tree.
Output roots:
Root 1 (<=2): Node 2, left 1. Right null.
Root 2 (>2): Node 4, left 3 (attached here?), right 6...
Actually, let's visualize the split recursively.

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[1, 50]`.
*   `0 <= Node.val, target <= 1000`.
