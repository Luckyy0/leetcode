# Result for Word Abbreviation
# *Kết quả cho bài toán Viết tắt Từ*

## Description
## *Mô tả*

Given an array of **distinct** strings `words`, return *the minimal possible abbreviations for every word*.
*Cho một mảng các chuỗi **phân biệt** `words`, hãy trả về *các từ viết tắt tối thiểu có thể cho mỗi từ*.*

The following are the rules for a string abbreviation:
1.  Begin with the first character, and then the number of characters abbreviated, which followed by the last character.
2.  If there are any conflict, that is more than one words share the same abbreviation, a longer prefix is used instead of only the first character until making the map from word to abbreviation become unique. In other words, a final abbreviation cannot map to more than one original words.
3.  If the abbreviation doesn't make the word shorter, then keep it as original.

*Sau đây là các quy tắc viết tắt chuỗi:*
1.  *Bắt đầu bằng ký tự đầu tiên, sau đó là số lượng ký tự được viết tắt, tiếp theo là ký tự cuối cùng.*
2.  *Nếu có bất kỳ xung đột nào, tức là nhiều hơn một từ có cùng từ viết tắt, một tiền tố dài hơn sẽ được sử dụng thay vì chỉ ký tự đầu tiên cho đến khi việc ánh xạ từ từ sang từ viết tắt trở nên duy nhất. Nói cách khác, một từ viết tắt cuối cùng không thể ánh xạ tới nhiều hơn một từ gốc.*
3.  *Nếu từ viết tắt không làm cho từ ngắn hơn, hãy giữ nguyên từ gốc.*

## Example 1:
## *Ví dụ 1:*

**Input:** `words = ["like","god","internal","me","internet","interval","intension","face","intrusion"]`
**Output:** `["l2e","god","internal","me","i6t","interval","inte4n","f2e","intr4n"]`

## Example 2:
## *Ví dụ 2:*

**Input:** `words = ["aa","aaa"]`
**Output:** `["aa","aaa"]`

## Constraints:
## *Ràng buộc:*

*   `1 <= words.length <= 400`
*   `2 <= words[i].length <= 400`
*   `words[i]` consists of lowercase English letters.
*   All the strings of `words` are **unique**.
