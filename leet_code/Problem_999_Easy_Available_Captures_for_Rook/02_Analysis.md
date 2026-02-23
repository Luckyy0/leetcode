# Analysis for Available Captures for Rook
# *Phân tích cho bài toán Các nước Bắt cờ Khả dụng cho Xe*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Count how many pawns (`'p'`) a rook (`'R'`) can attack directly without being blocked by a bishop (`'B'`).
*Đếm số lượng con tốt (`'p'`) mà một quân xe (`'R'`) có thể tấn công trực tiếp mà không bị chặn bởi một quân tượng (`'B'`).*

### KEY INSIGHT
### *Nhận xét quan trọng*
- The board is always $8 \times 8$.
- The Rook moves in 4 cardinal directions: Up, Down, Left, Right.
- The Rook stops its attack range in a particular direction as soon as it hits either:
  1. The edge of the board.
  2. A blocking piece: Bishop (`'B'`).
  3. A target piece: Pawn (`'p'`). If it hits a pawn, it can capture it, but it cannot move *past* it to capture another pawn behind it. The attack stops there.
*Quân xe đi theo 4 hướng. Nó dừng lại (hoặc kết thúc đường đạn) ngay khi gặp Tượng, gặp Tốt (bắt 1 con tốt), hoặc đụng mép bàn cờ.*

---

## 2. Strategy: Directional Ray-Casting
## *2. Chiến lược: Tuyến tính Đa chiều*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Find the Rook:** Scan the $8 \times 8$ grid to locate the row `r` and column `c` where the character is `'R'`.
    *   **Tìm Quân Xe:** Duyệt mảng $8 \times 8$ để tìm toa độ `r, c`.*

2.  **Cast 4 Rays:** Iterate through the 4 directions (up `[-1, 0]`, down `[1, 0]`, left `[0, -1]`, right `[0, 1]`).
    *   For each direction, keep moving the `current_r` and `current_c`.
    *   If out of bounds, stop this direction.
    *   If cell is `'B'`, stop this direction (blocked).
    *   If cell is `'p'`, increment `captures`, then stop this direction.
    *   If cell is `'.'`, continue moving.
    *   **Quét 4 Hướng:** Lặp theo 4 vector hướng. Tăng biến bị bắt nếu gặp `'p'`, và dừng việc quét lại nếu ra ngoài hoặc gặp `'B'`, `'p'`.*

3.  **Return:** The total count of `captures`.
    *   **Trả về:** Tổng số lần bắt cờ.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public class Solution {
    public int numRookCaptures(char[][] board) {
        int r = -1, c = -1;
        
        // 1. Find the Rook
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    r = i;
                    c = j;
                    break;
                }
            }
        }
        
        int captures = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // 2. Scan 4 directions
        for (int[] dir : directions) {
            int curR = r + dir[0];
            int curC = c + dir[1];
            
            while (curR >= 0 && curR < 8 && curC >= 0 && curC < 8) {
                if (board[curR][curC] == 'B') {
                    break; // Blocked by friendly bishop
                } else if (board[curR][curC] == 'p') {
                    captures++; // Captured an enemy pawn
                    break; // Cannot jump over it
                }
                
                // Continue moving in the same direction
                curR += dir[0];
                curC += dir[1];
            }
        }
        
        return captures;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$ because the board size is strictly $8 \times 8$ (64 cells). Finding the rook takes 64 operations, and scanning the 4 directions takes at most 8 operations each. Overall bounded by a very small constant time.
    *   **Độ phức tạp thời gian:** $O(1)$ hay $O(N)$ với $N = 64$. Quá trình cực kỳ nhỏ gọn.*
*   **Space Complexity:** $O(1)$. No extra space required other than a few integer variables.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Simple matrix traversal efficiently handles this fixed-size game board problem.
*Việc duyệt ma trận đơn giản dễ dàng xử lý bài toán mô phỏng bàn cờ cố định này.*
