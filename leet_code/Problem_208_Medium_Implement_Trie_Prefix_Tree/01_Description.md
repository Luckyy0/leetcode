# Result for Implement Trie (Prefix Tree)
# *Kết quả cho bài toán Triển khai Trie (Cây tiền tố)*

## Description
## *Mô tả*

A [Trie](https://en.wikipedia.org/wiki/Trie) (pronounced as "try") or **prefix tree** is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
*Một [Trie](https://en.wikipedia.org/wiki/Trie) (phát âm là "try") hoặc **cây tiền tố** là một cấu trúc dữ liệu cây được sử dụng để lưu trữ và truy xuất khóa một cách hiệu quả trong một tập dữ liệu chuỗi. Có nhiều ứng dụng của cấu trúc dữ liệu này, chẳng hạn như tự động hoàn thành và kiểm tra chính tả.*

Implement the `Trie` class:
*Triển khai lớp `Trie`:*

*   `Trie()` Initializes the trie object.
    *`Trie()` Khởi tạo đối tượng trie.*
*   `void insert(String word)` Inserts the string `word` into the trie.
    *`void insert(String word)` Chèn chuỗi `word` vào trie.*
*   `boolean search(String word)` Returns `true` if the string `word` is in the trie (i.e., was inserted before), and `false` otherwise.
    *`boolean search(String word)` Trả về `true` nếu chuỗi `word` có trong trie (tức là đã được chèn trước đó), và `false` nếu không.*
*   `boolean startsWith(String prefix)` Returns `true` if there is a previously inserted string `word` that has the prefix `prefix`, and `false` otherwise.
    *`boolean startsWith(String prefix)` Trả về `true` nếu có một chuỗi `word` đã được chèn trước đó có tiền tố `prefix`, và `false` nếu không.*

## Example 1:
## *Ví dụ 1:*

**Input**
`["Trie", "insert", "search", "search", "startsWith", "insert", "search"]`
`[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]`
**Output**
`[null, null, true, false, true, null, true]`

**Explanation**
```
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
```

## Constraints:
## *Ràng buộc:*

*   `1 <= word.length, prefix.length <= 2000`
*   `word` and `prefix` consist only of lowercase English letters.
*   At most `3 * 10^4` calls in total will be made to `insert`, `search`, and `startsWith`.
