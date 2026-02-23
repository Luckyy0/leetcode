# Result for Count The Repetitions
# *Kết quả cho bài toán Đếm số lần Lặp lại*

## Description
## *Mô tả*

We define `str = [s, n]` as the string `str` which consists of the string `s` concatenated `n` times.
- For example, `str = ["abc", 3] = "abcabcabc"`.

We define that string `s1` can be obtained from string `s2` if we can remove some characters from `s2` such that it becomes `s1`.
- For example, `s1 = "abc"` can be obtained from `s2 = "abdbec"` based on our definition by removing the bolded characters.

You are given two strings `s1` and `s2` and two integers `n1` and `n2`. You have the strings `str1 = [s1, n1]` and `str2 = [s2, n2]`.
*Bạn được cho hai chuỗi `s1`, `s2` và hai số nguyên `n1`, `n2`. Bạn có các chuỗi `str1 = [s1, n1]` và `str2 = [s2, n2]`.*

Return the maximum integer `m` such that `str2` concatenated `m` times can be obtained from `str1`.
*Hãy trả về số nguyên `m` lớn nhất sao cho chuỗi `str2` lặp lại `m` lần có thể thu được từ chuỗi `str1`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `s1 = "acb", n1 = 4, s2 = "ab", n2 = 2`
**Output:** `2`

## Example 2:
## *Ví dụ 2:*

**Input:** `s1 = "acb", n1 = 1, s2 = "acb", n2 = 1`
**Output:** `1`

## Constraints:
## *Ràng buộc:*

*   `1 <= s1.length, s2.length <= 100`
*   `s1` and `s2` consist of lowercase English letters.
*   `1 <= n1, n2 <= 10^6`
