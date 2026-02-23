# Analysis for 24 Game
# *Phân tích cho bài toán Trò chơi 24*

## 1. Problem Essence & Exhaustive State Search
## *1. Bản chất vấn đề & Tìm kiếm Trạng thái Kiệt quệ*

### The Challenge
### *Thách thức*
Given 4 cards with single-digit numbers, we need to find if any combination of basic operations (+, -, *, /) and parentheses can result in exactly 24. This is a classic "reach the target" problem where the number of elements is extremely small (4).
*Cho 4 lá bài với các số có một chữ số, chúng ta cần tìm xem liệu bất kỳ sự kết hợp nào của các phép tính cơ bản và dấu ngoặc có thể tạo ra đúng 24 hay không. Đây là bài toán "đạt tới mục tiêu" điển hình với số lượng phần tử cực nhỏ (4).*

---

## 2. Strategy: Backtracking with Pair-wise Reduction
## *2. Chiến lược: Đệ quy Thử sai với Giảm cặp*

Since we have only 4 numbers, we can use a recursive backtracking approach that picks any two numbers, applies an operation, and continues with the result.
*Vì chúng ta chỉ có 4 con số, chúng ta có thể sử dụng phương pháp đệ quy thử sai (backtracking) bằng cách chọn hai số bất kỳ, thực hiện một phép tính, và tiếp tục với kết quả đó.*

### Recursive Step
### *Bước Đệ quy*

1.  **Base Case:** If there is only **1 number** left, check if it is approximately `24.0` (within a small precision error like `Math.abs(result - 24) < 1e-6`).
    * **Trường hợp Cơ sở:** Nếu chỉ còn 1 số, kiểm tra xem nó có xấp xỉ 24 hay không.*

2.  **Selection:** Pick any two distinct numbers $a$ and $b$ from the current pool.
    * **Lựa chọn:** Chọn hai số bất kỳ $a$ và $b$ từ tập hợp hiện tại.*

3.  **Operations:** Combine $a$ and $b$ using all possible unique arithmetic operations:
    - $a + b$
    - $a - b$
    - $b - a$
    - $a \times b$
    - $a / b$ (if $b \neq 0$)
    - $b / a$ (if $a \neq 0$)
    * **Phép tính:** Kết hợp $a$ và $b$ bằng tất cả các phép toán khả thi.*

4.  **Transition:** Create a new pool of numbers by removing $a, b$ and adding the result. Recurse.
    * **Chuyển đổi:** Tạo một tập hợp mới bằng cách loại bỏ $a, b$ và thêm vào kết quả của phép tính. Tiếp tục đệ quy.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Precision:** Use `double` for all calculations to handle real division correctly. Integer division will lead to incorrect "False" results for cases like $4 / (1 - 2/3)$.
    * **Độ chính xác:** Sử dụng kiểu `double` để xử lý phép chia thực. Phép chia số nguyên sẽ dẫn đến kết quả sai.*
*   **Search Space:**
    - Choose 2 from 4: $\binom{4}{2} = 6$ ways.
    - 6 operations per pair.
    - Total states are roughly $6 \times 6 \times \binom{3}{2} \times 6 \times \dots$, which is very small (< 10,000 combinations).
    * **Không gian tìm kiếm:** Rất nhỏ, giúp đệ quy chạy cực kỳ nhanh.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$ in practical terms. Specifically, the number of ways to pick pairs and operators is constant and small. Even with 4 elements, it's roughly 9216 possible evaluation trees.
    * **Độ phức tạp thời gian:** $O(1)$ theo ý nghĩa thực tế vì số lượng tổ hợp là hữu hạn và rất nhỏ.*
*   **Space Complexity:** $O(1)$. The recursion depth is fixed at 4.
    * **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** [4, 1, 8, 7]
1. Pick 8 and 4. Op: 8 - 4 = 4. Pool: [1, 7, 4].
2. Pick 7 and 1. Op: 7 - 1 = 6. Pool: [4, 6].
3. Pick 4 and 6. Op: 4 * 6 = 24. Pool: [24].
4. Result is 24. Return **true**.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

For problems with a very small fixed N (like $N=4$ or $N=5$), exhaustive search (backtracking) is often the simplest and most effective solution. Ensure floating-point precision is handled when dealing with division to avoid rounding errors.
*Đối với các bài toán có N rất nhỏ và cố định, tìm kiếm kiệt quệ (backtracking) thường là giải pháp đơn giản và hiệu quả nhất.*
---
*Trò chơi của những con số (24 Game) là một mê cung của những sự kết hợp. Trong không gian của 4 lá bài (Cards), mỗi phép tính là một nấc thang dẫn tới mục tiêu duy nhất: 24. Dữ liệu dạy ta rằng bằng cách thử nghiệm mọi ngã rẽ (Backtracking) và duy trì sự chính xác trong từng phân mảnh (Double precision), ta có thể tìm thấy lời giải giữa hàng ngàn khả năng vô tận.*
The game of numbers (24 Game) is a labyrinth of combinations. In the space of 4 cards (Cards), each calculation is a step leading to the single goal: 24. Data teaches us that by trying every fork (Backtracking) and maintaining precision in every fragment (Double precision), we can find the solution among thousands of endless possibilities.
