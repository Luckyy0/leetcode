# Analysis for Best Time to Buy and Sell Stock
# *Phân tích cho bài toán Thời Điểm Tốt Nhất để Mua và Bán Cổ Phiếu*

## 1. Understanding & Problem Essence
## *1. Hiểu đề & Bản chất bài toán*

### Core Objective
### *Mục tiêu cốt lõi*
*   We need to find two indices $i$ and $j$ such that $i < j$ (buy before sell) and the difference `prices[j] - prices[i]` is maximized.
    *Chúng ta cần tìm hai chỉ số $i$ và $j$ sao cho $i < j$ (mua trước khi bán) và hiệu `prices[j] - prices[i]` là lớn nhất.*
*   If no such $i, j$ exist where $prices[j] > prices[i]$, the profit is $0$.
    *Nếu không tồn tại $i, j$ sao cho $prices[j] > prices[i]$, lợi nhuận là $0$.*

### Challenges & Constraints
### *Thách thức & Ràng buộc*
*   The array size is up to $10^5$. A brute-force approach comparing all pairs $(i, j)$ would take $O(N^2)$ time, which is $10^{10}$ operations—too slow for a 1-2 second limit.
    *Kích thước mảng lên tới $10^5$. Cách tiếp cận thô bạo (brute-force) so sánh tất cả các cặp $(i, j)$ sẽ mất thời gian $O(N^2)$, tương đương $10^{10}$ phép tính—quá chậm với giới hạn 1-2 giây.*
*   We only need to buy and sell **once**.
    *Chúng ta chỉ cần mua và bán **một lần** duy nhất.*

---

## 2. Approach: One-Pass Greedy / Dynamic Programming
## *2. Hướng tiếp cận: Tham lam một lần duyệt / Quy hoạch động*

### Logic
### *Logic*
*   To maximize profit, we want to buy at the lowest possible price seen *so far* and sell at the highest possible price *after* that buy date.
    *Để tối đa hóa lợi nhuận, chúng ta muốn mua ở mức giá thấp nhất có thể được thấy *cho đến nay* và bán ở mức giá cao nhất có thể *sau* ngày mua đó.*
*   As we iterate through the array:
    1.  Keep track of the **minimum price** encountered since the start.
    2.  At each current price, calculate the potential profit: `currentPrice - minPrice`.
    3.  Compare this potential profit with the **maximum profit** found so far and update it if the new one is higher.
    *Khi chúng ta duyệt qua mảng:*
    *1. Theo dõi **giá thấp nhất** gặp phải kể từ khi bắt đầu.*
    *2. Tại mỗi mức giá hiện tại, tính toán lợi nhuận tiềm năng: `giáHiệnTại - giáThấpNhất`.*
    *3. So sánh lợi nhuận tiềm năng này với **lợi nhuận tối đa** được tìm thấy cho đến nay và cập nhật nếu lợi nhuận mới cao hơn.*

### Intuition
### *Trực giác*
Think of this as an online algorithm. If you were looking at stock prices day by day, you would always remember the lowest price you've ever seen. Every day, you'd wonder: "If I bought at that lowest price and sold today, how much would I make?". The answer to that question, maintained as a "max", is our result.
*Hãy coi đây là một thuật toán trực tuyến. Nếu bạn theo dõi giá cổ phiếu từng ngày, bạn sẽ luôn ghi nhớ mức giá thấp nhất mà bạn từng thấy. Mỗi ngày, bạn sẽ tự hỏi: "Nếu mình mua ở mức giá thấp nhất đó và bán hôm nay, mình sẽ kiếm được bao nhiêu?". Câu trả lời cho câu hỏi đó, được duy trì dưới dạng "max", chính là kết quả của chúng ta.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. We traverse the array exactly once. Each step involves simple arithmetic and comparison operations.
    *Độ phức tạp thời gian: $O(N)$. Chúng ta duyệt qua mảng đúng một lần. Mỗi bước bao gồm các phép toán số học và so sánh đơn giản.*
*   **Space Complexity:** $O(1)$. We only maintain two variables (`minPrice` and `maxProfit`), regardless of the size of the input array.
    *Độ phức tạp không gian: $O(1)$. Chúng ta chỉ duy trì hai biến (`minPrice` và `maxProfit`), bất kể kích thước của mảng đầu vào.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng hình ảnh*

**Input:** `prices = [7, 1, 5, 3, 6, 4]`

| Day | Price | `minPrice` | Profit (`Price - minPrice`) | `maxProfit` |
| :--- | :--- | :--- | :--- | :--- |
| 1 | 7 | 7 | 0 | 0 |
| 2 | 1 | 1 | 0 | 0 |
| 3 | 5 | 1 | 4 | 4 |
| 4 | 3 | 1 | 2 | 4 |
| 5 | 6 | 1 | 5 | **5** |
| 6 | 4 | 1 | 3 | 5 |

**Final Result:** 5

---

## 5. Key Takeaway
## *5. Điểm mấu chốt*
*   **The "Valley-Peak" Pattern:** We don't necessarily look for the absolute global minimum and absolute global maximum. The global max might come *before* the global min. We look for the greatest positive slope between a point and its preceding minimum.
    *Mô hình "Thung lũng - Đỉnh": Chúng ta không nhất thiết phải tìm giá trị nhỏ nhất tuyệt đối và lớn nhất tuyệt đối của toàn bộ mảng. Giá trị lớn nhất tuyệt đối có thể xuất hiện *trước* giá trị nhỏ nhất tuyệt đối. Chúng ta tìm độ dốc dương lớn nhất giữa một điểm và giá trị nhỏ nhất đứng trước nó.*
*   **Initial Values:** Initialize `minPrice` to a very large value (infinity) and `maxProfit` to 0.
    *Giá trị ban đầu: Khởi tạo `minPrice` bằng một giá trị rất lớn (vô cực) và `maxProfit` bằng 0.*
---
*Đôi khi các giải pháp đơn giản nhất lại là hiệu quả nhất, chỉ cần một con mắt tinh tường để nắm bắt quy luật biến thiên.*
Sometimes the simplest solutions are the most effective, requiring only a keen eye to grasp the rules of variation.
