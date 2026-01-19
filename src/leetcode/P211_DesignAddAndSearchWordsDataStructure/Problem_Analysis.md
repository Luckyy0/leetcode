# 211. Design Add and Search Words Data Structure / Thiết Kế Cấu Trúc Dữ Liệu Thêm và Tìm Kiếm Từ

## Problem Description / Mô tả bài toán
Design a data structure that supports adding new words and finding if a string matches any previously added string.
Thiết kế một cấu trúc dữ liệu hỗ trợ việc thêm các từ mới và tìm xem một chuỗi có khớp với bất kỳ chuỗi nào đã được thêm trước đó hay không.

Implement the `WordDictionary` class:
- `WordDictionary()` Initializes the object.
- `void addWord(word)` Adds `word` to the data structure, it can be matched later.
- `bool search(word)` Returns `true` if there is any string in the data structure that matches `word` or `false` otherwise. `word` may contain dots `'.'` where dots can be matched with any letter.

### Example 1:
```text
Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
```

## Constraints / Ràng buộc
- `1 <= word.length <= 25`
- `word` in `addWord` consists of lowercase English letters.
- `word` in `search` consist of '.' or lowercase English letters.
- At most `10^4` calls will be made to `addWord` and `search`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Trie with DFS / Trie kết hợp DFS
This problem is an extension of the Trie (Prefix Tree).
Bài toán này là phần mở rộng của Trie (Cây tiền tố).

**Standard Operations**:
- `addWord`: Same as standard Trie insertion.

**Pattern Matching with '.'**:
- Usually, we traverse the Trie following specific characters.
- When we encounter a `'.'`, we must explore **all** possible children of the current node.
- This implies a recursive **DFS** approach for the `search` function.

---

## Analysis / Phân tích

### Approach: Trie + Backtracking

**Algorithm**:
1.  **Insert**: Standard Trie insert.
2.  **Search**: `search(node, word, index)`
    - Base case: If `index == word.length`, return `node.isEndOfWord`.
    - If `char == '.'`: Iterate through all 26 children. If any recursive call returns true, return true.
    - If `char != '.'`: Check specific child. If null, return false. Else recurse.

### Complexity / Độ phức tạp
- **Time**:
    - `addWord`: O(L), where L is the length of the word.
    - `search`: Worst case O(26^L) if the word consists of only dots. However, for words with dots mixed with letters, it's faster.
- **Space**: O(N * L * 26) for the Trie storage.

---

## Edge Cases / Các trường hợp biên
1.  **Word with all dots**: Checks all paths of that length.
2.  **Empty Trie**: Search anything returns false.
3.  **Prefix**: Search "ba" when "bad" exists -> false (unless "ba" was also added).
