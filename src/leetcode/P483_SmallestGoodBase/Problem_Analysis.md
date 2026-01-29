# 483. Smallest Good Base / Cơ Số Tốt Nhỏ Nhất

## Problem Description / Mô tả bài toán
Given an integer `n` as a string, return the smallest good base of `n` as a string.
Cho một số nguyên `n` dưới dạng chuỗi, hãy trả về cơ số tốt nhỏ nhất của `n` dưới dạng chuỗi.

An integer `k >= 2` is a **good base** of `n` if all digits of `n` base `k` are `1`.
Một số nguyên `k >= 2` là một **cơ số tốt** của `n` nếu tất cả các chữ số của `n` trong cơ số `k` đều là `1`.

### Example 1:
```text
Input: n = "13"
Output: "3"
Explanation: 13 base 3 is 111 (3^2 + 3^1 + 3^0 = 13).
```

### Example 2:
```text
Input: n = "4681"
Output: "8"
Explanation: 4681 base 8 is 11111 (8^4 + 8^3 + 8^2 + 8^1 + 8^0 = 4681).
```

### Example 3:
```text
Input: n = "1000000000000000000"
Output: "999999999999999999"
Explanation: 1000000000000000000 base 999999999999999999 is 11.
```

## Constraints / Ràng buộc
- `n` is an integer in the range `[3, 10^18]`.
- `n` does not contain leading zeros.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Geometric Series Equation / Phương trình Chuỗi Hình học
If $n$ in base $k$ is all 1s with $m$ digits, then:
$n = k^{m-1} + k^{m-2} + ... + k^1 + k^0$
$n = \frac{k^m - 1}{k - 1}$

We want to find the **smallest** $k$, which means we want to find the **largest** possible $m$ (number of digits).
- Maximum $m$: Since $k \ge 2$, $2^{m-1} \le n$. For $n=10^{18}$, $m \approx \log_2(10^{18}) \approx 60$.
- Minimum $m$: The problem requires $k \ge 2$ and $n \ge 3$, so the minimum number of 1s is 2 (e.g., $n = k+1$). So $m \ge 2$.

Algorithm:
1. Iterate $m$ from 60 down to 2.
2. For a fixed $m$, find $k$ such that $(k^m - 1) / (k - 1) = n$.
   - Since the function is increasing with $k$, we can use **Binary Search** to find $k$.
   - The range for $k$ is $[2, n^{1/(m-1)}]$.
3. For each $k$, calculate the sum of the geometric series and compare with $n$.
   - Be careful with `BigInteger` or potential overflow in `long`.
4. The first $k$ we find will be the smallest because we started from the largest $m$.

### Complexity / Độ phức tạp
- **Time**: O(log^2 N) where N is $10^{18}$ (60 iterations of binary search).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Binary Search on Every Possible Length

**Algorithm**:
1.  Target loops from max length 60 down to 2.
2.  Binary search for base $k$.
3.  Check geometric sum.

---
