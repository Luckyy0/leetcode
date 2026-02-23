# Analysis for Battleships in a Board
# *Phân tích cho bài toán Tàu chiến trên Bàn cờ*

## 1. Problem Essence & Head Counting
## *1. Bản chất vấn đề & Đếm điểm đầu*

### The Challenge
### *Thách thức*
Counting the number of discrete battleships (horizontal or vertical 1D blocks). The constraint is to do it in one pass, without modifying the board, and using $O(1)$ extra space.

### Strategy: Identify the "Top-Left" Cell
### *Chiến lược: Nhận dạng ô "Trên cùng - Bên trái"*
A battleship is a collection of contiguous 'X's. To avoid double-counting, we only count the **first** cell of each ship.
A cell `(r, c)` is considered the "head" or starting point of a battleship if:
1.  Current cell is `'X'`.
2.  The cell above `(r-1, c)` is empty/out-of-bounds.
3.  The cell to the left `(r, c-1)` is empty/out-of-bounds.

If both conditions (2) and (3) are met, it means we've encountered a ship that hasn't been counted by a previous iteration from the top or left.

---

## 2. Approach: Single Pass Iteration
## *2. Hướng tiếp cận: Duyệt Một Lần*

### Logic
### *Logic*
(See above). By checking only the immediate top and left neighbors, we can verify if the current 'X' is the beginning of a ship in $O(1)$ time for each cell.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(MN) One-Pass:** Extremely efficient linear scan.
    *Hiệu quả O(MN) một lần duyệt: Quét tuyến tính cực nhanh.*
*   **O(1) Memory:** No extra arrays, visited sets, or recursion stack (DFS) needed.
    *Bộ nhớ O(1): Không cần mảng phụ, tập hợp đã ghé thăm hay ngăn xếp đệ quy.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(MN)$, where $M, N$ are dimensions of the grid.
    *Độ phức tạp thời gian: $O(MN)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Board:**
```
X . . X
. . . X
. . . X
```
1. `(0, 0)`: 'X'. Top/Left are empty. **Count = 1**.
2. `(0, 3)`: 'X'. Top/Left are empty. **Count = 2**.
3. `(1, 3)`: 'X'. Top is 'X'. Skip.
4. `(2, 3)`: 'X'. Top is 'X'. Skip.
Result: 2.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Count only 'X' cells with no 'X' above or to the left.
*Chỉ đếm các ô 'X' mà không có ô 'X' nào ở trên hoặc bên trái.*
---
*Số lượng chiến hạm (battleships) không nằm ở việc chúng lớn bao nhiêu (length), mà nằm ở việc chúng bắt đầu từ đâu. Bằng cách chỉ ghi nhận điểm khởi đầu (top-left head) và phớt lờ những phần còn lại đã được kết nối, ta có thể thấu thị toàn bộ đội hình địch chỉ trong một cái nhìn duy nhất.*
The number of battleships (battleships) does not lie in how large they are (length), but in where they start. By only recording the starting point (top-left head) and ignoring the rest that have been connected, we can perceive the entire enemy formation in a single glance.
