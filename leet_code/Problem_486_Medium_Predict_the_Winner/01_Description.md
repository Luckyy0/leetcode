# Result for Predict the Winner
# *Kết quả cho bài toán Dự đoán Người thắng*

## Description
## *Mô tả*

You are given an integer array `nums`. Two players are playing a game with this array: player 1 and player 2.
*Bạn được cho một mảng số nguyên `nums`. Hai người chơi đang chơi một trò chơi với mảng này: người chơi 1 và người chơi 2.*

Player 1 and player 2 take turns, with player 1 starting first. Both players start the game with a score of `0`. At each turn, the player takes one of the numbers from either end of the array (i.e., `nums[0]` or `nums[nums.length - 1]`) which reduces the size of the array by 1. The player adds the chosen number to their score. The game ends when there are no more elements in the array.
*Người chơi 1 và người chơi 2 lần lượt đi, với người chơi 1 bắt đầu trước. Cả hai người chơi bắt đầu trò chơi với số điểm là `0`. Tại mỗi lượt, người chơi lấy một trong các số từ một trong hai đầu của mảng (tức là `nums[0]` hoặc `nums[nums.length - 1]`), làm giảm kích thước của mảng đi 1. Người chơi cộng số đã chọn vào điểm số của họ. Trò chơi kết thúc khi không còn phần tử nào trong mảng.*

Return `true` if Player 1 can win the game. If the scores of both players are equal, then player 1 is still the winner, and you should also return `true`. You may assume that both players are playing optimally.
*Hãy trả về `true` nếu Người chơi 1 có thể thắng trò chơi. Nếu điểm số của cả hai người chơi bằng nhau, thì người chơi 1 vẫn là người chiến thắng và bạn cũng nên trả về `true`. Bạn có thể giả định rằng cả hai người chơi đều chơi tối ưu.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [1,5,2]`
**Output:** `false`
**Explanation:** Initially, player 1 can choose between 1 and 2. 
If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2). 
So, final score of player 1 is 1 + 2 = 3, and player 2 is 5.
Hence, player 1 will never be the winner and you need to return false.

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [1,5,233,7]`
**Output:** `true`
**Explanation:** Player 1 first chooses 1. Then player 2 have to choose between 5 and 7. No matter which number player 2 choose, player 1 can choose 233.
Finally, player 1 has more score (234) than player 2 (12), so you need to return True.

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 20`
*   `0 <= nums[i] <= 10^7`
