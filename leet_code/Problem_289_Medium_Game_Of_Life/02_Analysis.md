# Analysis for Game of Life
# *Phân tích cho bài toán Trò chơi Cuộc sống*

## 1. Problem Essence & In-Place State
## *1. Bản chất vấn đề & Trạng thái Tại chỗ*

### The Simultaneous Challenge
### *Thách thức Đồng thời*
We need to compute next state based on *current* state.
If we update in-place simply (`board[i][j] = newState`), subsequent calculations for neighbors will use the *new* value, which is wrong.
Naive solution: Copy board. $O(MN)$ space.
Constraint: In-place $O(1)$ space.

### Strategy: State Encoding
### *Chiến lược: Mã hóa Trạng thái*
We need to store two pieces of info in each cell:
1.  Original State (for neighbor calculations).
2.  Next State (for final output).

Since input is 0/1, we can use extra bits or integer values.
Encoding:
- `0`: Dead -> Dead
- `1`: Live -> Live
- `2`: Live -> Dead (Was 1, becomes 0)
- `3`: Dead -> Live (Was 0, becomes 1)

When checking neighbors, `1` and `2` count as LIVE.
After checking, `0` and `2` become 0. `1` and `3` become 1.
Alternatively:
- `00`: Dead -> Dead
- `01`: Dead -> Live
- `10`: Live -> Dead
- `11`: Live -> Live
Bit 0 = Current. Bit 1 = Next.
Algorithm using bits:
1.  Iterate all cells. Count neighbors using `board[x][y] & 1`.
2.  Set state. If Next is Live, `board[i][j] |= 2` (set 2nd bit).
3.  Shift right: `board[i][j] >>= 1`.

---

## 2. Approach: Bit Manipulation
## *2. Hướng tiếp cận: Thao tác Bit*

### Logic
### *Logic*
1.  Loop `i`, `j`:
    - Count live neighbors. check `(board[r][c] & 1) == 1`.
    - Apply rules:
        - If Live (`board[i][j] & 1 == 1`):
            - If neighbors 2 or 3 -> Lives. `board[i][j] |= 2` (Set bit 1).
        - If Dead (`board[i][j] & 1 == 0`):
            - If neighbors == 3 -> Lives. `board[i][j] |= 2`.
2.  Loop `i`, `j`:
    - `board[i][j] >>= 1`. (New state moves to bit 0).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Memory Efficiency:** Exploits unused bits in Integer.
*   **Simultaneity:** Preserves old state in lower bit while building new state in higher bit.
    *Hiệu quả bộ nhớ: Khai thác các bit thừa trong số nguyên. Tính đồng thời: Giữ trạng thái cũ ở bit thấp trong khi xây dựng trạng thái mới ở bit cao.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \cdot N)$.
    *Độ phức tạp thời gian: $O(M \cdot N)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[[0,1,0],[0,0,1],[1,1,1],[0,0,0]]`
Cell (0,1) is 1. Neighbors: (0,0)=0, (0,2)=0, (1,0)=0, (1,1)=0, (1,2)=1.
Top row neighbors only? No, all 8.
Let's trace one. (1,2)=1 (Live).
Neighbors: (0,1)=1, (0,2)=0, (1,1)=0, (2,1)=1, (2,2)=1, (2,3)=N/A...
Count = 3. Live -> Live. Set bit 1 -> 3 (binary 11).
Final Pass: 3 >> 1 = 1. Correct.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Bit manipulation is the standard trick for in-place state updates.
*Thao tác bit là thủ thuật tiêu chuẩn cho cập nhật trạng thái tại chỗ.*
---
*Cuộc sống không chỉ là sống hay chết, mà còn là sự chuyển tiếp (transition). Quá khứ và tương lai cùng tồn tại trong hiện tại (bit 0 & bit 1) trước khi thời gian trôi qua.*
Life is not just life or death, but transition. Past and future correspond in the present (bit 0 & bit 1) before time moves on.
