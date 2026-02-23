# Analysis for Power of Three
# *Phân tích cho bài toán Lũy thừa của Ba*

## 1. Problem Essence & Integer Limits
## *1. Bản chất vấn đề & Giới hạn Số nguyên*

### The Challenge
### *Thách thức*
Check if $n = 3^x$.
Loop: Divide by 3 until 1 or remainder != 0.
Follow up: No loops. `O(1)`.

### Strategy: Math / Integer Limit
### *Chiến lược: Toán học / Giới hạn Số nguyên*
Since `n` is a 32-bit integer, max value is $2^{31} - 1 \approx 2 \cdot 10^9$.
Max power of 3 explicitly: $3^{19} = 1162261467$. $3^{20} > 2^{31}$.
So, `n` is a power of three iff `n > 0` and `1162261467 % n == 0`.
This is because 3 is prime. All divisors of $3^{19}$ are powers of 3.

---

## 2. Approach: Modulo Max Power
## *2. Hướng tiếp cận: Modulo Lũy thừa Lớn nhất*

### Logic
### *Logic*
(See above).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(1):** No loops.
    *O(1): Không có vòng lặp.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$.
    *Độ phức tạp thời gian: $O(1)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** 27.
`27 > 0`. `1162261467 % 27 == 0`. True.

**Input:** 45.
`45 > 0`. 45 is $9 * 5$. Not power of 3.
`1162261467` only has factors of 3. So `1162261467 % 45` will be non-zero (since 5 is not factor). False.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Math trick for prime bases.
*Thủ thuật toán học cho cơ số nguyên tố.*
---
*Đôi khi giới hạn (limit) lại chính là chìa khóa giải phóng chúng ta khỏi những vòng lặp vô tận.*
Sometimes restrictions (limit) are the key to liberating us from endless loops.
