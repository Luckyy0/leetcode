# 212. Word Search II / Tìm Kiếm Từ II

## Problem Description / Mô tả bài toán
Given an `m x n` `board` of characters and a list of strings `words`, return all words on the board.
Cho một bảng ký tự `board` kích thước `m x n` và một danh sách các chuỗi `words`, hãy trả về tất cả các từ có trên bảng.

Each word must be constructed from letters of sequentially adjacent cells, where **adjacent cells** are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
Mỗi từ phải được tạo thành từ các chữ cái của các ô liền kề nhau theo trình tự, trong đó **các ô liền kề** là các ô lân cận theo chiều ngang hoặc chiều dọc. Ô chứa cùng một chữ cái không được sử dụng nhiều hơn một lần trong một từ.

### Example 1:
```text
Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
```

### Example 2:
```text
Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []
```

## Constraints / Ràng buộc
- `m == board.length`
- `n == board[i].length`
- `1 <= m, n <= 12`
- `board[i][j]` is a lowercase English letter.
- `1 <= words.length <= 3 * 10^4`
- `1 <= words[i].length <= 10`
- `words[i]` consists of lowercase English letters.
- All the strings of `words` are unique.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Trie + Backtracking (DFS) / Trie + Quay lui
This problem is a combination of **Graph Traversal (DFS)** and **Trie**.
- **Naive DFS**: For each word, do a DFS search on the board. This is too slow (`NumWords * M * N * 4^L`).
- **Optimized**: Build a Trie of all words. Perform DFS on the board **once**, trying to traverse the Trie simultaneously.

**State**:
- During DFS at `board[i][j]`, we check if `board[i][j]` exists as a child of the current Trie node.
- If yes, we move to that child and continue DFS to neighbors.
- If the child node marks `isEndOfWord`, we found a word!

**Pruning Optimization**:
- Once a word is found, we should remove it (or unmark it) to avoid duplicates.
- More aggressively, we can remove leaf nodes from the Trie to prune the search space dynamically.

---

## Analysis / Phân tích

### Approach: Trie-guided DFS

**Algorithm**:
1.  Construct a Trie and insert all `words`. Store the actual String at the leaf node for easy retrieval.
2.  Iterate through every cell `(i, j)` of the board.
3.  Call `dfs(i, j, root)`.
4.  **DFS(i, j, node)**:
    - Check boundaries and visited status (`#`).
    - Check if `current char` is a child of `node`. If not, return.
    - Move to `childNode`.
    - If `childNode.word` is not null, add to result and set `childNode.word = null` (deduplicate).
    - Mark `board[i][j] = '#'` (visited).
    - Recurse for 4 neighbors.
    - Backtrack: Restore `board[i][j]`.

### Complexity / Độ phức tạp
- **Time**: O(M * N * 4^L) in worst case (where L is max word length), but Trie pruning makes it much faster on average.
- **Space**: O(Sum of all word lengths) for Trie.

---

## Edge Cases / Các trường hợp biên
1.  **Multiple words starting same char**: Handled by Trie.
2.  **Palindromes / Backtracking**: Visited marking handles this.
3.  **No matching words**: Returns empty list.
4.  **Board small**: Constraint <= 12x12.
