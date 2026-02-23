# Result for Can I Win
# *Kết quả cho bài toán Tôi có thể Thắng không*

## Description
## *Mô tả*

In the "100 game", two players take turns adding, to a running total, any integer from `1` to `10`. The player who first causes the running total to reach or exceed 100 wins.
*Trong "trò chơi 100", hai người chơi thay phiên nhau cộng thêm bất kỳ số nguyên nào từ `1` đến `10` vào một tổng đang chạy. Người chơi đầu tiên làm cho tổng đạt đến hoặc vượt quá 100 sẽ giành chiến thắng.*

What if we change the game so that players **cannot re-use integers**?
*Điều gì sẽ xảy ra nếu chúng ta thay đổi trò chơi sao cho người chơi **không thể sử dụng lại các số nguyên**?*

For example, two players might take turns drawing from a common pool of numbers from `1` to `15` without replacement until they reach a total >= 100.
*Ví dụ: hai người chơi có thể thay phiên nhau rút từ một tập hợp chung các số từ `1` đến `15` mà không được thay thế cho đến khi tổng của họ đạt >= 100.*

Given two integers `maxChoosableInteger` and `desiredTotal`, return `true` if the first player to move can force a win, otherwise, return `false`. Assume both players play optimally.
*Cho hai số nguyên `maxChoosableInteger` và `desiredTotal`, hãy trả về `true` nếu người chơi đầu tiên thực hiện lượt đi có thể cưỡng ép một chiến thắng, ngược lại, hãy trả về `false`. Giả định cả hai người chơi đều chơi một cách tối ưu.*

## Example 1:
## *Ví dụ 1:*

**Input:** `maxChoosableInteger = 10, desiredTotal = 11`
**Output:** `false`
**Explanation:**
No matter which integer the first player chooses, the second player will always be able to win.
The first player chooses 1, second player chooses 10 (total 11).
The first player chooses 2, second player chooses 9 (total 11).
...
The first player chooses 10, second player chooses 1 (total 11).

## Example 2:
## *Ví dụ 2:*

**Input:** `maxChoosableInteger = 10, desiredTotal = 0`
**Output:** `true`

## Example 3:
## *Ví dụ 3:*

**Input:** `maxChoosableInteger = 10, desiredTotal = 1`
**Output:** `true`

## Constraints:
## *Ràng buộc:*

*   `1 <= maxChoosableInteger <= 20`
*   `0 <= desiredTotal <= 300`
