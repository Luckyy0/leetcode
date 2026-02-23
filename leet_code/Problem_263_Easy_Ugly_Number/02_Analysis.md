# Analysis for Ugly Number
# *Phân tích cho bài toán Số xấu*

## 1. Problem Essence & Prime Factorization
## *1. Bản chất vấn đề & Phân tích thừa số nguyên tố*

### Definition
### *Định nghĩa*
Ugly number $x = 2^a \cdot 3^b \cdot 5^c$.
If `n <= 0`, not positive, so False.
If `n == 1`, True.

### Strategy
### *Chiến lược*
Repeatedly divide `n` by 2, 3, and 5 while it is divisible.
After dividing out all 2s, 3s, and 5s, if the remaining `n` is 1, then it had no other prime factors.
If `n > 1` (e.g., 7, 11, etc.), it is not ugly.

---

## 2. Approach: Iterative Division
## *2. Hướng tiếp cận: Chia lặp*

### Logic
### *Logic*
1.  If `n <= 0`: return `false`.
2.  While `n % 2 == 0`: `n /= 2`.
3.  While `n % 3 == 0`: `n /= 3`.
4.  While `n % 5 == 0`: `n /= 5`.
5.  Return `n == 1`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Reduction:** Reduces the number to its "non-ugly" core.
    *Rút gọn: Đưa số về lõi "không xấu" của nó.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log N)$. Division reduces size exponentially.
    *Độ phức tạp thời gian: $O(\log N)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** 14
1.  `14 % 2 == 0`. `n = 7`.
2.  `7 % 3 != 0`.
3.  `7 % 5 != 0`.
4.  Is `7 == 1`? False.

**Input:** 6
1.  `6 % 2 == 0`. `n = 3`.
2.  `3 % 3 == 0`. `n = 1`.
3.  `1 % 5 != 0`.
4.  Is `1 == 1`? True.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Simple math loop.
*Vòng lặp toán học đơn giản.*
---
*Xấu hay đẹp phụ thuộc vào tiêu chuẩn (2, 3, 5). Nếu bạn loại bỏ những định kiến bên ngoài và bản chất vẫn trọn vẹn (bằng 1), bạn là người đặc biệt.*
Ugly or beautiful depends on the standard (2, 3, 5). If you strip away external definitions and the essence remains whole (equals 1), you are special.
