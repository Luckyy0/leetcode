# Result for Leaf-Similar Trees
# *Kết quả cho bài toán Cây có Lá Tương tự*

## Description
## *Mô tả*

Consider all the leaves of a binary tree. From left to right order, the values of those leaves form a **leaf value sequence**.
*Hãy xem xét tất cả các lá của một cây nhị phân. Theo thứ tự từ trái sang phải, giá trị của các lá đó tạo thành một **dãy giá trị lá**.*

For example, in the given tree `[3,5,1,6,2,9,8,null,null,7,4]`, the leaf value sequence is `(6, 7, 4, 9, 8)`.
*Ví dụ, trong cây đã cho, dãy giá trị lá là `(6, 7, 4, 9, 8)`.*

Two binary trees are considered **leaf-similar** if their leaf value sequence is the same.
*Hai cây nhị phân được coi là **có lá tương tự** nếu dãy giá trị lá của chúng giống nhau.*

Return `true` *if and only if the two given trees with heads `root1` and `root2` are leaf-similar*.
*Trả về `true` *nếu và chỉ nếu hai cây đã cho với đầu là `root1` và `root2` có lá tương tự*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
**Output:** true

## Example 2:
## *Ví dụ 2:*

**Input:** root1 = [1,2,3], root2 = [1,3,2]
**Output:** false

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in each tree will be in the range `[1, 200]`.
*   Both of the given trees will have values in the range `[0, 200]`.
