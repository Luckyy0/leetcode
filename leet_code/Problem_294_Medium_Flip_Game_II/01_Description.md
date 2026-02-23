# Result for Flip Game II
# *Kết quả cho bài toán Trò chơi Lật II*

## Description
## *Mô tả*

You are playing a Flip Game with your friend.
*Bạn đang chơi Trò chơi Lật với bạn của mình.*

You are given a string `currentState` that contains only `'+'` and `'-'`. You and your friend take turns to flip two **consecutive** `"++"` into `"--"`. The game ends when a person can no longer make a move to flip two consecutive `"++"`, and that person loses.
*Bạn được cung cấp một chuỗi `currentState` chỉ chứa `'+'` và `'-'`. Bạn và bạn của bạn thay phiên nhau lật hai `"++"` **liên tiếp** thành `"--"`. Trò chơi kết thúc khi một người không còn có thể thực hiện nước đi để lật hai `"++"` liên tiếp nữa, và người đó thua.*

Return `true` *if the starting player can guarantee a win*, and `false` otherwise.
*Trả về `true` *nếu người chơi bắt đầu có thể đảm bảo chiến thắng*, và `false` nếu ngược lại.*

## Example 1:
## *Ví dụ 1:*

**Input:** `currentState = "++++"`
**Output:** `true`
**Explanation:** The starting player can guarantee a win by flipping the middle "++" to become "+--+".

## Example 2:
## *Ví dụ 2:*

**Input:** `currentState = "+"`
**Output:** `false`

## Constraints:
## *Ràng buộc:*

*   `1 <= currentState.length <= 60`
*   `currentState[i]` is either `'+'` or `'-'`.

**Follow up:** Derive your algorithm's runtime complexity.
**Câu hỏi mở rộng:** Suy ra độ phức tạp thời gian chạy của thuật toán của bạn.
