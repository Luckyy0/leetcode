# Analysis for Pow(x, n)
# *Phân tích cho bài toán Tính Lũy Thừa x^n*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Double `x`, integer `n`. *Số thực `x`, số nguyên `n`.*
*   **Output:** Result of $x^n$. *Kết quả của $x^n$.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `n` can be large (up to $2 \times 10^9$).
*   `n` can be negative.
*   *`n` có thể lớn (lên tới $2 \times 10^9$).*
*   *`n` có thể âm.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Binary Exponentiation (Fast Power)
### *Hướng tiếp cận: Lũy Thừa Nhị Phân (Tính Nhanh Lũy Thừa)*

*   **Intuition:** Instead of multiplying `x` by itself `n` times ($O(n)$), we can use the property $x^n = (x^{n/2})^2$ for even $n$, and $x \cdot (x^{n/2})^2$ for odd $n$. This reduces the complexity to $O(\log n)$.
*   *Ý tưởng: Thay vì nhân `x` với chính nó `n` lần ($O(n)$), chúng ta có thể sử dụng tính chất $x^n = (x^{n/2})^2$ cho $n$ chẵn, và $x \cdot (x^{n/2})^2$ cho $n$ lẻ. Điều này làm giảm độ phức tạp xuống $O(\log n)$.*

*   **Algorithm Steps:**
    1.  Handle negative `n`: $x^n = (1/x)^{-n}$. Note that if $n = -2^{31}$, taking $-n$ results in overflow. Use a `long` to store $N = |n|$.
    2.  `fastPow(x, N)`:
        *   Base case: if $N = 0$, return 1.
        *   Calculate `half = fastPow(x, N / 2)`.
        *   If `N` is even, return `half * half`.
        *   Else, return `half * half * x`.

*   **Complexity:**
    *   Time: $O(\log N)$.
    *   Space: $O(\log N)$ for recursion stack.

### Dry Run
### *Chạy thử*
`x=2, n=10`
1.  `pow(2, 5) * pow(2, 5)`
2.  `pow(2, 5)` = `2 * pow(2, 2) * pow(2, 2)`
3.  `pow(2, 2)` = `pow(2, 1) * pow(2, 1)`
4.  `pow(2, 1)` = `2 * pow(2, 0) * pow(2, 0)` = 2.
Back up:
`pow(2, 2) = 2*2=4`.
`pow(2, 5) = 2*4*4=32`.
`pow(2, 10) = 32*32=1024`.
Result: 1024. Correct.
