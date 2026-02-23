# Result for Best Time to Buy and Sell Stock III
# *Kết quả cho bài toán Thời Điểm Tốt Nhất để Mua và Bán Cổ Phiếu III*

## Description
## *Mô tả*

You are given an array `prices` where `prices[i]` is the price of a given stock on the `i`-th day.
*Bạn được cho một mảng `prices` trong đó `prices[i]` là giá của một cổ phiếu nhất định vào ngày thứ `i`.*

Find the maximum profit you can achieve. You may complete **at most two transactions**.
*Tìm lợi nhuận tối đa bạn có thể đạt được. Bạn có thể thực hiện **tối đa hai giao dịch**.*

**Note:** You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
*Lưu ý: Bạn không được thực hiện nhiều giao dịch cùng một lúc (tức là bạn phải bán cổ phiếu trước khi mua lại).*

## Example 1:
## *Ví dụ 1:*

**Input:** `prices = [3,3,5,0,0,3,1,4]`
**Output:** `6`
**Explanation:** Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Total profit is 3 + 3 = 6.

## Example 2:
## *Ví dụ 2:*

**Input:** `prices = [1,2,3,4,5]`
**Output:** `4`
**Explanation:** Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging in multiple transactions simultaneously. You must sell before buying again.

## Example 3:
## *Ví dụ 3:*

**Input:** `prices = [7,6,4,3,1]`
**Output:** `0`
**Explanation:** In this case, no transaction is done, i.e. max profit = 0.

## Constraints:
## *Ràng buộc:*

*   `1 <= prices.length <= 10^5`
*   `0 <= prices[i] <= 10^5`
