# Result for Dota2 Senate
# *Kết quả cho bài toán Thượng viện Dota2*

## Description
## *Mô tả*

In the world of Dota2, there are two parties: the Radiant and the Dire.
*Trong thế giới của Dota2, có hai phe: Radiant và Dire.*

The Dota2 senate consists of senators coming from two parties. Now the Senate wants to decide on a change in the Dota2 game. The voting for this change is a round-based procedure. In each round, each senator can exercise **one** of the two rights:
*Thượng viện Dota2 bao gồm các thượng nghị sĩ đến từ hai phe. Bây giờ Thượng viện muốn quyết định một thay đổi trong trò chơi Dota2. Việc bỏ phiếu cho thay đổi này là một quy trình theo vòng. Trong mỗi vòng, mỗi thượng nghị sĩ có thể thực hiện **một** trong hai quyền:*

1.  **Ban one senator's right:** A senator can make another senator from the opposite party lose all his rights in this and all the following rounds.
    *   *  **Cấm quyền của một thượng nghị sĩ:** Một thượng nghị sĩ có thể khiến một thượng nghị sĩ khác từ phe đối lập mất tất cả các quyền của mình trong vòng này và tất cả các vòng tiếp theo.*
2.  **Announce the victory:** If this senator found the senators who still have rights to vote are all from the same party, he can announce the victory and decide on the change in the game.
    *   *  **Tuyên bố chiến thắng:** Nếu thượng nghị sĩ này nhận thấy tất cả các thượng nghị sĩ vẫn còn quyền bỏ phiếu đều đến từ cùng một phe, ông ta có thể tuyên bố chiến thắng và quyết định thay đổi trong trò chơi.*

Given a string `senate` representing each senator's party belonging. The character `'R'` and `'D'` represent the Radiant party and the Dire party. Then if there are `n` senators, the size of the given string will be `n`.
*Cho một chuỗi `senate` đại diện cho phe của mỗi thượng nghị sĩ. Ký tự `'R'` và `'D'` đại diện cho phe Radiant và phe Dire. Nếu có `n` thượng nghị sĩ, kích thước của chuỗi đã cho sẽ là `n`.*

The round-based procedure starts from the first senator to the last senator in the given order. This procedure will last until the end of voting. All the senators who have lost their rights will be skipped during the procedure.
*Quy trình theo vòng bắt đầu từ thượng nghị sĩ đầu tiên đến thượng nghị sĩ cuối cùng theo thứ tự đã cho. Quy trình này sẽ kéo dài cho đến khi kết thúc bỏ phiếu. Tất cả các thượng nghị sĩ đã mất quyền sẽ bị bỏ qua trong quy trình.*

Suppose every senator is smart enough and will play the best strategy for his own party. Predict which party will finally announce the victory and change the Dota2 game. The output should be `"Radiant"` or `"Dire"`.
*Giả sử mọi thượng nghị sĩ đều đủ thông minh và sẽ chơi chiến lược tốt nhất cho phe của mình. Hãy dự đoán phe nào cuối cùng sẽ tuyên bố chiến thắng và thay đổi trò chơi Dota2. Kết quả trả về nên là `"Radiant"` hoặc `"Dire"`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** senate = "RD"
**Output:** "Radiant"
**Explanation:** 
The first senator comes from Radiant and he can just ban the next senator's right in round 1. 
And the second senator won't have any rights anymore since his right has been banned. 
In round 2, the first senator can just announce the victory since he is the only guy in the senate who can vote.

## Example 2:
## *Ví dụ 2:*

**Input:** senate = "RDD"
**Output:** "Dire"
**Explanation:** 
The first senator comes from Radiant and he can just ban the next senator's right in round 1. 
And the second senator's right will be banned that contains the one from Dire. 
Then the third senator comes from Dire and he can ban the first senator's right in round 1. 
And in round 2, the third senator can just announce the victory since he is the only guy in the senate who can vote.

---

## Constraints:
## *Ràng buộc:*

*   `n == senate.length`
*   `1 <= n <= 10^4`
*   `senate[i]` is either `'R'` or `'D'`.
