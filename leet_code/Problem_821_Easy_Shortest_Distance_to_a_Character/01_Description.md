# Result for Shortest Distance to a Character
# *Kết quả cho bài toán Khoảng cách ngắn nhất đến một ký tự*

## Description
## *Mô tả*

Given a string `s` and a character `c` that occurs in `s`, return *an array of integers `answer` where `answer.length == s.length` and `answer[i]` is the **distance** from index `i` to the **closest** occurrence of character `c` in `s`*.
*Cho một chuỗi `s` và một ký tự `c` xuất hiện trong `s`, hãy trả về *một mảng số nguyên `answer` trong đó `answer.length == s.length` và `answer[i]` là **khoảng cách** từ chỉ số `i` đến vị trí **gần nhất** của ký tự `c` trong `s`*.*

The **distance** between two indices `i` and `j` is `abs(i - j)`.
*Khoảng cách giữa hai chỉ số `i` và `j` là `abs(i - j)`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s = "loveleetcode", c = "e"
**Output:** [3,2,1,0,1,0,0,1,2,2,1,0]
**Explanation:** The character 'e' appears at indices 3, 5, 6, and 11 (0-indexed).
The closest occurrence of 'e' for index 0 is at index 3, so the distance is abs(0 - 3) = 3.
The closest occurrence of 'e' for index 1 is at index 3, so the distance is abs(1 - 3) = 2.
For index 4, there is a tie between the 'e' at index 3 and the 'e' at index 5, but the distance is still the same: abs(4 - 3) == abs(4 - 5) = 1.
The closest occurrence of 'e' for index 8 is at index 6, so the distance is abs(8 - 6) = 2.

## Example 2:
## *Ví dụ 2:*

**Input:** s = "aaab", c = "b"
**Output:** [3,2,1,0]

---

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 10^4`
*   `s[i]` and `c` are lowercase English letters.
*   It is guaranteed that `c` occurs at least once in `s`.
