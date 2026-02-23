# Analysis for Zuma Game
# *Phân tích cho bài toán Trò chơi Zuma*

## 1. Problem Essence & State Space Search
## *1. Bản chất vấn đề & Tìm kiếm Không gian Trạng thái*

### The Challenge
### *Thách thức*
Clearing a board using limited balls in hand. The complexity arises from the **chain reactions** (cascading removals) and the vast number of possible insertion points.
- Board length up to 16, Hand up to 5.
- Seems small, but branching factor is large if we consider every index.

### Strategy: DFS / BFS with Memoization
### *Chiến lược: DFS / BFS với Ghi nhớ*

1.  **State:** `(board, hand)`. Since hand is small, we can represent hand as a sorted string or hash map of counts.
2.  **Transitions:**
    - Iterate through the `board`. Identify groups of consecutive same-colored balls.
    - Try to add balls from `hand` to complete a group of 3+.
        - Note: You *could* insert a ball anywhere, but optimal moves usually involve completing existing groups or setting up a cascade.
        - Pruning: Only trying to insert a ball `C` next to another `C` on the board (to make a pair or triple) covers most optimal cases. Actually, checking insertion at `i` where `board[i] == ball` is sufficient.
    - Update board (handle chain reaction removals).
    - Recurse with new board and reduced hand.
3.  **Optimization (Pruning):**
    - **Hand Count:** Store hand as frequency map (e.g., `R:2, B:1`).
    - **Consecutive Insertion:** If board has `RR`, we only need 1 `R`. If `R`, we need 2 `R`s. If we don't have enough, skip.
    - **Memoization:** Store `state -> min_steps`. Wait, `hand` changes. A simple visited set `[board + hand]` might be too large or ineffective due to many permutations.
    - **Crucial Pruning:** Only insert ball into a group of same color (e.g., into `RR` or `R`). Exception: Sometimes inserting `G` into `RR` to make `RGR` is helpful if a later `R` removes the `G`? No, Zuma rules remove consecutive. So we only insert to match colors. 
    - Actually, inserting a different color breaks a sequence, which is almost never good given the goal is *clearing*. The only subtle case is if we need to split a group to prevent it from clearing too early? No, clearing is always forced 3+.
    - So, we iterate distinct colors in hand, try to insert into matching positions in board.

---

## 2. Approach: DFS with Recursion
## *2. Hướng tiếp cận: DFS với Đệ quy*

### Logic
### *Logic*
(See above).
- `dfs(board, handCount)`: min balls to clear.
- Iterate `i` in board only where `board[i]` changes (start of groups).
- Try adding needed balls (1 or 2) to complete group of 3.
- If have enough in hand, construct `newBoard` (simulate removal), decrement hand, recurse.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Recursion:** Naturally handles the multi-step decision process.
    *Đệ quy: Xử lý tự nhiên quá trình ra quyết định nhiều bước.*
*   **String Manipulation:** Simulation of "collapse" is easiest with string replacement loop.
    *Thao tác chuỗi: Mô phỏng "sụp đổ" dễ nhất với vòng lặp thay thế chuỗi.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** High branching factor, bounded by depth 5 (hand size). Approximate $O((N \cdot K)^M)$ where $M=5$. With pruning, it passes.
    *Độ phức tạp thời gian: Cao nhưng khả thi với cắt tỉa.*
*   **Space Complexity:** $O(M \cdot N)$ for recursion stack and strings.
    *Độ phức tạp không gian: $O(M \cdot N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `board="WWRRBBWW", hand="WRBRW"` -> Hand: `W:2, R:2, B:1`.
1. Group `WW` (0,1): Need 1 `W`. Hand has 2.
   - Use 1 `W`. New board `W[W]WRRBBWW` -> `RRBBWW`. Recurse.
     - Hand `W:1, R:2, B:1`.
     - Group `RR`: Need 1 `R`. Hand has 2.
       - Use 1 `R`. New `R[R]RBBWW` -> `BBWW`. Recurse.
         - Group `BB`: Need 1 `B`. Hand has 1.
           - Use 1 `B`. New `B[B]BWW` -> `WW`. Recurse.
             - Group `WW`: Need 1 `W`. Hand has 1.
               - Use 1 `W`. New `W[W]W` -> Empty.
               - Return 0 steps (from this level). Total used: 1+1+1+1 = 4.
   - Best result might be 2. Let's see example path.
   - Start: `WWRRBBWW`.
   - Try inserting `B` into `BB` -> `WWRR(B)BBWW` -> `WWRRWW`.
   - Then `R` into `RR` -> `WW(R)RRWW` -> `WWWW` -> Empty.
   - Total used: 1 `B`, 1 `R`. Total 2. Better than 4.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Backtracking/DFS trying to complete groups. Crucial: Simulate board collapse fully.
*Quay lui/DFS cố gắng hoàn thành các nhóm. Quan trọng: Mô phỏng sụp đổ bảng hoàn toàn.*
---
*Cuộc đời (board) đôi khi như một trò chơi Zuma, những rắc rối cứ dồn dập kéo đến (balls). Để giải quyết chúng, ta không thể chỉ thụ động chờ đợi, mà phải chủ động thêm vào những yếu tố cần thiết (hand) để tạo ra sự đột phá (critical mass of 3). Mỗi khi một vấn đề được giải quyết, nó có thể kéo theo sự tan biến của hàng loạt vấn đề khác (chain reaction), trả lại cho ta một tâm trí trống rỗng và thanh thản (empty board).*
Life (board) is sometimes like a Zuma game, troubles keep forcing (balls). To solve them, we can't just passively wait, but we must actively add the necessary elements (Hand) to create a breakthrough (Critical Mass of 3). Every time a problem is solved, it can lead to the disappearance of a series of other problems (chain reaction), returning us an empty and serene mind (Empty Board).
