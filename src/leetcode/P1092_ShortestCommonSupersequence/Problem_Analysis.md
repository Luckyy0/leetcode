# 1092. Shortest Common Supersequence / Siêu Chuỗi Chung Ngắn nhất

## Problem Description / Mô tả bài toán
Given two strings `str1` and `str2`, return the shortest string that has both `str1` and `str2` as subsequences. If there are multiple valid strings, return any of them.
Cho hai chuỗi `str1` và `str2`, hãy trả về chuỗi ngắn nhất có cả `str1` và `str2` làm chuỗi con. Nếu có nhiều chuỗi hợp lệ, hãy trả về bất kỳ chuỗi nào trong số đó.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Longest Common Subsequence (LCS) / Chuỗi con Chung Dài nhất
The shortest common supersequence will consist of the LCS + the distinct characters from `str1` + the distinct characters from `str2`.
Length of SCS = `len1 + len2 - len(LCS)`.

Algorithm:
1. Compute LCS dynamic programming table.
2. Backtrack from `dp[n][m]` to construct the SCS.
   - If `s1[i] == s2[j]`, add this char, move diagonal.
   - Else if `dp[i-1][j] > dp[i][j-1]` (meaning LCS came from `s1` removal? no), actually check which path gives max LCS.
     - We want SHORTEST supersequence, so we want to preserve chars that give MAX LCS.
     - If we go Up (`i-1`), it means `s1[i]` was NOT part of LCS solution there. So `s1[i]` must be added individually.
     - Same for Left.
     - Wait, standard LCS reconstruction logic.
   - While `i > 0` and `j > 0`:
     - If `s1[i-1] == s2[j-1]`: append `s1[i-1]`, `i--`, `j--`.
     - Else if `dp[i-1][j] > dp[i][j-1]`: append `s1[i-1]`, `i--`.
     - Else: append `s2[j-1]`, `j--`.
   - While `i > 0`: append `s1[i-1]`, `i--`.
   - While `j > 0`: append `s2[j-1]`, `j--`.
   - Reverse the result string.

### Complexity / Độ phức tạp
- **Time**: O(N * M).
- **Space**: O(N * M).

---

## Analysis / Phân tích

### Approach: LCS Extension
Determine the Longest Common Subsequence (LCS) of the two strings. The Shortest Common Supersequence is formed by inserting the non-LCS characters of both strings into the LCS structure in their respective order. We reconstruct this by backtracking through the LCS DP table: characters present in the LCS are taken once, while mismatched characters are taken from their respective strings as we traverse the optimal path.
Xác định Chuỗi con Chung Dài nhất (LCS) của hai chuỗi. Siêu Chuỗi Chung Ngắn nhất được hình thành bằng cách chèn các ký tự không thuộc LCS của cả hai chuỗi vào cấu trúc LCS theo thứ tự tương ứng của chúng. Chúng ta xây dựng lại điều này bằng cách quay lui qua bảng LCS DP: các ký tự có trong LCS được lấy một lần, trong khi các ký tự không khớp được lấy từ các chuỗi tương ứng của chúng khi chúng ta duyệt qua đường dẫn tối ưu.

---
