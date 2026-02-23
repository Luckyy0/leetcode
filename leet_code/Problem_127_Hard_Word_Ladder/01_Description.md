# Result for Word Ladder
# *Kết quả cho bài toán Tìm Thang Từ*

## Description
## *Mô tả*

A **transformation sequence** from word `beginWord` to word `endWord` using a dictionary `wordList` is a sequence of words `beginWord -> s1 -> s2 -> ... -> sk` such that:
*Một **chuỗi biến đổi** từ từ `beginWord` sang từ `endWord` sử dụng một từ điển `wordList` là một chuỗi các từ `beginWord -> s1 -> s2 -> ... -> sk` sao cho:*

*   Every adjacent pair of words differs by a single letter.
    *Mỗi cặp từ liền kề khác nhau đúng một chữ cái.*
*   Every `si` for `1 <= i <= k` is in `wordList`. (Note that `beginWord` does not need to be in `wordList`).
    *Mỗi `si` với `1 <= i <= k` đều nằm trong `wordList`. (Lưu ý rằng `beginWord` không nhất thiết phải nằm trong `wordList`).*
*   `sk == endWord`.
    *`sk == endWord`.*

Given two words, `beginWord` and `endWord`, and a dictionary `wordList`, return *the **number of words** in the shortest transformation sequence from `beginWord` to `endWord`, or `0` if no such sequence exists.*
*Cho hai từ, `beginWord` và `endWord`, và một từ điển `wordList`, hãy trả về *số lượng các từ** trong chuỗi biến đổi ngắn nhất từ `beginWord` sang `endWord`, hoặc `0` nếu không tồn tại chuỗi nào như vậy.*

## Example 1:
## *Ví dụ 1:*

**Input:** `beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]`
**Output:** `5`
**Explanation:** One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> "cog" which is 5 words long.

## Example 2:
## *Ví dụ 2:*

**Input:** `beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]`
**Output:** `0`
**Explanation:** The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.

## Constraints:
## *Ràng buộc:*

*   `1 <= beginWord.length <= 10`
*   `endWord.length == beginWord.length`
*   `1 <= wordList.length <= 5000`
*   `wordList[i].length == beginWord.length`
*   `beginWord`, `endWord`, and `wordList[i]` consist of lowercase English letters.
*   `beginWord != endWord`
*   All the words in `wordList` are **unique**.
