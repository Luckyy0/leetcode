# 425. Word Squares / Hình Vuông Từ

## Problem Description / Mô tả bài toán
Given a set of words (without duplicates), find all **word squares** you can build from them.
Cho một tập hợp các từ (không trùng lặp), hãy tìm tất cả các **hình vuông từ** mà bạn có thể xây dựng từ chúng.

A sequence of words forms a valid word square if the `k-th` row and `k-th` column read the same string, where `0 <= k < max(numRows, numCols)`.
Một chuỗi các từ tạo thành một hình vuông từ hợp lệ nếu hàng thứ `k` và cột thứ `k` đọc giống hệt nhau.

For example, the word sequence `["ball","area","lead","lady"]` forms a word square because each word reads the same horizontally and vertically.
Ví dụ: `["ball","area","lead","lady"]` tạo thành một hình vuông từ:
```text
b a l l
a r e a
l e a d
l a d y
```

### Example:
```text
Input: words = ["area","ball","dear","lady","lead","yard"]
Output: [["ball","area","lead","lady"],["ball","area","lead","yard"]]
```

## Constraints / Ràng buộc
- `1 <= words.length <= 1000`
- `1 <= words[i].length <= 5`
- All words have the same length.
- `words[i]` consists of only lowercase English letters.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Backtracking with Trie / Quay lui với Trie
Building a word square row by row requires finding words that satisfy a prefix condition.
1. When we are at row `i`, the prefix required for the new word must match the characters already placed in column `i` by the previous rows `0, 1, ..., i-1`.
2. The required prefix is `square[0][i] + square[1][i] + ... + square[i-1][i]`.
3. A **Trie** can efficiently store the words and provide all words matching a given prefix.

Algorithm:
1. Build a Trie. Each node in the Trie should maintain a list of strings (`indexes` or `words`) that pass through that node (i.e., have that prefix).
2. Start backtracking from row 0. 
   - Row 0 can be any word from the dictionary.
   - For row `i > 0`, calculate the required prefix and find candidate words using the Trie.
   - Recursively try each candidate.

### Complexity / Độ phức tạp
- **Time**: O(N * 26^L) in worst case, where L is word length. However, the Trie significantly prunes the search space.
- **Space**: O(N * L) for the Trie.

---

## Analysis / Phân tích

### Approach: Prefix-Based Backtracking

**Algorithm**:
1.  Define `TrieNode` with a `wordsWithPrefix` list.
2.  Implement `Trie.insert()` and `Trie.search(prefix)`.
3.  Perform DFS/Backtracking.

---
