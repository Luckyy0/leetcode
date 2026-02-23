# Analysis for Fizz Buzz
# *Phân tích cho bài toán Fizz Buzz*

## 1. Problem Essence & Multi-condition Check
## *1. Bản chất vấn đề & Kiểm tra đa điều kiện*

### The Challenge
### *Thách thức*
Generating a sequence of strings based on divisibility rules for 3 and 5. It is a fundamental programming exercise to test basic logic and control flow.

### Strategy: Sequential Check
### *Chiến lược: Kiểm tra Tuần tự*
The conditions should be checked in order:
1.  **Divisible by both 3 and 5** (equivalent to divisible by 15).
2.  **Divisible by 3**.
3.  **Divisible by 5**.
4.  **Neither.**

Alternatively, use string concatenation to build the result:
-   If divisible by 3, string += "Fizz".
-   If divisible by 5, string += "Buzz".
-   If string is empty, use the number `i`.

---

## 2. Approach: Simple Iteration
## *2. Hướng tiếp cận: Lặp Đơn giản*

### Logic
### *Logic*
Iterate from 1 to `n` and apply the conditions to determine the string for each index.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Efficiency:** Process each number exactly once.
    *Hiệu quả O(N): Xử lý mỗi số đúng một lần.*
*   **Scalability:** String concatenation approach makes it easy to add more conditions (e.g., "7 -> Jazz").
    *Khả năng mở rộng: Cách tiếp cận nối chuỗi giúp dễ dàng thêm nhiều điều kiện mới.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$ extra space (excluding the output list).
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `n = 15`
- `i = 3`: 3%3==0 $\to$ "Fizz".
- `i = 5`: 5%5==0 $\to$ "Buzz".
- `i = 15`: 15%3==0 and 15%5==0 $\to$ "FizzBuzz".
Result array correctly populated.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Iterative simulation.
*Mô phỏng lặp.*
---
*Fizz Buzz không chỉ là một bài toán lập trình cơ bản, mà còn là minh chứng cho việc thực thi logic một cách rành mạch. Khi các quy tắc chồng chéo lên nhau (divisibility), sự kỷ luật trong việc sắp xếp thứ tự ưu tiên chính là chìa khóa để tạo ra kết quả chính xác.*
Fizz Buzz is not just a basic programming problem, but also proof of executing logic clearly. When rules overlap (divisibility), discipline in arranging the order of priority is the key to creating accurate results.
