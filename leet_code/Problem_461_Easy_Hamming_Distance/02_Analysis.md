# Analysis for Hamming Distance
# *Phân tích cho bài toán Khoảng cách Hamming*

## 1. Problem Essence & Bitwise XOR
## *1. Bản chất vấn đề & Phép toán XOR trên Bit*

### The Challenge
### *Thách thức*
Counting the number of positions where two numbers have different bits. In binary terms, a difference at a specific bit position means one number has a `1` and the other has a `0`.

### Strategy: XOR + Bit Counting
### *Chiến lược: XOR + Đếm Bit*

1.  **XOR Operation (`^`):** The XOR of `x` and `y` will result in a number where bits are `1` only at positions where `x` and `y` differ.
    - Example: `1 (0001) ^ 4 (0100) = 5 (0101)`.
2.  **Count Set Bits (Population Count):** We need to count the number of `1`s in the result of `x ^ y`.
    - In Java, `Integer.bitCount()` is highly optimized for this.
    - Alternatively, use Brian Kernighan's algorithm: `n &= (n - 1)` repeatedly to clear the least significant set bit until `n` becomes 0.

---

## 2. Approach: Bitwise Logic
## *2. Hướng tiếp cận: Logic Thao tác Bit*

### Logic
### *Logic*
(See above). XOR is the perfect tool for identifying differences. Counting the resulting set bits directly gives the Hamming distance.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(1) Complexity:** Since integers are 32-bit, the operation runs in constant time regardless of the values.
    *Hiệu quả O(1): Vì số nguyên là 32-bit, thao tác chạy trong thời gian hằng số.*
*   **Optimal Primitives:** Uses direct CPU-level bitwise operations.
    *Nguyên tử tối ưu: Sử dụng các thao tác bit trực tiếp ngang mức CPU.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$ (effectively $O(\log W)$ where $W$ is the bit-width of the integer, e.g., 32).
    *Độ phức tạp thời gian: $O(1)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Summary Recommendation
## *5. Khuyến nghị tổng kết*

XOR followed by `Integer.bitCount()`.
*Thực hiện XOR sau đó dùng Integer.bitCount().*
---
*Sự khác biệt giữa hai thực thể (Hamming distance) thường được bộc lộ rõ nhất khi ta đặt chúng cạnh nhau và chỉ tập trung vào những điểm bất tương đồng (XOR). Trong toán học, việc đếm những "tia sáng" đơn lẻ (set bits) trong bóng tối sẽ cho ta biết khoảng cách giữa hai hệ tư tưởng. Một thao tác bit đơn giản nhưng chứa đựng triết lý sâu sắc về sự đối lập.*
The difference between two entities (Hamming Distance) is often most clearly exposed when we place them next to each other and focus only on the points of dissatisfaction (XOR). In mathematics, counting individual "light" (set bits) in the dark will tell us the distance between two ideologies. A simple bit manipulation but contains profound philosophies about the opposite.
