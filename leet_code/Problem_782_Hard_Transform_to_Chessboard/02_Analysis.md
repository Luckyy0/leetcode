# Analysis for Transform to Chessboard
# *Phân tích cho bài toán Biến đổi thành Bàn cờ*

## 1. Problem Essence & Invariants
## *1. Bản chất vấn đề & Bất biến*

### The Chessboard Pattern
### *Mẫu hình Bàn cờ*
A chessboard has rows alternating like `0101` and `1010`.
Key property:
1.  Every row must be equal to the first row OR inverse of the first row.
2.  Every column must be equal to the first column OR inverse of the first column.
*Một bàn cờ có các hàng xen kẽ `0101` và `1010`. Thuộc tính chính: Mọi hàng phải bằng hàng đầu tiên HOẶC đảo ngược của hàng đầu tiên. Tương tự với cột.*

### Validity Check
### *Kiểm tra Hợp lệ*
1.  **Row Check:** Check if every row matches `row[0]` or `row[0] ^ 1`.
2.  **Count Check:**
    - The number of rows matching `row[0]` must be `N/2` or `(N+1)/2`.
    - The number of `1`s in the first row must be `N/2` or `(N+1)/2`.
    - Same for columns.
*Kiểm tra Hàng: Kiểm tra xem mọi hàng có khớp `row[0]` hoặc `row[0] ^ 1`. Kiểm tra Số lượng: Số hàng khớp phải là một nửa. Số bit 1 cũng phải là một nửa.*

### Calculating Moves
### *Tính toán Nước đi*
Since we can swap rows/cols independently, minimal moves = (row swaps + col swaps).
For a single line (row/col) of length `N`, we want to transform it to `1010...` or `0101...`.
- Count misplacements compared to `1010...`.
- If `N` even: Min swaps = `min(misplaced_10, misplaced_01) / 2`.
- If `N` odd: We can only transform to the pattern that maintains the correct majority bit count. Min swaps = `misplaced_valid / 2`.
*Vì ta có thể hoán đổi hàng/cột độc lập, tổng nước đi = hoán đổi hàng + hoán đổi cột. Với một dòng, đếm số vị trí sai lệch so với mẫu `1010...`. Nếu N chẵn: min hoán đổi là `min(sai_10, sai_01) / 2`. Nếu N lẻ: chỉ có một mẫu hợp lệ.*

---

## 2. Strategy: Validate and Swap
## *2. Chiến lược: Xác thực và Hoán đổi*

### Algorithm
### *Thuật toán*

1.  **Validation:**
    - Iterate all rows `i`. If `board[i]` isn't `board[0]` AND `board[i]` isn't `inverse(board[0])`, return -1.
    - Check row counts: Count ones in `board[0]` and cols. Must be `N/2` or `(N+1)/2`.
    *   **Xác thực:** Kiểm tra tính nhất quán của hàng và số lượng bit.*

2.  **Calculate Swaps:**
    - `rowSwaps`: Compare first column with `1010...` and `0101...`.
    - `colSwaps`: Compare first row with `1010...` and `0101...`.
    - Handle odd/even logic described above.
    *   **Tính toán Hoán đổi:** So sánh hàng/cột đầu tiên với mẫu chuẩn và áp dụng logic chẵn/lẻ.*

### Code Logic Preview
### *Xem trước Logic Mã*

```java
public int movesToChessboard(int[][] board) {
    int n = board.length;
    // Check properties
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if ((board[0][0] ^ board[i][0] ^ board[0][j] ^ board[i][j]) == 1) return -1;
        }
    }
    
    int rowSum = 0, colSum = 0, rowMisplace = 0, colMisplace = 0;
    for (int i = 0; i < n; i++) {
        rowSum += board[0][i];
        colSum += board[i][0];
        if (board[i][0] == i % 2) rowMisplace++;
        if (board[0][i] == i % 2) colMisplace++;
    }
    
    // Check Sums
    if (rowSum != n/2 && rowSum != (n+1)/2) return -1;
    if (colSum != n/2 && colSum != (n+1)/2) return -1;
    
    // Calc moves
    int rowMoves = calc(n, rowMisplace, colSum); // Wait, use misplace count
    // Logic extraction to helper...
}
```

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2)$. Scanning the board once.
    *   **Độ phức tạp thời gian:** $O(N^2)$.*
*   **Space Complexity:** $O(1)$ extra space.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Board:** `[[0,1], [1,0]]` (N=2)
1. Check consistency:
    - (0,0)=0, (1,0)=1, (0,1)=1, (1,1)=0. `0^1^1^0 = 0`. OK.
2. Sums:
    - Row0: 1 (1/2 ok). Col0: 1 (1/2 ok).
3. Misplace (Target `0101...` implies `val == i%2`):
    - Col0 (starts with 0): `0` vs `0` (match), `1` vs `1` (match). Misplace=0.
    - Row0 (starts with 0): `0` vs `0`, `1` vs `1`. Misplace=0.
    - Odd/Even logic:
    - N=2 (E). `min(mis, N-mis) = min(0, 2) = 0`. Swaps = 0/2 = 0.
**Result:** 0.

**Board:** `[[0, 1, 1], [0, 1, 1], [1, 0, 0]]` (Example from memory? No, checking logic).
- Valid chessboard must have alternate rows/cols.
- If invalid, step 1 catches it.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

The bitwise property `board[0][0] ^ board[i][0] ^ board[0][j] ^ board[i][j] == 0` is a compact way to check the "rectangle property" (if corners form a valid rectangle in chessboard, they must XOR to 0).
*Thuộc tính bitwise XOR là cách gọn nhẹ để kiểm tra "tính chất hình chữ nhật" (các góc phải XOR bằng 0).*
