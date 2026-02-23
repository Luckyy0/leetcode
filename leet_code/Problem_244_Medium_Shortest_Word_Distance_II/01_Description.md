# Result for Shortest Word Distance II
# *Kết quả cho bài toán Khoảng cách từ ngắn nhất II*

## Description
## *Mô tả*

Design a data structure that will be initialized with a string array, and then it should answer queries of the shortest distance between two different strings from the array.
*Thiết kế một cấu trúc dữ liệu được khởi tạo với một mảng chuỗi, và sau đó nó sẽ trả lời các truy vấn về khoảng cách ngắn nhất giữa hai chuỗi khác nhau từ mảng.*

Implement the `WordDistance` class:
*Triển khai lớp `WordDistance`:*

*   `WordDistance(String[] wordsDict)` initializes the object with the strings array `wordsDict`.
*   `int shortest(String word1, String word2)` returns the shortest distance between `word1` and `word2`.

## Example 1:
## *Ví dụ 1:*

**Input**
`["WordDistance", "shortest", "shortest"]`
`[[["practice", "makes", "perfect", "coding", "makes"]], ["coding", "practice"], ["makes", "coding"]]`
**Output**
`[null, 3, 1]`

**Explanation**
```
WordDistance wordDistance = new WordDistance(["practice", "makes", "perfect", "coding", "makes"]);
wordDistance.shortest("coding", "practice"); // return 3
wordDistance.shortest("makes", "coding");    // return 1
```

## Constraints:
## *Ràng buộc:*

*   `1 <= wordsDict.length <= 3 * 10^4`
*   `1 <= wordsDict[i].length <= 10`
*   `wordsDict[i]` consists of lowercase English letters.
*   `word1` and `word2` are in `wordsDict`.
*   `word1 != word2`.
*   At most `5000` calls will be made to `shortest`.
