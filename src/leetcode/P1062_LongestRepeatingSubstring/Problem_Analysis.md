# 1062. Longest Repeating Substring / Chuỗi con Lặp lại Dài nhất

## Problem Description / Mô tả bài toán
Given a string `s`, find out the length of the longest repeating substring(s). Return 0 if no repeating substring exists.
Cho một chuỗi `s`, hãy tìm độ dài của (các) chuỗi con lặp lại dài nhất. Trả về 0 nếu không tồn tại chuỗi con lặp lại.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Binary Search + Rolling Hash / Suffix Array / DP
Similar to P1044 but string length up to 1500 or 2000? Leetcode P1062 N <= 1500 usually.
If N is small enough (N^2), DP works.
If N is large, Binary Search + Rolling Hash.

DP Approach:
`dp[i][j]` = length of common suffix between `s[0...i]` and `s[0...j]`.
If `s[i] == s[j]`, `dp[i][j] = dp[i-1][j-1] + 1`.
We are looking for `max(dp[i][j])` where `i != j`.

### Complexity / Độ phức tạp
- **Time**: O(N^2) for DP.
- **Space**: O(N^2).

---

## Analysis / Phân tích

### Approach: Dynamic Programming for Common Substrings
Compute the longest common suffix for every pair of indices $(i, j)$ where $i < j$. `dp[i][j]` stores this length. If $s[i] == s[j]$, extend the match from the previous positions. The maximum value in the DP table represents the longest substring that appears in at least two different locations.
Tính toán hậu tố chung dài nhất cho mọi cặp chỉ số $(i, j)$ trong đó $i < j$. `dp[i][j]` lưu trữ độ dài này. Nếu $s[i] == s[j]$, mở rộng kết quả khớp từ các vị trí trước đó. Giá trị lớn nhất trong bảng DP đại diện cho chuỗi con dài nhất xuất hiện ở ít nhất hai vị trí khác nhau.

---
