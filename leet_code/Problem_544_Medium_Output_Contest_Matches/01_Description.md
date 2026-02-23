# Result for Output Contest Matches
# *Kết quả cho bài toán Xuất Kết quả Trận đấu*

## Description
## *Mô tả*

During the NBA playoffs, we always arrange the rather strong team to play with the rather weak team, like make the rank 1 team play with the rank `n` team, which is a good strategy to make the contest more interesting.
*Trong vòng loại trực tiếp NBA, chúng tôi luôn sắp xếp đội mạnh hơn chơi với đội yếu hơn, như xếp đội hạng 1 đấu với đội hạng `n`, đây là chiến lược tốt để làm cho cuộc thi thú vị hơn.*

Now, you're given **n** teams, with integer `1` to `n`, which indicates their rank. In the first round, we divide the teams into two part: the first part consists of teams with rank `1` to `n/2`, and the second part consists of teams with rank `n/2 + 1` to `n`. We decide which team will play with which team using the following pattern:
*Bây giờ, bạn được cung cấp **n** đội, với số nguyên `1` đến `n`, biểu thị thứ hạng của họ. Ở vòng đầu tiên, chúng tôi chia các đội thành hai phần: phần đầu tiên bao gồm các đội có thứ hạng `1` đến `n/2`, và phần thứ hai bao gồm các đội có thứ hạng `n/2 + 1` đến `n`. Chúng tôi quyết định đội nào sẽ đấu với đội nào bằng cách sử dụng mẫu sau:*

1.  The strongest team from the first part plays with the weakest team from the second part.
    *Đội mạnh nhất từ phần đầu tiên đấu với đội yếu nhất từ phần thứ hai.*
2.  The second strongest team from the first part plays with the second weakest team from the second part.
    *Đội mạnh thứ hai từ phần đầu tiên đấu với đội yếu thứ hai từ phần thứ hai.*
3.  And so on... until the last team from the first part plays with the first team from the second part.
    *Và cứ thế... cho đến khi đội cuối cùng từ phần đầu tiên đấu với đội đầu tiên từ phần thứ hai.*

The contest pairs in this round are `(1,n)`, `(2,n-1)`, ..., `(n/2, n/2+1)`. Determine the matches that are played in the first round.
*Các cặp đấu trong vòng này là `(1,n)`, `(2,n-1)`, ..., `(n/2, n/2+1)`. Xác định các trận đấu được chơi trong vòng đầu tiên.*

However, the winner of a match will play with the winner of another match in the next round. Actually, whoever the winner is, valid matches in the next round should be the winner of `(1,n)` plays with the winner of `(n/2, n/2+1)`, the winner of `(2,n-1)` plays with the winner of `(n/2-1, n/2+2)`, and so on. This pattern repeats until the final round.
*Tuy nhiên, người chiến thắng trong một trận đấu sẽ đấu với người chiến thắng của một trận đấu khác trong vòng tiếp theo. Thực tế, bất kể người chiến thắng là ai, các trận đấu hợp lệ trong vòng tiếp theo sẽ là người chiến thắng của `(1,n)` đấu với người chiến thắng của `(n/2, n/2+1)`, người chiến thắng của `(2,n-1)` đấu với người chiến thắng của `(n/2-1, n/2+2)`, và cứ thế. Mẫu này lặp lại cho đến vòng chung kết.*

You need to return the matches in string format for the final round.
*Bạn cần trả về các trận đấu ở định dạng chuỗi cho vòng chung kết.*

## Example 1:
## *Ví dụ 1:*

**Input:** `n = 4`
**Output:** `"((1,4),(2,3))"`
**Explanation:** 
In the first round, we pair the team 1 and 4, the team 2 and 3 together, as we need to make the strong team and weak team together.
And we got (1,4),(2,3).
In the second round, the winners of (1,4) and (2,3) need to play again to generate the final winner, so you need to add the parantheses outside them.
And we got the final answer ((1,4),(2,3)).

## Example 2:
## *Ví dụ 2:*

**Input:** `n = 8`
**Output:** `"(((1,8),(4,5)),((2,7),(3,6)))"`

## Constraints:
## *Ràng buộc:*

*   `n` is an integer in range `[2, 4096]`.
*   `n` is a power of 2.
