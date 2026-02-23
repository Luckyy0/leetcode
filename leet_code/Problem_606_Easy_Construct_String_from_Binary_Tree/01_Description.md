# Result for Construct String from Binary Tree
# *Kết quả cho bài toán Xây dựng Chuỗi từ Cây Nhị phân*

## Description
## *Mô tả*

Given the `root` of a binary tree, construct a string consisting of parenthesis and integers from a binary tree with the preorder traversal way, and return it.
*Cho `root` của một cây nhị phân, hãy xây dựng một chuỗi bao gồm các dấu ngoặc đơn và các số nguyên từ cây nhị phân bằng cách duyệt theo tiền thứ tự, và trả về chuỗi đó.*

Omit all the empty parenthesis pairs that do not affect the one-to-one mapping relationship between the string and the original binary tree.
*Loại bỏ tất cả các cặp dấu ngoặc đơn trống mà không làm ảnh hưởng đến mối quan hệ ánh xạ một-một giữa chuỗi và cây nhị phân ban đầu.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** root = [1,2,3,4]
**Output:** "1(2(4))(3)"
**Explanation:** Originally, it needs to be "1(2(4)())(3()())", but you need to omit all the unnecessary empty parenthesis pairs. And it will be "1(2(4))(3)".

## Example 2:
## *Ví dụ 2:*

**Input:** root = [1,2,3,null,4]
**Output:** "1(2()(4))(3)"
**Explanation:** Almost the same as the first example, except we cannot omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[1, 10^4]`.
*   `-1000 <= Node.val <= 1000`
