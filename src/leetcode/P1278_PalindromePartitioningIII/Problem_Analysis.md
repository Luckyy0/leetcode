# 1278. Palindrome Partitioning III / Phân vùng Palindrome III

## Problem Description / Mô tả bài toán
String `s`, integer `k`.
Change characters to make string partitioned into `k` palindromic substrings.
Minimize changed characters.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming
1. Precompute `cost[i][j]`: min changes to make `s[i...j]` a palindrome.
   - `cost[i][j] = (s[i] != s[j]) + cost[i+1][j-1]`.
2. `dp[k][i]`: min changes to partition `s[0...i-1]` into `k` parts.
   - `dp[k][i] = min(dp[k-1][j] + cost[j][i-1])` for `j < i`.
   - `j` ranges from `k-1` to `i-1`. (Need at least k-1 chars for k-1 parts).

### Complexity / Độ phức tạp
- **Time**: `cost` O(N^2), `dp` O(K * N^2). N=100. very fast.
- **Space**: O(N^2) or O(N).

---

## Analysis / Phân tích

### Approach: DP with Precomputed Costs
First, precompute `cost[i][j]`, the number of changes to make substring `s[i...j]` a palindrome. Use DP logic: if `s[i] == s[j]`, `cost[i][j] = cost[i+1][j-1]`; else, `1 + cost[i+1][j-1]`. Base cases are lengths 1 and 2.
Next, define `dp[m][i]` as min changes to partition the prefix `s[0..i]` into `m` palindromes. Transition: `dp[m][i] = min(dp[m-1][j-1] + cost[j][i])` over all valid split points `j`. The answer is `dp[k][n-1]`.
Đầu tiên, tính trước `cost[i][j]`, số lượng thay đổi để biến chuỗi con `s[i...j]` thành palindrome. Sử dụng logic DP: nếu `s[i] == s[j]`, `cost[i][j] = cost[i+1][j-1]`; ngược lại, `1 + cost[i+1][j-1]`. Trường hợp cơ sở là độ dài 1 và 2.
Tiếp theo, xác định `dp[m][i]` là số thay đổi tối thiểu để phân vùng tiền tố `s[0..i]` thành `m` palindrome. Chuyển đổi: `dp[m][i] = min(dp[m-1][j-1] + cost[j][i])` trên tất cả các điểm phân tách hợp lệ `j`. Câu trả lời là `dp[k][n-1]`.

---
