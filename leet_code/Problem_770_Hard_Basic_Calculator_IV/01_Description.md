# Result for Basic Calculator IV
# *Kết quả cho bài toán Máy tính Cơ bản IV*

## Description
## *Mô tả*

Given an expression such as `expression = "e + 8 - a + 5"` and an evaluation map such as `{"e": 1}` (given in terms of `evalvars` and `evalints`), return a list of strings representing the expression simplified.
*Cho một biểu thức chẳng hạn như `expression = "e + 8 - a + 5"` và một bản đồ đánh giá chẳng hạn như `{"e": 1}` (được cho dưới dạng `evalvars` và `evalints`), hãy trả về một danh sách các chuỗi đại diện cho biểu thức đã được đơn giản hóa.*

For example, for the above expression "e + 8 - a + 5" and evaluation map `{"e": 1}`, the simplified expression is "14 - a".
*Ví dụ, đối với biểu thức trên "e + 8 - a + 5" và bản đồ đánh giá `{"e": 1}`, biểu thức đã đơn giản hóa là "14 - a".*

*   Variables are given as strings of lowercase letters. Each variable has a coefficient.
*   The simplified expression should be a polynomial in terms of free variables.
*   Terms should be sorted by **degree** in descending order.
*   If degrees are equal, sort by **lexicographical order** of the variables (concatenation).
*   The output list should be formatted as strings, like `["-a", "14"]` for the example above.

*   *Các biến được cho dưới dạng chuỗi các chữ cái thường. Mỗi biến có một hệ số.*
*   *Biểu thức đơn giản hóa nên là một đa thức theo các biến tự do.*
*   *Các hạng tử nên được sắp xếp theo **bậc** giảm dần.*
*   *Nếu bậc bằng nhau, sắp xếp theo **thứ tự từ điển** của các biến (nối chuỗi).*
*   *Danh sách đầu ra nên được định dạng dưới dạng chuỗi, như `["-a", "14"]` cho ví dụ trên.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** expression = "e + 8 - a + 5", evalvars = ["e"], evalints = [1]
**Output:** ["-1*a","14"]

## Example 2:
## *Ví dụ 2:*

**Input:** expression = "e - 8 + 5", evalvars = ["e"], evalints = [1]
**Output:** ["-2"]

## Example 3:
## *Ví dụ 3:*

**Input:** expression = "(e + 8) * (e - 8)", evalvars = [], evalints = []
**Output:** ["1*e*e","-64"]

---

## Constraints:
## *Ràng buộc:*

*   `1 <= expression.length <= 250`
*   `expression` consists of digits, lowercase English letters, `'+'`, `'-'`, `'*'`, `'('`, `')'`, and `' '`.
*   `evalvars.length == evalints.length`
*   `1 <= evalvars.length <= 100`
