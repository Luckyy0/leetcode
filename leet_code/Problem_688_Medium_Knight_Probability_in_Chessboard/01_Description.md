# Result for Knight Probability in Chessboard
# *Kết quả cho bài toán Xác suất Quân Mã trên Bàn cờ*

## Description
## *Mô tả*

On an `n x n` chessboard, a knight starts at the cell `(row, column)` and attempts to make `k` moves. The rows and columns are 0-indexed, so the top-left cell is `(0, 0)`, and the bottom-right cell is `(n - 1, n - 1)`.
*Trên một bàn cờ `n x n`, một quân mã bắt đầu tại ô `(row, column)` và cố gắng thực hiện `k` bước di chuyển. Các hàng và cột được đánh chỉ số từ 0, vì vậy ô trên cùng bên trái là `(0, 0)` và ô dưới cùng bên phải là `(n - 1, n - 1)`.*

A chess knight has eight possible moves it can make, as illustrated below. Each move is two cells in a cardinal direction, then one cell in an orthogonal direction.
*Một quân mã có tám bước di chuyển khả thi. Mỗi bước di chuyển là hai ô theo một hướng chính, sau đó một ô theo hướng trực giao.*

Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.
*Mỗi khi quân mã di chuyển, nó chọn một trong tám nước đi khả thi một cách ngẫu nhiên đồng nhất (ngay cả khi quân cờ có thể đi chệch ra ngoài bàn cờ) và di chuyển đến đó.*

The knight continues moving until it has made exactly `k` moves or has moved off the chessboard.
*Quân mã tiếp tục di chuyển cho đến khi nó thực hiện đúng `k` bước di chuyển hoặc đã đi ra ngoài bàn cờ.*

Return the probability that the knight remains on the chessboard after it has stopped moving.
*Hãy trả về xác suất quân mã vẫn còn trên bàn cờ sau khi nó dừng di chuyển.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** n = 3, k = 2, row = 0, column = 0
**Output:** 0.06250
**Explanation:** There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
From each of those positions, there are also two moves that will keep the knight on the board.
The total probability the knight stays on the board is ((1/8) * (2/8) + (1/8) * (2/8)) = 0.0625.

## Example 2:
## *Ví dụ 2:*

**Input:** n = 1, k = 0, row = 0, column = 0
**Output:** 1.00000

---

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 25`
*   `0 <= k <= 100`
*   `0 <= row, column <= n - 1`
