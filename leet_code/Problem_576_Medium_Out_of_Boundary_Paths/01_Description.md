# Result for Out of Boundary Paths
# *Kết quả cho bài toán Đường ra ngoài Biên*

## Description
## *Mô tả*

There is an `m x n` grid with a ball. The ball is initially at the position `[startRow, startColumn]`. You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid boundary). You can apply **at most** `maxMove` moves to the ball.
*Có một lưới `m x n` với một quả bóng. Quả bóng ban đầu ở vị trí `[startRow, startColumn]`. Bạn được phép di chuyển quả bóng đến một trong bốn ô liền kề trong lưới (có thể là ra ngoài biên lưới). Bạn có thể áp dụng **tối đa** `maxMove` bước di chuyển cho quả bóng.*

Given the five integers `m`, `n`, `maxMove`, `startRow`, `startColumn`, return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it **modulo 10^9 + 7**.
*Cho năm số nguyên `m`, `n`, `maxMove`, `startRow`, `startColumn`, hãy trả về số cách để di chuyển quả bóng ra ngoài biên lưới. Vì câu trả lời có thể rất lớn, hãy trả về kết quả theo **modulo 10^9 + 7**.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
**Output:** 6

## Example 2:
## *Ví dụ 2:*

**Input:** m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
**Output:** 12

---

## Constraints:
## *Ràng buộc:*

*   `1 <= m, n <= 50`
*   `0 <= maxMove <= 50`
*   `0 <= startRow < m`
*   `0 <= startColumn < n`
