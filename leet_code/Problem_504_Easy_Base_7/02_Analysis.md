# Analysis for Base 7
# *Phân tích cho bài toán Hệ cơ số 7*

## 1. Problem Essence & Base Conversion
## *1. Bản chất vấn đề & Chuyển đổi Cơ số*

### The Challenge
### *Thách thức*
Converting an integer to its Base-7 string representation.
- Handle `0` edge case.
- Handle negative numbers (sign).

### Strategy: Modulo and Division
### *Chiến lược: Chia lấy dư và Chia nguyên*

1.  **Zero Case:** If `num == 0`, return `"0"`.
2.  **Sign Handling:** If `num < 0`, append `-` to result eventually, work with `abs(num)`. (Or work with negative and append sign at end).
3.  **Iteration:**
    - `digit = num % 7`
    - `num = num / 7`
    - Prepend `digit` (or append and reverse).
    - Repeat until `num == 0`.

---

## 2. Approach: Iterative Modulo
## *2. Hướng tiếp cận: Lặp Chia lấy dư*

### Logic
### *Logic*
(See above). Use `StringBuilder`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Simplicity:** Standard algorithm.
    *Đơn giản: Thuật toán chuẩn.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log_7 |num|)$.
    *Độ phức tạp thời gian: $O(\log_7 |num|)$.*
*   **Space Complexity:** $O(\log_7 |num|)$ for output string.
    *Độ phức tạp không gian: $O(\log_7 |num|)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `100`
1. `100 % 7 = 2`. `100 / 7 = 14`. SB=`2`.
2. `14 % 7 = 0`. `14 / 7 = 2`. SB=`20`.
3. `2 % 7 = 2`. `2 / 7 = 0`. SB=`202`.
Reverse -> `202`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Standard base conversion loop.
*Vòng lặp chuyển đổi cơ số chuẩn.*
---
*Mọi con số, dù lớn đến đâu, đều được xây dựng từ những viên gạch cơ bản (remainder). Việc chia nhỏ vấn đề (division) và sắp xếp lại từng mảnh ghép (reverse) giúp ta nhìn thấy bản chất thực sự của sự vật dưới một hệ quy chiếu mới (base 7).*
Every number, no matter how big, is built from basic bricks (remainder). Dividing the problem (Division) and rewriting each piece (Reverse) helps us see the true nature of things under a new reference frame (Base 7).
