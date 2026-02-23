# Analysis for Design Tic-Tac-Toe
# *Phân tích cho bài toán Thiết kế Tic-Tac-Toe*

## 1. Problem Essence & Efficiency
## *1. Bản chất vấn đề & Hiệu quả*

### The Challenge
### *Thách thức*
Track the state of a Tic-Tac-Toe board and efficiently determine if a player has won after each move.
The board size `n` can be up to 100, and we want to optimize the win condition check.

### Naive Approach
### *Cách Tiếp cận Ngây thơ*
After each move, check the entire row, column, and two diagonals. This takes $O(n)$ per move.
If we were to store the whole board, it would take $O(n^2)$ space.

### Strategy: Score Tracking
### *Chiến lược: Theo dõi Điểm số*
We don't actually need to store the board. We only need to track the "counts" for each row, column, and diagonal.
1.  Assign `+1` for Player 1 and `-1` for Player 2.
2.  Maintain arrays:
    - `rows[n]`: sums of values in each row.
    - `cols[n]`: sums of values in each column.
    - `diag`: sum of values in the main diagonal (where `row == col`).
    - `antiDiag`: sum of values in the anti-diagonal (where `row + col == n - 1`).
3.  In each `move(row, col, player)`:
    - Determine `val = (player == 1) ? 1 : -1`.
    - `rows[row] += val`.
    - `cols[col] += val`.
    - If `row == col`, `diag += val`.
    - If `row + col == n - 1`, `antiDiag += val`.
    - Check if any updated sum's absolute value is equal to `n`.
    - If `|sum| == n`, the current player wins.

---

## 2. Approach: Counter Arrays
## *2. Hướng tiếp cận: Mảng Bộ đếm*

### Logic
### *Logic*
(See Strategy above). This approach reduces the win check to $O(1)$ by simply looking up the precomputed sums.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(1) Time:** The `move` operation is extremely fast.
    *Thời gian O(1): Thao tác `move` cực kỳ nhanh.*
*   **O(n) Space:** We avoid storing the $n^2$ grid.
    *Không gian O(n): Chúng ta tránh việc lưu trữ lưới $n^2$.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$ per `move()`.
    *Độ phức tạp thời gian: $O(1)$ cho mỗi lần gọi `move()`.*
*   **Space Complexity:** $O(n)$ to store row/column/diagonal totals.
    *Độ phức tạp không gian: $O(n)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Board Size:** 3
1.  **Move (0,0,1):** `rows[0]=1, cols[0]=1, diag=1`. No one wins.
2.  **Move (0,2,2):** `rows[0]=1-1=0, cols[2]=-1`. No one wins.
3.  **Move (1,1,1):** `rows[1]=1, cols[1]=1, diag=1+1=2, antiDiag=1`. No one wins.
4.  **Move (2,2,1):** `rows[2]=1, cols[2]=-1+1=0, diag=2+1=3`.
    - `diag == 3`. Player 1 wins!

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Use score arrays for $O(1)$ moves.
*Sử dụng mảng điểm số để thực hiện nước đi O(1).*
---
*Thắng thua trong một trò chơi đôi khi không nằm ở việc quan sát toàn bộ cục diện (O(n^2)), mà ở việc nắm vững những mắt xích trọng yếu (O(n)). Khi bạn tích lũy đủ sức mạnh (sum == n), chiến thắng sẽ tự nhiên đến.*
Winning or losing in a game sometimes does not lie in observing the entire situation (O(n^2)), but in mastering the key links (O(n)). When you accumulate enough power (sum == n), victory will come naturally.
