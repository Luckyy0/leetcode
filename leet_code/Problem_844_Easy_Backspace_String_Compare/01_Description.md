# Result for Backspace String Compare
# *Kết quả cho bài toán So sánh Chuỗi có Dấu xóa ngược*

## Description
## *Mô tả*

Given two strings `s` and `t`, return `true` *if they are equal when both are typed into empty text editors*. `'#'` means a backspace character.
*Cho hai chuỗi `s` và `t`, hãy trả về `true` *nếu chúng bằng nhau khi cả hai được nhập vào các trình soạn thảo văn bản trống*. `'#'` tượng trưng cho phím xóa ngược (backspace).*

Note that after backspacing an empty text, the text will continue empty.
*Lưu ý rằng sau khi xóa ngược một văn bản trống, văn bản đó sẽ vẫn tiếp tục trống.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s = "ab#c", t = "ad#c"
**Output:** true
**Explanation:** Both s and t become "ac".

## Example 2:
## *Ví dụ 2:*

**Input:** s = "ab##", t = "c#d#"
**Output:** true
**Explanation:** Both s and t become "".

## Example 3:
## *Ví dụ 3:*

**Input:** s = "a#c", t = "b"
**Output:** false
**Explanation:** s becomes "c" while t becomes "b".

---

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length, t.length <= 200`
*   `s` and `t` only contain lowercase letters and `'#'` characters.

---

## Follow up:
Can you solve it in `O(n)` time and `O(1)` space?
*Bạn có thể giải quyết nó trong thời gian `O(n)` và không gian `O(1)` không?*
