# Result for Design Add and Search Words Data Structure
# *Kết quả cho bài toán Thiết kế cấu trúc dữ liệu thêm và tìm kiếm từ*

## Description
## *Mô tả*

Design a data structure that supports adding new words and finding if a string matches any previously added string.
*Thiết kế một cấu trúc dữ liệu hỗ trợ thêm các từ mới và tìm xem một chuỗi có khớp với bất kỳ chuỗi nào đã được thêm trước đó hay không.*

Implement the `WordDictionary` class:
*Triển khai lớp `WordDictionary`:*

*   `WordDictionary()` Initializes the object.
    *`WordDictionary()` Khởi tạo đối tượng.*
*   `void addWord(word)` Adds `word` to the data structure, it can be matched later.
    *`void addWord(word)` Thêm `word` vào cấu trúc dữ liệu, nó có thể được khớp sau này.*
*   `boolean search(word)` Returns `true` if there is any string in the data structure that matches `word` or `false` otherwise. `word` may contain dots `'.'` where dots can be matched with any letter.
    *`boolean search(word)` Trả về `true` nếu có bất kỳ chuỗi nào trong cấu trúc dữ liệu khớp với `word` hoặc `false` nếu không. `word` có thể chứa dấu chấm `'.'`, trong đó dấu chấm có thể khớp với bất kỳ ký tự nào.*

## Example 1:
## *Ví dụ 1:*

**Input**
`["WordDictionary","addWord","addWord","addWord","search","search","search","search"]`
`[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]`
**Output**
`[null,null,null,null,false,true,true,true]`

**Explanation**
```
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
```

## Constraints:
## *Ràng buộc:*

*   `1 <= word.length <= 25`
*   `word` in `addWord` consists of lowercase English letters.
*   `word` in `search` consist of '.' or lowercase English letters.
*   There will be at most `2` dots in `word` for `search` queries.
*   At most `10^4` calls will be made to `addWord` and `search`.
