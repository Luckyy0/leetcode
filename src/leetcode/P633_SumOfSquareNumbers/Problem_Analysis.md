# 633. Sum of Square Numbers / Tổng Của Các Số Bình Phương

## Problem Description / Mô tả bài toán
Given a non-negative integer `c`, decide whether there're two integers `a` and `b` such that `a^2 + b^2 = c`.
Cho một số nguyên không âm `c`, hãy quyết định xem có hai số nguyên `a` và `b` sao cho `a^2 + b^2 = c` hay không.

### Example 1:
```text
Input: c = 5
Output: true
Explanation: 1 * 1 + 2 * 2 = 5
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Two Pointers / Fermat's Theorem / Hai Con Trỏ / Định Lý Fermat
Two Pointers approach:
`a` from 0, `b` from `sqrt(c)`.
While `a <= b`:
`sum = a*a + b*b`.
If `sum == c`, return true.
If `sum < c`, `a++`.
If `sum > c`, `b--`.

Fermat's Theorem on Sums of Two Squares:
A number `c` can be expressed as sum of two squares iff in the prime factorization of `c`, every prime of the form `4k+3` occurs an even number of times.

Two pointers is O(sqrt(c)), very efficient.

### Complexity / Độ phức tạp
- **Time**: O(sqrt(C)).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Two Pointers

**Algorithm**:
1.  Initialize left=0, right=sqrt(c).
2.  Check sum of squares.
3.  Adjust pointers.

---
