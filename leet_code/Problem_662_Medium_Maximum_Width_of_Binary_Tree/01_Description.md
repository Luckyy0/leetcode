# Result for Maximum Width of Binary Tree
# *Kết quả cho bài toán Chiều rộng Tối đa của Cây Nhị phân*

## Description
## *Mô tả*

Given the `root` of a binary tree, return the **maximum width** of the given tree.
*Cho gốc `root` của một cây nhị phân, hãy trả về **chiều rộng tối đa** của cây đã cho.*

The **maximum width** of a tree is the maximum **width** among all levels.
*Chiểu rộng tối đa của một cây là chiều rộng lớn nhất trong tất cả các tầng.*

The **width** of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree of the same height are also counted into the length calculation.
*Chiều rộng của một tầng được định nghĩa là độ dài giữa các nút cuối (nút không null nằm ngoài cùng bên trái và ngoài cùng bên phải), trong đó các nút null ở giữa các nút cuối (những nút vốn sẽ tồn tại trong một cây nhị phân đầy đủ có cùng chiều cao) cũng được tính vào phép tính độ dài.*

It is **guaranteed** that the answer will in the range of a **32-bit** signed integer.
*Đáp án được **đảm bảo** sẽ nằm trong phạm vi số nguyên có dấu **32-bit**.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** root = [1,3,2,5,3,null,9]
**Output:** 4
**Explanation:** The maximum width exists in the third level with length 4 (5,3,null,9).

## Example 2:
## *Ví dụ 2:*

**Input:** root = [1,3,2,5,null,null,9,6,null,7]
**Output:** 7
**Explanation:** The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[1, 3000]`.
*   `-100 <= Node.val <= 100`
