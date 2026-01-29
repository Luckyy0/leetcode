# 342. Power of Four / Lũy Thừa Của Bốn

## Problem Description / Mô tả bài toán
Given an integer `n`, return `true` if it is a power of four. Otherwise, return `false`.
Cho một số nguyên `n`, trả về `true` nếu nó là lũy thừa của bốn. Ngược lại, trả về `false`.

An integer `n` is a power of four, if there exists an integer `x` such that `n == 4^x`.

### Example 1:
```text
Input: n = 16
Output: true
```

### Example 2:
```text
Input: n = 5
Output: false
```

### Example 3:
```text
Input: n = 1
Output: true
```

## Constraints / Ràng buộc
- `-2^31 <= n <= 2^31 - 1`

**Follow up**: Could you solve it without loops/recursion?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Bit Manipulation / Thao Tác Bit
Power of 4 is a subset of Power of 2.
1.  `n > 0`.
2.  `n` is power of 2: `(n & (n - 1)) == 0`.
3.  `n` is power of 4:
    Powers of 4: `1, 4, 16, 64...`
    Binary:
    1: `...0001`
    4: `...0100`
    16: `...10000`
    The single set bit is always at an **odd position** (1st, 3rd, 5th... from right (1-indexed) or bit index 0, 2, 4... (0-indexed)).
    Wait, `1` is `4^0`. Bit index 0. Even.
    `4` is `4^1`. Bit index 2. Even.
    `16` is `4^2`. Bit index 4. Even.
    So the set bit must be at an **even** bit index (0, 2, 4, ...).

    Mask for odd bit positions (1, 3, 5...): `0xAAAAAAAA` (10101010...). Power of 4 should have 0 bits here.
    Mask for even bit positions (0, 2, 4...): `0x55555555` (01010101...). Power of 4 should have 1 bit here.

    Condition: `(n & 0x55555555) != 0`. (Combine with power of 2 check).
    Or `(n & 0xAAAAAAAA) == 0`.

### Complexity / Độ phức tạp
- **Time**: O(1).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Bitwise Check

**Algorithm**:
1.  `n > 0`.
2.  `(n & (n - 1)) == 0` (Power of 2).
3.  `(n & 0x55555555) != 0` (Bit at even index).
    Alternatively: `(n & 0xAAAAAAAA) == 0`.

---
