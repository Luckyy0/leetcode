# Result for Coin Change II
# *Kết quả cho bài toán Đổi Tiền II*

## Description
## *Mô tả*

You are given an integer array `coins` representing coins of different denominations and an integer `amount` representing a total amount of money.
*Bạn được cho một mảng số nguyên `coins` đại diện cho các đồng xu có mệnh giá khác nhau và một số nguyên `amount` đại diện cho tổng số tiền.*

Return *the number of combinations that make up that amount*. If that amount of money cannot be made up by any combination of the coins, return `0`.
*Trả về *số lượng kết hợp tạo thành số tiền đó*. Nếu số tiền đó không thể được tạo thành bởi bất kỳ sự kết hợp nào của các đồng xu, hãy trả về `0`.*

You may assume that you have an infinite number of each kind of coin.
*Bạn có thể giả định rằng bạn có vô số đồng xu mỗi loại.*

The answer is guaranteed to fit into a signed 32-bit integer.
*Đáp án được đảm bảo nằm trong phạm vi số nguyên có dấu 32-bit.*

## Example 1:
## *Ví dụ 1:*

**Input:** `amount = 5, coins = [1,2,5]`
**Output:** `4`
**Explanation:** there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1

## Example 2:
## *Ví dụ 2:*

**Input:** `amount = 3, coins = [2]`
**Output:** `0`
**Explanation:** the amount of 3 cannot be made up just with coins of 2.

## Example 3:
## *Ví dụ 3:*

**Input:** `amount = 10, coins = [10]`
**Output:** `1`

## Constraints:
## *Ràng buộc:*

*   `1 <= coins.length <= 300`
*   `1 <= coins[i] <= 5000`
*   `All the values of coins are unique.`
*   `0 <= amount <= 5000`
