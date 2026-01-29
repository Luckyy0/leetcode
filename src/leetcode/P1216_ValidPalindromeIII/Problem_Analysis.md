# 1216. Valid Palindrome III / Palindrome Hợp lệ III

## Problem Description / Mô tả bài toán
Given a string `s` and an integer `k`, return `true` if `s` is a `k`-palindrome.
A string is `k`-palindrome if it can be transformed into a palindrome by removing at most `k` characters.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Longest Palindromic Subsequence (LPS) / Chuỗi con Palindrome Dài nhất
Finding if `s` can become palindrome by removing `k` chars is equivalent to finding if the Longest Palindromic Subsequence has length `>= len(s) - k`.
Or min deletions = `len(s) - len(LPS)`.
Check if `min deletions <= k`.

### Complexity / Độ phức tạp
- **Time**: O(N^2) for LPS.
- **Space**: O(N^2) or O(N) optimized.

---

## Analysis / Phân tích

### Approach: LPS Calculation
Compute the length of the Longest Palindromic Subsequence (LPS) of `s` using dynamic programming. `dp[i][j]` stores the LPS length for substring `s[i...j]`. If `s[i] == s[j]`, `dp[i][j] = 2 + dp[i+1][j-1]`. Otherwise, `dp[i][j] = max(dp[i+1][j], dp[i][j-1])`. The minimum deletions required to make `s` a palindrome is `s.length() - LPS`. Return true if this value is $\le k$.
Tính độ dài của Chuỗi con Palindrome Dài nhất (LPS) của `s` bằng cách sử dụng quy hoạch động. `dp[i][j]` lưu trữ độ dài LPS cho chuỗi con `s[i...j]`. Nếu `s[i] == s[j]`, `dp[i][j] = 2 + dp[i+1][j-1]`. Ngược lại, `dp[i][j] = max(dp[i+1][j], dp[i][j-1])`. Số lần xóa tối thiểu cần thiết để biến `s` thành một palindrome là `s.length() - LPS`. Trả về true nếu giá trị này $\le k$.

---
