# Result for Fraction Addition and Subtraction
# *Kết quả cho bài toán Cộng và Trừ Phân số*

## Description
## *Mô tả*

Given a string `expression` representing an expression of fraction addition and subtraction, return the calculation result in string format.
*Cho một chuỗi `expression` đại diện cho một biểu thức cộng và trừ phân số, hãy trả về kết quả tính toán dưới dạng chuỗi.*

The final result should be an **irreducible fraction**. If your final result is an integer, say `2`, you need to change it to the format of a fraction that has a denominator `1`. So in this case, `2` should be converted to `2/1`.
*Kết quả cuối cùng nên là một **phân số tối giản**. Nếu kết quả cuối cùng là một số nguyên, ví dụ `2`, bạn cần chuyển nó sang định dạng phân số có mẫu số là `1`. Vì vậy, trong trường hợp này, `2` nên được chuyển thành `2/1`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** expression = "-1/2+1/2"
**Output:** "0/1"

## Example 2:
## *Ví dụ 2:*

**Input:** expression = "-1/2+1/2+1/3"
**Output:** "1/3"

## Example 3:
## *Ví dụ 3:*

**Input:** expression = "1/3-1/2"
**Output:** "-1/6"

---

## Constraints:
## *Ràng buộc:*

*   The input expression is a valid string of fractions.
*   The denominator for each fraction will be in the range `[1, 10]`.
*   The total number of fractions is in the range `[1, 10]`.
