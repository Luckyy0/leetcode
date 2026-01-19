# 79. Word Search / Tìm Kiếm Từ

## Problem Description / Mô tả bài toán
Given an `m x n` grid of characters `board` and a string `word`, return `true` if `word` exists in the grid.
Cho một lưới `m x n` các ký tự `board` và một chuỗi `word`, trả về `true` nếu `word` tồn tại trong lưới.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
Từ có thể được xây dựng từ các chữ cái của các ô liền kề tuần tự, trong đó các ô liền kề là láng giềng theo chiều ngang hoặc chiều dọc. Cùng một ô chữ cái không được sử dụng quá một lần.

### Example 1:
```text
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
```

### Example 2:
```text
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
```

### Example 3:
```text
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
```

## Constraints / Ràng buộc
- `m == board.length`
- `n = board[i].length`
- `1 <= m, n <= 6`
- `1 <= word.length <= 15`
- `board` and `word` consists of only lowercase and uppercase English letters.

---

## Analysis / Phân tích

### Approach: Backtracking (DFS) / Quay Lui (DFS)
- **Idea**: For every cell `(i, j)`, check if it matches the first character of `word`. If yes, start DFS to match the rest.
- **Ý tưởng**: Đối với mỗi ô `(i, j)`, kiểm tra xem nó có khớp với ký tự đầu tiên của `word` hay không. Nếu có, bắt đầu DFS để khớp phần còn lại.
- **DFS(i, j, index)**:
    - Base case: `index == word.length` -> True.
    - Check bounds and char match: If out of bounds or `board[i][j] != word[index]`, return False.
    - Mark `board[i][j]` as visited (e.g., replace with `#`).
    - Recurse neighbors: `DFS(i+1, j, index+1) || DFS(i-1, j, index+1) ...`
    - Backtrack: Restore `board[i][j]`.
- **Time Complexity**: O(M * N * 3^L), where L is word length. (Branching factor 3 because we don't go back to parent).
- **Space Complexity**: O(L) recursion stack.

---

## Edge Cases / Các trường hợp biên
1.  **Single Letter**: Board `[["a"]]`, word "a" -> true.
2.  **Not Found**: Return false.
3.  **Used Twice**: "ABCB" fails if B is reused incorrectly.
