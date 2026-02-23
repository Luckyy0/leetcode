# Result for Smallest String Starting From Leaf
# *Kết quả cho bài toán Chuỗi Nhỏ nhất Bắt đầu Từ Lá*

## Description
## *Mô tả*

You are given the `root` of a binary tree where each node has a value in the range `[0, 25]` representing the letters `'a'` to `'z'`.
*Bạn được cho `gốc` của một cây nhị phân trong đó mỗi nút có giá trị trong khoảng `[0, 25]` đại diện cho các chữ cái từ `'a'` đến `'z'`.*

Return *the **lexicographically smallest** string that starts at a leaf of this tree and ends at the root*.
*Trả về *chuỗi **nhỏ nhất theo thứ tự từ điển** bắt đầu từ một lá của cây này và kết thúc ở gốc*.*

As a reminder, any shorter prefix of a string is **lexicographically smaller**.
*Xin nhắc lại, bất kỳ tiền tố nào ngắn hơn của một chuỗi đều **nhỏ hơn theo thứ tự từ điển**.*

*   For example, `"ab"` is lexicographically smaller than `"aba"`.
    *   *Ví dụ, `"ab"` nhỏ hơn `"aba"` theo thứ tự từ điển.*

A leaf of a node is a node that has no children.
*Một lá của một nút là một nút không có con cái.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** root = [0,1,2,3,4,3,4]
**Output:** "dba"
**Explanation:** The smallest string starting from leaf to root is "dba", ending at the root which has value 0 ('a'). The leaf is valued 3 ('d'). 

## Example 2:
## *Ví dụ 2:*

**Input:** root = [25,1,3,1,3,0,2]
**Output:** "adz"

## Example 3:
## *Ví dụ 3:*

**Input:** root = [2,2,1,null,1,0,null,0]
**Output:** "abc"

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[1, 8500]`.
*   `0 <= Node.val <= 25`
