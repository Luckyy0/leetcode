# Analysis for Longest Increasing Path in a Matrix
# *Phân tích cho bài toán Đường đi Tăng dài nhất trong Ma trận*

## 1. Problem Essence & DAG
## *1. Bản chất vấn đề & DAG*

### The Structure
### *Cấu trúc*
We want to find the longest path such that `A -> B` implies `val(A) < val(B)`.
Since it's strictly increasing, there are NO cycles.
The grid implicitly forms a Directed Acyclic Graph (DAG).
Problem is finding Longest Path in DAG.

### Strategy: DFS + Memoization
### *Chiến lược: DFS + Ghi nhớ*
Compute `dfs(r, c)`: length of longest increasing path starting at `(r, c)`.
`dfs(r, c) = 1 + max(dfs(neighbors) where neighbor > current)`.
If no valid neighbors, return 1.
Use `memo[r][c]` to store results to avoid re-computation.
Result: `max(dfs(r, c))` over all `r, c`.

---

## 2. Approach: DFS Memoization
## *2. Hướng tiếp cận: Ghi nhớ DFS*

### Logic
### *Logic*
1.  `cache[m][n]` init with 0.
2.  Loop `i`, `j`:
    - `maxLen = max(maxLen, dfs(i, j))`.
3.  `dfs(i, j)`:
    - If `cache[i][j] != 0` return it.
    - `currMax = 1`.
    - For `dir` in directions:
        - `nx, ny`. If valid and `matrix[nx][ny] > matrix[x][y]`:
            - `currMax = max(currMax, 1 + dfs(nx, ny))`.
    - `cache[i][j] = currMax`.
    - Return `currMax`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Avoid Cycles:** Strictly increasing condition ensures termination without `visited` set for recursion stack (though memo acts as visited for completed nodes).
    *Tránh chu trình: Điều kiện tăng nghiêm ngặt đảm bảo kết thúc mà không cần tập `visited` cho ngăn xếp đệ quy.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \cdot N)$. Each cell computed once.
    *Độ phức tạp thời gian: $O(M \cdot N)$.*
*   **Space Complexity:** $O(M \cdot N)$.
    *Độ phức tạp không gian: $O(M \cdot N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:**
9 9 4
6 6 8
2 1 1
Start e.g. at 2 (2,0):
Neighbors: 6 (1,0).
DFS(6): Neighbors 9 (0,0), 9 (0,1).
DFS(9): No greater neighbors. Return 1.
DFS(6) takes 1 + 1 = 2.
DFS(2) takes 1 + 2 = 3.
Wait, 1 (2,1) -> 2 (2,0) -> 6(1,0) -> 9(0,0). Length 4.
Global max will find this.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Standard DFS on Grid with Memoization.
*DFS tiêu chuẩn trên Lưới với Ghi nhớ.*
---
*Đôi khi cách duy nhất để đi xa hơn (longest path) là luôn vươn lên cao hơn (increasing). Những ai chấp nhận dậm chân tại chỗ hay đi lùi sẽ không bao giờ nhìn thấy đỉnh cao.*
Sometimes the only way to go further (longest path) is to always reach higher (increasing). Those who accept standing still or going backward will never see the peak.
