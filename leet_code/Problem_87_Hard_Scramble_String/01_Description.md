# Result for Scramble String
# *Kết quả cho bài toán Chuỗi Xáo Trộn*

## Description
## *Mô tả*

We can scramble a string `s` to get a string `t` using the following algorithm:
*Chúng ta có thể xáo trộn một chuỗi `s` để có được một chuỗi `t` bằng thuật toán sau:*

1.  If the length of the string is 1, stop.
2.  If the length of the string is > 1, do the following:
    *   Split the string into two non-empty substrings at a random index, i.e., if the string is `s`, divide it to `x` and `y` where `s = x + y`.
    *   **Randomly** decide to swap the two substrings or to keep them in the same order. i.e., after this step, `s` may become `s = x + y` or `s = y + x`.
    *   Apply step 1 recursively on each of the two substrings `x` and `y`.

Given two strings `s1` and `s2` of the same length, return `true` if `s2` is a scrambled string of `s1`, otherwise, return `false`.
*Cho hai chuỗi `s1` và `s2` có cùng độ dài, hãy trả về `true` nếu `s2` là một chuỗi xáo trộn của `s1`, ngược lại, trả về `false`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `s1 = "great", s2 = "rgeat"`
**Output:** `true`
**Explanation:** One possible scenario:
"great" --> "gr" + "eat" // divide at index 2
"gr" --> "g" + "r" // divide index 1
"g" + "r" --> "r" + "g" // swap
"rgeat" --> "rg" + "eat" // merge

## Example 2:
## *Ví dụ 2:*

**Input:** `s1 = "abcde", s2 = "caebd"`
**Output:** `false`

## Example 3:
## *Ví dụ 3:*

**Input:** `s1 = "a", s2 = "a"`
**Output:** `true`

## Constraints:
## *Ràng buộc:*

*   `s1.length == s2.length`
*   `1 <= s1.length <= 30`
*   `s1` and `s2` consist of lowercase English letters.
