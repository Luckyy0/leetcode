# Analysis for Can I Win
# *Phân tích cho bài toán Tôi có thể Thắng không*

## 1. Problem Essence & Game Theory Recursion
## *1. Bản chất vấn đề & Đệ quy Lý thuyết Trò chơi*

### The Challenge
### *Thách thức*
Determining if the first player can force a win in a picking game with a target sum and shared resources (no replacement). With `maxChoosableInteger` up to 20, the state space is defined by which numbers have been used.

### Strategy: Minimax + Memoization + bitmask
### *Chiến lược: Minimax + Ghi nhớ + Mặt nạ bit*

1.  **State Definition:** The state is defined by the set of "available numbers". Since `maxChoosableInteger <= 20`, we can use a **Bitmask** (an integer where the $i$-th bit represents whether number $i$ has been used) to uniquely represent the state.
2.  **Edge Cases:**
    - If `desiredTotal <= 0`, first player wins immediately.
    - If the sum of all available integers is less than `desiredTotal`, no one can ever win (so return `false` per LeetCode rules).
3.  **Recursive Step:**
    - `canWin(mask, currentTotal)`:
        - For each number `i` from 1 to `maxChoosableInteger`:
            - If `i` is not yet used (bit $i-1$ is 0):
                - If `currentTotal + i >= desiredTotal`: First player wins! Return `true`.
                - If the opponent **cannot win** from the next state (`mask | (1 << i-1)`, `currentTotal + i`): First player wins! Return `true`.
        - If no choice leads to a win, return `false`.
4.  **Memoization:** Store the result of `canWin(mask)` in a `Boolean[]` or `Map` to avoid redundant calculations.

---

## 2. Approach: Optimal Recursive Search
## *2. Hướng tiếp cận: Tìm kiếm Đệ quy Tối ưu*

### Logic
### *Logic*
(See above). The sub-problem is: "Given the current available numbers, can the current player force a win?". If *any* choice leads to a state where the opponent *cannot* win, then the current player can force a win.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Bit manipulation:** Extremely fast state representation and comparison.
    *Thao tác bit: Biểu diễn và so sánh trạng thái cực nhanh.*
*   **Memoization:** Reduces exponential complexity $O(2^n \cdot n)$ to something manageable.
    *Ghi nhớ: Giảm độ phức tạp lũy thừa xuống mức có thể xử lý.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(2^N \cdot N)$, where $N$ is `maxChoosableInteger`.
    *Độ phức tạp thời gian: $O(2^N \cdot N)$.*
*   **Space Complexity:** $O(2^N)$ for the memoization table.
    *Độ phức tạp không gian: $O(2^N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `max = 4, total = 6`
1. Player 1 picks 4. `Total = 4`. mask: `1000`.
   - Remaining: `1, 2, 3`.
   - Player 2 picks 2. `Total = 6`. **P2 Wins.**
2. Player 1 picks 1. `Total = 1`. mask: `0001`.
   - Remaining: `2, 3, 4`.
   - Player 2 picks 4. `Total = 5`. mask: `1001`.
   - Remaining: `2, 3`.
   - Player 1 picks 2 or 3. `Total >= 6`. **P1 Wins.**
Player 1 will try to find a starting move that leads to a win regardless of player 2's moves.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Backtracking with bitmask memoization.
*Quay lui kết hợp ghi nhớ bằng mặt nạ bit.*
---
*Trong cuộc chơi của trí tuệ, chiến thắng không đến từ sự may rủi, mà từ khả năng dự đoán mọi nước đi của đối phương (optimal play). Bằng cách ghi nhớ những vết xe đổ (memoization) và bao quát toàn bộ các khả năng (bitmask), ta có thể tìm ra con đường dẫn đến vinh quang. Đôi khi, nước cờ đầu tiên chuẩn xác mới là yếu tố quyết định cả bàn cờ.*
In the game of wisdom, victory does not come from luck, but from the ability to predict every move of the opponent (optimal play). By remembering the tracks (memoization) and covering all possibilities (bitmask), we can find the road leading to glory. Sometimes, the first accurate move is the deciding factor in the whole chess set.
