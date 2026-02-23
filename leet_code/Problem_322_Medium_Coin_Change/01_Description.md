# Result for Coin Change
# *Kết quả cho bài toán Đổi Tiền*

## Description
## *Mô tả*

You are given an integer array `coins` representing coins of different denominations and an integer `amount` representing a total amount of money.
*Bạn được cho một mảng số nguyên `coins` đại diện cho các đồng xu có mệnh giá khác nhau và một số nguyên `amount` đại diện cho tổng số tiền.*

Return *the fewest number of coins that you need to make up that amount*. If that amount of money cannot be made up by any combination of the coins, return `-1`.
*Trả về *số lượng đồng xu ít nhất mà bạn cần để tạo nên số tiền đó*. Nếu số tiền đó không thể được tạo thành bởi bất kỳ sự kết hợp nào của các đồng xu, trả về `-1`.*

You may assume that you have an infinite number of each kind of coin.
*Bạn có thể giả định rằng bạn có vô số đồng xu mỗi loại.*

## Example 1:
## *Ví dụ 1:*

**Input:** `coins = [1,2,5], amount = 11`
**Output:** `3`
**Explanation:** 11 = 5 + 5 + 1

## Example 2:
## *Ví dụ 2:*

**Input:** `coins = [2], amount = 3`
**Output:** `-1`

## Example 3:
## *Ví dụ 3:*

**Input:** `coins = [1], amount = 0`
**Output:** `0`

## Constraints:
## *Ràng buộc:*

*   `1 <= coins.length <= 12`
*   `1 <= coins[i] <= 2^31 - 1`
*   `0 <= amount <= 10^4`
