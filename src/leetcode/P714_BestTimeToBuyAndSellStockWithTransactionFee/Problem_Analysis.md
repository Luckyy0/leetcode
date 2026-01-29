# 714. Best Time to Buy and Sell Stock with Transaction Fee / Thời điểm Tốt nhất để Mua và Bán Cổ phiếu với Phí Giao dịch

## Problem Description / Mô tả bài toán
You are given an array `prices` where `prices[i]` is the price of a given stock on the `ith` day, and an integer `fee` representing a transaction fee.
Bạn được cho một mảng `prices` trong đó `prices[i]` là giá của một cổ phiếu nhất định vào ngày thứ `i`, và một số nguyên `fee` đại diện cho phí giao dịch.

Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
Hãy tìm lợi nhuận tối đa bạn có thể đạt được. Bạn có thể thực hiện bao nhiêu giao dịch tùy thích, nhưng bạn cần trả phí giao dịch cho mỗi giao dịch đó.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
Lưu ý: Bạn không thể tham gia nhiều giao dịch cùng lúc (tức là bạn phải bán cổ phiếu trước khi mua lại).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Quy hoạch Động
We can maintain two states for each day:
- `hold[i]`: Maximum profit on day `i` if we hold a stock.
- `cash[i]`: Maximum profit on day `i` if we don't hold a stock (cash in hand).

Transitions:
- `cash[i] = max(cash[i-1], hold[i-1] + price[i] - fee)` (either stay in cash or sell today).
- `hold[i] = max(hold[i-1], cash[i-1] - price[i])` (either keep holding or buy today).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1) by only keeping the previous day's state.

---

## Analysis / Phân tích

### Approach: Iterative State Transition
Maintain `cash` and `hold` variables. For each price, update the two states to reflect the best possible outcome.
Duy trì các biến `cash` và `hold`. Đối với mỗi mức giá, hãy cập nhật hai trạng thái để phản ánh kết quả tốt nhất có thể.

---
