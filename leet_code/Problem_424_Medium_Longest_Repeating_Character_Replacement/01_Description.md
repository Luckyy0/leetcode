# Result for Longest Repeating Character Replacement
# *Kết quả cho bài toán Chuỗi con có Ký tự Lặp lại Dài nhất sau khi Thay thế*

## Description
## *Mô tả*

You are given a string `s` and an integer `k`. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most `k` times.
*Bạn được cho một chuỗi `s` và một số nguyên `k`. Bạn có thể chọn bất kỳ ký tự nào của chuỗi và thay đổi nó thành bất kỳ ký tự tiếng Anh viết hoa nào khác. Bạn có thể thực hiện thao tác này tối đa `k` lần.*

Return *the length of the longest substring containing the same letter you can get after performing the above operations*.
*Hãy trả về *độ dài của chuỗi con dài nhất chứa cùng một chữ cái mà bạn có thể nhận được sau khi thực hiện các phép toán trên*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "ABAB", k = 2`
**Output:** `4`
**Explanation:** Replace the two 'A's with two 'B's or vice versa.

## Example 2:
## *Ví dụ 2:*

**Input:** `s = "AABABBA", k = 1`
**Output:** `4`
**Explanation:** Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating character, which is 4.
There may exists other ways to achieve this answer too.

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 10^5`
*   `s` consists of only uppercase English letters.
*   `0 <= k <= s.length`
