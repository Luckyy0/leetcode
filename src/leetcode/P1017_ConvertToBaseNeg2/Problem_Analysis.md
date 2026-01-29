# 1017. Convert to Base -2 / Chuyển đổi sang Cơ số -2

## Problem Description / Mô tả bài toán
Given an integer `n`, return a binary string representing its value in base -2.
Cho một số nguyên `n`, hãy trả về một chuỗi nhị phân đại diện cho giá trị của nó trong cơ số -2.

Base -2 uses digits 0 and 1, and powers of -2: $(-2)^0, (-2)^1, (-2)^2, \dots$
Cơ số -2 sử dụng các chữ số 0 và 1, và lũy thừa của -2: $(-2)^0, (-2)^1, (-2)^2, \dots$

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Negative Base Conversion / Chuyển đổi Cơ số Âm
Standard division algorithm `n = quotient * base + remainder`.
Thuật toán chia tiêu chuẩn `n = thương * cơ_số + số_dư`.
In C++/Java, `%` operator can return negative remainder.
However, for base representation, digits (remainder) must be non-negative ($0 \le r < |base|$).

For base `b = -2`:
- Calculate `rem = n % -2`.
- Calculate `n = n / -2`.
- If `rem < 0`:
  - `rem += 2`.
  - `n += 1`. (Adjustment to quotient: since we added 2 to remainder, we subtracted 2 from part covered by quotient, so `q * (-2)` became `(q+1) * (-2) - 2`?).
  - Math: $n = q(-2) + r$. If $r = -1$, we want $r' = 1$.
    $n = q(-2) - 1 = q(-2) - 2 + 1 = (q+1)(-2) + 1$.
    So quotient increases by 1.

### Complexity / Độ phức tạp
- **Time**: O(log N).
- **Space**: O(log N).

---

## Analysis / Phân tích

### Approach: Adjusted Euclidean Division
Perform repeated division by -2. Crucially, strictly enforce that the remainder must be non-negative (0 or 1). If the programming language yields a negative remainder, adjust the quotient and remainder to satisfy the definition of a positional numeral system.
Thực hiện phép chia liên tục cho -2. Quan trọng là phải thực thi nghiêm ngặt rằng số dư phải không âm (0 hoặc 1). Nếu ngôn ngữ lập trình trả về số dư âm, hãy điều chỉnh thương và số dư để thỏa mãn định nghĩa của hệ thống số theo vị trí.

---
