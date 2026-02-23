# Result for Find All Anagrams in a String
# *Kết quả cho bài toán Tìm tất cả các từ Đảo chữ trong một Chuỗi*

## Description
## *Mô tả*

Given two strings `s` and `p`, return *an array of all the start indices of `p`'s anagrams in `s`*. You may return the answer in **any order**.
*Cho hai chuỗi `s` và `p`, hãy trả về *một mảng chứa tất cả các chỉ số bắt đầu của các từ đảo chữ (anagrams) của `p` trong `s`*. Bạn có thể trả về câu trả lời theo **bất kỳ thứ tự nào**.*

An **Anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
*Một **Từ đảo chữ** (Anagram) là một từ hoặc cụm từ được tạo thành bằng cách sắp xếp lại các chữ cái của một từ hoặc cụm từ khác, thường sử dụng tất cả các chữ cái gốc đúng một lần.*

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "cbaebabacd", p = "abc"`
**Output:** `[0,6]`
**Explanation:**
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

## Example 2:
## *Ví dụ 2:*

**Input:** `s = "abab", p = "ab"`
**Output:** `[0,1,2]`
**Explanation:**
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length, p.length <= 3 * 10^4`
*   `s` and `p` consist of lowercase English letters.
