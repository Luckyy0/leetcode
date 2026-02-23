# Result for Minimum Unique Word Abbreviation
# *Kết quả cho bài toán Từ viết tắt Duy nhất Ngắn nhất*

## Description
## *Mô tả*

A string can be **abbreviated** by replacing any number of **non-empty** substrings with their lengths. The lengths should not have leading zeros.
*Một chuỗi có thể được **viết tắt** bằng cách thay thế bất kỳ số lượng chuỗi con **không trống** nào bằng độ dài của chúng. Độ dài không được có số 0 ở đầu.*

For example, a string such as `"substitution"` could be abbreviated as:
- `"s10n"` (`"s ubstitutio n"`)
- `"sub4u4"` (`"sub stit u tion"`)
- `"12"` (`"substitution"`)
- `"su3i1u2on"` (`"su bst i t u ti on"`)
- `"substitution"` (no substrings replaced)

Given a target string `target` and a dictionary of strings `dictionary`, return *the abbreviation of `target` with the **shortest possible length** such that it does not abbreviate any word in `dictionary`*. If there are multiple shortest abbreviations, return any of them.
*Cho một chuỗi mục tiêu `target` và một từ điển các chuỗi `dictionary`, hãy trả về *từ viết tắt của `target` có **độ dài ngắn nhất có thể** sao cho nó không viết tắt bất kỳ từ nào trong `dictionary`*. Nếu có nhiều từ viết tắt ngắn nhất, hãy trả về bất kỳ từ nào trong số đó.*

## Example 1:
## *Ví dụ 1:*

**Input:** `target = "apple", dictionary = ["blade"]`
**Output:** `"a4"`
**Explanation:** The shortest abbreviations of "apple" are "5" (length 1), then "a4", "4e", "ap3", etc. (length 2).
- "5" abbreviates "apple" and "blade".
- "a4" abbreviates "apple" but does not abbreviate "blade".
- Thus, "a4" is the shortest unique abbreviation.

## Example 2:
## *Ví dụ 2:*

**Input:** `target = "apple", dictionary = ["plain", "amber", "blade"]`
**Output:** `"1p1l1"`

## Constraints:
## *Ràng buộc:*

*   `target.length == m`
*   `dictionary.length == n`
*   `1 <= m <= 21`
*   `0 <= n <= 1000`
*   `1 <= dictionary[i].length <= 100`
*   If `dictionary[i].length != target.length`, it is impossible for `dictionary[i]` to match any abbreviation of `target`.
