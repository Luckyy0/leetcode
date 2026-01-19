# 188. Best Time to Buy and Sell Stock IV / Thời điểm Tốt nhất để Mua và Bán Cổ phiếu IV

## Problem Description / Mô tả bài toán
You are given an integer array `prices` where `prices[i]` is the price of a given stock on the `i-th` day, and an integer `k`.
Cho một mảng số nguyên `prices` trong đó `prices[i]` là giá của một cổ phiếu nhất định vào ngày thứ `i`, và một số nguyên `k`.

Find the maximum profit you can achieve. You may complete at most `k` transactions: i.e. you may buy at most `k` times and sell at most `k` times.
Hãy tìm lợi nhuận tối đa bạn có thể đạt được. Bạn có thể thực hiện tối đa `k` giao dịch: nghĩa là bạn có thể mua tối đa `k` lần và bán tối đa `k` lần.

**Note**: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
**Lưu ý**: Bạn không được thực hiện nhiều giao dịch cùng một lúc (nghĩa là bạn phải bán cổ phiếu trước khi mua lại).

### Example 1:
```text
Input: k = 2, prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
```

### Example 2:
```text
Input: k = 2, prices = [3,2,6,5,0,3]
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3. Total profit = 4 + 3 = 7.
```

## Constraints / Ràng buộc
- `1 <= k <= 100`
- `1 <= prices.length <= 1000`
- `0 <= prices[i] <= 1000`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Dynamic Programming with State Machine / Quy hoạch động với Máy trạng thái
This problem can be generalized as finding the maximum profit with `k` transactions. Each transaction consists of two states: "holding a stock" and "not holding a stock".
Bài toán này có thể được tổng quát hóa thành việc tìm lợi nhuận tối đa với `k` giao dịch. Mỗi giao dịch bao gồm hai trạng thái: "đang giữ cổ phiếu" và "không giữ cổ phiếu".

**State Definition**:
- `buy[i][j]`: Maximum profit on day `i` after performing at most `j` transactions and currently holding a stock.
- `sell[i][j]`: Maximum profit on day `i` after performing at most `j` transactions and currently NOT holding a stock.

**Transitions**:
- `buy[i][j] = max(buy[i-1][j], sell[i-1][j-1] - prices[i])`
- `sell[i][j] = max(sell[i-1][j], buy[i-1][j] + prices[i])`

**Optimization**:
Since the state only depends on the previous day, we can reduce space complexity to O(k).
Vì trạng thái chỉ phụ thuộc vào ngày hôm trước, chúng ta có thể giảm độ phức tạp không gian xuống O(k).

---

## Analysis / Phân tích

### Approach: Dynamic Programming (Space Optimized)

**Special Case**:
If `k >= n/2`, the problem becomes equivalent to infinite transactions (Best Time to Buy and Sell Stock II), as we can at most perform `n/2` transactions.
Nếu `k >= n/2`, bài toán trở nên tương đương với số giao dịch vô hạn, vì chúng ta chỉ có thể thực hiện tối đa `n/2` giao dịch.

**Complexity / Độ phức tạp**:
- **Time**: O(N * k)
- **Space**: O(k)

---

## Edge Cases / Các trường hợp biên
1.  **k = 0**: Profit is 0.
2.  **k is very large**: Handled by the infinite transaction logic.
3.  **prices.length < 2**: Profit is 0.
4.  **Decreasing prices**: Profit is 0.
