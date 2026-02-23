# Result for Maximum Product of Word Lengths
# *Kết quả cho bài toán Tích Lớn nhất của Độ dài Từ*

## Description
## *Mô tả*

Given a string array `words`, return *the maximum value of* `length(word[i]) * length(word[j])` *where the two words do not share common letters*. If no such two words exist, return `0`.
*Cho một mảng chuỗi `words`, trả về *giá trị lớn nhất của* `length(word[i]) * length(word[j])` *trong đó hai từ không chia sẻ các chữ cái chung*. Nếu không tồn tại hai từ như vậy, trả về `0`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `words = ["abcw","baz","foo","bar","xtfn","abcdef"]`
**Output:** `16`
**Explanation:** The two words can be "abcw", "xtfn".

## Example 2:
## *Ví dụ 2:*

**Input:** `words = ["a","ab","abc","d","cd","bcd","abcd"]`
**Output:** `4`
**Explanation:** The two words can be "ab", "cd".

## Example 3:
## *Ví dụ 3:*

**Input:** `words = ["a","aa","aaa","aaaa"]`
**Output:** `0`
**Explanation:** No such pair of words.

## Constraints:
## *Ràng buộc:*

*   `2 <= words.length <= 1000`
*   `1 <= words[i].length <= 1000`
*   `words[i]` consists only of lowercase English letters.
