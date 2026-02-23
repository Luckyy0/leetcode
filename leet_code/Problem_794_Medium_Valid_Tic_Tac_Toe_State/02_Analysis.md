# Analysis for Valid Tic-Tac-Toe State
# *Phân tích cho bài toán Trạng thái Tic-Tac-Toe Hợp lệ*

## 1. Problem Essence & Game Conditions
## *1. Bản chất vấn đề & Điều kiện Trò chơi*

### The Challenge
### *Thách thức*
We need to check if the counts of X and O are valid and if the winning states are consistent.
*Chúng ta cần kiểm tra xem số lượng X và O có hợp lệ không và các trạng thái thắng có nhất quán không.*

**Rules:**
1.  **Turns:** X goes first. So `count(X)` must be equal to `count(O)` or `count(O) + 1`.
    *   **Lượt chơi:** X đi trước. Nên `count(X)` phải bằng `count(O)` hoặc `count(O) + 1`.*
2.  **Wins:**
    - If X wins, X must have made the last move. So `count(X) == count(O) + 1`.
    - If O wins, O must have made the last move. So `count(X) == count(O)`.
    - Both cannot win simultaneously (impossible in normal gameplay).
    *   **Chiến thắng:** Nếu X thắng, X phải đi cuối (`X = O + 1`). Nếu O thắng, O phải đi cuối (`X = O`). Cả hai không thể cùng thắng.*

---

## 2. Strategy: Count and Validate
## *2. Chiến lược: Đếm và Xác thực*

### Algorithm
### *Thuật toán*

1.  **Count:** Iterate board, count 'X' and 'O'.
2.  **Order Check:** `X < O` or `X > O + 1` is invalid.
3.  **Win Check:** Helper function `win(player)` checks 8 lines (3 rows, 3 cols, 2 diagonals).
4.  **Consistency:**
    - `xWins = win('X')`, `oWins = win('O')`.
    - If `xWins` and `oWins`: Invalid.
    - If `xWins`: Must be `X == O + 1`.
    - If `oWins`: Must be `X == O`.
    *   **Đếm:** Đếm X và O. **Kiểm tra Thứ tự:** X < O hoặc X > O + 1 là sai. **Kiểm tra Thắng:** Hàm phụ kiểm tra 8 đường. **Nhất quán:** X thắng thì X = O + 1. O thắng thì X = O. Cả hai thắng là sai.*

### Code Logic Preview
### *Xem trước Logic Mã*

```java
public boolean validTicTacToe(String[] board) {
    int xCount = 0, oCount = 0;
    for (String row : board) {
        for (char c : row.toCharArray()) {
            if (c == 'X') xCount++;
            else if (c == 'O') oCount++;
        }
    }
    
    if (oCount != xCount && oCount != xCount - 1) return false;
    
    boolean xWins = win(board, 'X');
    boolean oWins = win(board, 'O');
    
    if (xWins && oWins) return false;
    if (xWins && xCount != oCount + 1) return false;
    if (oWins && xCount != oCount) return false;
    
    return true;
}

boolean win(String[] B, char P) {
    // Check rows, cols, diagonals
}
```

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$. Fixed 3x3 board.
    *   **Độ phức tạp thời gian:** $O(1)$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Board:** `["XOX", " X ", "   "]`
- X: 3, O: 1.
- `X (3) > O (1) + 1`. Invalid.

**Board:** `["XOX", "O O", "XOX"]`
- X: 5, O: 4. `X == O + 1`. OK.
- xWins? X has 1st col? No. Last col? No. Diag? Yes (`X` at 0,0; `O` at 1,1; `X` at 2,2? No).
- Wait, board breakdown:
  R1: X O X
  R2: O   O
  R3: X O X
- Cols: C1 (XOX), C2 (O O), C3 (XOX).
- Diags: X O X (Back slash), X O X (Forward slash).
- Rows: XOX, O O, XOX.
- X wins on Diagonals? No, middle is ' '.
- Wait, check manually.
- Actually, example said "True". Why?
- `X` counts 5 (1,3,5,7,9?).
- Board in example 3: `["XOX","O O","XOX"]`
  X at (0,0), (0,2), (2,0), (2,2). Wait, Middle is Space? Row 2 is "O O".
  Actually X count: 4. O count: 3. `4 == 3+1`. OK.
  Wins? X at corners. O at top-mid, mid-left, mid-right, bot-mid?
  Manual check:
  X O X
  O   O
  X O X
  No line of 3 for X. No line of 3 for O.
  Valid.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Simply counting and checking win conditions covers all rules.
*Chỉ cần đếm và kiểm tra điều kiện thắng là bao phủ tất cả các luật.*
