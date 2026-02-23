# Result for Best Time to Buy and Sell Stock with Cooldown
# *Kết quả cho bài toán Thời điểm Tốt nhất để Mua và Bán Cổ phiếu với Thời gian Nghỉ*

## Description
## *Mô tả*

You are given an array `prices` where `prices[i]` is the price of a given stock on the `i^th` day.
*Bạn được cho một mảng `prices` trong đó `prices[i]` là giá của một cổ phiếu nhất định vào ngày thứ `i`.*

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
*   After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
*Tìm lợi nhuận tối đa bạn có thể đạt được. Bạn có thể hoàn thành bao nhiêu giao dịch tùy thích (tức là mua một và bán một cổ phiếu nhiều lần) với các hạn chế sau:*
*   *Sau khi bạn bán cổ phiếu của mình, bạn không thể mua cổ phiếu vào ngày hôm sau (tức là nghỉ một ngày).*

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
*Lưu ý: Bạn không thể tham gia nhiều giao dịch cùng lúc (tức là bạn phải bán cổ phiếu trước khi mua lại).*

## Example 1:
## *Ví dụ 1:*

**Input:** `prices = [1,2,3,0,2]`
**Output:** `3`
**Explanation:** transactions = [buy, sell, cooldown, buy, sell]

## Example 2:
## *Ví dụ 2:*

**Input:** `prices = [1]`
**Output:** `0`

## Constraints:
## *Ràng buộc:*

*   `1 <= prices.length <= 5000`
*   `0 <= prices[i] <= 1000`
