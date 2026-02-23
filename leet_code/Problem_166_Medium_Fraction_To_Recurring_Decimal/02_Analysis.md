# Analysis for Fraction to Recurring Decimal
# *Phân tích cho bài toán Chuyển đổi phân số thành số thập phân vô hạn tuần hoàn*

## 1. Problem Essence & Numerical Pitfalls
## *1. Bản chất vấn đề & Các cạm bẫy về con số*

### The Core Challenge
### *Thử thách cốt lõi*
Converting a fraction into its decimal representation is straightforward division. However, identifying **recurring parts** (like $1/3 = 0.333...$ or $1/6 = 0.1666...$) requires us to remember which remainders we have already seen.
*Chuyển đổi một phân số thành dạng thập phân là phép chia đơn giản. Tuy nhiên, việc xác định **phần tuần hoàn** yêu cầu chúng ta phải ghi nhớ những số dư nào mình đã gặp qua.*

### Edge Cases & Pitfalls
### *Các trường hợp biên & Cạm bẫy*
1.  **Zero Numerator:** $0 / 5 = "0"$.
2.  **Integer results:** $4 / 2 = "2"$.
3.  **Signs:** $-5 / 2 = "-2.5"$, $5 / -2 = "-2.5"$, $-5 / -2 = "2.5"$.
4.  **Overflow:** The division of `Integer.MIN_VALUE` by `-1` or taking its absolute value will overflow a 32-bit integer. We must use `long`.
*- Trường hợp tử số bằng 0.*
*- Kết quả là số nguyên.*
*- Dấu âm/dương.*
*- Tràn số: Việc lấy trị tuyệt đối của `-2147483648` sẽ gây tràn số 32-bit, do đó cần sử dụng `long`.*

---

## 2. Approach: Long Division with Remainder Mapping
## *2. Hướng tiếp cận: Phép chia dài với Bản đồ số dư*

### Step-by-Step Logic
### *Logic từng bước*
1.  **Sign Handling:** Determine the sign of the result. Use a `StringBuilder` to start with `-` prematurely if signs differ.
2.  **Integer Part:** Calculate the quotient of `numerator / denominator`. Append it and the decimal point (if a fractional part exists).
3.  **Fractional Part:** 
    - Maintain a `HashMap<Long, Integer>` to store `remainder -> position_in_string`.
    - Perform long division:
      - Multiply the remainder by 10.
      - Calculate the next digit: `remainder / denominator`.
      - Calculate the next remainder: `remainder % denominator`.
      - If the current remainder is already in the map, a cycle has been detected. 
      - Insert `(` at the stored position and append `)`.
    - If the remainder becomes 0, the decimal is terminating.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Hashing for Cycles:** Using a `HashMap` to store indices is the most efficient way to pinpoint exactly where the repeating part begins.
    *Sử dụng `HashMap` để lưu trữ các chỉ số là cách hiệu quả nhất để xác định chính xác nơi phần lặp lại bắt đầu.*
*   **Arbitrary Precision:** By simulating long division, we can generate as many digits as needed until a termination or cycle occurs.
    *Phân tích tùy ý: Bằng cách mô phỏng phép chia dài, chúng ta có thể tạo ra bao nhiêu chữ số tùy thích cho đến khi kết thúc hoặc lặp lại.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\text{Length of result})$. In the worst case, we might visit every possible remainder up to the value of the `denominator`. The problem guarantees output length $< 10^4$.
    *Độ phức tạp thời gian: Tuyến tính so với độ dài kết quả.*
*   **Space Complexity:** $O(\text{Denominator})$. The map stores remainders. Since decimals either terminate or repeat, the number of unique remainders is limited by the denominator.
    *Độ phức tạp không gian: Tỷ lệ thuận với số lượng số dư duy nhất gặp phải.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `4 / 333`

1.  Integer part: `4 / 333 = 0`. SB: "0."
2.  Remainder: `4`. Map: `{4: 2}` (pos 2 is after '.')
3.  Next: `40`. Digit: `0`. Rem: `40`. Map: `{4: 2, 40: 3}`. SB: "0.0"
4.  Next: `400`. Digit: `1`. Rem: `67`. Map: `{4: 2, 40: 3, 67: 4}`. SB: "0.01"
5.  Next: `670`. Digit: `2`. Rem: `4`. 
6.  **Cycle Found!** Remainder 4 was at position 2.
    - Insert '(' at index 2.
    - Result: `0.(012)`

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Fraction to Decimal is a high-precision problem that tests your ability to handle edge cases and data structures together. The use of `long` is mandatory to avoid the `Integer.MIN_VALUE` trap. Always check for the remainder in your map **before** appending the new digit to ensure you insert the parenthesis at the correct starting point of the cycle.
*Chuyển đổi phân số thành số thập phân là một bài toán đòi hỏi độ chính xác cao, kiểm tra khả năng xử lý các trường hợp biên và cấu trúc dữ liệu cùng lúc. Việc sử dụng `long` là bắt buộc để tránh bẫy `Integer.MIN_VALUE`. Luôn kiểm tra số dư trong bản đồ **trước khi** thêm chữ số mới để đảm bảo bạn chèn dấu ngoặc đơn vào đúng điểm bắt đầu của chu trình.*
---
*Những con số có thể kéo dài vô tận, nhưng logic luôn biết cách bao bọc sự lặp lại trong một quy luật hữu hạn.*
Numbers can stretch to infinity, but logic always knows how to wrap repetition into a finite rule.
