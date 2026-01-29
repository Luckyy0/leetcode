# 1531. String Compression II / Nén Chuỗi II

## Problem Description / Mô tả bài toán
String `s`. Delete at most `k` characters.
Return minimum length of run-length encoded version.
"a" -> "a" (1)
"aa" -> "a2" (2)
"aaa" -> "a3" (2)
"aaaa...a" (10 times) -> "a10" (3)

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming
`dp[i][k]`: Minimal length for prefix `s[0...i-1]` after deleting `k` chars.
State: `dp[i][k]` = min length of encoded `s[i:]` with `k` removals allowed?
Better: `dp[idx][lastChar][lastCharCount][removals]`. Too large.
Standard DP: `dp[i][k]`: min length of compression for suffix `s[i:]` (or prefix) with `k` removals left.
Transition for `dp[i][k]`:
1. Delete `s[i]`: `dp[i+1][k-1]`.
2. Keep `s[i]`: Scan forward `j` from `i`. Count same char `s[i]`. Delete different chars `diff`.
   If `diff <= k`, transition to `dp[j+1][k-diff]`.
   Cost increases based on count of same char (1 -> 2 -> 3 -> 4 length changes at count 1, 2, 10, 100).
   `cost(c)`: 1 if `c=1`. 2 if `c=2..9`. 3 if `c=10..99`. 4 if `c=100`.

### Complexity / Độ phức tạp
- **Time**: O(N^2 * K). N=100. K=100. $100^3 = 10^6$. OK.
- **Space**: O(N * K).

---

## Analysis / Phân tích

### Approach: 2D DP with Inner Loop
`dp[i][k]` = min length for `s[i...n-1]` with `k` removals.
Base case: `dp[n][k] = 0`.
Logic:
`dp[i][k] = dp[i+1][k-1]` (Delete s[i]).
Iterate `j` from `i` to `n-1`.
Count char `s[i]` instances (`same`). Different chars (`diff`).
If `diff > k`, break inner loop.
Recursion: `cost(same) + dp[j+1][k-diff]`.
Minimize.
Memoize.
`dp[i][k]` = độ dài tối thiểu cho `s[i...n-1]` với `k` lần xóa.
`dp[i][k] = dp[i+1][k-1]` (Xóa s[i]).
Lặp lại `j` từ `i` đến `n-1`.

---
