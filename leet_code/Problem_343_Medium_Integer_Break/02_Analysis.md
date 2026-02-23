# Analysis for Integer Break
# *Phân tích cho bài toán Chia nhỏ Số nguyên*

## 1. Problem Essence & Math Property
## *1. Bản chất vấn đề & Tính chất Toán học*

### The Optimization
### *Tối ưu hóa*
Maximize product $x_1 \cdot x_2 \cdot \dots \cdot x_k$ subject to $\sum x_i = n$.
Intuitively, numbers should be as equal as possible.
Optimal components are $e \approx 2.718$.
Closest integers are 2 and 3.
$3 > 2$. We prefer factors of 3.
Proof: $3(n-3) \ge 2(n-2)$ for $n \ge 5$? $3n-9 \ge 2n-4 \to n \ge 5$.
Wait. $3(2) = 6$. $2(3) = 6$.
4 can be $2 \cdot 2 = 4$ or just 4. Breaking 4 into 3+1 -> $3 \cdot 1 = 3 < 4$.
So don't break 4 into 3+1. Keep as 4 (or 2+2).
However, for larger numbers, break into as many 3s as possible.
Exception for remainder:
- Remainder 0: All 3s.
- Remainder 1: `3, 3, ..., 3, 1`. $3 \cdot 1 = 3$. Better: `3, ..., 2, 2`. $2 \cdot 2 = 4 > 3$. So take one 3 and convert it to 3+1 -> 4.
- Remainder 2: `3, ..., 3, 2`. $3 \cdot 2 = 6$. Optimal.

### Strategy: Greedy by Math
### *Chiến lược: Tham lam theo Toán học*
Base cases:
- $n=2$: $1+1 \to 1$.
- $n=3$: $2+1 \to 2$.
Larger $n$:
- Remainder $n \% 3 = 0$: $3^{n/3}$.
- Remainder $n \% 3 = 1$: $3^{(n/3)-1} \cdot 4$.
- Remainder $n \% 3 = 2$: $3^{n/3} \cdot 2$.

---

## 2. Approach: DP or Math
## *2. Hướng tiếp cận: DP hoặc Toán học*

### Logic (Math)
### *Logic (Toán học)*
(See above).

### Logic (DP)
### *Logic (DP)*
`dp[i]`: max product for number `i`.
`dp[i] = max(j * max(i-j, dp[i-j]))` for `j` in `1..i/2`.
$O(N^2)$. Since $N \le 58$, DP is perfectly fine. Math is $O(N)$ or $O(\log N)$.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Factors of 3:** Math solution is mathematically beautiful and optimal ($O(1)$).
    *Thừa số 3: Giải pháp toán học đẹp đẽ về mặt toán học và tối ưu ($O(1)$).*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$ (Math) or $O(N^2)$ (DP). Given constraints, both are trivial.
    *Độ phức tạp thời gian: $O(1)$ (Toán) hoặc $O(N^2)$ (DP).*
*   **Space Complexity:** $O(1)$ or $O(N)$.
    *Độ phức tạp không gian: $O(1)$ hoặc $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** 10.
$10 \% 3 = 1$.
Logic: $3^{(10/3)-1} \cdot 4 = 3^{2} \cdot 4 = 9 \cdot 4 = 36$.
Correct.

**Input:** 5.
$5 \% 3 = 2$.
Logic: $3^{1} \cdot 2 = 6$. (2+3=5, 2*3=6).
Correct.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Math Approach (Greedy with 3s).
*Cách tiếp cận Toán học (Tham lam với số 3).*
---
*Số 3 là con số kỳ diệu của sự phát triển (growth). Để tối đa hóa tiềm năng, hãy chia nhỏ vấn đề thành những thành phần tối giản nhưng hiệu quả nhất (thừa số 3), và điều chỉnh phần dư cuối cùng một cách khôn ngoan.*
Number 3 is the magic number of growth. To maximize potential, break the problem into the most minimal yet effective components (factors of 3), and adjust the final remainder wisely.
