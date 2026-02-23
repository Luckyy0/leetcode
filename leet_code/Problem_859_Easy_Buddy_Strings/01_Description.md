# Result for Buddy Strings
# *Kết quả cho bài toán Chuỗi Bạn bè*

## Description
## *Mô tả*

Given two strings `s` and `goal`, return `true` *if you can swap two letters in `s` so the result is equal to `goal`, otherwise, return `false`*.
*Cho hai chuỗi `s` và `goal`, hãy trả về `true` *nếu bạn có thể tráo đổi hai chữ cái trong `s` để kết quả bằng `goal`, ngược lại, trả về `false`*.*

Swapping letters is defined as taking two indices `i` and `j` (0-indexed) such that `i != j` and swapping the characters at `s[i]` and `s[j]`.
*Tráo đổi các chữ cái được định nghĩa là lấy hai chỉ số `i` và `j` sao cho `i != j` và tráo đổi các ký tự tại `s[i]` và `s[j]`.*

- For example, swapping at indices `0` and `2` in `"abcd"` results in `"cbad"`.

---

## Example 1:
## *Ví dụ 1:*

**Input:** s = "ab", goal = "ba"
**Output:** true
**Explanation:** You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.

## Example 2:
## *Ví dụ 2:*

**Input:** s = "ab", goal = "ab"
**Output:** false
**Explanation:** The only letters you can swap are s[0] = 'a' and s[1] = 'b', which results in "ba" != goal.

## Example 3:
## *Ví dụ 3:*

**Input:** s = "aa", goal = "aa"
**Output:** true
**Explanation:** You can swap s[0] = 'a' and s[1] = 'a' to get "aa", which is equal to goal.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length, goal.length <= 2 * 10^4`
*   `s` and `goal` consist of lowercase English letters.
