# 127. Word Ladder / Bậc Thang Từ

## Problem Description / Mô tả bài toán
A **transformation sequence** from word `beginWord` to word `endWord` using a dictionary `wordList` is a sequence of words `beginWord -> s1 -> s2 -> ... -> sk` such that:
Một **chuỗi biến đổi** từ từ `beginWord` đến từ `endWord` sử dụng từ điển `wordList` là một chuỗi các từ `beginWord -> s1 -> s2 -> ... -> sk` sao cho:

- Every adjacent pair of words differs by a single letter.
- Mọi cặp từ liền kề khác nhau một chữ cái duy nhất.
- Every `si` for `1 <= i <= k` is in `wordList`.
- Mọi `si` với `1 <= i <= k` đều có trong `wordList`.
- `sk == endWord`.

Given two words, `beginWord` and `endWord`, and a dictionary `wordList`, return the **number of words** in the **shortest transformation sequence** from `beginWord` to `endWord`, or `0` if no such sequence exists.
Cho hai từ `beginWord` và `endWord`, và một từ điển `wordList`, trả về **số từ** trong **chuỗi biến đổi ngắn nhất** từ `beginWord` đến `endWord`, hoặc `0` nếu không tồn tại chuỗi như vậy.

### Example 1:
```text
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: "hit" -> "hot" -> "dot" -> "dog" -> "cog" (5 words)
```

### Example 2:
```text
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: endWord "cog" is not in wordList.
```

## Constraints / Ràng buộc
- `1 <= beginWord.length <= 10`
- `endWord.length == beginWord.length`
- `1 <= wordList.length <= 5000`
- `wordList[i].length == beginWord.length`
- All words consist of lowercase English letters.
- `beginWord` and `endWord` are not necessarily in `wordList`.
- All words in `wordList` are **unique**.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Comparison with Problem 126 / So sánh với Bài toán 126

| Problem | Output | Approach |
|---------|--------|----------|
| **126** | All shortest paths | BFS + DFS |
| **127** | Length of shortest path | **BFS only** |

### BFS for Shortest Path / BFS cho Đường đi Ngắn nhất
- BFS explores nodes level by level.
- First time we reach `endWord`, we've found the shortest path.
- **Key Theorem**: In an unweighted graph, BFS always finds the shortest path.

### Graph Model / Mô hình Đồ thị
- **Nodes**: Words.
- **Edges**: Undirected edges between words differing by exactly one letter.
- **Goal**: Shortest path from `beginWord` to `endWord`.

### Neighbor Generation / Tạo Các Láng giềng
For a word of length L:
Đối với một từ có độ dài L:
- For each position (L positions), try all 26 letters.
- Check if resulting word is in wordList.
- Alternative: Use wildcard patterns (e.g., "h*t" matches "hot", "hit").

---

## Analysis / Phân tích

### Approach: BFS / Tìm kiếm Theo Chiều Rộng

**Algorithm**:
```
1. If endWord not in wordList, return 0
2. Add beginWord to queue with distance 1
3. BFS:
   - For each word in queue:
     - If word == endWord, return distance
     - Generate all valid neighbors
     - Add unvisited neighbors to queue
4. Return 0 if endWord never reached
```

### Optimization: Bidirectional BFS / BFS Hai Chiều
- Start BFS from both beginWord and endWord.
- Meet in the middle.
- Reduces search space significantly.

### Complexity / Độ phức tạp
- **Time**: O(N × L² × 26) where N = words, L = word length.
- **Space**: O(N × L) for visited set and queue.

---

## Edge Cases / Các trường hợp biên
1.  **endWord not in wordList**: Return 0.
2.  **beginWord == endWord**: Return 1 (if endWord in list) or 0.
3.  **No path exists**: Return 0.
