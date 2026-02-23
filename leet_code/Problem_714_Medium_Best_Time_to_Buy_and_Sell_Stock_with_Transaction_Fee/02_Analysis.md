# Analysis for Best Time to Buy and Sell Stock with Transaction Fee
# *Phân tích cho bài toán Thời điểm tốt nhất để Mua và Bán Cổ phiếu có Phí giao dịch*

## 1. Problem Essence & State Space
## *1. Bản chất vấn đề & Không gian Trạng thái*

### The Challenge
### *Thách thức*
We can make unlimited transactions, but each trade incurs a fee. This means we should only sell if the profit outweighs the fee. This is a classic dynamic programming problem with two recurring states: "holding a stock" or "not holding a stock."
*Chúng ta có thể thực hiện vô số giao dịch, nhưng mỗi lần giao dịch đều tốn phí. Điều này có nghĩa là ta chỉ nên bán nếu lợi nhuận lớn hơn phí. Đây là bài toán quy hoạch động điển hình với hai trạng thái lặp lại: "đang giữ cổ phiếu" hoặc "không giữ cổ phiếu".*

---

## 2. Strategy: Finite State Machine (DP)
## *2. Chiến lược: Máy trạng thái hữu hạn (DP)*

### State Definition
### *Định nghĩa trạng thái*
- `hold`: Max profit on current day if we **have** a stock.
- `free`: Max profit on current day if we **do not have** a stock.
* - `hold`: Lợi nhuận tối đa nếu đang giữ một cổ phiếu.*
* - `free`: Lợi nhuận tối đa nếu không giữ cổ phiếu nào.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Transition for `hold`:**
    - Either we continue holding the stock we bought yesterday: `hold[i-1]`.
    - Or we buy a stock today (meaning we must have been "free" yesterday): `free[i-1] - prices[i]`.
    - `hold[i] = max(hold[i-1], free[i-1] - prices[i])`.
    * **Chuyển trạng thái cho `hold`:** Hoặc tiếp tục giữ từ hôm qua, hoặc hôm nay mua mới.*

2.  **Transition for `free`:**
    - Either we stay free (no stock today and no stock yesterday): `free[i-1]`.
    - Or we sell the stock we were holding: `hold[i-1] + prices[i] - fee`.
    - `free[i] = max(free[i-1], hold[i-1] + prices[i] - fee)`.
    * **Chuyển trạng thái cho `free`:** Hoặc tiếp tục không giữ cổ phiếu, hoặc hôm nay bán cổ phiếu đang có.*

3.  **Space Optimization:** Since current day only depends on the previous day, we only need two variables instead of an array.
    * **Tối ưu không gian:** Chỉ cần dùng hai biến thay vì mảng.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Linear Efficiency:** The algorithm scans the price array once, leading to $O(N)$ time.
    * **Hiệu suất Tuyến tính:** Thuật toán chỉ quét mảng một lần.*
*   **Logical Consistency:** By grouping the fee with the `sale` action (or the `buy` action, as long as it's consistent), the model accurately reflects the net gain.
    * **Tính nhất quán:** Việc gộp phí vào hành động bán giúp mô hình phản ánh chính xác lợi nhuận ròng.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the number of days.
    * **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(1)$ with variable-based DP.
    * **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**prices = [1, 3, 8], fee = 2**
1. Day 0 (1): `hold = -1`, `free = 0`.
2. Day 1 (3):
   - `hold = max(-1, 0 - 3) = -1`.
   - `free = max(0, -1 + 3 - 2) = 0`.
3. Day 2 (8):
   - `hold = max(-1, 0 - 8) = -1`.
   - `free = max(0, -1 + 8 - 2) = 5`.
**Result:** 5.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

For all stock problems in LeetCode, defining the "state" (held vs free) is the most reliable method. The transition equations rarely change; only the specific constraints (fees, cooldowns, transaction limits) differ.
*Đối với mọi bài toán cổ phiếu, việc định nghĩa "trạng thái" là phương pháp đáng tin cậy nhất. Các phương trình chuyển đổi thường tương tự nhau, chỉ khác ở các ràng buộc cụ thể.*
---
*Lợi nhuận (Profit) không chỉ là sự chênh lệch giá, mà là kết quả của sự kiên nhẫn sau khi trừ đi chi phí của hành động (Fee). Trong sự dao động của thị trường (Prices), máy trạng thái (DP) giúp ta giữ được sự thấu thị về việc khi nào nên nắm giữ (Hold) và khi nào nên tự do (Free). Dữ liệu dạy ta rằng bằng cách tích lũy giá trị từ những quyết định đúng đắn nhất trong quá khứ, ta có thể đạt được sự thịnh vượng tối ưu giữa những biến động không ngừng.*
Profit (Profit) is not just the price difference, but the result of patience after subtracting the cost of action (Fee). In the fluctuations of the market (Prices), the state machine (DP) helps us maintain insight into when to hold (Hold) and when to be free (Free). Data teaches us that by accumulating value from the best decisions in the past, we can achieve optimal prosperity amid constant fluctuations.
