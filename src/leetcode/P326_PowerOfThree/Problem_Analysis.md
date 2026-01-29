# 326. Power of Three / Lũy Thừa Của Ba

## Problem Description / Mô tả bài toán
Given an integer `n`, return `true` if it is a power of three. Otherwise, return `false`.
Cho một số nguyên `n`, trả về `true` nếu nó là lũy thừa của ba. Ngược lại, trả về `false`.

An integer `n` is a power of three, if there exists an integer `x` such that `n == 3^x`.

### Example 1:
```text
Input: n = 27
Output: true
```

### Example 2:
```text
Input: n = 0
Output: false
```

## Constraints / Ràng buộc
- `-2^31 <= n <= 2^31 - 1`

**Follow up**: Could you solve it without loops/recursion?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Integer Limits / Giới Hạn Số Nguyên
The largest power of 3 that fits in a signed 32-bit integer (`2^31 - 1` = 2,147,483,647) is `3^19` = `1,162,261,467`.
Checking if `n > 0` and `1162261467 % n == 0` is sufficient.
This works because 3 is prime. The divisors of `3^K` are only powers of 3.

### Loop Approach
`while (n % 3 == 0) n /= 3; return n == 1;`. (Needs `n > 0`).

 I will use the **Integer Limit** approach for the follow-up.

---

## Analysis / Phân tích

### Approach: Modulo Max Power

**Algorithm**:
1.  Result `n > 0 && 1162261467 % n == 0`.

---
