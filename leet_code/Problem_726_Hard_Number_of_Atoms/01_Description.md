# Result for Number of Atoms
# *Kết quả cho bài toán Số lượng Nguyên tử*

## Description
## *Mô tả*

Given a chemical `formula` (string), return the count of each atom.
*Cho một công thức hóa học `formula` (chuỗi), hãy trả về số lượng của mỗi nguyên tử.*

The atomic name begins with an uppercase character, followed by zero or more lowercase characters.
*Tên nguyên tử bắt đầu bằng một chữ cái viết hoa, theo sau bởi không hoặc nhiều chữ cái viết thường.*

One or more digits representing the count may follow if the count is greater than 1. If the count is 1, no digits will follow. For example, `H2O` and `H2O2` are possible, but `H1O2` is impossible.
*Một hoặc nhiều chữ số đại diện cho số lượng có thể theo sau nếu số lượng lớn hơn 1. Nếu số lượng là 1, sẽ không có chữ số đi kèm. Ví dụ, `H2O` và `H2O2` là có thể, nhưng `H1O2` thì không.*

Two formulas concatenated together to form another formula. For example, `H2O2He3Mg4` is also a formula.
*Hai công thức nối lại với nhau tạo thành một công thức khác. Ví dụ, `H2O2He3Mg4` cũng là một công thức.*

A formula placed in parentheses, and a count (optionally added) may follow. For example, `(H2O2)` and `(H2O2)3` are formulas.
*Một công thức đặt trong dấu ngoặc đơn, và một số lượng (tùy chọn) có thể theo sau. Ví dụ, `(H2O2)` và `(H2O2)3` là các công thức.*

Return the count of all elements as a string in the following form: the first name (in lexicographical order), followed by its count (if that count is more than 1), followed by the second name (in lexicographical order), followed by its count (if that count is more than 1), and so on.
*Hãy trả về số lượng của tất cả các nguyên tố dưới dạng một chuỗi theo mẫu sau: tên đầu tiên (theo thứ tự từ điển), theo sau là số lượng của nó (nếu số lượng lớn hơn 1), theo sau là tên thứ hai (theo thứ tự từ điển), tiếp theo là số lượng của nó (nếu số lượng lớn hơn 1), và cứ thế tiếp tục.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** formula = "H2O"
**Output:** "H2O"

## Example 2:
## *Ví dụ 2:*

**Input:** formula = "Mg(OH)2"
**Output:** "H2MgO2"
**Explanation:** The count of H is 2, Mg is 1, O is 2.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= formula.length <= 1000`
*   `formula` consists of English letters, digits, `(`, and `)`.
*   `formula` is a valid formula.
