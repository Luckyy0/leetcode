# 122. Best Time to Buy and Sell Stock II / Thời Điểm Tốt Nhất để Mua và Bán Cổ Phiếu II

## Problem Description / Mô tả bài toán
You are given an integer array `prices` where `prices[i]` is the price of a given stock on the `i`th day.
Bạn được cho một mảng số nguyên `prices` trong đó `prices[i]` là giá của một cổ phiếu vào ngày thứ `i`.

On each day, you may decide to buy and/or sell the stock. You can only hold **at most one** share of the stock at any time. However, you can buy it then immediately sell it on the **same day**.
Vào mỗi ngày, bạn có thể quyết định mua và/hoặc bán cổ phiếu. Bạn chỉ có thể giữ **tối đa một** cổ phiếu tại bất kỳ thời điểm nào. Tuy nhiên, bạn có thể mua nó rồi ngay lập tức bán nó trong **cùng một ngày**.

Find and return the **maximum** profit you can achieve.
Tìm và trả về lợi nhuận **tối đa** bạn có thể đạt được.

### Example 1:
```text
Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy day 2 (1), sell day 3 (5), profit = 4.
             Buy day 4 (3), sell day 5 (6), profit = 3.
             Total profit = 7.
```

### Example 2:
```text
Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy day 1 (1), sell day 5 (5), profit = 4.
```

### Example 3:
```text
Input: prices = [7,6,4,3,1]
Output: 0
```

## Constraints / Ràng buộc
- `1 <= prices.length <= 3 * 10^4`
- `0 <= prices[i] <= 10^4`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Difference from Problem 121 / Khác biệt với Bài toán 121

| Problem | Transactions | Strategy |
|---------|--------------|----------|
| **121** | At most 1 | Single buy-sell |
| **122** | **Unlimited** | Multiple transactions |

### Key Insight: Collect All Upward Moves / Điểm quan trọng: Thu thập Tất cả Các Tăng

Since we can make unlimited transactions with no fee, the optimal strategy is:
Vì chúng ta có thể thực hiện không giới hạn giao dịch mà không có phí, chiến lược tối ưu là:
**Collect every positive difference between consecutive days.**
**Thu thập mọi chênh lệch dương giữa các ngày liên tiếp.**

```
prices = [1, 2, 3, 4, 5]

Consecutive differences: +1, +1, +1, +1
All positive → collect all: 1 + 1 + 1 + 1 = 4

This equals buying at 1, selling at 5!
```

### Why This Works / Tại sao Điều này Hoạt động
Any upward trend can be decomposed into daily gains:
Bất kỳ xu hướng tăng nào cũng có thể được phân tách thành lợi nhuận hàng ngày:
```
sell(day 5) - buy(day 1) = (p5-p4) + (p4-p3) + (p3-p2) + (p2-p1)
```

By collecting all positive `(prices[i] - prices[i-1])`, we capture all upward movements optimally.

---

## Analysis / Phân tích

### Approach: Greedy - Sum of Positive Differences / Tham lam - Tổng Các Chênh lệch Dương

**Algorithm**:
```
profit = 0
for i = 1 to n-1:
    if prices[i] > prices[i-1]:
        profit += prices[i] - prices[i-1]
return profit
```

### Complexity / Độ phức tạp
- **Time**: O(N) - single pass.
- **Space**: O(1) - only one variable.

---

## Edge Cases / Các trường hợp biên
1.  **Single day**: Return 0.
2.  **Decreasing prices**: Return 0.
3.  **All same price**: Return 0.
