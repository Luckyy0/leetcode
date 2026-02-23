# Result for Word Search
# *Kết quả cho bài toán Tìm Từ*

## Description
## *Mô tả*

Given an `m x n` grid of characters `board` and a string `word`, return `true` *if `word` exists in the grid*.
*Cho một lưới các ký tự `m x n` gọi là `board` và một chuỗi `word`, hãy trả về `true` *nếu `word` tồn tại trong lưới***.*

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
*Từ có thể được xây dựng từ các chữ cái của các ô liền kề tuần tự, trong đó các ô liền kề là các ô lân cận theo chiều ngang hoặc chiều dọc. Một ô chữ cái không được sử dụng nhiều hơn một lần.*

## Example 1:
## *Ví dụ 1:*

**Input:** `board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"`
**Output:** `true`

## Example 2:
## *Ví dụ 2:*

**Input:** `board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"`
**Output:** `true`

## Example 3:
## *Ví dụ 3:*

**Input:** `board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"`
**Output:** `false`

## Constraints:
## *Ràng buộc:*

*   `m == board.length`
*   `n = board[i].length`
*   `1 <= m, n <= 6`
*   `1 <= word.length <= 15`
*   `board` and `word` consist of only lowercase and uppercase English letters.

## Follow up:
*   Could you use search pruning to make your solution faster with a larger board?
