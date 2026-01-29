# 1447. Simplified Fractions / Phân số Đơn giản hóa

## Problem Description / Mô tả bài toán
Integer `n`. Return list of all simplified fractions between 0 and 1 (exclusive) with denominator <= `n`.
Format "numerator/denominator".

---

## Theoretical Foundation / Cơ sơ lý thuyết

### GCD
Iterate `d` from 2 to `n`.
Iterate `nom` from 1 to `d-1`.
If `gcd(nom, d) == 1`, add fraction.

### Complexity / Độ phức tạp
- **Time**: O(N^2 * log(N)).
- **Space**: O(N^2) for output.

---

## Analysis / Phân tích

### Approach: Double Loop
Iterate `denominator` from 2 to `n`.
Iterate `numerator` from 1 to `denominator-1`.
Check if `gcd(numerator, denominator) == 1`.
If yes, add string to list.
Lặp lại `denominator` từ 2 đến `n`.
Lặp lại `numerator` từ 1 đến `denominator-1`.
Kiểm tra xem `gcd` có bằng 1 hay không.

---
