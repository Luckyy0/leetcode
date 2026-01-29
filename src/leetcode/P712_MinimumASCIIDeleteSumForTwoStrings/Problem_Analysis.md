# 712. Minimum ASCII Delete Sum for Two Strings / Tổng ASCII Xóa tối thiểu cho Hai chuỗi

## Problem Description / Mô tả bài toán
Given two strings `s1` and `s2`, return the lowest **ASCII sum** of deleted characters to make two strings equal.
Cho hai chuỗi `s1` và `s2`, hãy trả về **tổng ASCII** thấp nhất của các ký tự đã bị xóa để làm cho hai chuỗi bằng nhau.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Quy hoạch Động
This is a variation of the Longest Common Subsequence (LCS) problem.
Đây là một biến thể của bài toán Chuỗi con chung dài nhất (LCS).

Let `dp[i][j]` be the minimum ASCII delete sum for `s1[i:]` and `s2[j:]`.
Gọi `dp[i][j]` là tổng các giá trị ASCII bị xóa tối thiểu cho `s1[i:]` và `s2[j:]`.

Transition:
- If `s1[i] == s2[j]`: `dp[i][j] = dp[i+1][j+1]` (no deletion).
- If `s1[i] != s2[j]`: `dp[i][j] = min(s1[i] + dp[i+1][j], s2[j] + dp[i][j+1])`.

Base cases:
- `dp[n1][j]` = sum of remaining ASCII values in `s2`.
- `dp[i][n2]` = sum of remaining ASCII values in `s1`.

### Complexity / Độ phức tạp
- **Time**: O(N * M) where N, M are lengths of the strings.
- **Space**: O(N * M) or O(M) with space optimization.

---

## Analysis / Phân tích

### Approach: Interval DP
Fill the DP table bottom-up. The result is `dp[0][0]`.
Điền vào bảng DP từ dưới lên. Kết quả là `dp[0][0]`.

---
