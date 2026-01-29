# 999. Available Captures for Rook / Các quân bị Xe bắt được

## Problem Description / Mô tả bài toán
Find the number of pawns 'p' that a white Rook 'R' can capture on an 8x8 chessboard.
Hãy tìm số lượng quân tốt 'p' mà quân Xe trắng 'R' có thể bắt được trên bàn cờ 8x8.

A Rook can move horizontally or vertically and captures the first piece it encounters, provided it is a pawn. Encountering a Bishop 'B' blocks the movement.
Quân Xe có thể di chuyển theo chiều ngang hoặc chiều dọc và bắt quân cờ đầu tiên nó gặp, miễn là quân đó là quân tốt. Gặp quân Tượng 'B' sẽ chặn đường di chuyển.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Linear Scanning (4-directions) / Quét tuyến tính (4 hướng)
Algorithm:
1. Find positions of 'R'.
2. Scan in 4 directions (Up, Down, Left, Right).
3. In each direction:
   - If we hit 'p', `count++` and break.
   - If we hit 'B' or boundary, break.
   - Ignore '.' (empty spaces).

### Complexity / Độ phức tạp
- **Time**: O(1) (fixed 8x8 grid).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Orthogonal Visibility check
Locate the rook and project outward along the two main axes. By identifying the first non-empty square in each direction, we can tally how many of these primary obstacles are enemy pawns, while ignoring empty squares and stopping at blocking bishops or board edges.
Xác định vị trí quân xe và phóng ra ngoài dọc theo hai trục chính. Bằng cách xác định ô không trống đầu tiên ở mỗi hướng, chúng ta có thể đếm xem có bao nhiêu quân cờ trong số này là quân tốt của đối phương, đồng thời bỏ qua các ô trống và dừng lại ở các quân tượng cản đường hoặc cạnh bàn cờ.

---
