# Result for Remove Outermost Parentheses
# *Kết quả cho bài toán Xóa Dấu Ngoặc Đơn Lớp Ngoài Cùng*

## Description
## *Mô tả*

A valid parentheses string is either empty `""`, `"(" + A + ")"`, or `A + B`, where `A` and `B` are valid parentheses strings, and `+` represents string concatenation.
*Một chuỗi dấu ngoặc đơn hợp lệ là chuỗi rỗng `""`, `"(" + A + ")"`, hoặc `A + B`, trong đó `A` và `B` là các chuỗi dấu ngoặc đơn hợp lệ, và `+` biểu thị phép nối chuỗi.*

*   For example, `""`, `"()"`, `"(())()"`, and `"(()(()))"` are all valid parentheses strings.
    *   *Ví dụ, `""`, `"()"`, `"(())()"`, và `"(()(()))"` đều là chuỗi dấu ngoặc đơn hợp lệ.*

A valid parentheses string `s` is primitive if it is nonempty, and there does not exist a way to split it into `s = A + B`, with `A` and `B` nonempty valid parentheses strings.
*Một chuỗi dấu ngoặc đơn hợp lệ `s` được gọi là nguyên thủy (primitive) nếu nó không rỗng và không có cách nào chia nó thành `s = A + B`, với `A` và `B` là các chuỗi dấu ngoặc hợp lệ không rỗng.*

Given a valid parentheses string `s`, consider its primitive decomposition: `s = P_1 + P_2 + ... + P_k`, where `P_i` are primitive valid parentheses strings.
*Cho một chuỗi dấu ngoặc hợp lệ `s`, xét quá trình phân rã nguyên thủy của nó: `s = P_1 + P_2 + ... + P_k`, trong đó mỗi `P_i` là một chuỗi dấu ngoặc hợp lệ nguyên thủy.*

Return `s` *after removing the outermost parentheses of every primitive string in the primitive decomposition*.
*Trả về chuỗi `s` sau khi loại bỏ dấu ngoặc đơn lớp ngoài cùng của mỗi chuỗi nguyên thủy trong đợt phân rã nguyên thủy.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s = "(()())(())"
**Output:** "()()()"
**Explanation:** 
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
*Giải thích: Phân rã "(()())(())" thành hai mảng lõi cứng: "(()())" và "(())". Bóc vỏ ngoài của khối lõi đầu tuột ra "()()", vỏ khối lõi sau tuột ra "()". Ráp lại thành "()()()".*

## Example 2:
## *Ví dụ 2:*

**Input:** s = "(()())(())(()(()))"
**Output:** "()()()()(())"
**Explanation:** 
The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".

## Example 3:
## *Ví dụ 3:*

**Input:** s = "()()"
**Output:** ""
**Explanation:** 
The input string is "()()", with primitive decomposition "()" + "()".
After removing outer parentheses of each part, this is "" + "" = "".
*Giải thích: Đập nát lớp ngoài cùng của "()" thì chỉ còn mảnh hư vô "".*

---

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 10^5`
*   `s[i]` is either `'('` or `')'`.
*   `s` is a valid parentheses string.
