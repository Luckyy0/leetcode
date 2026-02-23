# Result for Guess Number Higher or Lower
# *Kết quả cho bài toán Đoán số Cao hơn hay Thấp hơn*

## Description
## *Mô tả*

We are playing the Guess Game. The game is as follows:
*Chúng ta đang chơi Trò chơi Đoán số. Trò chơi như sau:*

I pick a number from `1` to `n`. You have to guess which number I picked.
*Tôi chọn một con số từ `1` đến `n`. Bạn phải đoán xem tôi đã chọn số nào.*

Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
*Mỗi khi bạn đoán sai, tôi sẽ cho bạn biết số tôi đã chọn cao hơn hay thấp hơn số bạn đoán.*

You call a pre-defined API `int guess(int num)`, which returns three possible results:
*Bạn gọi một API đã được định nghĩa trước `int guess(int num)`, API này trả về ba kết quả có thể xảy ra:*

*   `-1`: Your guess is higher than the number I picked (i.e. `num > pick`).
*   `1`: Your guess is lower than the number I picked (i.e. `num < pick`).
*   `0`: your guess is equal to the number I picked (i.e. `num == pick`).

Return *the number that I picked*.
*Trả về *con số mà tôi đã chọn*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `n = 10, pick = 6`
**Output:** `6`

## Example 2:
## *Ví dụ 2:*

**Input:** `n = 1, pick = 1`
**Output:** `1`

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 2^31 - 1`
*   `1 <= pick <= n`
