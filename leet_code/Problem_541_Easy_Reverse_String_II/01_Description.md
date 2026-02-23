# Result for Reverse String II
# *Kết quả cho bài toán Đảo ngược Chuỗi II*

## Description
## *Mô tả*

Given a string `s` and an integer `k`, reverse the first `k` characters for every `2k` characters counting from the start of the string.
*Cho một chuỗi `s` và một số nguyên `k`, hãy đảo ngược `k` ký tự đầu tiên cho mỗi `2k` ký tự tính từ đầu chuỗi.*

If there are fewer than `k` characters left, reverse all of them. If there are less than `2k` but greater than or equal to `k` characters, then reverse the first `k` characters and leave the other as original.
*Nếu còn ít hơn `k` ký tự, hãy đảo ngược tất cả chúng. Nếu còn ít hơn `2k` nhưng lớn hơn hoặc bằng `k` ký tự, thì hãy đảo ngược `k` ký tự đầu tiên và giữ nguyên các ký tự còn lại.*

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "abcdefg", k = 2`
**Output:** `"bacdfeg"`

## Example 2:
## *Ví dụ 2:*

**Input:** `s = "abcd", k = 2`
**Output:** `"bacd"`

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 10^4`
*   `s` consists of only lowercase English letters.
*   `1 <= k <= 10^4`
