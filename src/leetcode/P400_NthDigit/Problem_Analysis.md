# 400. Nth Digit / Chữ Số Thứ N

## Problem Description / Mô tả bài toán
Given an integer `n`, return the `n-th` digit of the infinite integer sequence `1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...`.
Cho một số nguyên `n`, hãy trả về chữ số thứ `n` của chuỗi số nguyên vô hạn `1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...`.

### Example 1:
```text
Input: n = 3
Output: 3
```

### Example 2:
```text
Input: n = 11
Output: 0
Explanation: The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
```

## Constraints / Ràng buộc
- `1 <= n <= 2^31 - 1`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Mathematical Calculation / Tính toán toán học
The sequence can be grouped by the number of digits:
- 1-digit numbers: 1 to 9 (9 numbers, 9*1 = 9 digits).
- 2-digit numbers: 10 to 99 (90 numbers, 90*2 = 180 digits).
- 3-digit numbers: 100 to 999 (900 numbers, 900*3 = 2700 digits).
- Generally: `len`-digit numbers start from `10^(len-1)` and there are `9 * 10^(len-1)` such numbers, contributing `len * 9 * 10^(len-1)` digits.

Algorithm:
1.  Find the length `len` of the number where the `n-th` digit resides.
2.  Find the specific number that contains the `n-th` digit.
3.  Find the specific digit within that number.

### Complexity / Độ phức tạp
- **Time**: O(log N). The number of digits increases logarithmically.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Grouping by Length

**Algorithm**:
1.  `len = 1`, `count = 9`, `start = 1`.
2.  While `n > len * count`:
    - `n -= len * count`.
    - `len++`.
    - `count *= 10`.
    - `start *= 10`.
3.  Target number: `start + (n - 1) / len`.
4.  Digit index within target number: `(n - 1) % len`.
5.  Return the digit at that index.

---
