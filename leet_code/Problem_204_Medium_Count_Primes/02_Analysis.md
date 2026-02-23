# Analysis for Count Primes
# *Phân tích cho bài toán Đếm số nguyên tố*

## 1. Problem Essence & Efficiency
## *1. Bản chất vấn đề & Hiệu quả*

### The Naive Approach
### *Cách tiếp cận ngây thơ*
Checking `isPrime(i)` for every number from 2 to `n` takes $O(N \sqrt{N})$. With $N = 5 \times 10^6$, this is roughly $10^{10}$ operations, which will TLE (Time Limit Exceeded).
*Kiểm tra `isPrime(i)` cho mỗi số sẽ mất $O(N \sqrt{N})$. Với $N$ lớn, điều này sẽ quá hạn thời gian.*

### The Ancient Solution
### *Giải pháp cổ xưa*
The **Sieve of Eratosthenes** is the efficient way to find all primes up to $N$.
*Sàng Eratosthenes là cách hiệu quả để tìm tất cả các số nguyên tố lên đến $N$.*

---

## 2. Approach: Sieve of Eratosthenes
## *2. Hướng tiếp cận: Sàng Eratosthenes*

### Logic
### *Logic*
1.  Assume all numbers from 2 to $n-1$ are prime.
2.  Start with the first prime, $p = 2$.
3.  Mark all multiples of $p$ ($2p, 3p, ...$) as **not prime**.
    - Optimization: Start marking from $p \times p$, because smaller multiples ($2p, 3p...$) would have already been marked by smaller primes (2, 3...).
4.  Find the next number that is still marked as prime. Set it as new $p$.
5.  Repeat until $p \times p \ge n$.
6.  Count the remaining numbers marked as prime.

*1. Giả sử tất cả các số đều là số nguyên tố. 2. Bắt đầu với $p=2$. 3. Đánh dấu tất cả bội số của $p$ là không phải số nguyên tố. Tối ưu: Bắt đầu đánh dấu từ $p \times p$. 4. Tìm số tiếp theo vẫn là số nguyên tố. 5. Lặp lại.*

### Optimizations
### *Tối ưu hóa*
- **Outer Loop Limit:** Loop only up to $\sqrt{N}$. If a number $x < N$ is composite, it must have a factor $\le \sqrt{N}$.
- **Inner Loop Start:** Start marking multiples of `i` from `i * i`, skipping `i * 2`, `i * 3`, etc.
- **Odd Numbers Only:** We can ignore even numbers > 2 entirely to save half the space/time (advanced). For standard interviews, the boolean array approach is sufficient.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Speed:** Time complexity is $O(N \log \log N)$, which is nearly linear.
    *Tốc độ: Độ phức tạp thời gian là $O(N \log \log N)$, gần như tuyến tính.*
*   **Simplicity:** Uses a simple boolean array.
    *Đơn giản: Sử dụng một mảng boolean đơn giản.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log \log N)$.
    *Độ phức tạp thời gian: $O(N \log \log N)$.*
*   **Space Complexity:** $O(N)$. We need an array of size $N$ to track the primality of each number.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `n = 10`
Array `isPrime` indices 0..9.
Initially true: `[F, F, T, T, T, T, T, T, T, T]` (0,1 false; 2..9 true)

1.  `i = 2`: `isPrime[2]` is True.
    - Mark multiples starting `2*2=4`: 4, 6, 8 become False.
2.  `i = 3`: `isPrime[3]` is True.
    - Mark multiples starting `3*3=9`: 9 becomes False.
3.  `i = 4`: `i*i = 16 > 10`. Stop outer loop.

Count True in `[2, 3, 5, 7]`. Result: 4.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Count Primes is the definition of "knowing the right algorithm". You cannot invent the Sieve of Eratosthenes on the spot efficiently if you've never seen it. Remember the `i * i` optimization to show you understand the redundant work.
*Đếm số nguyên tố là định nghĩa của việc "biết đúng thuật toán". Hãy nhớ tối ưu hóa `i * i` để thể hiện bạn hiểu về các công việc dư thừa.*
---
*Đôi khi cách nhanh nhất để tìm những viên ngọc (số nguyên tố) là loại bỏ tất cả những hòn đá giả mạo (hợp số).*
Sometimes the fastest way to find gems (primes) is to discard all the fake stones (composites).
