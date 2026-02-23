# Result for Decoded String at Index
# *Kết quả cho bài toán Chuỗi Giải mã tại Chỉ số*

## Description
## *Mô tả*

You are given an encoded string `s` and an integer `k`. To decode the string to a tape, the encoded string is read one character at a time and the following steps are taken:
*Bạn được cho một chuỗi đã mã hóa `s` và một số nguyên `k`. Để giải mã chuỗi vào một băng ghi, chuỗi đã mã hóa được đọc từng ký tự một và thực hiện các bước sau:*

- If the character read is a letter, that letter is written onto the tape.
*Nếu ký tự đọc được là một chữ cái, chữ cái đó sẽ được viết lên băng.*
- If the character read is a digit `d`, the entire current tape is repeatedly written `d - 1` more times in total.
*Nếu ký tự đọc được là một chữ số `d`, toàn bộ băng hiện tại sẽ được viết lặp lại thêm `d - 1` lần nữa.*

Given an integer `k`, return *the `k`-th letter (1-indexed) in the decoded string*.
*Cho một số nguyên `k`, hãy trả về *chữ cái thứ `k` (đánh chỉ số từ 1) trong chuỗi đã được giải mã*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s = "leet2code3", k = 10
**Output:** "o"
**Explanation:** The decoded string is "leetleetcodeleetleetcodeleetleetcode".
The 10th letter in the string is "o".

## Example 2:
## *Ví dụ 2:*

**Input:** s = "ha22", k = 5
**Output:** "h"
**Explanation:** The decoded string is "hahahaha".
The 5th letter is "h".

## Example 3:
## *Ví dụ 3:*

**Input:** s = "a2345678999999999999999", k = 1
**Output:** "a"
**Explanation:** The decoded string is "a" repeated 8301531247005483000 times.
The 1st letter is "a".

---

## Constraints:
## *Ràng buộc:*

*   `2 <= s.length <= 100`
*   `s` consists of lowercase English letters and digits `2` through `9`.
*   `s` starts with a letter.
*   `1 <= k <= 10^9`
*   It is guaranteed that `k` is less than or equal to the length of the decoded string.
*   The decoded string is guaranteed to have less than `2^63` characters.
