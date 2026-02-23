# Result for Word Break II
# *Kết quả cho bài toán Tách Từ II*

## Description
## *Mô tả*

Given a string `s` and a dictionary of strings `wordDict`, add spaces in `s` to construct a sentence where each word is a valid dictionary word. Return **all such possible sentences** in any order.
*Cho một chuỗi `s` và một từ điển các chuỗi `wordDict`, hãy thêm dấu cách vào `s` để tạo thành một câu trong đó mỗi từ là một từ hợp lệ trong từ điển. Hãy trả về **tất cả các câu khả thi như vậy** theo bất kỳ thứ tự nào.*

**Note** that the same word in the dictionary may be reused multiple times in the segmentation.
**Lưu ý** rằng cùng một từ trong từ điển có thể được tái sử dụng nhiều lần trong quá trình phân tách.

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]`
**Output:** `["cats and dog","cat sand dog"]`

## Example 2:
## *Ví dụ 2:*

**Input:** `s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]`
**Output:** `["pine apple pen apple","pineapple pen apple","pine applepen apple"]`
**Explanation:** Note that you are allowed to reuse a dictionary word.

## Example 3:
## *Ví dụ 3:*

**Input:** `s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]`
**Output:** `[]`

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 20`
*   `1 <= wordDict.length <= 1000`
*   `1 <= wordDict[i].length <= 10`
*   `s` and `wordDict[i]` consist of only lowercase English letters.
*   All the strings of `wordDict` are **unique**.
*   Input is generated such that the length of the answer is at most $10^5$.
