# 1397. Find All Good Strings / Tìm Tất cả Các Chuỗi Tốt

## Problem Description / Mô tả bài toán
Two strings `s1` and `s2` size `n`. Also `evil` string.
Count strings `s` of size `n` such that `s1 <= s <= s2` and `s` does not contain `evil` as substring.
Modulo 10^9 + 7.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Digit DP with KMP State
Count strings <= `s2` minus count strings < `s1` (or <= `s1-1`).
Function `count(s)`.
DP state: `dp[idx][stats_kmp][tight_constraint]`.
`idx`: current position in `s` (0 to n-1).
`stats_kmp`: length of prefix of `evil` matched so far (0 to len(evil)-1).
`tight`: boolean, restricted by `s` digits.
Transitions:
Iterate char `c` from 'a' to limit.
New KMP state: updating `stats_kmp` with `c` using KMP `next` array.
If new state == len(evil), invalid path (contains evil).
Memoize.

### Complexity / Độ phức tạp
- **Time**: O(N * M * 26) where M = len(evil). N = 500, M = 50.
- **Space**: O(N * M).

---

## Analysis / Phân tích

### Approach: Digit DP + KMP
Compute the KMP failure function (LPS array) for `evil`.
Define `solve(index, evilMatchLen, tight, isS1Prefix, isS2Prefix)`?
Alternative: `count(s)` calculates number of valid strings <= `s`.
Result = `count(s2) - count(s1) + check(s1)`?
Actually common pattern is `solve(index, matchLen, tight1, tight2)`.
Where `tight1` means we are matching prefix of `s1` (lower bound), `tight2` matching prefix of `s2` (upper bound).
Wait, "lower bound s1 and upper bound s2". Standard digit DP usually does `0 to N`.
Since s1 and s2 have same length `n`, we can run one DP with both lower (`tight1`) and upper (`tight2`) constraints simultaneously.
`dp[index][match][tight1][tight2]`.
- `index`: 0 to n.
- `match`: 0 to m-1 (if m, invalid).
- `tight1`: true if we are restricted by `s1` (cannot go below `s1[index]`).
- `tight2`: true if we are restricted by `s2` (cannot go above `s2[index]`).
Loop `char` from `minChar` to `maxChar`.
Updated constraints and KMP state.
Modulo arithmetic.
Tính toán hàm lỗi KMP (mảng LPS) cho `evil`.
Sử dụng DP chữ số với cả ràng buộc dưới (`tight1`) và trên (`tight2`).
`dp[index][match][tight1][tight2]`.
- `index`: 0 đến n.
- `match`: 0 đến m-1.
- `tight1`: true nếu bị giới hạn bởi `s1`.
- `tight2`: true nếu bị giới hạn bởi `s2`.
Lặp `char` từ `minChar` đến `maxChar`.
Cập nhật các ràng buộc và trạng thái KMP.
Số học theo modulo.

---
