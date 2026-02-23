# Analysis for Implement Rand10() Using Rand7()
# *Phân tích cho bài toán Triển khai Rand10() bằng Rand7()*

## 1. Problem Essence & Uniform Distribution
## *1. Bản chất vấn đề & Phân phối Đồng nhất*

### The Challenge
### *Thách thức*
Generating numbers in range `[1, 10]` uniformly using a function that generates `[1, 7]`.
- Simply doing `(rand7() + rand7()) % 10` does NOT give a uniform distribution.
- We need to generate a range of values larger than or equal to 10 that is a multiple of 10, or effectively uniformly mapping a larger space to 10.

### Strategy: Rejection Sampling (Base Conversion)
### *Chiến lược: Lấy mẫu Từ chối (Chuyển đổi Cơ số)*

1.  **Generate a Larger Range:** By calling `rand7()` twice, we can visualize a 2D grid of size $7 \times 7$.
    - `row = rand7()`, `col = rand7()`.
    - `index = (row - 1) * 7 + col`.
    - This generates a number in `[1, 49]` uniformly.
2.  **Rejection:**
    - We have 49 outcomes.
    - We want outcomes in range `[1, 10]`.
    - The largest multiple of 10 within 49 is 40.
    - If `index` is in `[1, 40]`, we can map it to `[1, 10]` using `(index - 1) % 10 + 1`. This is because each number in `[1, 10]` will be hit exactly 4 times (1, 11, 21, 31 $\to$ 1; etc.).
    - If `index` is in `[41, 49]`, the remaining 9 outcomes are not enough to balance the distribution. We must **reject** these and try again.
3.  **Optimization:** Instead of throwing away the 9 rejected outcomes, we can reuse them with another `rand7()` call to form a new range, reducing the overall expected calls (though the basic rejection sampling is sufficient).

---

## 2. Approach: 7-base Expansion
## *2. Hướng tiếp cận: Mở rộng Cơ số 7*

### Logic
### *Logic*
(See above). Think of `rand7()` as generating a digit in base-7. Two calls generate a 2-digit number in base-7 (values 00 to 66 in base 7 $\approx$ 0-48 in decimal).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Uniformity:** Guaranteeing uniform distribution is the primary goal. Rejection sampling ensures this perfectly.
    *Tính đồng nhất: Đảm bảo phân phối đồng nhất là mục tiêu chính. Lấy mẫu từ chối đảm bảo điều này một cách hoàn hảo.*
*   **Safety:** No bias introduced by modulo operations on non-multiple ranges.
    *An toàn: Không có độ lệch do phép modulo trên các phạm vi không phải bội số.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** Expected number of calls is low. Probability of success is $40/49 \approx 81\%$. Average calls $\approx 2 / 0.81 \approx 2.45$. In worst case (infinite rejection), it's unbounded but probability approaches 0 rapidly.
    *Độ phức tạp thời gian: Số lần gọi kỳ vọng thấp. Xác suất thành công là 40/49.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Goal:** Get a number 1-10.
1. `row = 6, col = 3`. `idx = (5)*7 + 3 = 38`.
   - `38 <= 40`. Accept.
   - `result = (38-1)%10 + 1 = 37%10 + 1 = 7 + 1 = 8`. Return 8.
2. `row = 6, col = 6`. `idx = 35 + 6 = 41`.
   - `41 > 40`. Reject.
3. `row = 1, col = 1`. `idx = 0 + 1 = 1`.
   - `1 <= 40`. Accept.
   - `result = 0%10 + 1 = 1`. Return 1.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Generate uniform `[1, 49]` and reject values `> 40`.
*Tạo số ngẫu nhiên `[1, 49]` và từ chối các giá trị `> 40`.*
---
*Ngẫu nhiên (randomness) không có nghĩa là hỗn loạn, mà là sự công bằng tuyệt đối. Khi nguồn lực có hạn (Rand7) nhưng nhu cầu lại lớn hơn (Rand10), ta phải biết cách từ chối (rejection) những kết quả không đảm bảo sự công bằng. Chấp nhận làm lại từ đầu (retry) để đạt được sự phân phối chuẩn mực còn hơn là vội vã chấp nhận một kết quả sai lệch.*
Randomness (randomness) does not mean chaos, but absolute fairness. When resources are limited (Rand7) but demand is greater (Rand10), we must know how to refuse (rejection) results that do not guarantee fairness. Accepting starting over (retry) to achieve a standard distribution is better than rushing to accept a biased result.
