# Result for Shifting Letters
# *Kết quả cho bài toán Dịch chuyển Chữ cái*

## Description
## *Mô tả*

You are given a string `s` of lowercase English letters and an integer array `shifts` of the same length.
*Bạn được cho một chuỗi `s` gồm các chữ cái tiếng Anh viết thường và một mảng số nguyên `shifts` có cùng độ dài.*

Call the `shift()` of a letter, the next letter in the alphabet, (wrapping around so that `'z'` becomes `'a'`).
*Thao tác `shift()` một chữ cái là việc chuyển nó sang chữ cái tiếp theo trong bảng chữ cái (xoay vòng sao cho `'z'` trở thành `'a'`).*

For example, `shift('a') = 'b'`, `shift('t') = 'u'`, and `shift('z') = 'a'`.
*Ví dụ, `shift('a') = 'b'`, `shift('t') = 'u'`, và `shift('z') = 'a'`.*

Now for each `shifts[i] = x`, we want to shift the first `i + 1` characters of `s`, `x` times.
*Bây giờ, với mỗi `shifts[i] = x`, chúng ta muốn dịch chuyển `i + 1` ký tự đầu tiên của `s`, `x` lần.*

Return *the final string after all such shifts to `s` are applied*.
*Hãy trả về *chuỗi cuối cùng sau khi tất cả các lần dịch chuyển đó được áp dụng cho `s`*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s = "abc", shifts = [3,5,9]
**Output:** "rpl"
**Explanation:** We start with "abc".
After shifting the first 1 character of s by 3, we have "dbc".
After shifting the first 2 characters of s by 5, we have "igc".
After shifting the first 3 characters of s by 9, we have "rpl", which is the answer.

## Example 2:
## *Ví dụ 2:*

**Input:** s = "aaa", shifts = [1,2,3]
**Output:** "gfd"

---

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 10^5`
*   `s` consists of lowercase English letters.
*   `shifts.length == s.length`
*   `0 <= shifts[i] <= 10^9`
