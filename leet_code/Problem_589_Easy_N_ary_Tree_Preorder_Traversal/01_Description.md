# Result for N-ary Tree Preorder Traversal
# *Kết quả cho bài toán Duyệt Tiền thứ tự Cây N-phân*

## Description
## *Mô tả*

Given the `root` of an n-ary tree, return the **preorder traversal** of its nodes' values.
*Cho gốc của một cây n-phân, hãy trả về **thứ tự duyệt tiền thứ tự** các giá trị của các nút trong cây.*

Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value.
*Việc tuần tự hóa đầu vào Cây n-phân được đại diện bằng cách duyệt theo mức. Mỗi nhóm con được tách biệt bởi giá trị null.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** root = [1,null,3,2,4,null,5,6]
**Output:** [1,3,5,6,2,4]

## Example 2:
## *Ví dụ 2:*

**Input:** root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
**Output:** [1,2,3,6,7,11,14,4,8,12,5,9,13,10]

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[0, 104]`.
*   `0 <= Node.val <= 104`
*   The height of the n-ary tree is less than or equal to `1000`.

## Follow up:
Recursive solution is trivial, could you do it iteratively?
*Giải pháp đệ quy là hiển nhiên, bạn có thể giải nó bằng cách lặp không?*
