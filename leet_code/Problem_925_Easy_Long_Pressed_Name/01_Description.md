# Result for Long Pressed Name
# *Kết quả cho bài toán Nhấn dài*

## Description
## *Mô tả*

Your friend is typing his `name` into a keyboard. Sometimes, when typing a character `c`, the key might get long pressed, and the character will be typed 1 or more times.
*Bạn của bạn đang gõ `name` (tên) của mình vào bàn phím. Đôi khi, khi gõ một ký tự `c`, phím có thể bị nhấn lâu và ký tự sẽ được gõ 1 hoặc nhiều lần.*

You examine the `typed` characters of the keyboard. Return `True` if it is possible that it was your friend's `name`, with some characters (possibly none) being long pressed.
*Bạn kiểm tra các ký tự `typed` (đã gõ) của bàn phím. Trả về `True` nếu có khả năng đó là `name` của bạn của bạn, với một số ký tự (có thể không có ký tự nào) bị nhấn lâu.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** name = "alex", typed = "aaleex"
**Output:** true
**Explanation:** 'a' and 'e' in 'alex' were long pressed.

## Example 2:
## *Ví dụ 2:*

**Input:** name = "saeed", typed = "ssaaedd"
**Output:** false
**Explanation:** 'e' must have been pressed twice, but it was not in the typed output.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= name.length, typed.length <= 1000`
*   `name` and `typed` consist of only lowercase English letters.
