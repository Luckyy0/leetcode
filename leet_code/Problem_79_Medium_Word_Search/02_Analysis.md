# Analysis for Word Search
# *Phân tích cho bài toán Tìm Từ*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** 2D board of characters, target `word`. *Bảng ký tự 2 chiều, chuỗi mục tiêu `word`.*
*   **Output:** Boolean (word exists or not). *Boolean (từ có tồn tại hay không).*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Board size up to 6x6 (very small).
*   Word length up to 15.
*   Cells cannot be reused in a single path.
*   *Kích thước bảng lên tới 6x6 (rất nhỏ).*
*   *Độ dài từ lên tới 15.*
*   *Các ô không được sử dụng lại trong cùng một đường đi.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Backtracking (DFS)
### *Hướng tiếp cận: Quay lui (DFS)*

*   **Intuition:** For each cell on the board, if it matches the first character of the word, start a Depth First Search (DFS) or backtracking. Explore neighbors (up, down, left, right) to find the next characters.
*   *Ý tưởng: Đối với mỗi ô trên bảng, nếu nó khớp với ký tự đầu tiên của từ, hãy bắt đầu Tìm kiếm theo chiều sâu (DFS) hoặc quay lui. Khám phá các ô lân cận (trên, dưới, trái, phải) để tìm các ký tự tiếp theo.*

*   **Algorithm Steps:**
    1.  Iterate `row`, `col` of board:
        *   If `board[row][col] == word[0]`:
            *   Start `backtrack(row, col, index = 0)`.
    2.  `backtrack(r, c, i)`:
        *   If `i == word.length`, return `true`.
        *   Check bounds and if `board[r][c] != word[i]`.
        *   Mark current cell as visited (e.g., `board[r][c] = '#'`).
        *   Explore 4 neighbors recursively.
        *   Unmark current cell (restore `board[r][c]`) to allow other paths.
    3.  Return `false` if no path found.

*   **Complexity:**
    *   Time: $O(M \cdot N \cdot 3^L)$ where $L$ is word length. (At each step, we have 3 choices).
    *   Space: $O(L)$ for recursion stack.

### Dry Run
### *Chạy thử*
`board = [["A","B"],["C","D"]], word = "AC"`
1. `(0,0)`: 'A' matches. Mark `(0,0)` visited.
2. Neighbors of `(0,0)`: `(0,1)` is 'B', `(1,0)` is 'C'.
3. `(1,0)` matches 'C'. Index reaches end. Return `true`.
---
*Quay lui cho phép chúng ta khám phá mọi cơ hội tiềm năng và quay lại nếu gặp ngõ cụt.*
Backtracking allows us to explore all potential opportunities and go back if we hit a dead end.
