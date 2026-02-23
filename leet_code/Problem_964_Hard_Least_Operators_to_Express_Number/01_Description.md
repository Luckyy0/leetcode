# Result for Least Operators to Express Number
# *Kết quả cho bài toán Toán tử Ít nhất để Biểu diễn Số*

## Description
## *Mô tả*

Given a single positive integer `x`, we will write an expression of the form `x (op1) x (op2) x (op3) x ...` where each operator `op1`, `op2`, etc. is either addition, subtraction, multiplication, or division (`+`, `-`, `*`, or `/`). For example, with `x = 3`, we might write `3 * 3 / 3 + 3 - 3` which is a value of `3`.
*Cho một số nguyên dương duy nhất `x`, chúng ta sẽ viết một biểu thức có dạng `x (op1) x (op2) x (op3) x ...` trong đó mỗi toán tử `op1`, `op2`, v.v. là phép cộng, phép trừ, phép nhân hoặc phép chia (`+`, `-`, `*`, hoặc `/`). Ví dụ, với `x = 3`, chúng ta có thể viết `3 * 3 / 3 + 3 - 3` có giá trị là `3`.*

When writing such an expression, we adhere to the following conventions:
*Khi viết một biểu thức như vậy, chúng ta tuân thủ các quy ước sau:*

1.  The division operator (`/`) returns rational numbers.
    *   *Toán tử chia (`/`) trả về số hữu tỉ.*
2.  There are no parentheses placed anywhere.
    *   *Không có dấu ngoặc đơn nào được đặt ở bất kỳ đâu.*
3.  We use the usual order of operations: multiplication and division happen before addition and subtraction.
    *   *Chúng ta sử dụng thứ tự phép toán thông thường: nhân và chia thực hiện trước cộng và trừ.*
4.  It is not allowed to use the unary negation operator (`-`). For example, "`x - x`" is a valid expression as it only uses subtraction, but "`-x + x`" is not because it uses negation.
    *   *Không được phép sử dụng toán tử phủ định một ngôi (`-`). Ví dụ, "`x - x`" là một biểu thức hợp lệ vì nó chỉ sử dụng phép trừ, nhưng "`-x + x`" không hợp lệ vì nó sử dụng phủ định.*

We would like to write an expression with the least number of operators such that the expression equals the given `target`. Return the least number of operators used.
*Chúng ta muốn viết một biểu thức với số lượng toán tử ít nhất sao cho biểu thức bằng `target` đã cho. Trả về số lượng toán tử ít nhất được sử dụng.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** x = 3, target = 19
**Output:** 5
**Explanation:** 3 * 3 + 3 * 3 + 3 / 3. The expression contains 5 operators.

## Example 2:
## *Ví dụ 2:*

**Input:** x = 5, target = 501
**Output:** 8
**Explanation:** 5 * 5 * 5 * 5 - 5 * 5 * 5 + 5 / 5. The expression contains 8 operators.

## Example 3:
## *Ví dụ 3:*

**Input:** x = 100, target = 100000000
**Output:** 3
**Explanation:** 100 * 100 * 100 * 100. The expression contains 3 operators.

---

## Constraints:
## *Ràng buộc:*

*   `2 <= x <= 100`
*   `1 <= target <= 2 * 10^8`
