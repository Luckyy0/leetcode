# Analysis for Best Time to Buy and Sell Stock III
# *Phân tích cho bài toán Thời Điểm Tốt Nhất để Mua và Bán Cổ Phiếu III*

## 1. Problem complexity & States
## *1. Độ phức tạp của bài toán & Các trạng thái*

### The "At Most Two" Constraint
### *Ràng buộc "Tối đa Hai"*
*   This problem is significantly harder than previous versions because of the fixed transaction limit (up to 2). We cannot simply sum all positive differences like in Part II, and we cannot just find one min-max pair like in Part I.
    *Bài toán này khó hơn đáng kể so với các phiên bản trước vì giới hạn giao dịch cố định (tối đa 2). Chúng ta không thể chỉ đơn giản cộng tất cả các khoản chênh lệch dương như trong Phần II, và cũng không thể chỉ tìm một cặp min-max như trong Phần I.*
*   We need to track multiple stages of our investment journey simultaneously.
    *Chúng ta cần theo dõi đồng thời nhiều giai đoạn trong hành trình đầu tư của mình.*

### Defining the States
### *Định nghĩa các trạng thái*
At any given day, we can be in one of four states after taking an action:
*Vào bất kỳ ngày nào, chúng ta có thể ở một trong bốn trạng thái sau khi thực hiện một hành động:*
1.  **First Buy:** We have bought our first stock.
    *Mua lần đầu: Chúng ta đã mua cổ phiếu đầu tiên.*
2.  **First Sell:** We have sold our first stock. We now have a certain amount of cash (profit).
    *Bán lần đầu: Chúng ta đã bán cổ phiếu đầu tiên. Hiện tại chúng ta có một số tiền mặt (lợi nhuận).*
3.  **Second Buy:** We have bought our second stock using the profit from the first sale.
    *Mua lần hai: Chúng ta đã mua cổ phiếu thứ hai bằng cách sử dụng lợi nhuận từ lần bán đầu tiên.*
4.  **Second Sell:** We have sold our second stock. This is our final total profit.
    *Bán lần hai: Chúng ta đã bán cổ phiếu thứ hai. Đây là tổng lợi nhuận cuối cùng của chúng ta.*

---

## 2. Approach: DP with State Variables
## *2. Hướng tiếp cận: DP với các biến trạng thái*

### Logic
### *Logic*
We maintain four variables to represent the maximum money (balance) we can have in each state:
*Chúng ta duy trì bốn biến để đại diện cho số tiền (số dư) tối đa mà chúng ta có thể có ở mỗi trạng thái:*

1.  `buy1`: The maximum remaining money after first buy. Since we start with 0, this will be `-prices[i]`. We want to maximize this (minimize spend).
    *`buy1`: Số tiền còn lại tối đa sau lần mua đầu tiên. Vì chúng ta bắt đầu với 0, giá trị này sẽ là `-prices[i]`. Chúng ta muốn tối đa hóa giá trị này (tối thiểu hóa chi tiêu).*
2.  `sell1`: The maximum money after first sell. `profit = buy1 + prices[i]`.
    *`sell1`: Số tiền tối đa sau lần bán đầu tiên. `lợi nhuận = buy1 + prices[i]`.*
3.  `buy2`: The maximum money after second buy. `balance = sell1 - prices[i]`.
    *`buy2`: Số tiền tối đa sau lần mua thứ hai. `số dư = sell1 - prices[i]`.*
4.  `sell2`: The maximum money after second sell. `totalProfit = buy2 + prices[i]`.
    *`sell2`: Số tiền tối đa sau lần bán thứ hai. `tổngLợinhuận = buy2 + prices[i]`.*

### Why this works?
### *Tại sao nó hoạt động?*
By updating these variables in sequence for each day, we effectively simulate all possible combinations of buying and selling times while only keeping the best outcomes for each stage. The `sell1` value at day `i` acts as the "reinvestment fund" for `buy2`.
*Bằng cách cập nhật các biến này theo thứ tự cho mỗi ngày, chúng ta mô phỏng hiệu quả tất cả các tổ hợp thời điểm mua và bán có thể có trong khi vẫn chỉ giữ lại kết quả tốt nhất cho mỗi giai đoạn. Giá trị `sell1` tại ngày `i` đóng vai trò là "quỹ tái đầu tư" cho `buy2`.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. We iterate through the array once. Each step involves constant time arithmetic operations for the 4 state variables.
    *Độ phức tạp thời gian: $O(N)$. Chúng ta duyệt qua mảng một lần. Mỗi bước bao gồm các phép toán số học với thời gian hằng số cho 4 biến trạng thái.*
*   **Space Complexity:** $O(1)$. We only use 4 variables to store the states, regardless of input size.
    *Độ phức tạp không gian: $O(1)$. Chúng ta chỉ sử dụng 4 biến để lưu trữ các trạng thái, bất kể kích thước đầu vào.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng hình ảnh*

**Input:** `prices = [3, 3, 5, 0]`

| Price | `buy1` (max `-p`) | `sell1` (max `b1+p`) | `buy2` (max `s1-p`) | `sell2` (max `b2+p`) |
| :--- | :--- | :--- | :--- | :--- |
| **Start** | $- \infty$ | 0 | $- \infty$ | 0 |
| 3 | -3 | 0 | -3 | 0 |
| 3 | -3 | 0 | -3 | 0 |
| 5 | -3 | 2 | -3 | 2 |
| 0 | 0 | 2 | 2 | 2 |

*Note: In the final step with price 0, `buy1` becomes 0 (better than -3). `buy2` becomes 2 (reinvesting the 2 profit from before at price 0).*

---

## 5. Summary Recommendation
## *5. Khuyến nghị tổng kết*

This four-variable DP approach is extremely powerful and can be generalized to $K$ transactions (where you would use two arrays of size $K$). For this specific case ($K=2$), hardcoding the variables as we did is the most memory-efficient and fastest implementation.
*Cách tiếp cận DP bốn biến này cực kỳ mạnh mẽ và có thể được tổng quát hóa cho $K$ giao dịch (trong đó bạn sẽ sử dụng hai mảng kích thước $K$). Đối với trường hợp cụ thể này ($K=2$), việc viết mã trực tiếp các biến như chúng ta đã làm là bản triển khai tiết kiệm bộ nhớ nhất và nhanh nhất.*
---
*Đầu tư thông minh không chỉ là mua thấp bán cao một lần, mà là biết cách tái đầu tư lợi nhuận để tạo ra giá trị lũy kế.*
Smart investing isn't just about buying low and selling high once, it's about knowing how to reinvest profits to create cumulative value.
