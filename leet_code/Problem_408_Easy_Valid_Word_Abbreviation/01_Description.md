# Result for Valid Word Abbreviation
# *Kết quả cho bài toán Xác thực từ Viết tắt Hợp lệ*

## Description
## *Mô tả*

A string can be **abbreviated** by replacing any number of **non-empty** substrings with their lengths. The lengths should not have leading zeros.
*Một chuỗi có thể được **viết tắt** bằng cách thay thế bất kỳ số lượng chuỗi con **không trống** nào bằng độ dài của chúng. Độ dài không được có số 0 ở đầu.*

For example, a string such as `"substitution"` could be abbreviated as:
*(Ví dụ, một chuỗi như `"substitution"` có thể được viết tắt thành:)*
- `"s10n"` (`"s ubstitutio n"`)
- `"sub4u4"` (`"sub stit u tion"`)
- `"12"` (`"substitution"`)
- `"su3i1u2on"` (`"su bst i t u ti on"`)
- `"substitution"` (no substrings replaced)

The following are **not** valid abbreviations:
*(Những trường hợp sau đây **không** phải là viết tắt hợp lệ:)*
- `"s010n"` (has leading zeros)
- `"s0filler"` (replaced empty substring)

Given a string `word` and an abbreviation `abbr`, return *whether the string matches the given abbreviation*.
*Cho một chuỗi `word` và một từ viết tắt `abbr`, hãy trả về *liệu chuỗi đó có khớp với từ viết tắt đã cho hay không*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `word = "internationalization", abbr = "i12iz4n"`
**Output:** `true`

## Example 2:
## *Ví dụ 2:*

**Input:** `word = "apple", abbr = "a2e"`
**Output:** `false`

## Constraints:
## *Ràng buộc:*

*   `1 <= word.length <= 20`
*   `word` consists of only lowercase English letters.
*   `1 <= abbr.length <= 10`
*   `abbr` consists of lowercase English letters and digits.
*   All the integers in `abbr` will fit in a 32-bit integer.
