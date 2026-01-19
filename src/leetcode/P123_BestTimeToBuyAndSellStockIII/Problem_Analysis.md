# 123. Best Time to Buy and Sell Stock III / Thời Điểm Tốt Nhất để Mua và Bán Cổ Phiếu III

## Problem Description / Mô tả bài toán
You are given an array `prices` where `prices[i]` is the price of a given stock on the `i`th day.
Bạn được cho một mảng `prices` trong đó `prices[i]` là giá của một cổ phiếu vào ngày thứ `i`.

Find the maximum profit you can achieve. You may complete **at most two transactions**.
Tìm lợi nhuận tối đa bạn có thể đạt được. Bạn có thể hoàn thành **tối đa hai giao dịch**.

**Note**: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
**Lưu ý**: Bạn không thể tham gia vào nhiều giao dịch đồng thời (tức là bạn phải bán cổ phiếu trước khi mua lại).

### Example 1:
```text
Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy day 4 (0), sell day 6 (3), profit = 3. Buy day 7 (1), sell day 8 (4), profit = 3. Total = 6.
```

### Example 2:
```text
Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy day 1 (1), sell day 5 (5), profit = 4. One transaction is enough.
```

### Example 3:
```text
Input: prices = [7,6,4,3,1]
Output: 0
```

## Constraints / Ràng buộc
- `1 <= prices.length <= 10^5`
- `0 <= prices[i] <= 10^5`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Problem Progression / Tiến trình Bài toán

| Problem | Transactions | Approach |
|---------|--------------|----------|
| 121 | At most 1 | Track min, compute max profit |
| 122 | Unlimited | Sum all positive differences |
| **123** | **At most 2** | **State machine DP** |

### State Machine Model / Mô hình Máy Trạng thái
Track 4 states at each day:
Theo dõi 4 trạng thái tại mỗi ngày:

1.  `buy1`: Max profit after **first buy** (or still waiting).
2.  `sell1`: Max profit after **first sell**.
3.  `buy2`: Max profit after **second buy** (reusing sell1 profit).
4.  `sell2`: Max profit after **second sell**.

### State Transitions / Chuyển đổi Trạng thái
```
buy1 = max(buy1, -price)              // Buy first stock (spend money)
sell1 = max(sell1, buy1 + price)      // Sell first stock
buy2 = max(buy2, sell1 - price)       // Buy second stock (use sell1 profit)
sell2 = max(sell2, buy2 + price)      // Sell second stock
```

**Key Insight / Điểm quan trọng**: 
- `buy1` tracks the best buy point for first transaction.
- `sell1` uses `buy1` to maximize first transaction profit.
- `buy2` builds on `sell1`, effectively "reinvesting" first profit.
- `sell2` gives final answer.

---

## Analysis / Phân tích

### Approach: State Machine DP / DP Máy Trạng thái

**Algorithm**:
```
buy1 = -infinity, sell1 = 0
buy2 = -infinity, sell2 = 0

for each price:
    buy1 = max(buy1, -price)
    sell1 = max(sell1, buy1 + price)
    buy2 = max(buy2, sell1 - price)
    sell2 = max(sell2, buy2 + price)

return sell2
```

### Why This Works / Tại sao Điều này Hoạt động
- Each state depends only on previous states.
- Order of updates matters: use previous day's values.
- Can process all in single pass because updates are chained correctly.

### Complexity / Độ phức tạp
- **Time**: O(N) - single pass.
- **Space**: O(1) - only 4 variables.

---

## Edge Cases / Các trường hợp biên
1.  **Single day or no profit**: Return 0.
2.  **One transaction is optimal**: sell2 will capture it.
3.  **Two separate peaks**: Captures both.
