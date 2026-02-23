# Result for Flip Game
# *Kết quả cho bài toán Trò chơi Lật*

## Description
## *Mô tả*

You are playing a Flip Game with your friend.
*Bạn đang chơi Trò chơi Lật với bạn của mình.*

You are given a string `currentState` that contains only `'+'` and `'-'`. You and your friend take turns to flip two **consecutive** `"++"` into `"--"`. The game ends when a person can no longer make a move to flip two consecutive `"++"`, and that person loses.
*Bạn được cung cấp một chuỗi `currentState` chỉ chứa `'+'` và `'-'`. Bạn và bạn của bạn thay phiên nhau lật hai `"++"` **liên tiếp** thành `"--"`. Trò chơi kết thúc khi một người không còn có thể thực hiện nước đi để lật hai `"++"` liên tiếp nữa, và người đó thua.*

Return all possible states of the string `currentState` after **one valid move**. You may return the answer in **any order**. If there is no valid move, return an empty list `[]`.
*Trả về tất cả các trạng thái có thể có của chuỗi `currentState` sau **một nước đi hợp lệ**. Bạn có thể trả về câu trả lời theo **bất kỳ thứ tự nào**. Nếu không có nước đi hợp lệ, hãy trả về một danh sách trống `[]`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `currentState = "++++"`
**Output:** `["--++","+--+","++--"]`

## Example 2:
## *Ví dụ 2:*

**Input:** `currentState = "+"`
**Output:** `[]`

## Constraints:
## *Ràng buộc:*

*   `1 <= currentState.length <= 500`
*   `currentState[i]` is either `'+'` or `'-'`.
