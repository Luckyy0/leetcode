# Analysis for Sum of Two Integers
# *Phân tích cho bài toán Tổng của Hai số nguyên*

## 1. Problem Essence & Bitwise Logic
## *1. Bản chất vấn đề & Logic Bitwise*

### The Challenge
### *Thách thức*
Performing addition without the `+` operator. This forces us to look at how addition works at the binary level (logic gates).

### Logic: Half-Adder Concept
### *Logic: Khái niệm Bộ cộng bán phần*
In binary addition of two bits:
1.  **Sum without carry:** $0+0=0, 0+1=1, 1+0=1, 1+1=0$. This is exactly the **XOR** (`^`) operation.
2.  **Carry:** $1+1=1$ (carry to next bit), otherwise 0. This is exactly the **AND** (`&`) operation, followed by a **left shift** (`<< 1`) to move the carry to the next position.

### Iterative Process:
### *Quá trình lặp:*
As long as there is a `carry`:
-   Update `a` to be the sum without carry (`a ^ b`).
-   Update `b` to be the shifted carry (`(oldA & oldB) << 1`).

---

## 2. Approach: Iterative Bitwise
## *2. Hướng tiếp cận: Bitwise Lặp*

### Logic
### *Logic*
(See above). The process eventually stops because the carry will eventually become 0 after at most 32 shifts (for 32-bit integers).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Primitive Efficiency:** Direct CPU-level operations.
    *Hiệu quả nguyên thủy: Các thao tác trực tiếp ở cấp độ CPU.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$ effectively, as it's limited by the bit-width (max 32 iterations).
    *Độ phức tạp thời gian: O(1).*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `a = 2 (10), b = 3 (11)`
1. `Sum = 2 ^ 3 = 01`. `Carry = (2 & 3) << 1 = 10 << 1 = 100`.
2. `a = 001, b = 100`.
3. `Sum = 1 ^ 100 = 101 (5)`. `Carry = (1 & 100) << 1 = 0`.
Result: 5.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

XOR for sum, AND-Shift for carry.
*XOR cho tổng, AND-Shift cho nhớ.*
---
*Đôi khi ngôn ngữ thông thường (+) là không đủ để diễn tả bản chất. Quay trở lại với những bit cơ bản nhất, ta thấy rằng sự kết hợp giữa sự khác biệt (XOR) và sự tương đồng (AND) mới thực sự tạo nên sự thăng tiến (carry) và kết quả cuối cùng.*
Sometimes common language (+) is not enough to express the essence. Going back to the most basic bits, we see that the combination of difference (XOR) and similarity (AND) is what truly creates progress (carry) and the final result.
