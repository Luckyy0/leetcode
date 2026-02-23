# Result for Satisfiability of Equality Equations
# *Kết quả cho bài toán Tính Thỏa mãn của Phương trình Đẳng thức*

## Description
## *Mô tả*

You are given an array of strings `equations` that represent relationships between variables where each string `equations[i]` is of length `4` and takes one of two different forms: `"x_{i}==y_{i}"` or `"x_{i}!=y_{i}"`.Here, `x_{i}` and `y_{i}` are lowercase letters (not necessarily different) that represent one-letter variable names.
*Bạn được cho một mảng các chuỗi `equations` thể hiện mối quan hệ giữa các biến trong đó mỗi chuỗi `equations[i]` có độ dài `4` và có một trong hai dạng khác nhau: `"x_{i}==y_{i}"` hoặc `"x_{i}!=y_{i}"`. Ở đây, `x_{i}` và `y_{i}` là các chữ cái viết thường (không nhất thiết phải khác nhau) đại diện cho các tên biến có độ dài một chữ cái.*

Return `true` *if it is possible to assign integers to variable names so as to satisfy all the given equations, or* `false` *otherwise*.
*Trả về `true` *nếu có thể gán các số nguyên cho tên biến sao cho đáp ứng tất cả các phương trình đã cho, hoặc* `false` *nếu ngược lại*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** equations = ["a==b","b!=a"]
**Output:** false
**Explanation:** If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.
There is no way to assign the variables to satisfy both equations.

## Example 2:
## *Ví dụ 2:*

**Input:** equations = ["b==a","a==b"]
**Output:** true
**Explanation:** We could assign a = 1 and b = 1 to satisfy both equations.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= equations.length <= 500`
*   `equations[i].length == 4`
*   `equations[i][0]` is a lowercase letter.
*   `equations[i][1]` is either `'='` or `'!'`.
*   `equations[i][2]` is `'='`.
*   `equations[i][3]` is a lowercase letter.
