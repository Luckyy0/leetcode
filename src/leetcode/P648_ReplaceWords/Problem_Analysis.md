# 648. Replace Words / Thay Thế Từ

## Problem Description / Mô tả bài toán
In English, we have a concept called root, which can be followed by some other word to form another longer word - let's call this word successor. For example, when the root "an" is followed by the successor word "other", we can form a new word "another".
Trong tiếng Anh, chúng ta có một khái niệm gọi là gốc (root), có thể được theo sau bởi một từ khác để tạo thành một từ dài hơn khác - hãy gọi từ này là từ kế thừa. Ví dụ, khi gốc "an" được theo sau bởi từ kế thừa "other", chúng ta có thể tạo thành một từ mới "another".

Given a `dictionary` consisting of many roots and a `sentence` consisting of words separated by spaces, replace all the successors in the sentence with the root forming it. If a successor can be replaced by more than one root, replace it with the root that has the **shortest length**.
Cho một `từ điển` bao gồm nhiều gốc và một `câu` bao gồm các từ được phân tách bằng dấu cách, hãy thay thế tất cả các từ kế thừa trong câu bằng gốc tạo thành nó. Nếu một từ kế thừa có thể được thay thế bởi nhiều hơn một gốc, hãy thay thế nó bằng gốc có **độ dài ngắn nhất**.

Return the sentence after the replacement.
Trả về câu sau khi thay thế.

### Example 1:
```text
Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Trie / Set checking / Trie / Kiểm Tra Tập Hợp
We need to find the shortest prefix of a word that exists in the dictionary.
Approach 1: Trie.
Insert all roots into a Trie. Mark end of words.
For each word in sentence:
Traverse Trie. Return the prefix corresponding to the *first* marked end node encountered.
If no prefix found in Trie, return original word.

Approach 2: HashSet.
For each word `w`, check prefixes `w[0..1]`, `w[0..2]`, etc. in Set.
Since roots are generally short, this is effective. Trie is more optimal for many shared prefixes.

### Complexity / Độ phức tạp
- **Time**: O(N * L) where N is number of words in sentence, L is word length. Trie build O(D * L) where D is dictionary size.
- **Space**: O(D * L).

---

## Analysis / Phân tích

### Approach: Trie

**Algorithm**:
1.  Build Trie from dictionary. mark `isEnd`.
2.  Split sentence into words.
3.  Process each word: search shortest matching prefix in Trie.
4.  Reconstruct sentence.

---
