# Result for Check If Word Is Valid After Substitutions
# *Kết quả cho bài toán Kiểm tra xem Từ có Hợp lệ sau khi thay thế không*

## Description
## *Mô tả*

Given a string `s`, determine if it is **valid**.
*Cho một chuỗi `s`, xác định xem nó có **hợp lệ** hay không.*

A string `s` is **valid** if, starting with an empty string `t = ""`, you can transform `t` into `s` after performing the following operation **any number of times**:
*Một chuỗi `s` được coi là **hợp lệ** nếu, bắt đầu với một chuỗi rỗng `t = ""`, bạn có thể biến đổi `t` thành `s` sau khi thực hiện thao tác sau **bất kỳ số lần nào**:*

*   Insert string `"abc"` into any position in `t`. More formally, `t` becomes `t_{left} + "abc" + t_{right}`, where `t == t_{left} + t_{right}`. Note that `t_{left}` and `t_{right}` may be **empty**.
    *   *Chèn chuỗi `"abc"` vào bất kỳ vị trí nào trong `t`. Nói một cách trang trọng, `t` trở thành `t_{left} + "abc" + t_{right}`, trong đó `t == t_{left} + t_{right}`. Lưu ý rằng `t_{left}` và `t_{right}` có thể **rỗng**.*

Return `true` *if* `s` *is a **valid** string, otherwise, return* `false`.
*Trả về `true` *nếu* `s` *là một chuỗi **hợp lệ**, ngược lại, trả về* `false`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s = "aabcbc"
**Output:** true
**Explanation:** 
"" -> "abc" -> "aabcbc"
Thus, "aabcbc" is valid.

## Example 2:
## *Ví dụ 2:*

**Input:** s = "abcabcababcc"
**Output:** true
**Explanation:** 
"" -> "abc" -> "abcabc" -> "abcabcabc" -> "abcabcababcc"
Thus, "abcabcababcc" is valid.

## Example 3:
## *Ví dụ 3:*

**Input:** s = "abccba"
**Output:** false
**Explanation:** It is impossible to get "abccba" using the operation.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 2 * 10^4`
*   `s` consists of letters `'a'`, `'b'`, and `'c'`
