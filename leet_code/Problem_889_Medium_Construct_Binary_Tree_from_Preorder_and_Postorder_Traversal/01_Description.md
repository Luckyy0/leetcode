# Result for Construct Binary Tree from Preorder and Postorder Traversal
# *Kết quả cho bài toán Xây dựng Cây Nhị phân từ Duyệt Tiền thứ tự và Hậu thứ tự*

## Description
## *Mô tả*

Given two integer arrays, `preorder` and `postorder` where `preorder` is the preorder traversal of a binary tree of distinct values and `postorder` is the postorder traversal of the same tree, reconstruct and return the binary tree.
*Cho hai mảng số nguyên `preorder` và `postorder`, trong đó `preorder` là duyệt tiền thứ tự (preorder) của một cây nhị phân gồm các giá trị riêng biệt và `postorder` là duyệt hậu thứ tự (postorder) của cùng một cây, hãy xây dựng lại và trả về cây nhị phân đó.*

If there exist multiple answers, you can **return any** of them.
*Nếu tồn tại nhiều câu trả lời, bạn có thể **trả về bất kỳ** cái nào trong số đó.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
**Output:** [1,2,3,4,5,6,7]
**Explanation:** 
Root is 1.
Left child of 1 is 2. Right child is 3.
Left child of 2 is 4 (and 5?). Wait.
Pre: 1, 2, 4, 5... Post: 4, 5, 2...
So 2 is parent of 4 and 5.
3 is parent of 6 and 7.

## Example 2:
## *Ví dụ 2:*

**Input:** preorder = [1], postorder = [1]
**Output:** [1]

---

## Constraints:
## *Ràng buộc:*

*   `1 <= preorder.length <= 30`
*   `preorder.length == postorder.length`
*   `preorder` and `postorder` consist of distinct values.
*   It is guaranteed that `preorder` and `postorder` are strictly valid traversals of a binary tree.
