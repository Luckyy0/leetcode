# Analysis for Best Time to Buy and Sell Stock IV
# *Phân tích cho bài toán Thời điểm tốt nhất để mua và bán cổ phiếu IV*

## 1. Problem Essence & Generalization
## *1. Bản chất vấn đề & Tổng quát hóa*

### The "k" Transactions Constraint
### *Ràng buộc "k" giao dịch*
This is the most general version of the stock trading problem.
- If $k=1$, it's Problem 121.
- If $k=\infty$, it's Problem 122.
- If $k=2$, it's Problem 123.
*Đây là phiên bản tổng quát nhất của bài toán giao dịch cổ phiếu. Nếu $k=1$, đó là Bài 121. Nếu $k=\infty$, đó là Bài 122. Nếu $k=2$, đó là Bài 123.*

The challenge is to efficiently manage the state for an arbitrary $k$.
*Thử thách là quản lý trạng thái hiệu quả cho một số $k$ tùy ý.*

### Quick Optimization
### *Tối ưu hóa nhanh*
If $k \ge n/2$, we can make as many transactions as we want (since a transaction requires at least 2 days). In this case, the problem reduces to Problem 122 (Infinite transactions), where we just collect every positive slope.
*Nếu $k \ge n/2$, chúng ta có thể thực hiện bao nhiêu giao dịch tùy thích (vì một giao dịch cần ít nhất 2 ngày). Trong trường hợp này, bài toán quy về Bài 122 (Giao dịch vô hạn), nơi chúng ta chỉ cần thu thập mọi con dốc dương.*

---

## 2. Approach: Dynamic Programming
## *2. Hướng tiếp cận: Quy hoạch động*

### State Definition
### *Định nghĩa trạng thái*
We need to track two things:
1.  How many transactions we have completed (or started).
2.  Whether we are currently holding a stock.

Let:
- `dp[i][0]` = Max profit using $i$ transactions and **having no stock** (sold).
- `dp[i][1]` = Max profit using $i$ transactions and **holding stock** (bought).
*Chúng ta cần theo dõi hai thứ: 1. Số lượng giao dịch đã hoàn thành. 2. Liệu chúng ta có đang giữ cổ phiếu hay không.*
*Gọi: `dp[i][0]` là lợi nhuận tối đa khi dùng $i$ giao dịch và không giữ cổ phiếu. `dp[i][1]` là lợi nhuận tối đa khi dùng $i$ giao dịch và đang giữ cổ phiếu.*

### Transitions
### *Chuyển đổi*
For each price `p` and for each transaction number `i` from 1 to `k`:
1.  `dp[i][0]` (Sell): Either keep previous state (don't sell) `dp[i][0]`, or sell the stock we are holding `dp[i][1] + p`.
    *`dp[i][0]` (Bán): Giữ trạng thái cũ hoặc bán cổ phiếu đang giữ.*
2.  `dp[i][1]` (Buy): Either keep previous state (don't buy) `dp[i][1]`, or buy new stock using profit from previous transaction `dp[i-1][0] - p`.
    *`dp[i][1]` (Mua): Giữ trạng thái cũ hoặc mua cổ phiếu mới bằng lợi nhuận từ giao dịch trước.*

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Memory Efficiency:** We can optimize the logic to use only two 1D arrays (or a single 2D array of size $k \times 2$) because the state of day `d` depends only on day `d-1`.
    *Hiệu quả bộ nhớ: Chúng ta có thể tối ưu hóa logic để chỉ sử dụng mảng 1D (hoặc mảng 2D kích thước $k \times 2$) vì trạng thái của ngày `d` chỉ phụ thuộc vào ngày `d-1`.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \times K)$, where $N$ is the number of days. For each day, we update $K$ states.
    *Độ phức tạp thời gian: $O(N \times K)$. Với mỗi ngày, chúng ta cập nhật $K$ trạng thái.*
*   **Space Complexity:** $O(K)$. We only need to store the current best values for each of the $K$ transactions.
    *Độ phức tạp không gian: $O(K)$.*

---

## 5. Visualized Dry Run (k=2)
## *5. Chạy thử bằng hình ảnh (k=2)*

**Price:** 3, 2, 6, 5, 0, 3

**Init:** `buy` array to $-\infty$, `sell` array to 0.

1.  **Day 1 (3):**
    - Buy1 = max(-inf, 0-3) = -3. Sell1 = 0.
    - Buy2 = -inf. Sell2 = 0.
2.  **Day 2 (2):**
    - Buy1 = max(-3, 0-2) = -2 (Better to buy at 2). Sell1 = max(0, -3+2) = 0.
    - Buy2 = max(-inf, 0-2) = -2. Sell2 = 0.
3.  **Day 3 (6):**
    - Buy1 = -2. Sell1 = max(0, -2+6) = 4 (Profit 4).
    - Buy2 = max(-2, 4-6) = -2. Sell2 = max(0, -2+6) = 4.
4.  **Day 4 (5):** ...
5.  **Day 5 (0):**
    - Buy2 might update (buy cheap using profit from first trade).
6.  **Day 6 (3):**
    - Sell2 might update (sell the cheap stock bought at 0).

**Result:** 7.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

This problem tests your ability to generalize DP state. The `buy[k]` and `sell[k]` array approach is standard. The tricky part is initialization (buy states should start at $-\infty$) and the loop order (iterate days outside, transactions inside). Don't forget the $O(N)$ shortcut for large $K$!
*Bài toán này kiểm tra khả năng tổng quát hóa trạng thái DP. Cách tiếp cận mảng `buy[k]` và `sell[k]` là tiêu chuẩn. Phần khó là khởi tạo (các trạng thái mua nên bắt đầu ở $-\infty$) và thứ tự vòng lặp (duyệt ngày bên ngoài, giao dịch bên trong). Đừng quên phím tắt $O(N)$ cho $K$ lớn!*
---
*Đầu tư không phải lúc nào cũng là mua thấp bán cao, mà là biết khi nào nên đứng ngoài cuộc chơi và khi nào nên tất tay.*
Investing is not always about buying low and selling high, but knowing when to stay out of the game and when to go all in.
