# 309. Best Time to Buy and Sell Stock with Cooldown / Thời Điểm Tốt Nhất Để Mua Và Bán Cổ Phiếu Có Thời Gian Hồi Chiêu

## Problem Description / Mô tả bài toán
You are given an array `prices` where `prices[i]` is the price of a given stock on the `i-th` day.
Bạn được cung cấp một mảng `prices` trong đó `prices[i]` là giá của một cổ phiếu nhất định vào ngày thứ `i`.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
Tìm lợi nhuận tối đa bạn có thể đạt được. Bạn có thể hoàn thành bao nhiêu giao dịch tùy ý (tức là mua một và bán một cổ phiếu nhiều lần) với các hạn chế sau:

- After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
- Sau khi bạn bán cổ phiếu của mình, bạn không thể mua cổ phiếu vào ngày hôm sau (tức là thời gian hồi chiêu một ngày).

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
Lưu ý: Bạn không được tham gia nhiều giao dịch cùng một lúc (tức là bạn phải bán cổ phiếu trước khi mua lại).

### Example 1:
```text
Input: prices = [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
```

### Example 2:
```text
Input: prices = [1]
Output: 0
```

## Constraints / Ràng buộc
- `1 <= prices.length <= 5000`
- `0 <= prices[i] <= 1000`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Dynamic Programming with State Machine / Quy Hoạch Động với Máy Trạng Thái
States:
1.  **Hold**: Max profit if we hold a stock at end of day `i`.
2.  **Sold**: Max profit if we sold a stock on day `i`. (Just sold).
3.  **Rest**: Max profit if we assume NO stock is held and NO stock was sold today (cooldown or idling).

**Transitions**:
- `Hold[i]`:
    - Keep holding: `Hold[i-1]`
    - Just bought: `Rest[i-1] - prices[i]`. (We buy from Rest state).
    - `Hold[i] = max(Hold[i-1], Rest[i-1] - prices[i])`.
- `Sold[i]`:
    - Just sold: `Hold[i-1] + prices[i]`.
    - `Sold[i] = Hold[i-1] + prices[i]`.
- `Rest[i]`:
    - Did nothing from Rest: `Rest[i-1]`.
    - Did nothing from Sold: `Sold[i-1]`.
    - `Rest[i] = max(Rest[i-1], Sold[i-1])`.

**Initialization**:
- `Hold[0] = -prices[0]`.
- `Sold[0] = 0` (Impossible to sell). Usually `-infinity`, but 0 is safe if we don't pick it (profit is >= 0). Actually, cannot sell on day 0. Let's say `Integer.MIN_VALUE`. Or simpler: `Rest[0] = 0`. `Sold[0] = 0`.
- `Rest[0] = 0`.

**Return**: `max(Sold[N-1], Rest[N-1])`. Note: `Hold` is never the end state for max profit (holding costs money).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N) or O(1) space optimization.

---

## Analysis / Phân tích

### Approach: DP with O(1) space
Variables: `held`, `sold`, `rest`.
Need `prev_held`, `prev_sold`, `prev_rest`.

Iteration:
- `next_held = max(prev_held, prev_rest - price)`
- `next_sold = prev_held + price`
- `next_rest = max(prev_rest, prev_sold)`

---
