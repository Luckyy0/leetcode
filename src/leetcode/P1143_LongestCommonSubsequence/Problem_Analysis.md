# 1143. Longest Common Subsequence / Chuỗi con Chung Dài nhất

## Problem Description / Mô tả bài toán
Given two strings `text1` and `text2`, return the length of their longest common subsequence.
Cho hai chuỗi `text1` và `text2`, hãy trả về độ dài của chuỗi con chung dài nhất của chúng.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Quy hoạch Động
Standard LCS problem.
`dp[i][j]` = length of LCS of `text1[0..i-1]` and `text2[0..j-1]`.
If `text1[i-1] == text2[j-1]`, `dp[i][j] = dp[i-1][j-1] + 1`.
Else `dp[i][j] = max(dp[i-1][j], dp[i][j-1])`.

### Complexity / Độ phức tạp
- **Time**: O(N * M).
- **Space**: O(N * M) or O(min(N, M)) with space optimization.

---

## Analysis / Phân tích

### Approach: Standard DP
Use 2D dynamic programming. `DP[i][j]` stores the LCS length for substrings ending at `i` and `j`. If characters match, increment the diagonal count. Otherwise, inherit the maximum from the top or left cell.
Sử dụng quy hoạch động 2D. `DP[i][j]` lưu trữ độ dài LCS cho các chuỗi con kết thúc tại `i` và `j`. Nếu các ký tự khớp, tăng số đếm chéo. Nếu không, thừa hưởng giá trị tối đa từ ô trên hoặc ô bên trái.

---
