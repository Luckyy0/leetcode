# Result for Unique Substrings in Wraparound String
# *Kết quả cho bài toán Chuỗi con Duy nhất trong Chuỗi Vòng*

## Description
## *Mô tả*

We define the string `base` to be the infinite wraparound string of `"abcdefghijklmnopqrstuvwxyz"`, so `base` will look like this:
- `"...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd...."`

Given a string `s`, return *the number of **unique non-empty substrings** of `s` are present in `base`*.
*Cho một chuỗi `s`, hãy trả về *số lượng các **chuỗi con phi rỗng duy nhất** của `s` có mặt trong chuỗi `base`***.*

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "a"`
**Output:** `1`
**Explanation:** Only "a" is present in base.

## Example 2:
## *Ví dụ 2:*

**Input:** `s = "cac"`
**Output:** `2`
**Explanation:** There are two substrings "a", "c" of s in base.

## Example 3:
## *Ví dụ 3:*

**Input:** `s = "zab"`
**Output:** `6`
**Explanation:** Substrings "z", "a", "b", "za", "ab", "zab" are all present in base.

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 10^5`
*   `s` consists of lowercase English letters.
