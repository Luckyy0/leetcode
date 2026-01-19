# 126. Word Ladder II / Bậc Thang Từ II

## Problem Description / Mô tả bài toán
A **transformation sequence** from word `beginWord` to word `endWord` using a dictionary `wordList` is a sequence of words `beginWord -> s1 -> s2 -> ... -> sk` such that:
Một **chuỗi biến đổi** từ từ `beginWord` đến từ `endWord` sử dụng từ điển `wordList` là một chuỗi các từ `beginWord -> s1 -> s2 -> ... -> sk` sao cho:

- Every adjacent pair of words differs by a single letter.
- Mọi cặp từ liền kề khác nhau một chữ cái duy nhất.
- Every `si` for `1 <= i <= k` is in `wordList`.
- Mọi `si` với `1 <= i <= k` đều có trong `wordList`.
- `sk == endWord`.

Given two words, `beginWord` and `endWord`, and a dictionary `wordList`, return **all the shortest transformation sequences** from `beginWord` to `endWord`, or an empty list if no such sequence exists.
Cho hai từ `beginWord` và `endWord`, và một từ điển `wordList`, trả về **tất cả các chuỗi biến đổi ngắn nhất** từ `beginWord` đến `endWord`, hoặc một danh sách rỗng nếu không tồn tại chuỗi như vậy.

### Example 1:
```text
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
```

### Example 2:
```text
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: []
Explanation: endWord "cog" is not in wordList.
```

## Constraints / Ràng buộc
- `1 <= beginWord.length <= 5`
- `endWord.length == beginWord.length`
- `1 <= wordList.length <= 500`
- `wordList[i].length == beginWord.length`
- All words consist of lowercase English letters.
- `beginWord`, `endWord`, and all words in `wordList` are unique.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Graph Model / Mô hình Đồ thị
- **Nodes**: Words.
- **Edges**: Between words that differ by exactly one letter.
- **Goal**: Find ALL shortest paths from `beginWord` to `endWord`.

### Two-Phase Approach / Phương pháp Hai Giai đoạn

**Phase 1: BFS to Build Distance Map / BFS để Xây dựng Bản đồ Khoảng cách**
- BFS from `endWord` (or `beginWord`) to find shortest distance to each word.
- This gives us the "level" of each word in the shortest path.
- Also checks if path exists.

**Phase 2: DFS/Backtracking to Collect Paths / DFS/Quay lui để Thu thập Đường đi**
- Start from `beginWord`.
- Only move to words with `distance - 1` (getting closer to target).
- Collect all valid paths.

### Why BFS First? / Tại sao BFS Trước?
- BFS guarantees shortest path discovery.
- Distance map ensures DFS only follows optimal paths.
- Avoids exploring suboptimal routes.

---

## Analysis / Phân tích

### Approach: BFS + DFS Backtracking

**Algorithm**:
```
1. BFS from endWord to build distance map
2. If beginWord not reachable, return empty
3. DFS from beginWord:
   - At each step, only go to neighbors with distance - 1
   - When reaching endWord, add path to result
```

### Complexity / Độ phức tạp
- **Time**: O(N × L² × 26) for BFS + O(paths × L) for DFS.
- **Space**: O(N × L) for distance map and paths.

Where N = number of words, L = word length.

---

## Edge Cases / Các trường hợp biên
1.  **endWord not in wordList**: Return `[]`.
2.  **No path exists**: Return `[]`.
3.  **Multiple shortest paths**: Return all of them.
