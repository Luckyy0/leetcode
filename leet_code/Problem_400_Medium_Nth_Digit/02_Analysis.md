# Analysis for Nth Digit
# *Phân tích cho bài toán Chữ số thứ N*

## 1. Problem Essence & Multi-stage Search
## *1. Bản chất vấn đề & Tìm kiếm đa giai đoạn*

### The Challenge
### *Thách thức*
Calculating a specific digit in a sequence formed by concatenating all integers. The sequence grows rapidly, so we need to narrow down the target in stages.

### Strategy: Three-Step Localization
### *Chiến lược: Định vị Ba Bước*
1.  **Find the length of the number (digits per number):**
    - $1 \dots 9$: 9 numbers $\times$ 1 digit = 9 digits.
    - $10 \dots 99$: 90 numbers $\times$ 2 digits = 180 digits.
    - $100 \dots 999$: 900 numbers $\times$ 3 digits = 2700 digits.
    - Keep subtracting the total digits of each stage from $n$ until $n$ falls within a stage.
2.  **Find the actual number:**
    - Smallest number of current stage is `start` (1, 10, 100...).
    - `targetNumber = start + (n - 1) / len`.
3.  **Find the specific digit:**
    - It's the `(n - 1) % len`-th digit of `targetNumber`.

---

## 2. Approach: Iterative Refinement
## *2. Hướng tiếp cận: Tinh lọc lặp*

### Logic
### *Logic*
(See above). We use `long` for the digit count calculation to prevent overflow as $n$ can be up to $2^{31}-1$.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(log N) Complexity:** The number of stages is the number of digits of the target number, which is logarithmic with respect to $n$.
    *Hiệu quả O(log N): Số lượng giai đoạn chính là số chữ số của số mục tiêu, tỷ lệ thuận với logarit của n.*
*   **Constant Space:** No large strings or sequences stored.
    *Không gian hằng số: Không lưu trữ chuỗi hay dãy số lớn.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log n)$.
    *Độ phức tạp thời gian: $O(\log n)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `n = 11`
1. **Find len:** 
   - $n=11, len=1, count=9, start=1$.
   - $n > 1*9$? Yes. $n = 11 - 9 = 2$. $len=2, start=10$.
2. **Find number:**
   - $n=2$. Target number = $start + (2-1)/2 = 10 + 0 = 10$.
3. **Find digit:**
   - Digit index = $(2-1) \% 2 = 1$.
   - 1st digit (0-indexed) of `10` is `0`.
Result: 0.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Mathematical breakdown by digit length.
*Phân tích toán học theo độ dài chữ số.*
---
*Trong một thế giới vô tận của những con số (infinite sequence), để tìm thấy một chi tiết nhỏ nhất (nth digit), ta cần biết cách phân lớp (layering) và định vị (localization). Bằng cách hiểu rõ quy luật của sự gia tăng (9, 90, 900...), ta có thể biến một hành trình tưởng chừng vô vọng thành một vài bước tính toán chuẩn xác.*
In an infinite world of numbers (infinite sequence), to find the smallest detail (nth digit), we need to know how to layer (layering) and locate (localization). By understanding the rules of increase (9, 90, 900...), we can transform a journey that seems hopeless into a few precise calculation steps.
