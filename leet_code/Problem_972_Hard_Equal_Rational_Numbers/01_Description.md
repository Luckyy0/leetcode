# Result for Equal Rational Numbers
# *Kết quả cho bài toán Các Số Hữu tỉ Bằng nhau*

## Description
## *Mô tả*

Given two strings `s` and `t`, each of which represents a non-negative rational number, return `true` if and only if they represent the same number. The strings may use parentheses to denote the repeating part of the rational number.
*Cho hai chuỗi `s` và `t`, mỗi chuỗi biểu diễn một số hữu tỉ không âm, trả về `true` khi và chỉ khi chúng biểu diễn cùng một số. Các chuỗi có thể sử dụng dấu ngoặc đơn để biểu thị phần lặp lại của số hữu tỉ.*

A **rational number** can be represented using up to three parts: `<IntegerPart>`, `<NonRepeatingPart>`, and a `<RepeatingPart>`. The number will be represented in one of the following three ways:
*Một **số hữu tỉ** có thể được biểu diễn bằng tối đa ba phần: `<Phần Nguyên>`, `<Phần Không Lặp>`, và `<Phần Lặp>`. Số sẽ được biểu diễn theo một trong ba cách sau:*

1.  `<IntegerPart>` (e.g., `0`, `12`, `123`)
2.  `<IntegerPart><.><NonRepeatingPart>` (e.g., `0.5`, `1.`, `2.12`, `2.0001`)
3.  `<IntegerPart><.><NonRepeatingPart><(><RepeatingPart><)>` (e.g., `0.1(6)`, `1.(9)`, `123.45(678)`)

The size of repeating part is between `1` and `4`.
*Kích thước của phần lặp lại là từ `1` đến `4`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s = "0.(52)", t = "0.5(25)"
**Output:** true
**Explanation:** Because 0.(52) = 0.525252... and 0.5(25) = 0.52525252...

## Example 2:
## *Ví dụ 2:*

**Input:** s = "0.1666(6)", t = "0.166(66)"
**Output:** true

## Example 3:
## *Ví dụ 3:*

**Input:** s = "0.9(9)", t = "1."
**Output:** true
**Explanation:** 0.9(9) represents 0.9999... which equals 1. [This is a standard mathematical result 0.99... = 1]

---

## Constraints:
## *Ràng buộc:*

*   Each part consists only of digits.
*   The `<IntegerPart>` does not have a leading zero (except for the zero itself).
*   `1 <= <IntegerPart>.length <= 4`
*   `0 <= <NonRepeatingPart>.length <= 4`
*   `1 <= <RepeatingPart>.length <= 4`
