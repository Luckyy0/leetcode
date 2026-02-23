# Result for Word Break
# *Kết quả cho bài toán Tách Từ*

## Description
## *Mô tả*

Given a string `s` and a dictionary of strings `wordDict`, return `true` if `s` can be segmented into a space-separated sequence of one or more dictionary words.
*Cho một chuỗi `s` và một từ điển các chuỗi `wordDict`, hãy trả về `true` nếu `s` có thể được phân tách thành một chuỗi các từ trong từ điển được ngăn cách bởi dấu cách.*

**Note** that the same word in the dictionary may be reused multiple times in the segmentation.
**Lưu ý** rằng cùng một từ trong từ điển có thể được tái sử dụng nhiều lần trong quá trình phân tách.

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "leetcode", wordDict = ["leet","code"]`
**Output:** `true`
**Explanation:** Return true because "leetcode" can be segmented as "leet code".

## Example 2:
## *Ví dụ 2:*

**Input:** `s = "applepenapple", wordDict = ["apple","pen"]`
**Output:** `true`
**Explanation:** Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.

## Example 3:
## *Ví dụ 3:*

**Input:** `s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]`
**Output:** `false`

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 300`
*   `1 <= wordDict.length <= 1000`
*   `1 <= wordDict[i].length <= 20`
*   `s` and `wordDict[i]` consist of only lowercase English letters.
*   All the strings of `wordDict` are **unique**.
