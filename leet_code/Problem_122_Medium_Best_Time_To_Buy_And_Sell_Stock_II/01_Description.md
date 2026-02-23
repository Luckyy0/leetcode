# Result for Best Time to Buy and Sell Stock II
# *Kết quả cho bài toán Thời Điểm Tốt Nhất để Mua và Bán Cổ Phiếu II*

## Description
## *Mô tả*

You are given an integer array `prices` where `prices[i]` is the price of a given stock on the `i`-th day.
*Bạn được cho một mảng số nguyên `prices` trong đó `prices[i]` là giá của một cổ phiếu nhất định vào ngày thứ `i`.*

On each day, you may decide to buy and/or sell the stock. You can only hold **at most one** share of the stock at any time. However, you can buy it then immediately sell it on the **same day**.
*Vào mỗi ngày, bạn có thể quyết định mua và/hoặc bán cổ phiếu. Bạn chỉ có thể nắm giữ **tối đa một** cổ phiếu tại bất kỳ thời điểm nào. Tuy nhiên, bạn có thể mua nó rồi bán ngay lập tức trong **cùng một ngày**.*

Find and return *the **maximum** profit you can achieve*.
*Tìm và trả về *lợi nhuận **tối đa** bạn có thể đạt được**.*

## Example 1:
## *Ví dụ 1:*

**Input:** `prices = [7,1,5,3,6,4]`
**Output:** `7`
**Explanation:** Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5 - 1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6 - 3 = 3.
Total profit is 4 + 3 = 7.

## Example 2:
## *Ví dụ 2:*

**Input:** `prices = [1,2,3,4,5]`
**Output:** `4`
**Explanation:** Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5 - 1 = 4.
Total profit is 4.

## Example 3:
## *Ví dụ 3:*

**Input:** `prices = [7,6,4,3,1]`
**Output:** `0`
**Explanation:** There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.

## Constraints:
## *Ràng buộc:*

*   `1 <= prices.length <= 3 * 10^4`
*   `0 <= prices[i] <= 10^4`
