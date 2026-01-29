# 471. Encode String with Shortest Length / Mã Hóa Chuỗi Với Độ Dài Ngắn Nhất

## Problem Description / Mô tả bài toán
Given a string `s`, encode the string such that its length is minimized.
Cho một chuỗi `s`, hãy mã hóa chuỗi đó sao cho độ dài của nó là nhỏ nhất.

The encoding rule is: `k[encoded_string]`, where the `encoded_string` inside the square brackets is being repeated exactly `k` times. `k` should be a positive integer.
Quy tắc mã hóa là: `k[encoded_string]`, trong đó `encoded_string` bên trong dấu ngoặc vuông được lặp lại đúng `k` lần. `k` phải là một số nguyên dương.

If an encoding does not help shorten the string, do not encode it.
Nếu việc mã hóa không giúp rút ngắn chuỗi, đừng mã hóa nó.

### Example 1:
```text
Input: s = "aaa"
Output: "aaa"
Explanation: "3[a]" is same length, so "aaa" is fine.
```

### Example 2:
```text
Input: s = "aaaaaaaaaa"
Output: "10[a]"
```

### Example 3:
```text
Input: s = "aabcaabcd"
Output: "2[aabc]d"
```

## Constraints / Ràng buộc
- `1 <= s.length <= 150`
- `s` consists of lowercase English letters.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Quy hoạch động
Let `dp[i][j]` be the shortest encoded string for the substring `s[i...j]`.

Algorithm:
1. Iterate over all possible lengths `len` from 1 to `n`.
2. For each length, iterate over starting position `i`. End position `j = i + len - 1`.
3. For each substring `s[i...j]`:
   - Initially, set `dp[i][j] = s[i...j]`.
   - **Case 1: Split**. Try all splitting points `k` from `i` to `j-1`. `dp[i][j] = min(dp[i][j], dp[i][k] + dp[k+1][j])`.
   - **Case 2: Repeat**. Check if `s[i...j]` can be formed by a repeating pattern.
     - Find the smallest repeating period `P`. (Using the `s+s` trick or KMP).
     - If `s[i...j]` is a repetition of `P` `k` times, a candidate encoding is `k + "[" + dp[i][i+P-1] + "]"`.
     - Update `dp[i][j]` if this candidate is shorter.
4. Return `dp[0][n-1]`.

### Complexity / Độ phức tạp
- **Time**: O(N^4) (Nested loops for `i, j, k` plus string repetition check and manipulation).
- **Space**: O(N^3) (2D DP table storing strings).

---

## Analysis / Phân tích

### Approach: Interval-based DP

**Algorithm**:
1.  Iterate through all substrings.
2.  Split-point evaluation.
3.  Pattern detection for repetitive encoding.
4.  Greedy min length selection.

---
