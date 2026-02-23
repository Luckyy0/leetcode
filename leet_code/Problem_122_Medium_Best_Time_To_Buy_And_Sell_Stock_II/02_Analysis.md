# Analysis for Best Time to Buy and Sell Stock II
# *Phân tích cho bài toán Thời Điểm Tốt Nhất để Mua và Bán Cổ Phiếu II*

## 1. Problem Nuance & Strategy
## *1. Sắc thái của bài toán & Chiến lược*

### Unlimited Transactions
### *Không giới hạn giao dịch*
*   Unlike Part I (121), where we could only perform **one** transaction, here we can perform as many as we want.
    *Khác với Phần I (121), nơi chúng ta chỉ có thể thực hiện **một** giao dịch, ở đây chúng ta có thể thực hiện bao nhiêu tùy thích.*
*   The only restriction is that we can only hold one share at a time.
    *Ràng buộc duy nhất là chúng ta chỉ có thể nắm giữ một cổ phiếu tại một thời điểm.*

### The Greedy Philosophy
### *Triết lý Tham lam*
*   Because we want the *maximum total* profit, we should capture every single upward price movement.
    *Bởi vì chúng ta muốn *tổng lợi nhuận tối đa*, chúng ta nên nắm bắt mọi sự biến động tăng giá.*
*   If the price tomorrow is higher than the price today, we "buy" today and "sell" tomorrow to lock in that small profit.
    *Nếu giá ngày mai cao hơn giá hôm nay, chúng ta "mua" hôm nay và "bán" ngày mai để khóa khoản lợi nhuận nhỏ đó.*
*   Even if the price keeps rising for several days (e.g., `1, 2, 3, 4, 5`), selling daily (`(2-1) + (3-2) + (4-3) + (5-4)`) is mathematically identical to buying on day 1 and selling on day 5 (`5-1`). This allows the algorithm to be extremely simple.
    *Ngay cả khi giá liên tục tăng trong nhiều ngày (ví dụ: `1, 2, 3, 4, 5`), việc bán hàng ngày (`(2-1) + (3-2) + (4-3) + (5-4)`) về mặt toán học là giống hệt với việc mua vào ngày 1 và bán vào ngày 5 (`5-1`). Điều này cho phép thuật toán trở nên vô cùng đơn giản.*

---

## 2. Approach: Single Pass Peak-Valley (Greedy)
## *2. Hướng tiếp cận: Một lần duyệt Đỉnh-Thung lũng (Tham lam)*

### Algorithm Logic
### *Logic thuật toán*
1.  Initialize `maxProfit = 0`.
2.  Iterate through the `prices` array from the second element (index 1).
3.  Whenever the current price is higher than the previous day's price:
    -   Add the difference `prices[i] - prices[i-1]` to `maxProfit`.
4.  Return `maxProfit`.

### Practical Explanation
### *Giải thích thực tế*
Imagine you are at the end of each day. If you see that tomorrow's price is going up, you buy today and sell tomorrow. If tomorrow's price is going down, you do nothing. By summing up all "upward" gaps, you automatically find the maximum possible profit.
*Hãy tưởng tượng bạn đang ở cuối mỗi ngày. Nếu bạn thấy giá ngày mai sẽ tăng, bạn mua hôm nay và bán ngày mai. Nếu giá ngày mai giảm, bạn không làm gì cả. Bằng cách cộng tất cả các khoảng trống "tăng", bạn sẽ tự động tìm thấy lợi nhuận tối đa có thể.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. We traverse the list once. Each step is a simple subtraction and addition.
    *Độ phức tạp thời gian: $O(N)$. Chúng ta duyệt qua danh sách một lần. Mỗi bước là một phép trừ và cộng đơn giản.*
*   **Space Complexity:** $O(1)$. We only use one variable to store the total profit.
    *Độ phức tạp không gian: $O(1)$. Chúng ta chỉ sử dụng một biến để lưu trữ tổng lợi nhuận.*

---

## 4. Why Greedy Works?
## *2. Tại sao Tham lam lại hoạt động?*

Mathematically, any long profit sequence `prices[end] - prices[start]` can be decomposed into the sum of its daily differences:
*Về mặt toán học, bất kỳ chuỗi lợi nhuận dài nào `prices[end] - prices[start]` đều có thể được phân tách thành tổng các chênh lệch hàng ngày của nó:*

$(prices[j] - prices[i]) + (prices[k] - prices[j]) + ... + (prices[z] - prices[y]) = prices[z] - prices[i]$

By only picking pairs where $(prices[next] - prices[current]) > 0$, we are effectively picking all non-overlapping profitable intervals in the most granular way possible.
*Bằng cách chỉ chọn các cặp mà $(prices[tiếp] - prices[hiện]) > 0$, chúng ta đang chọn tất cả các khoảng thời gian có lợi nhuận không chồng chéo theo cách chi tiết nhất có thể.*

---

## 5. Summary Recommendation
## *5. Khuyến nghị tổng kết*

This solution is the gold standard for Part II because it is both efficient and intuitive once the "daily accumulation" concept is understood. It avoids more complex state-tracking variables that would be required if transaction limits were imposed.
*Giải pháp này là tiêu chuẩn cho Phần II vì nó vừa hiệu quả vừa trực quan sau khi khái niệm "tích lũy hàng ngày" được thấu hiểu. Nó tránh được các biến theo dõi trạng thái phức tạp hơn vốn sẽ cần thiết nếu có áp dụng giới hạn giao dịch.*
---
*Cộng dồn những lợi ích nhỏ nhất chính là cách chắc chắn nhất để đạt được kết quả lớn nhất.*
Accumulating the smallest benefits is the surest way to achieve the greatest results.
