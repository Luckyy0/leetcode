# 233. Number of Digit One / Số Lượng Chữ Số Một

## Problem Description / Mô tả bài toán
Given an integer `n`, count the total number of digit `1` appearing in all non-negative integers less than or equal to `n`.
Cho một số nguyên `n`, hãy đếm tổng số lần xuất hiện của chữ số `1` trong tất cả các số nguyên không âm nhỏ hơn hoặc bằng `n`.

### Example 1:
```text
Input: n = 13
Output: 6
Explanation: Digit 1 occurs in: 1, 10, 11, 12, 13.
Note: 11 contains two 1s. Total = 1 + 1 + 2 + 1 + 1 = 6.
```

### Example 2:
```text
Input: n = 0
Output: 0
```

## Constraints / Ràng buộc
- `0 <= n <= 10^9`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Digit Position Analysis / Phân Tích Vị Trí Chữ Số
Counting how many times `1` appears at the "ones" place, "tens" place, "hundreds" place, etc., separately.
Đếm số lần `1` xuất hiện ở hàng đơn vị, hàng chục, hàng trăm, v.v., một cách riêng biệt.

For a specific digit position `i` (which is a power of 10: 1, 10, 100...):
Let `n = xyzdabc` where we are focusing on digit `d` at position `i`.
We can split `n` into three parts:
- `high`: digits to the left of `d` (`xyz`).
- `cur`: the current digit `d`.
- `low`: digits to the right of `d` (`abc`).

Formula to count 1s at position `i`:
1.  **Count from higher parts**: `high * i`.
    - `0` to `high - 1` sequences contribute `i` ones each.
2.  **Count from current digit**:
    - If `cur == 0`: 0 extra (covered by higher part logic implicitly being full blocks).
    - If `cur == 1`: We have partial overlap. Add `low + 1`.
    - If `cur > 1`: We have full overlap for this block. Add `i`.

**Compact Formula**: by combining logic
`count += (n / (i*10)) * i + min(max(n % (i*10) - i + 1, 0), i)`
Or using splitting:
- `count = high * i`
- `if cur == 1: count += low + 1`
- `if cur > 1: count += i`

---

## Analysis / Phân tích

### Approach: Iterative Digit Counting

**Algorithm**:
1.  Iterate `i` from 1, 10, 100... while `i <= n`.
2.  Calculate `divider = i * 10`.
3.  `count += (n / divider) * i`.
4.  Calculcate remainder: `rem = n % divider`.
5.  If `rem >= i + i` (i.e. digit at `i` > 1), add `i`.
    Else if `rem >= i` (i.e. digit at `i` == 1), add `rem - i + 1`.

Wait, the logic `rem >= i + i` means the digit is `>= 2`.
Correct logic:
- `div` = `i * 10`.
- Quotient `q` = `n / div`.
- Remainder `r` = `n % div`.
- `count += q * i`.
- Correction based on `r` (which corresponds to `cur` and `low` combined):
    - `r` ranges from `0` to `i*10 - 1`.
    - The range within `r` that has digit 1 at position `i` is `[i, 2*i - 1]`.
    - So add `Math.min(Math.max(r - i + 1, 0), i)`.

### Complexity / Độ phức tạp
- **Time**: O(log10 N) - Loop runs once per digit (max 10 times).
- **Space**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **n = 0**: Returns 0.
2.  **n = 10^9**: Max loop. `i` reaches 1,000,000,000. `long` needed for `i` to avoid overflow if checking `i <= n` loop condition strictly or `i*10` overflow.

**Important Note**: Use `long` for `i` to prevent overflow when `i * 10` exceeds `Integer.MAX_VALUE`.
