# Result for Minimum Add to Make Parentheses Valid
# *Kết quả cho bài toán Bổ sung Tối thiểu để Làm Hợp lệ Dấu ngoặc*

## Description
## *Mô tả*

A parentheses string is valid if and only if:
*Một chuỗi ngoặc là hợp lệ khi và chỉ khi:*

*   It is the empty string,
    *   *Nó là chuỗi rỗng,*
*   It can be written as `AB` (`A` concatenated with `B`), where `A` and `B` are valid strings, or
    *   *Nó có thể được viết dưới dạng `AB` (`A` nối với `B`), trong đó `A` và `B` là các chuỗi hợp lệ, hoặc*
*   It can be written as `(A)`, where `A` is a valid string.
    *   *Nó có thể được viết dưới dạng `(A)`, trong đó `A` là một chuỗi hợp lệ.*

You are given a parentheses string `s`. In one move, you can insert a parenthesis at any position of the string.
*Bạn được cho một chuỗi ngoặc `s`. Trong một bước, bạn có thể chèn một dấu ngoặc tại bất kỳ vị trí nào của chuỗi.*

*   For example, if `s = "()))"`, you can insert an opening parenthesis to be `"( ()))"` or a closing parenthesis to be `"( )))"`.
    *   *Ví dụ, nếu `s = "()))"`, bạn có thể chèn một dấu ngoặc mở để trở thành `"( ()))"` hoặc một dấu ngoặc đóng để trở thành `"( )))"`.*

Return *the minimum number of moves required to make `s` valid*.
*Hãy trả về *số bước di chuyển tối thiểu cần thiết để làm cho `s` hợp lệ*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s = "())"
**Output:** 1

## Example 2:
## *Ví dụ 2:*

**Input:** s = "((("
**Output:** 3

---

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 1000`
*   `s[i]` is either `'('` or `')'`.
