# Result for Available Captures for Rook
# *Kết quả cho bài toán Các nước Bắt cờ Khả dụng cho Xe*

## Description
## *Mô tả*

On an `8 x 8` chessboard, there is exactly one white rook `'R'` and some number of white bishops `'B'`, black pawns `'p'`, and empty squares `'.'`.
*Trên một bàn cờ `8 x 8`, có chính xác một quân xe trắng `'R'` và một số quân tượng trắng `'B'`, quân tốt đen `'p'`, và các ô trống `'.'`. *

When the rook moves, it chooses one of four cardinal directions (north, east, south, or west), then moves in that direction until it chooses to stop, reaches the edge of the board, captures a black pawn, or is blocked by a white bishop. A rook is considered **attacking** a pawn if the rook can capture the pawn on the rook's turn. The number of available captures for the white rook is the number of pawns that the rook is **attacking**.
*Khi quân xe di chuyển, nó chọn một trong bốn hướng chính (bắc, đông, nam hoặc tây), sau đó di chuyển theo hướng đó cho đến khi nó quyết định dừng lại, chạm đến mép bàn cờ, bắt một quân tốt đen hoặc bị chặn bởi một quân tượng trắng. Xe được coi là **đang tấn công** một con tốt nếu xe có thể bắt con tốt đó trong lượt của mình. Số lượng nước bắt cờ khả dụng cho quân xe trắng là số lượng quân tốt mà quân xe đang **tấn công**.*

Return *the number of available captures for the white rook*.
*Trả về *số lượng nước bắt cờ khả dụng cho quân xe trắng*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** board = [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],
[".",".",".","R",".",".",".","p"],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
**Output:** 3
**Explanation:** In this example, the rook is attacking all the pawns.

## Example 2:
## *Ví dụ 2:*

**Input:** board = [[".",".",".",".",".",".",".","."],[".","p","p","p","p","p",".","."],[".","p","p","B","p","p",".","."],[".","p","B","R","B","p",".","."],[".","p","p","B","p","p",".","."],[".","p","p","p","p","p",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
**Output:** 0
**Explanation:** The bishops are blocking the rook from attacking any of the pawns.

---

## Constraints:
## *Ràng buộc:*

*   `board.length == 8`
*   `board[i].length == 8`
*   `board[i][j]` is either `'R'`, `'.'`, `'B'`, or `'p'`.
*   There is exactly one `'R'` on the board.
