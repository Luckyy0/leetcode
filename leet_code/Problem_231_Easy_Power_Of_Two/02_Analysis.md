# Analysis for Power of Two
# *Phân tích cho bài toán Lũy thừa của 2*

## 1. Problem Essence & Bit Manipulation
## *1. Bản chất vấn đề & Thao tác Bit*

### Properties of Power of 2
### *Tính chất của lũy thừa của 2*
In binary representation:
- $1 (2^0) = 00...001$
- $2 (2^1) = 00...010$
- $4 (2^2) = 00...100$
- $8 (2^3) = 00...1000$

All powers of two have **exactly one bit set to 1**.
*Tất cả các lũy thừa của 2 đều có **chính xác một bit được đặt là 1**.*

### The Trick
### *Mẹo*
If we subtract 1 from a power of two:
$8 - 1 = 7$
$1000 - 0001 = 0111$
Notice that `n` and `n-1` have **no common set bits**.
So, `n & (n-1) == 0`.
*Nếu giảm lũy thừa của 2 đi 1 đơn vị, các bit sẽ đảo ngược từ bit 1 duy nhất trở về sau. Do đó, `n & (n-1) == 0`.*

---

## 2. Approach: Bitwise AND
## *2. Hướng tiếp cận: Bitwise AND*

### Logic
### *Logic*
1.  Check if `n > 0`. (Negative numbers or 0 are not powers of two).
2.  Check if `(n & (n - 1)) == 0`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Speed:** $O(1)$ time complexity without any loops.
    *Tốc độ: $O(1)$ thời gian mà không cần vòng lặp.*

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

**Input:** 16 ($10000$)
16 - 1 = 15 ($01111$)
$10000 \ \& \ 01111 = 00000$. **True**.

**Input:** 18 ($10010$)
18 - 1 = 17 ($10001$)
$10010 \ \& \ 10001 = 10000 \ne 0$. **False**.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

The `n & (n-1)` trick is a staple for bit manipulation problems (also used to count bits or turn off the rightmost bit). Memorize it.
*Mẹo `n & (n-1)` là kiến thức cơ bản cho các bài toán thao tác bit. Hãy ghi nhớ nó.*
---
*Định nghĩa của sự độc tôn: Chỉ có một bit duy nhất được quyền tỏa sáng.*
Definition of singularity: Only a single bit is allowed to shine.
