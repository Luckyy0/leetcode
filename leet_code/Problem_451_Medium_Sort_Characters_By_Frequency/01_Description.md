# Result for Sort Characters By Frequency
# *Kết quả cho bài toán Sắp xếp Ký tự theo Tần suất*

## Description
## *Mô tả*

Given a string `s`, sort it in **decreasing order** based on the **frequency** of the characters. The **frequency** of a character is the number of times it appears in the string.
*Cho một chuỗi `s`, hãy sắp xếp nó theo **thứ tự giảm dần** dựa trên **tần suất** của các ký tự. **Tần suất** của một ký tự là số lần nó xuất hiện trong chuỗi.*

Return *the sorted string*. If there are multiple answers, return *any of them*.
*Trả về *chuỗi đã được sắp xếp*. Nếu có nhiều đáp án, hãy trả về *bất kỳ đáp án nào trong số đó*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "tree"`
**Output:** `"eert"`
**Explanation:** 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

## Example 2:
## *Ví dụ 2:*

**Input:** `s = "cccaaa"`
**Output:** `"aaaccc"`
**Explanation:** Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 5 * 10^5`
*   `s` consists of uppercase and lowercase English letters and digits.
