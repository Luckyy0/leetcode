# 1362. Closest Divisors / Các Ước số Gần nhất

## Problem Description / Mô tả bài toán
Integer `num`. Find two integers `factor1, factor2` such that:
- `factor1 * factor2` equals `num + 1` or `num + 2`.
- `|factor1 - factor2|` is minimal.
Return `[factor1, factor2]`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Divisor Finding
Iterate `i` from `sqrt(target)` down to 1.
If `target % i == 0`, pair is `(i, target/i)`.
Minimal difference is guaranteed if we start from sqrt.
Check for `num + 1` and `num + 2`. Compare results.

### Complexity / Độ phức tạp
- **Time**: O(sqrt(N)).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Check Both
Check divisors for `num + 1`. Find `(d1, d2)` closest to sqrt. Diff `abs(d1-d2)`.
Check divisors for `num + 2`. Find `(d3, d4)` closest to sqrt.
Return pair with smaller difference.
Start checking from `sqrt(val)` down to 1. The first pair found is best.
Kiểm tra các ước số cho `num + 1`. Tìm `(d1, d2)` gần nhất với căn bậc hai.
Kiểm tra các ước số cho `num + 2`. Tìm `(d3, d4)` gần nhất với căn bậc hai.
Trả về cặp có sự khác biệt nhỏ hơn.
Bắt đầu kiểm tra từ `sqrt(val)` xuống 1. Cặp đầu tiên tìm thấy là tốt nhất.

---
