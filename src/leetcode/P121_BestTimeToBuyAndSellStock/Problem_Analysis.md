# 121. Best Time to Buy and Sell Stock / Thời Điểm Tốt Nhất để Mua và Bán Cổ Phiếu

## Problem Description / Mô tả bài toán
You are given an array `prices` where `prices[i]` is the price of a given stock on the `i`th day.
Bạn được cho một mảng `prices` trong đó `prices[i]` là giá của một cổ phiếu vào ngày thứ `i`.

You want to maximize your profit by choosing a **single day** to buy one stock and choosing a **different day in the future** to sell that stock.
Bạn muốn tối đa hóa lợi nhuận của mình bằng cách chọn **một ngày** để mua một cổ phiếu và chọn **một ngày khác trong tương lai** để bán cổ phiếu đó.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return `0`.
Trả về lợi nhuận tối đa bạn có thể đạt được từ giao dịch này. Nếu bạn không thể đạt được bất kỳ lợi nhuận nào, trả về `0`.

### Example 1:
```text
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
```

### Example 2:
```text
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: No transaction is done, max profit = 0.
```

## Constraints / Ràng buộc
- `1 <= prices.length <= 10^5`
- `0 <= prices[i] <= 10^4`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Problem Reformulation / Tái xây dựng Bài toán
Find `max(prices[j] - prices[i])` where `j > i`.
Tìm `max(prices[j] - prices[i])` trong đó `j > i`.

This is equivalent to:
Điều này tương đương với:
- For each day `j`, find the minimum price on any day before `j`.
- Calculate `prices[j] - minPriceSoFar`.
- Track the maximum of these differences.

### One-Pass Algorithm Insight / Hiểu biết Thuật toán Một Lượt
As we iterate through prices:
Khi chúng ta duyệt qua các giá:

1.  **Track minimum price seen so far** (`minPrice`).
2.  **Calculate potential profit** if selling today: `prices[i] - minPrice`.
3.  **Update maximum profit** if current profit is higher.

```
prices = [7, 1, 5, 3, 6, 4]
         ↓  ↓  ↓  ↓  ↓  ↓
minPrice: 7  1  1  1  1  1
profit:   0  0  4  2  5  3
maxProfit:0  0  4  4  5  5
```

### Greedy Principle / Nguyên lý Tham lam
- Always buy at the lowest price seen so far.
- Always consider selling at current price.
- The optimal solution naturally emerges.

---

## Analysis / Phân tích

### Approach: One-Pass with Min Tracking / Một Lượt với Theo dõi Min

**Algorithm**:
```
minPrice = infinity
maxProfit = 0

for each price in prices:
    if price < minPrice:
        minPrice = price
    else:
        profit = price - minPrice
        maxProfit = max(maxProfit, profit)

return maxProfit
```

### Complexity / Độ phức tạp
- **Time**: O(N) - single pass through array.
- **Space**: O(1) - only two variables.

---

## Edge Cases / Các trường hợp biên
1.  **Single day**: Return 0 (can't buy and sell).
2.  **Decreasing prices**: Return 0 (no profit possible).
3.  **All same price**: Return 0.
