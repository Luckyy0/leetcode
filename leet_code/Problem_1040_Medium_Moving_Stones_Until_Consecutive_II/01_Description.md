# Moving Stones Until Consecutive II
# *Di chuyển Đá cho đến khi Liên tiếp II*

## Description
## *Mô tả*

There are some stones in different positions on the X-axis. You are given an integer array `stones`, the positions of the stones.
*Có một số viên đá nằm ở các vị trí khác nhau trên trục X. Bạn được cung cấp một mảng số nguyên `stones`, chứa tọa độ vị trí của các viên đá đó.*

Call a stone an **endpoint** stone if it has the smallest or largest position. In one move, you can pick up an endpoint stone and move it to an unoccupied position so that it is no longer an endpoint stone.
*Một viên đá được gọi là **viên đá mút** (chặn đầu/đuôi) nếu nó nằm ở vị trí nhỏ nhất hoặc lớn nhất. Trong một lượt di chuyển, bạn có thể nhặt viên đá mút chóp này và ném nó vào một khoảng trống bên trong sao cho nó không còn là viên đá mút nữa.*

- In particular, if the stones are at say, `stones = [1,2,5]`, you cannot move the endpoint stone at position `5`, since moving it to any position (such as `0`, or `3`) will still keep that stone as an endpoint stone.
- *Cụ thể, giả sử các viên đá nằm ở `stones = [1,2,5]`; bạn không thể bốc viên đá chóp đuôi `5` và ném ra vị trí `0` hoặc `3` vì dù có ném đi, nó (nếu ở 0) hoặc một cục khác (nếu 5 nảy vào 3 thì 3 sẽ là đầu chóp) vẫn duy trì luật đá mút vi phạm.* (Lưu ý: Ví dụ gốc chỉ cấm hành động làm nó THÀNH viên mút mới, ví ném 5 tới 0. Ném 5 tới 3 thì 1,2,3 biến 3 thành mút lớn nhất, nó không hợp lệ vì luật phải chen VÀO GIỮA - *into an unoccupied position between other stones*).

The game ends when you cannot make any more moves, i.e., the stones are in consecutive positions.
*Trò chơi kết thúc khi bạn không thể lê chuyển thêm được bước nào nữa, tức là toàn bộ đá đã nằm co cụm khít rịt vào nhau liên tiếp trên trục số.*

Return an integer array `answer` of length 2 where:
*Trả về một mảng số nguyên dạng `answer` có độ dài 2 trong đó:*
- `answer[0]` is the minimum number of moves you can play, and
- *`answer[0]` là số bước di chuyển Tối thiều bạn cần chơi.*
- `answer[1]` is the maximum number of moves you can play.
- *`answer[1]` là số lượng chiêu dời đá Tối Đa vắt kiệt để giải quyết.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** stones = [7,4,9]
**Output:** [1,2]
**Explanation:** 
*Giải thích:*
We can move 4 -> 8 for one move to finish the game.
*Nhặt 4 thả xen vào ô 8. Chi mất đúng chóc 1 bước (7, 8, 9).*
Or, we can move 9 -> 5, 4 -> 6 for two moves.
*Hoặc dắt dây: bốc 9 bỏ vào 5, bốc 4 nhét vào 6. Hết trò trong 2 bước.*

## Example 2:
## *Ví dụ 2:*

**Input:** stones = [6,5,4,3,10]
**Output:** [2,3]
**Explanation:** 
*Giải thích:*
We can move 3 -> 8 then 10 -> 7 to finish the game.
*Chúng ta chuyển 3 nhét vào 8, tiếp đó lôi nốt 10 đáp vào 7 để đóng trò.*
Or, we can move 3 -> 7, 4 -> 8, 5 -> 9 to finish the game.
*Hoặc ta có thể chuyển 3 đến 7, 4 sang 8 và 5 kéo lên 9 là xế lại.* Note we cannot move 10 -> 2 to finish the game, because that would be an illegal move.
*Chú ý rằng không được lôi 10 vứt xuống tọa độ 2, bởi vì đó là lượt đi lề luật Cấm.*

## Constraints:
## *Ràng buộc:*

*   `3 <= stones.length <= 10^4`
*   `1 <= stones[i] <= 10^9`
*   All the values of `stones` are unique.
*   *Tất cả giá trị của `stones` đều là duy nhất.*
