# Result for Minimum ASCII Delete Sum for Two Strings
# *Kết quả cho bài toán Tổng ASCII nhỏ nhất khi xóa ký tự của Hai chuỗi*

## Description
## *Mô tả*

Given two strings `s1` and `s2`, return the lowest **ASCII sum** of deleted characters to make two strings equal.
*Cho hai chuỗi `s1` và `s2`, hãy trả về **tổng mã ASCII** thấp nhất của các ký tự cần xóa để làm cho hai chuỗi bằng nhau.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s1 = "sea", s2 = "eat"
**Output:** 231
**Explanation:** Deleting "s" from "sea" adds 115 (ASCII value of "s") to the sum.
Deleting "t" from "eat" adds 116 to the sum.
At the end, both strings are equal to "ea", and 115 + 116 = 231 is the minimum sum possible to achieve this.

## Example 2:
## *Ví dụ 2:*

**Input:** s1 = "delete", s2 = "leet"
**Output:** 403
**Explanation:** Deleting "dee" from "delete" to turn the string into "let", adds 100+101+101 to the sum.
Deleting "e" from "leet" adds 101 to the sum.
At the end, both strings are equal to "let", and 100+101+101+101 = 403 is the minimum sum possible to achieve this.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= s1.length, s2.length <= 1000`
*   `s1` and `s2` consist of lowercase English letters.
