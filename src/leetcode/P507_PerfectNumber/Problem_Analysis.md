# 507. Perfect Number / Số Hoàn Hảo

## Problem Description / Mô tả bài toán
A **perfect number** is a **positive integer** that is equal to the sum of its **positive divisors**, excluding the number itself.
Một **số hoàn hảo** là một **số nguyên dương** bằng tổng của các **ước số dương** của nó, không bao gồm chính số đó.

Given an integer `n`, return `true` if `n` is a perfect number, otherwise return `false`.
Cho một số nguyên `n`, hãy trả về `true` nếu `n` là một số hoàn hảo, ngược lại trả về `false`.

### Example 1:
```text
Input: num = 28
Output: true
Explanation: 28 = 1 + 2 + 4 + 7 + 14
1, 2, 4, 7, and 14 are all divisors of 28.
```

### Example 2:
```text
Input: num = 7
Output: false
```

## Constraints / Ràng buộc
- `1 <= num <= 10^8`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Divisor Summation / Tổng ước số
A number `n` is perfect if `Sum(divisors of n) = 2n` (if we include `n` itself) or `Sum(divisors excluding n) = n`.
We can find all divisors of `n` in $O(\sqrt{n})$ time.

Algorithm:
1. If `num <= 1`, return `false`.
2. Initialize `sum = 1`. (1 is always a divisor).
3. For `i` from 2 up to `sqrt(num)`:
   - If `num % i == 0`:
     - Add `i` to `sum`.
     - If `i * i != num`, add `num / i` to `sum`.
4. Return `sum == num`.

### Complexity / Độ phức tạp
- **Time**: O(sqrt(N)).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Square-Root Divisor Enumeration

**Algorithm**:
1.  Boundary check.
2.  Iterate up to square root.
3.  Add divisor pairs.
4.  Final equality check.

---
