# 1312. Minimum Insertion Steps to Make a String Palindrome / Số Bước Chèn Tối thiểu để Làm Chuỗi thành Palindrome

## Problem Description / Mô tả bài toán
Given string `s`. Insert chars to make it palindrome. Minimum steps.
Same as finding longest palindromic subsequence and inserting efficient chars.
Min insertions = Length - Longest Palindromic Subsequence (LPS).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming (LCS / LPS)
LPS of `s` is equivalent to LCS of `s` and `reverse(s)`.
1. Compute `reverse(s)`.
2. Compute `LCS(s, reverse(s))`.
3. Answer: `n - LCS`.
Or specific LPS DP:
`dp[i][j]` = max length palindrome in `s[i...j]`.
- If `s[i] == s[j]`: `2 + dp[i+1][j-1]` (if `i+1 <= j-1` else 1/2 handled by base).
- Else: `max(dp[i+1][j], dp[i][j-1])`.

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(N^2).

---

## Analysis / Phân tích

### Approach: LCS Reduction
The minimum insertions required to make a string a palindrome is equal to the length of the string minus the length of its Longest Palindromic Subsequence (LPS). The LPS of a string `s` can be found by computing the Longest Common Subsequence (LCS) between `s` and its reverse, `t`. Thus, the answer is `len(s) - LCS(s, reverse(s))`.
Số bước chèn tối thiểu cần thiết để làm cho một chuỗi trở thành palindrome bằng độ dài của chuỗi trừ đi độ dài của Chuỗi con Palindrome Dài nhất (LPS) của nó. LPS của một chuỗi `s` có thể được tìm thấy bằng cách tính Chuỗi con Chung Dài nhất (LCS) giữa `s` và đảo ngược của nó, `t`. Do đó, câu trả lời là `len(s) - LCS(s, reverse(s))`.

---
