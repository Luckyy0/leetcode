# Result for Insert into a Binary Search Tree
# *Kết quả cho bài toán Chèn vào Cây Nhị phân Tìm kiếm*

## Description
## *Mô tả*

You are given the `root` node of a binary search tree (BST) and a `value` to insert into the tree. Return the `root` node of the BST after the insertion. It is **guaranteed** that the new value does not exist in the original BST.
*Bạn được cho nút `root` của một cây nhị phân tìm kiếm (BST) và một `value` để chèn vào cây. Hãy trả về nút `root` của BST sau khi chèn. Đảm bảo rằng giá trị mới không tồn tại trong BST ban đầu.*

Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return **any of them**.
*Lưu ý rằng có thể có nhiều cách chèn hợp lệ khác nhau, miễn là cây vẫn là BST sau khi chèn. Bạn có thể trả về **bất kỳ cách nào** trong số đó.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** root = [4,2,7,1,3], val = 5
**Output:** [4,2,7,1,3,5]
**Explanation:** Another accepted tree is: [5,2,7,1,3,null,null,null,null,null,4]

## Example 2:
## *Ví dụ 2:*

**Input:** root = [40,20,60,10,30,50,70], val = 25
**Output:** [40,20,60,10,30,50,70,null,null,25]

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree will be in the range `[0, 10^4]`.
*   `-10^8 <= Node.val <= 10^8`
*   All the values `Node.val` are **unique**.
*   `-10^8 <= val <= 10^8`
*   It's **guaranteed** that `val` does not exist in the original BST.
