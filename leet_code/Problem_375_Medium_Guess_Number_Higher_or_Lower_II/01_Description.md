# Result for Guess Number Higher or Lower II
# *Kết quả cho bài toán Đoán số Cao hơn hay Thấp hơn II*

## Description
## *Mô tả*

We are playing the Guessing Game. The game will be as follows:
*Chúng ta đang chơi Trò chơi Đoán số. Trò chơi sẽ như sau:*

1.  I pick a number from `1` to `n`.
2.  You have to guess which number I picked.
3.  Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess, and you will pay me the amount of money equal to the number you guessed.
4.  When you guess the correct number, the game will stop and you do not need to pay anything.

Given a particular `n`, return *the minimum amount of money you need to **guarantee a win** regardless of what number I pick*.
*Cho một số nguyên `n`, hãy trả về *số tiền tối thiểu bạn cần để **đảm bảo chiến thắng** bất kể tôi chọn số nào*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `n = 10`
**Output:** `16`
**Explanation:** The winning strategy is as follows:
- The range is [1,10]. Guess 7.
    - If this is my number, your total is $0. Otherwise, you pay $7.
    - If my number is higher than 7, the range is [8,10]. Guess 9.
        - If this is my number, your total is $7. Otherwise, you pay $9.
        - If my number is higher than 9, the only possible number is 10. Guess 10. Your total is $7 + $9 = $16.
        - If my number is lower than 9, the only possible number is 8. Guess 8. Your total is $7 + $9 = $16.
    - If my number is lower than 7, the range is [1,6]. Guess 3.
        - ... (and so on)
In the worst case, you will pay $16.

## Example 2:
## *Ví dụ 2:*

**Input:** `n = 1`
**Output:** `0`

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 200`
