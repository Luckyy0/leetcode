# Result for Generalized Abbreviation
# *Kết quả cho bài toán Viết tắt Tổng quát*

## Description
## *Mô tả*

A word's **generalized abbreviation** can be constructed by taking any number of non-overlapping and non-adjacent substrings and replacing them with their respective lengths.
*Một **từ viết tắt tổng quát** của một từ có thể được xây dựng bằng cách lấy bất kỳ số lượng chuỗi con không chồng chéo và không liền kề nào và thay thế chúng bằng độ dài tương ứng của chúng.*

*   For example, `"abcde"` can be abbreviated into:
    *   `"a3e"` (`"bcd"` turned into `"3"`)
    *   `"1b1"` (`"a"` turned into `"1"` and `"c"` turned into `"1"`)
    *   `"5"` (`"abcde"` turned into `"5"`)
    *   `"abcde"` (no substrings replaced)
*   However, these abbreviations are **invalid**:
    *   `"23"` (`"ab"` turned into `"2"` and `"cde"` turned into `"3"`) is invalid as the substrings chosen are adjacent.

Given a string `word`, return *a list of all the possible **generalized abbreviations** of* `word`. Return the answer in **any order**.
*Cho một chuỗi `word`, hãy trả về *một danh sách tất cả các **từ viết tắt tổng quát** có thể có của* `word`. Trả về câu trả lời theo **bất kỳ thứ tự nào**.*

## Example 1:
## *Ví dụ 1:*

**Input:** `word = "word"`
**Output:** `["4","3d","2r1","2rd","1o2","1o1d","1or1","1ord","w3","w2d","w1r1","w1rd","wo2","wo1d","wor1","word"]`

## Example 2:
## *Ví dụ 2:*

**Input:** `word = "a"`
**Output:** `["1","a"]`

## Constraints:
## *Ràng buộc:*

*   `1 <= word.length <= 15`
*   `word` consists of only lowercase English letters.
