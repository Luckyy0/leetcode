# 600. Non-negative Integers without Consecutive Ones / Các Số Nguyên Không Âm Không Có Số Một Liên Tiếp

## Problem Description / Mô tả bài toán
Given a positive integer `n`, return the number of the integers in the range `[0, n]` whose binary representations **do not** contain consecutive ones.
Cho một số nguyên dương `n`, hãy trả về số lượng các số nguyên trong phạm vi `[0, n]` có biểu diễn nhị phân **không** chứa các số một liên tiếp.

### Example 1:
```text
Input: n = 5
Output: 5
Explanation:
0: 0
1: 1
2: 10
3: 11 (Invalid)
4: 100
5: 101
Valid: 0, 1, 2, 4, 5. Total 5.
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Digit DP / Fibonacci Numbers / Quy hoạch động chữ số / Số Fibonacci
The number of valid binary strings of length `k` without consecutive ones follows Fibonacci sequence.
`f[k]`: count of valid strings length `k` (could have leading zeros conceptually if considering full range of bits).

Actually:
`f[0] = 1`: "" (1 string)
`f[1] = 2`: "0", "1" (2 strings)
`f[2] = 3`: "00", "01", "10" (3 strings)
`f[i] = f[i-1] + f[i-2]`.

To solve for specific `n`, we iterate from MSB down to 0.
Let binary of `n` be `b_k...b_1b_0`.
Iterate `i` from `k` down to `0`.
If `b_i == 1`:
   - If we choose `0` at this position, all remaining `i` bits can form any valid sequence. Count is `f[i]`.
   - We then try to match `1` (continue loop).
   - If the previous bit (`b_{i+1}`) was also `1`:
     - We have consecutive ones in the prefix matching `n`.
     - We cannot continue matching `n` because `n` itself is invalid (or any number starting with this prefix).
     - But we already counted the case where we put `0` at this position (which covers all numbers less than current prefix).
     - So we stop and break.
If `b_i == 0`:
   - We must match `0`. We can't put `1` (would exceed `n`).
   - Continue loop.

If we finish the loop without breaking (meaning `n` itself is valid), we add 1 for `n` itself.

Example `n = 5` (101):
`f` array: `f[0]=1, f[1]=2, f[2]=3, f[3]=5`.
Binary `101` (len 3).
- `i=2` (val 1): Add `f[2]` (valid strings of len 2: 00, 01, 10 -> correspond to 0XX < 1XX). Correct?
  `f[i]` is count of valid binary strings of length `i`. `00, 01, 10`. So `000, 001, 010`. These are 0, 1, 2. Correct.
  We matched '1' at pos 2. Prev check: None.
- `i=1` (val 0): We must put '0'. Cannot add `f[1]` (which implies putting '1' < '0' impossible).
  Prev bit was '1'. Current is '0'. No consecutive ones yet. Continue.
- `i=0` (val 1): Add `f[0]` (len 0 string -> "").
  We matched '1'. Prev was '0'. No violation.
- Loop ends. Add 1 (for 101 itself).
Total: `3 + 1 + 1 = 5`.

### Complexity / Độ phức tạp
- **Time**: O(log N) (number of bits).
- **Space**: O(log N).

---

## Analysis / Phân tích

### Approach: Digit DP with Fibonacci

**Algorithm**:
1.  Precompute Fibonacci Numbers.
2.  Iterate bits of `n` from MSB.
3.  Accumulate counts for branches where we pick '0' instead of '1'.
4.  Handle consecutive ones constraint to prune search.

---
