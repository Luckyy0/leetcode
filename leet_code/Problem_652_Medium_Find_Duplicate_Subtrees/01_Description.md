# Result for Find Duplicate Subtrees
# *Kết quả cho bài toán Tìm các Cây con Trùng lặp*

## Description
## *Mô tả*

Given the `root` of a binary tree, return all **duplicate subtrees**.
*Cho gốc `root` của một cây nhị phân, hãy trả về tất cả các **cây con trùng lặp**.*

For each kind of duplicate subtrees, you only need to return the root node of any **one** of them.
*Đối với mỗi loại cây con trùng lặp, bạn chỉ cần trả về nút gốc của **một** trong số chúng.*

Two trees are **duplicate** if they have the **same structure** with the **same node values**.
*Hai cây được coi là **trùng lặp** nếu chúng có **cùng cấu trúc** với các **giá trị nút giống nhau**.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** root = [1,2,3,4,null,2,4,null,null,4]
**Output:** [[2,4],[4]]

## Example 2:
## *Ví dụ 2:*

**Input:** root = [2,1,1]
**Output:** [[1]]

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree will be in the range `[1, 5000]`.
*   `-200 <= Node.val <= 200`
