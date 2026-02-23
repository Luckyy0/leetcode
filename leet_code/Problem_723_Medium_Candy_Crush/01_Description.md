# Result for Candy Crush
# *Kết quả cho bài toán Xếp kẹo (Candy Crush)*

## Description
## *Mô tả*

This question is about implementing a basic elimination algorithm for Candy Crush.
*Câu hỏi này yêu cầu cài đặt một thuật toán loại bỏ cơ bản cho trò chơi Candy Crush.*

Given an `m x n` integer array `board` representing the grid of candies, where `board[i][j]` is a positive integer representing the type of candy, and `0` represents an empty cell.
*Cho một mảng số nguyên `board` kích thước `m x n` đại diện cho lưới kẹo, trong đó `board[i][j]` là một số nguyên dương đại diện cho loại kẹo, và `0` đại diện cho một ô trống.*

The board should be stabilized according to the following rules:
*Lưới kẹo nên được ổn định theo các quy tắc sau:*

1.  **Crush:** If three or more candies of the same type are adjacent vertically or horizontally, "crush" them by setting their value to 0. All candies that meet this condition should be crushed **simultaneously**.
2.  **Drop:** After crushing, candies above empty spaces (value 0) should drop down to fill the gaps.
3.  **Repeat:** Repeat steps 1 and 2 until no more candies can be crushed.

* 1. **Loại bỏ (Crush):** Nếu có ba hoặc nhiều viên kẹo cùng loại nằm cạnh nhau theo chiều dọc hoặc chiều ngang, hãy "loại bỏ" chúng bằng cách đặt giá trị của chúng về 0. Tất cả các viên kẹo thỏa mãn điều kiện này phải được loại bỏ **đồng thời**.*
* 2. **Rơi (Drop):** Sau khi loại bỏ, các viên kẹo phía trên các ô trống (giá trị 0) sẽ rơi xuống để lấp đầy các khoảng trống.*
* 3. **Lặp lại:** Lặp lại bước 1 và 2 cho đến khi không còn viên kẹo nào có thể bị loại bỏ.*

Return the stabilized board.
*Hãy trả về lưới kẹo đã được ổn định.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** board = [[110,5,112,113,114],[210,211,5,213,214],[310,311,3,313,314],[410,411,412,5,414],[5,1,512,3,3],[610,4,1,613,614],[710,1,2,713,714],[810,1,2,1,1],[1,1,2,2,2],[4,1,4,4,1014]]
**Output:** [[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[110,0,0,0,114],[210,0,0,0,214],[310,0,0,113,314],[410,0,0,213,414],[610,211,112,313,614],[710,311,412,613,714],[810,411,512,713,1014]]

---

## Constraints:
## *Ràng buộc:*

*   `m == board.length`
*   `n == board[i].length`
*   `3 <= m, n <= 50`
*   `1 <= board[i][j] <= 2000`
