# 208. Implement Trie (Prefix Tree) / Cài Đặt Trie (Cây Tiền Tố)

## Problem Description / Mô tả bài toán
A **Trie** (pronounced as "try") or **prefix tree** is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
Một **Trie** (phát âm là "try") hoặc **cây tiền tố** là cấu trúc dữ liệu cây được sử dụng để lưu trữ và truy xuất hiệu quả các khóa trong tập dữ liệu chuỗi. Có nhiều ứng dụng khác nhau của cấu trúc dữ liệu này, chẳng hạn như tự động hoàn thành và kiểm tra chính tả.

Implement the `Trie` class:
- `Trie()` Initializes the trie object.
- `void insert(String word)` Inserts the string `word` into the trie.
- `boolean search(String word)` Returns `true` if the string `word` is in the trie (i.e., was inserted before), and `false` otherwise.
- `boolean startsWith(String prefix)` Returns `true` if there is a previously inserted string `word` that has the prefix `prefix`, and `false` otherwise.

### Example 1:
```text
Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]
```

## Constraints / Ràng buộc
- `1 <= word.length, prefix.length <= 2000`
- `word` and `prefix` consist only of lowercase English letters.
- At most `3 * 10^4` calls in total will be made to `insert`, `search`, and `startsWith`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Trie Data Structure / Cấu trúc Dữ liệu Trie
A Trie node contains:
1.  **Children**: A mapping to child nodes (usually an array of size 26 for 'a'-'z').
2.  **IsEndOfWord**: A boolean flag to indicate if this node marks the end of a complete word.

**Operations**:
- **Insert**: Traverse down the tree, creating nodes if they don't exist. Mark start node's flag at end.
- **Search**: Traverse. If we hit a null link, return false. If we finish, check the flag.
- **StartsWith**: Traverse. If we hit a null link, return false. If we finish, return true regardless of flag.

---

## Analysis / Phân tích

### Approach: Standard Trie Node Implementation

**Complexity / Độ phức tạp**:
- **Time**: O(L) for Insert, Search, StartsWith where L is the length of the string.
- **Space**: O(N * L * Σ) where N is number of words, L is average length, Σ is alphabet size (26).

---

## Edge Cases / Các trường hợp biên
1.  **Empty string**: Usually not tested based on constraints (`>= 1`).
2.  **Prefix matching word**: "apple" exists, search "app" -> false, startsWith "app" -> true.
3.  **Word matching prefix**: insert "app", search "apple" -> false.
