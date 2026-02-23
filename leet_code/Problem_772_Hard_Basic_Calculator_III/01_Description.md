# Result for Basic Calculator III
# *Kết quả cho bài toán Máy tính Cơ bản III*

## Description
## *Mô tả*

Implement a basic calculator to evaluate a simple expression string.
*Thực hiện một máy tính cơ bản để đánh giá một chuỗi biểu thức đơn giản.*

The expression string contains only non-negative integers, `+`, `-`, `*`, `/` operators, and open `(` and closing parentheses `)`. The integer division should truncate toward zero.
*Chuỗi biểu thức chỉ chứa các số nguyên không âm, các toán tử `+`, `-`, `*`, `/`, và các dấu ngoặc mở `(` và đóng `)`. Phép chia số nguyên nên cắt bỏ phần thập phân về phía không.*

You may assume that the given expression is always valid. All intermediate results will be in the range of `[-2147483648, 2147483647]`.
*Bạn có thể giả định rằng biểu thức đã cho luôn hợp lệ. Tất cả các kết quả trung gian sẽ nằm trong khoảng `[-2147483648, 2147483647]`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s = "1+1"
**Output:** 2

## Example 2:
## *Ví dụ 2:*

**Input:** s = "6-4/2"
**Output:** 4

## Example 3:
## *Ví dụ 3:*

**Input:** s = "2*(5+5*2)/3+(6/2+8)"
**Output:** 21

---

## Constraints:
## *Ràng buộc:*

*   `1 <= s <= 10^4`
*   `s` consists of digits, `'+'`, `'-'`, `'*'`, `'/'`, `'('`, and `')'`.
*   `s` is a valid expression.
