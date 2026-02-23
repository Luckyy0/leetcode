# Result for Construct Binary Tree from String
# *Kết quả cho bài toán Xây dựng Cây Nhị phân từ Chuỗi*

## Description
## *Mô tả*

You need to construct a binary tree from a string consisting of parenthesis and integers.
*Bạn cần xây dựng một cây nhị phân từ một chuỗi bao gồm dấu ngoặc đơn và các số nguyên.*

The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.
*Toàn bộ đầu vào đại diện cho một cây nhị phân. Nó chứa một số nguyên theo sau là không, một hoặc hai cặp dấu ngoặc đơn. Số nguyên đại diện cho giá trị của gốc và một cặp dấu ngoặc đơn chứa một cây nhị phân con có cùng cấu trúc.*

You always start to construct the **left** child node from the first parenthesis (if it exists). That is to say, the first pair of parenthesis (if it exists) is always the left child, and the second pair of parenthesis (if it exists) is always the right child.
*Bạn luôn bắt đầu xây dựng nút con **trái** từ dấu ngoặc đơn đầu tiên (nếu nó tồn tại). Điều đó có nghĩa là, cặp dấu ngoặc đơn đầu tiên (nếu nó tồn tại) luôn là con trái, và cặp dấu ngoặc đơn thứ hai (nếu nó tồn tại) luôn là con phải.*

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "4(2(3)(1))(6(5))"`
**Output:** `[4,2,6,3,1,5]`

## Example 2:
## *Ví dụ 2:*

**Input:** `s = "4(2(3)(1))(6(5)(7))"` - Wait, problem says zero/one/two pairs. Format is `Val(Left)(Right)`.
**Output:** `[4,2,6,3,1,5,7]`

## Example 3:
## *Ví dụ 3:*

**Input:** `s = "-4(2(3)(1))(6(5)(7))"`
**Output:** `[-4,2,6,3,1,5,7]`

## Constraints:
## *Ràng buộc:*

*   `0 <= s.length <= 3 * 10^4`
*   `s` consists of digits, `'+'`, `'-'`, `'('`, and `')'`.
*   The text inside the parenthesis is well-formed.
