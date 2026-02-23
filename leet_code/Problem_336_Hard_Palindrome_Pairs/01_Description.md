# Result for Palindrome Pairs
# *Kết quả cho bài toán Cặp Palindrome*

## Description
## *Mô tả*

Given a list of **unique** words, return all the pairs of the **distinct** indices `(i, j)` in the given list, so that the concatenation of the two words `words[i] + words[j]` is a palindrome.
*Cho một danh sách các từ **duy nhất**, hãy trả về tất cả các cặp chỉ số **riêng biệt** `(i, j)` trong danh sách đã cho, sao cho sự nối của hai từ `words[i] + words[j]` là một palindrome (chuỗi đối xứng).*

## Example 1:
## *Ví dụ 1:*

**Input:** `words = ["abcd","dcba","lls","s","sssll"]`
**Output:** `[[0,1],[1,0],[3,2],[2,4]]`
**Explanation:** The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]

## Example 2:
## *Ví dụ 2:*

**Input:** `words = ["bat","tab","cat"]`
**Output:** `[[0,1],[1,0]]`
**Explanation:** The palindromes are ["battab","tabbat"]

## Example 3:
## *Ví dụ 3:*

**Input:** `words = ["a",""]`
**Output:** `[[0,1],[1,0]]`

## Constraints:
## *Ràng buộc:*

*   `1 <= words.length <= 5000`
*   `0 <= words[i].length <= 300`
*   `words[i]` consists of lower-case English letters.
