# 583. Delete Operation for Two Strings / Thao Tác Xóa Cho Hai Chuỗi

## Problem Description / Mô tả bài toán
Given two strings `word1` and `word2`, return the minimum number of steps required to make `word1` and `word2` the same.
Cho hai chuỗi `word1` và `word2`, hãy trả về số bước tối thiểu cần thiết để làm cho `word1` và `word2` giống nhau.

In one step, you can delete exactly one character in either string.
Trong một bước, bạn có thể xóa chính xác một ký tự trong một trong hai chuỗi.

### Example 1:
```text
Input: word1 = "sea", word2 = "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Longest Common Subsequence (LCS) / Chuỗi Con Chung Dài Nhất
The characters that remain must form a common subsequence. To minimize deletions, we must find the **Longest** Common Subsequence.
Min Steps = `(len(word1) - LCS) + (len(word2) - LCS)`.
`dp[i][j]` = LCS of `word1[0...i-1]` and `word2[0...j-1]`.
If `c1 == c2`, `dp[i][j] = 1 + dp[i-1][j-1]`.
Else `dp[i][j] = max(dp[i-1][j], dp[i][j-1])`.

Alternatively, Direct DP for Min Deletions:
`dp[i][j]` = min deletions for `word1[0...i]` and `word2[0...j]`.
If mismatch: `1 + min(dp[i-1][j], dp[i][j-1])`.
If match: `dp[i-1][j-1]`.

LCS is usually simpler to reason about.

### Complexity / Độ phức tạp
- **Time**: O(M * N).
- **Space**: O(M * N) or O(min(M, N)) with space optimization.

---

## Analysis / Phân tích

### Approach: LCS Reduction

**Algorithm**:
1.  Compute LCS length of two strings.
2.  Result is sum of lengths minus 2 * LCS length.

---
