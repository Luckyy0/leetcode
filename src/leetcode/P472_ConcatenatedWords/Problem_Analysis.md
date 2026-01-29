# 472. Concatenated Words / Các Từ Được Nối

## Problem Description / Mô tả bài toán
Given an array of strings `words` (**without duplicates**), return all the **concatenated words** in the given list of words.
Cho một mảng các chuỗi `words` (**không chứa phần tử trùng lặp**), hãy trả về tất cả các **từ được nối (concatenated words)** có trong danh sách.

A **concatenated word** is defined as a string that is comprised entirely of at least two shorter words in the given array.
Một **từ được nối** là một chuỗi được tạo thành hoàn toàn từ ít nhất hai từ ngắn hơn trong mảng đã cho.

### Example 1:
```text
Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats"; 
"dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
```

### Example 2:
```text
Input: words = ["cat","dog","catdog"]
Output: ["catdog"]
```

## Constraints / Ràng buộc
- `1 <= words.length <= 10^4`
- `1 <= words[i].length <= 30`
- `words[i]` consists of only lowercase English letters.
- All strings are **unique**.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Word Break Logic (Trie/Set + DFS) / Logic bẻ từ (Trie/Tập hợp + DFS)
This problem is essentially a variation of "Word Break". For each word, we check if it can be broken down into at least two other words already present in the collection.

Algorithm:
1. Store all words in a `HashSet` for O(1) lookup.
2. For each word `w`:
   - Use a recursive function `canForm(w, isOriginalWord)` to check if `w` can be split.
   - `canForm(sub, isOriginalWord)`:
     - Check if `sub` exists in memoization.
     - Iterate through split points `i` from 1 to `sub.length()`:
       - Prefix `p = sub.substring(0, i)`.
       - Suffix `s = sub.substring(i)`.
       - If `set.contains(p)`:
         - If `set.contains(s)` or `canForm(s, false)`, return `true`.
   - Add `w` to result if `canForm(w, true)` is true.

Optimization:
- Sort words by length. This allows us to only check shorter words for each candidate. (Actually, with a Set, sorting is not strictly necessary but can help pruning).

### Complexity / Độ phức tạp
- **Time**: O(N * L^3) where N is number of words and L is max length.
- **Space**: O(N * L).

---

## Analysis / Phân tích

### Approach: Recursive Word Splitting with Memoization

**Algorithm**:
1.  Populate HashSet.
2.  DFS with memoization for each word.
3.  Ensure at least two words are used.

---
