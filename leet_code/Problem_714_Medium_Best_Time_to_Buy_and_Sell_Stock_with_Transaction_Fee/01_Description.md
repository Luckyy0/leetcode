# Result for Best Time to Buy and Sell Stock with Transaction Fee
# *Kết quả cho bài toán Thời điểm tốt nhất để Mua và Bán Cổ phiếu có Phí giao dịch*

## Description
## *Mô tả*

You are given an array `prices` where `prices[i]` is the price of a given stock on the $i^{th}$ day, and an integer `fee` representing a transaction fee.
*Bạn được cho một mảng `prices` trong đó `prices[i]` là giá của một cổ phiếu vào ngày thứ $i$, và một số nguyên `fee` đại diện cho phí giao dịch.*

Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
*Hãy tìm lợi nhuận tối đa bạn có thể đạt được. Bạn có thể thực hiện bao nhiêu giao dịch tùy ý, nhưng bạn cần trả phí giao dịch cho mỗi lần giao dịch.*

**Note:** You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
*Lưu ý: Bạn không được thực hiện nhiều giao dịch cùng lúc (nghĩa là bạn phải bán cổ phiếu trước khi mua lại).*

---

## Example 1:
## *Ví dụ 1:*

**Input:** prices = [1,3,2,8,4,9], fee = 2
**Output:** 8
**Explanation:** The maximum profit can be achieved by:
- Buying at prices[0] = 1
- Selling at prices[3] = 8
- Buying at prices[4] = 4
- Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.

## Example 2:
## *Ví dụ 2:*

**Input:** prices = [1,3,7,5,10,3], fee = 3
**Output:** 6

---

## Constraints:
## *Ràng buộc:*

*   `1 <= prices.length <= 5 * 10^4`
*   `1 <= prices[i] < 5 * 10^4`
*   `0 <= fee < 5 * 10^4`
