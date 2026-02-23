# Result for Clumsy Factorial
# *Kết quả cho bài toán Giai thừa Vụng về*

## Description
## *Mô tả*

The **factorial** of a positive integer `n` is the product of all positive integers less than or equal to `n`.
*Giai thừa của số nguyên dương `n` là tích của tất cả các số nguyên dương nhỏ hơn hoặc bằng `n`.*

We instead make a **clumsy factorial**: using the integers in decreasing order, we swap out the multiply operations for a fixed rotation of operations: multiply `'*'`, divide `'/'`, add `'+'`, and subtract `'-'` in this order.
*Thay vào đó, chúng ta tạo ra một hệ **Giai thừa vụng về**: sử dụng các số nguyên theo thứ tự giảm dần, chúng ta hoán đổi phép toán nhân lấy một chu kỳ các phép toán cố định: nhân `'*'`, chia `'/'`, cộng `'+'`, và trừ `'-'` theo đúng thứ tự này.*

For example, `clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1`.
*Ví dụ, `clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1`.*

However, these operations are still applied using the usual order of operations of arithmetic: we do all multiplication and division steps before any addition or subtraction steps, and multiplication and division steps are processed left to right.
*Tuy nhiên, các phép toán này vẫn được áp dụng theo thứ tự ưu tiên của số học thông thường: chúng ta thực hiện tất cả các phép nhân chia trước khi cộng trừ, và phép nhân chia được xử lý từ trái qua phải.*

Return *the clumsy factorial of* `n`.
*Trả về giai thừa vụng về của `n`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** n = 4
**Output:** 7
**Explanation:** 7 = 4 * 3 / 2 + 1

## Example 2:
## *Ví dụ 2:*

**Input:** n = 10
**Output:** 12
**Explanation:** 12 = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1

---

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 10^4`
