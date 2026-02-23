# Analysis for Super Pow
# *Phân tích cho bài toán Siêu Lũy thừa*

## 1. Problem Essence & Modular Exponentiation
## *1. Bản chất vấn đề & Lũy thừa Modulo*

### The Challenge
### *Thách thức*
Computing $a^b \pmod{1337}$ where $b$ is so large it's represented as an array of digits $[d_1, d_2, \dots, d_k]$. We cannot calculate $b$ as a single number.

### Strategy: Recursive Decomposition
### *Chiến lược: Phân rã Đệ quy*
Using the properties of exponents:
$a^{[1, 2, 3]} = a^{123} = a^{120 + 3} = a^{12 \times 10} \times a^3 = (a^{12})^{10} \times a^3$.
In general:
`superPow(a, [d1, ..., dk]) = pow(superPow(a, [d1, ..., dk-1]), 10) * pow(a, dk) % 1337`.

This reduces the problem for $b$ to a smaller problem $(b \text{ without last digit})$.

### Core Modular Pow:
### *Lũy thừa Modulo Cốt lõi:*
Basic implementation of $(x^y) \pmod m$ is needed. Since $y$ is at most 10 in this recursion, we can just use a simple loop or binary exponentiation.

---

## 2. Approach: Recursion + Modular Math
## *2. Hướng tiếp cận: Đệ quy + Toán học Modulo*

### Logic
### *Logic*
(See recursion formula above). We take digits one by one from the end of the array.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Avoids Large Numbers:** All intermediate results are kept within modular limits.
    *Tránh số lớn: Tất cả các kết quả trung gian được giữ trong giới hạn modulo.*
*   **Simple Logic:** The recursive relationship is clean and maps directly to exponential rules.
    *Logic đơn giản: Mối quan hệ đệ quy sạch sẽ và ánh xạ trực tiếp vào các quy tắc lũy thừa.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(L)$, where $L$ is the number of digits in array $b$. Each digit takes constant time for `pow(..., 10)`.
    *Độ phức tạp thời gian: $O(L)$.*
*   **Space Complexity:** $O(L)$ due to recursion depth.
    *Độ phức tạp không gian: $O(L)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** $a=2, b=[1, 0]$
1. `lastDigit = 0`.
2. `part1 = superPow(2, [1])`.
   - `lastDigit = 1`. `part1 = superPow(2, [])` = 1.
   - `res = (1^10 * 2^1) % 1337 = 2`.
3. `res = (part1^10 * 2^0) % 1337 = (2^10 * 1) % 1337 = 1024`.
Result: 1024.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Recursive decomposition using $a^{10n+k} = (a^n)^{10} \cdot a^k$.
*Phân rã đệ quy sử dụng $a^{10n+k} = (a^n)^{10} \cdot a^k$.*
---
*Những sức mạnh khổng lồ (super powers) có thể được chế ngự bằng cách chia nhỏ chúng thành từng phần có thể kiểm soát được (single digits). Trong toán học cũng như trong cuộc sống, sự bền bỉ của phép lặp và tính kỷ luật của các quy tắc (modular properties) sẽ dẫn ta tới kết quả cuối cùng một cách an toàn.*
Giant powers (super powers) can be tamed by breaking them down into manageable parts (single digits). In math as in life, the persistence of iteration and the discipline of rules (modular properties) will lead us lead to the final result safely.
