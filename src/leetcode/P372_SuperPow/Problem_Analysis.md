# 372. Super Pow / Lũy Thừa Siêu Lớn

## Problem Description / Mô tả bài toán
Your task is to calculate `a^b mod 1337` where `a` is a positive integer and `b` is an extremely large positive integer given in the form of an array.
Nhiệm vụ của bạn là tính `a^b mod 1337` trong đó `a` là số nguyên dương và `b` là số nguyên dương cực lớn được cho dưới dạng mảng.

### Example 1:
```text
Input: a = 2, b = [3]
Output: 8
```

### Example 2:
```text
Input: a = 2, b = [1,0]
Output: 1024
```

### Example 3:
```text
Input: a = 1, b = [4,3,3,8,5,2]
Output: 1
```

## Constraints / Ràng buộc
- `1 <= a <= 2^31 - 1`
- `1 <= b.length <= 2000`
- `0 <= b[i] <= 9`
- `b` does not contain leading zeros.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Modular Exponentiation / Lũy Thừa Mũ Modulo
`a^[d1 d2 ... dn] mod m`
`[d1 d2 ... dn]` can be written as `d1 * 10^(n-1) + ...`.
Actually, recursive approach:
`a^[1, 2, 3] = a^(120 + 3) = a^120 * a^3 = (a^12)^10 * a^3`.
General formula: `f(a, [d1...dn]) = f(a, [d1...dn-1])^10 * a^dn mod 1337`.

We need a helper `pow(a, k, m)` (compute `a^k mod m`).
And process the array from end to start (or start to end, but recursive from end is natural if shrinking).
Or iterative from start:
`res = 1`.
Loop digit `d` in `b`:
`res = (res^10 * a^d) mod 1337`.
This is `a^(1...d)` logic.
`val = a`.
Start with `res = [digit 1] value?`
Formula: `value = value * 10 + digit`.
`a^value = a^(old_value * 10 + digit) = (a^old_value)^10 * a^digit`.
So:
1. `res = 1`.
2. Loop `d` in `b`.
3. `res = pow(res, 10) * pow(a, d) % 1337`.
Wait.
`b = [1, 2]`.
Init `res = 1` (value 0).
d=1: `res = 1^10 * a^1 = a`. (Correct, `a^1`).
d=2: `res = a^10 * a^2 = a^12`. (Correct).
Works.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is length of b. Each step does O(1) pow calc (10 is small).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Iterative Modular Exponentiation

**Algorithm**:
1.  MOD = 1337.
2.  `a %= MOD` (important!).
3.  `res = 1`.
4.  For `d` in `b`:
    - `res = pow(res, 10) * pow(a, d) % MOD`.
5.  Return `res`.

**Helper**: `pow(long a, int k)`:
- Standard binary exponentiation or simple loop since k <= 10.

---
