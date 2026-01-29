# 1201. Ugly Number III / Số Xấu III

## Problem Description / Mô tả bài toán
An ugly number is a positive integer that is divisible by `a`, `b`, or `c`.
Given four integers `n`, `a`, `b`, and `c`, return the `n-th` ugly number.
Result fits in 32-bit (Wait, example might exceed? Problem says return `nth` ugly number, might exceed 2^31-1. Problem constraints: a,b,c up to 10^9, n up to 10^9. Output fits in 2*10^9 typically. Max might be 2*10^9. Let's use long for calculation and casting.)

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Binary Search on Answer / Inclusion-Exclusion Principle
We need to find smallest `X` such that `count(X) >= n`.
`count(X)` = numbers <= X divisible by a, b, or c.
`count(X) = X/a + X/b + X/c - X/lcm(a,b) - X/lcm(a,c) - X/lcm(b,c) + X/lcm(a,b,c)`.
Range for Binary Search: `[1, 2 * 10^9]`. (Since minimal a=1, n=10^9 -> 10^9. Max a=10^9, n=10^9. Actually upper bound could be larger? If a,b,c large, e.g. 10^9, and n=10^9, then 10^18. Binary search needs Long range).
Wait, problem constraints: `1 <= n, a, b, c <= 10^9`.
If a=10^9, n=10^9, result is 10^18. Need `long`.
Return type is `int`? Leetcode problems sometimes have return type `int` but answer within range.
Wait. Checking constraints for 1201.
"It is guaranteed that the result will be in range [1, 2 * 10^9]."
Ah, so upper bound is 2e9. Fine.

LCM calculation: `lcm(x, y) = (x * y) / gcd(x, y)`. Care with overflow when computing `x*y`.

### Complexity / Độ phức tạp
- **Time**: O(log(2e9)).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Binary Search with Inclusion-Exclusion
We need to find the $n$-th number divisible by $a$, $b$, or $c$. The function `count(k)` calculates how many such numbers exist $\le k$ using the Inclusion-Exclusion Principle: counts multiples of $a, b, c$, subtracts multiples of pairwise LCMs, and adds multiples of the triple LCM. Since `count(k)` is monotonic, use binary search over the range $[1, 2 \times 10^9]$ to find the smallest $k$ where `count(k) >= n`. Use `long` for intermediate LCM calculations to prevent overflow.
Chúng ta cần tìm số thứ $n$ chia hết cho $a$, $b$, hoặc $c$. Hàm `count(k)` tính toán có bao nhiêu số như vậy $\le k$ bằng cách sử dụng Nguyên lý Bao hàm - Loại trừ: đếm các bội số của $a, b, c$, trừ đi các bội số của LCM từng đôi một và cộng thêm các bội số của LCM bộ ba. Vì `count(k)` là đơn điệu, hãy sử dụng tìm kiếm nhị phân trên phạm vi $[1, 2 \times 10^9]$ để tìm $k$ nhỏ nhất mà `count(k) >= n`. Sử dụng `long` cho các tính toán LCM trung gian để ngăn chặn tràn số.

---
