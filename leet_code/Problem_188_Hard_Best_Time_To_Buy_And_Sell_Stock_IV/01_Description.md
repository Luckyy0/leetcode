# Result for Best Time to Buy and Sell Stock IV
# *Kết quả cho bài toán Thời điểm tốt nhất để mua và bán cổ phiếu IV*

## Description
## *Mô tả*

You are given an integer array `prices` where `prices[i]` is the price of a given stock on the `i-th` day, and an integer `k`.
*Bạn được cho một mảng số nguyên `prices` trong đó `prices[i]` là giá của một loại cổ phiếu nhất định vào ngày thứ `i`, và một số nguyên `k`.*

Find the maximum profit you can achieve. You may complete at most `k` transactions.
*Tìm lợi nhuận tối đa bạn có thể đạt được. Bạn có thể hoàn thành tối đa `k` giao dịch.*

**Note:** You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
**Lưu ý:** Bạn không thể tham gia nhiều giao dịch cùng một lúc (nghĩa là bạn phải bán cổ phiếu trước khi mua lại).*

## Example 1:
## *Ví dụ 1:*

**Input:** `k = 2, prices = [2,4,1]`
**Output:** `2`
**Explanation:** Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.

## Example 2:
## *Ví dụ 2:*

**Input:** `k = 2, prices = [3,2,6,5,0,3]`
**Output:** `7`
**Explanation:** Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.

## Constraints:
## *Ràng buộc:*

*   `0 <= k <= 100`
*   `0 <= prices.length <= 1000`
*   `0 <= prices[i] <= 1000`
