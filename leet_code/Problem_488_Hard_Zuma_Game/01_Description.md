# Result for Zuma Game
# *Kết quả cho bài toán Trò chơi Zuma*

## Description
## *Mô tả*

You are playing a variation of the game Zuma.
*Bạn đang chơi một biến thể của trò chơi Zuma.*

In this variation of Zuma, there is a **single row** of colored balls on a board, where each ball can be colored Red `'R'`, Yellow `'Y'`, Blue `'B'`, Green `'G'`, or White `'W'`. You also have several balls in your hand.
*Trong biến thể này của Zuma, có một **hàng duy nhất** các quả bóng màu trên bảng, trong đó mỗi quả bóng có thể có màu Đỏ `'R'`, Vàng `'Y'`, Xanh dương `'B'`, Xanh lục `'G'`, hoặc Trắng `'W'`. Bạn cũng có một số quả bóng trong tay.*

Your goal is to clear all of the balls from the board. On each turn:
*Mục tiêu của bạn là xóa tất cả các quả bóng khỏi bảng. Trong mỗi lượt:*

*   Pick **any** ball from your hand and insert it in between two balls in the row or on either end of the row.
    *Chọn **bất kỳ** quả bóng nào từ tay của bạn và chèn nó vào giữa hai quả bóng trong hàng hoặc ở hai đầu hàng.*
*   If there is a group of **three or more** consecutive balls of the **same color**, then the group is removed from the board.
    *Nếu có một nhóm **ba hoặc nhiều hơn** quả bóng liên tiếp có **cùng màu**, thì nhóm đó sẽ bị loại bỏ khỏi bảng.*
*   If this removal causes more groups of three or more of the same color to form, then the new groups are also removed. This process continues until no more groups can be formed.
    *Nếu việc loại bỏ này khiến hình thành thêm các nhóm gồm ba hoặc nhiều quả cùng màu, các nhóm mới này cũng sẽ bị loại bỏ. Quá trình này tiếp tục cho đến khi không còn nhóm nào có thể được hình thành.*
*   Wait until all ball removals have finished before deciding on your next move.
    *Đợi cho đến khi tất cả việc loại bỏ bóng kết thúc trước khi quyết định nước đi tiếp theo của bạn.*

Given a string `board`, representing the row of balls on the board, and a string `hand`, representing the balls in your hand, return *the minimum number of balls you have to insert to clear all the balls from the board. If you cannot clear all the balls from the board, return `-1`*.
*Cho một chuỗi `board`, đại diện cho hàng bóng trên bảng, và một chuỗi `hand`, đại diện cho các quả bóng trong tay bạn, hãy trả về *số lượng bóng tối thiểu bạn phải chèn để xóa tất cả bóng khỏi bảng. Nếu bạn không thể xóa tất cả bóng khỏi bảng, hãy trả về `-1`*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `board = "WRRBBW", hand = "RB"`
**Output:** `-1`
**Explanation:** It is impossible to clear all the balls. The best you can do is:
- Insert 'R' so the board becomes WRRRBBW. WRRRBBW -> WBBW.
- Insert 'B' so the board becomes WBBBW. WBBBW -> WW.
There are still balls remaining.

## Example 2:
## *Ví dụ 2:*

**Input:** `board = "WWRRBBWW", hand = "WRBRW"`
**Output:** `2`
**Explanation:** To make the board empty:
- Insert 'R' so the board becomes WWRRRBBWW. WWRRRBBWW -> WWBBWW.
- Insert 'B' so the board becomes WWBBBWW. WWBBBWW -> WWWW -> empty.
2 balls from your hand were needed to clear the board.

## Constraints:
## *Ràng buộc:*

*   `1 <= board.length <= 16`
*   `1 <= hand.length <= 5`
*   `board` and `hand` consist of the characters `'R'`, `'Y'`, `'B'`, `'G'`, and `'W'`.
