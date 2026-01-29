# 1138. Alphabet Board Path / Đường đi trên Bảng Chữ cái

## Problem Description / Mô tả bài toán
On an alphabet board, we start at position `(0, 0)`, corresponding to character 'a'.
The board is:
a b c d e
f g h i j
k l m n o
p q r s t
u v w x y
z
Given a string `target`, return a sequence of moves (L, R, U, D) to spell it out. '!' adds the character.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Coordinate Geometry / Simulation / Hình học Tọa độ / Mô phỏng
Board has 5 cols.
Pos of char `c`: `row = (c - 'a') / 5`, `col = (c - 'a') % 5`.
For 'z': `row = 5`, `col = 0`.
Special case: Moving TO 'z' and FROM 'z'.
'z' is at `(5, 0)`. The rest of row 5 is empty.
To move TO 'z' from strictly right (e.g. from 'e' at `(0, 4)` to 'z' at `(5, 0)`), we must go Left then Down. Because `(5, 1)...(5, 4)` is invalid.
To move FROM 'z' to somewhere (e.g. to 'e'), we must go Up then Right.
General rule for path from `(r1, c1)` to `(r2, c2)`:
- Move Left/Right?
- Move Up/Down?
- Order matters for 'z'.
  - To be safe with 'z', prioritize:
    - Moves that stay within bounds.
    - If target is 'z', prioritize L then D.
    - If start is 'z', prioritize U then R.
  - Safe rule: Always move Left before moving Down. Always move Up before moving Right.
  - Explanation:
    - Moving Left is safe (never go out on right). Moving from any char to 'z' requires hitting `col 0` before `row 5`, or standard path.
    - Actually:
      - Moving `U`: `r` decreases. Always safe ('z' is bottom-most, moving up is fine).
      - Moving `L`: `c` decreases. Always safe.
      - Moving `R`: `c` increases. Not safe if at `z`. Must move `U` first.
      - Moving `D`: `r` increases. Not safe if going to `z` from `col > 0`. Must move `L` first.
    - So priority: **L, U, R, D**.
    - No.
    - If `dr < 0` (Up): Move U.
    - If `dc < 0` (Left): Move L.
    - If `dr > 0` (Down): Move D.
    - If `dc > 0` (Right): Move R.
    - Correct safe order: **L then U** handles `z -> target`.
    -Wait.
    - From `z` (5, 0) to `e` (0, 4): `U` (safe), `R` (safe). So U then R.
    - From `e` (0, 4) to `z` (5, 0): `L` (safe), `D` (safe). So L then D.
    - Combined safe order: Do L, then U, then R, then D. Or L/U first, then R/D last.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Coordinate Movement
Map each character to its `(row, col)` coordinates. To navigate between characters, compute the differences in rows and columns. Due to the board layout (where 'z' is isolated in the last row), standard greedy movement works only if we prioritize safe moves. Specifically, prioritize moving Left and Up before moving Right and Down to avoid stepping off the board when dealing with 'z'.
Ánh xạ từng ký tự tới tọa độ `(row, col)` của nó. Để di chuyển giữa các ký tự, hãy tính chênh lệch về hàng và cột. Do bố cục bảng (trong đó 'z' bị cô lập ở hàng cuối cùng), chuyển động tham lam tiêu chuẩn chỉ hoạt động nếu chúng ta ưu tiên các bước đi an toàn. Cụ thể, ưu tiên di chuyển sang Trái và Lên trước khi di chuyển sang Phải và Xuống để tránh bước ra khỏi bảng khi xử lý 'z'.

---
