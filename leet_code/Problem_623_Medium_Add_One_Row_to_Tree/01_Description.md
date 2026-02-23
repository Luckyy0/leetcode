# Result for Add One Row to Tree
# *Kết quả cho bài toán Thêm một Hàng vào Cây*

## Description
## *Mô tả*

Given the `root` of a binary tree and two integers `val` and `depth`, add a row of nodes with value `val` at the given depth `depth`.
*Cho gốc `root` của một cây nhị phân và hai số nguyên `val` và `depth`, hãy thêm một hàng các nút có giá trị `val` tại độ sâu `depth` đã cho.*

Note that the `root` node is at depth `1`.
*Lưu ý rằng nút gốc `root` ở độ sâu `1`.*

The adding rule is:
*Quy tắc thêm là:*
- Given the integer `depth`, for each not null tree node `cur` at the depth `depth - 1`, create two tree nodes with value `val` as `cur`'s left subtree root and right subtree root.
- *Cho số nguyên `depth`, đối với mỗi nút cây khác null `cur` tại độ sâu `depth - 1`, hãy tạo hai nút cây mới có giá trị `val` làm gốc cây con bên trái và gốc cây con bên phải của `cur`.*
- `cur`'s original left subtree should be the left subtree of the new left subtree root.
- *Cây con bên trái ban đầu của `cur` nên là cây con bên trái của gốc cây con bên trái mới.*
- `cur`'s original right subtree should be the right subtree of the new right subtree root.
- *Cây con bên phải ban đầu của `cur` nên là cây con bên phải của gốc cây con bên phải mới.*
- If `depth == 1` that means there is no depth `depth - 1` at all, then create a tree node with value `val` as the new root of the whole original tree, and the original tree is the new root's left subtree.
- *Nếu `depth == 1`, điều đó có nghĩa là không có độ sâu `depth - 1` nào cả, thì hãy tạo một nút cây mới có giá trị `val` làm gốc mới của toàn bộ cây ban đầu, và cây ban đầu trở thành cây con bên trái của gốc mới.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** root = [4,2,6,3,1,5], val = 1, depth = 2
**Output:** [4,1,1,2,null,null,6,3,1,5]

## Example 2:
## *Ví dụ 2:*

**Input:** root = [4,2,null,3,1], val = 1, depth = 3
**Output:** [4,2,null,1,1,3,null,null,1]

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[1, 10^4]`.
*   The depth of the tree is in the range `[1, 10^4]`.
*   `-100 <= Node.val <= 100`
*   `-10^5 <= val <= 10^5`
*   `1 <= depth <= the depth of tree + 1`
