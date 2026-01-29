# 357. Count Numbers with Unique Digits / Đếm Các Số Có Các Chữ Số Duy Nhất

## Problem Description / Mô tả bài toán
Given an integer `n`, return the count of all numbers with unique digits, `x`, where `0 <= x < 10^n`.
Cho một số nguyên `n`, trả về số lượng các số có các chữ số duy nhất `x`, trong đó `0 <= x < 10^n`.

### Example 1:
```text
Input: n = 2
Output: 91
Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100, excluding 11,22,33,44,55,66,77,88,99.
Total 100 - 9 = 91.
```

### Example 2:
```text
Input: n = 0
Output: 1
```

## Constraints / Ràng buộc
- `0 <= n <= 8`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Combinatorics / Tổ Hợp
`n=0`: Range [0, 1). Only 0. Count = 1.
`n=1`: Range [0, 10). 0-9. Count = 10.
`n=2`: Range [0, 100).
- 1 digit: 10 (from n=1).
- 2 digits: First digit 1-9 (9 choices). Second digit 0-9 distinct from first (9 choices).
  - 9 * 9 = 81.
  - Total = 10 + 81 = 91.

`n=3`: Range [0, 1000).
- 1, 2 digits: 91.
- 3 digits: First (1-9), Second (0-9 distinct), Third (0-9 distinct).
  - 9 * 9 * 8 = 648.
  - Total = 91 + 648 = 739.

Formula for `k` digits: `9 * 9 * 8 * ... * (9 - k + 2)`.
Sum up for length 1 to `n`. Plus 1 for `0` (actually n=1 case already covers 0 if not split, but n=1 is 10).
Correct logic:
- `ans[0] = 1`.
- `ans[1] = 10`.
- `ans[n] = ans[n-1] + 9 * P(9, n-1)`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: DP / Combinatorial

**Algorithm**:
1.  If `n=0` return 1.
2.  `ans = 10`.
3.  `curr = 9`. `available = 9`.
4.  Loop 2 to `n`:
    - `curr *= available`.
    - `ans += curr`.
    - `available--`.

Wait, for n=2: 9 * 9 = 81. Ans = 10 + 81 = 91.
For n=3: 9 * 9 * 8 = 648. Ans = 91 + 648.
Correct.

---
