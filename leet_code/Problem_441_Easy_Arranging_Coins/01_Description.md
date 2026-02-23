# Result for Arranging Coins
# *Kết quả cho bài toán Xếp tiền xu*

## Description
## *Mô tả*

You have `n` coins and you want to build a staircase with these coins. The staircase consists of `k` rows where the `i-th` row has exactly `i` coins. The last row of the staircase **may be** incomplete.
*Bạn có `n` đồng xu và muốn xây dựng một cầu thang bằng những đồng xu này. Cầu thang bao gồm `k` hàng, trong đó hàng thứ `i` có đúng `i` đồng xu. Hàng cuối cùng của cầu thang **có thể** không hoàn chỉnh.*

Given the integer `n`, return *the number of **complete rows** of the staircase you will build*.
*Cho số nguyên `n`, hãy trả về *số lượng **hàng hoàn chỉnh** của cầu thang mà bạn sẽ xây dựng được*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `n = 5`
**Output:** `2`
**Explanation:** Because the 3rd row is incomplete, we return 2.
- Row 1: 1 coin
- Row 2: 2 coins
- Row 3: 2 coins (incomplete, needs 3)

## Example 2:
## *Ví dụ 2:*

**Input:** `n = 8`
**Output:** `3`
**Explanation:** Because the 4th row is incomplete, we return 3.

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 2^{31} - 1`
