# Result for Ambiguous Coordinates
# *Kết quả cho bài toán Tọa độ không rõ ràng*

## Description
## *Mô tả*

We had some 2-dimensional coordinates, like `"(1, 3)"` or `"(2, 0.5)"`. Then, we removed all commas, decimal points, and spaces and ended up with the string `s`.
*Chúng ta có một số tọa độ 2 chiều, như `"(1, 3)"` hoặc `"(2, 0.5)"`. Sau đó, chúng ta xóa tất cả dấu phẩy, dấu thập phân và khoảng trắng, kết quả là chuỗi `s`.*

*   For example, `"(1, 3)"` becomes `s = "(13)"` and `"(2, 0.5)"` becomes `s = "(205)"`.
*   *Ví dụ, `"(1, 3)"` trở thành `"(13)"` và `"(2, 0.5)"` trở thành `"(205)"`.*

Return *a list of strings representing all possibilities for what our original coordinates could have been*.
*Trả về *danh sách các chuỗi đại diện cho tất cả các khả năng tọa độ ban đầu có thể có*.*

Our original representation had a space after the comma, was enclosed by parentheses, and the comma was the only separator within the parentheses. Any allowed representation of a number never has leading zeros (except for `"0"` itself) or trailing zeros (after a decimal point).
*Biểu diễn ban đầu có một khoảng trắng sau dấu phẩy, được bao bởi dấu ngoặc đơn. Một số không bao giờ có các số 0 ở đầu (ngoại trừ chính số "0") hoặc số 0 ở cuối (sau dấu thập phân).*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s = "(123)"
**Output:** ["(1, 23)", "(1, 2.3)", "(12, 3)", "(1.2, 3)"]

## Example 2:
## *Ví dụ 2:*

**Input:** s = "(00011)"
**Output:** ["(0, 0.011)", "(0.001, 1)"]
**Explanation:** 0.0, 00, 0001 or 00.011 are not allowed.

## Example 3:
## *Ví dụ 3:*

**Input:** s = "(0123)"
**Output:** ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"]

---

## Constraints:
## *Ràng buộc:*

*   `4 <= s.length <= 12`
*   `s[0] == '('` and `s[s.length - 1] == ')'`.
*   The rest of `s` are digits.
