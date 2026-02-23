# Result for Shortest Word Distance III
# *Kết quả cho bài toán Khoảng cách từ ngắn nhất III*

## Description
## *Mô tả*

Given an array of strings `wordsDict` and two strings that already exist in the array `word1` and `word2`, return *the shortest distance between these two words in the list*.
*Cho một mảng các chuỗi `wordsDict` và hai chuỗi đã tồn tại trong mảng `word1` và `word2`, hãy trả về *khoảng cách ngắn nhất giữa hai từ này trong danh sách*.*

**Note that `word1` and `word2` may be the same**. It is guaranteed that they represent **two individual words** in the list.
*Lưu ý rằng `word1` và `word2` có thể giống nhau. Đảm bảo rằng chúng đại diện cho **hai từ riêng biệt** trong danh sách.*

## Example 1:
## *Ví dụ 1:*

**Input:** `wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"`
**Output:** `1`

## Example 2:
## *Ví dụ 2:*

**Input:** `wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "makes"`
**Output:** `3`

## Constraints:
## *Ràng buộc:*

*   `1 <= wordsDict.length <= 10^5`
*   `1 <= wordsDict[i].length <= 10`
*   `wordsDict[i]` consists of lowercase English letters.
*   `word1` and `word2` are in `wordsDict`.
