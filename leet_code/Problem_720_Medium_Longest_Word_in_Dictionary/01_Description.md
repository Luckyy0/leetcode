# Result for Longest Word in Dictionary
# *Kết quả cho bài toán Từ dài nhất trong Từ điển*

## Description
## *Mô tả*

Given an array of strings `words` representing an English Dictionary, return the longest word in `words` that can be built one character at a time by other words in `words`.
*Cho một mảng các chuỗi `words` đại diện cho một Từ điển tiếng Anh, hãy trả về từ dài nhất trong `words` mà có thể được xây dựng từng ký tự một bởi các từ khác trong `words`.*

If there is more than one possible answer, return the longest word with the smallest lexicographical order. If there is no answer, return the empty string.
*Nếu có nhiều hơn một câu trả lời khả thi, hãy trả về từ dài nhất có thứ tự từ điển nhỏ nhất. Nếu không có câu trả lời, hãy trả về chuỗi rỗng.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** words = ["w","wo","wor","worl","world"]
**Output:** "world"
**Explanation:** The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".

## Example 2:
## *Ví dụ 2:*

**Input:** words = ["a","banana","app","appl","ap","apply","apple"]
**Output:** "apple"
**Explanation:** Both "apple" and "apply" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".

---

## Constraints:
## *Ràng buộc:*

*   `1 <= words.length <= 1000`
*   `1 <= words[i].length <= 30`
*   `words[i]` consists of lowercase English letters.
