# 730. Count Different Palindromic Subsequences / Đếm các Chuỗi con Đối xứng Khác nhau

## Problem Description / Mô tả bài toán
Given a string `s`, return the number of different non-empty palindromic subsequences in `s`. Since the answer may be very large, return it **modulo 10^9 + 7**.
Cho một chuỗi `s`, hãy trả về số lượng các chuỗi con đối xứng không rỗng khác nhau trong `s`. Vì câu trả lời có thể rất lớn, hãy trả về nó theo **modulo 10^9 + 7**.

Two sequences are considered different if there is some `i` for which `s1[i] != s2[i]`.
Hai chuỗi được coi là khác nhau nếu có một số `i` mà `s1[i] != s2[i]`.

Note: In this problem, we only consider characters 'a', 'b', 'c', and 'd'.
Lưu ý: Trong bài toán này, chúng ta chỉ xem xét các ký tự 'a', 'b', 'c' và 'd'.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Quy hoạch Động
Let `dp[i][j]` be the number of distinct palindromic subsequences in `s[i...j]`.
Gọi `dp[i][j]` là số lượng các chuỗi con đối xứng phân biệt trong `s[i...j]`.

Transition:
- If `s[i] != s[j]`:
  `dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1]`
- If `s[i] == s[j]`:
  Let `l` and `r` be the indices of characters equal to `s[i]` nearest to `i` (from left) and `j` (from right) in the inner range `(i, j)`.
  - No such `l`: `dp[i][j] = 2 * dp[i+1][j-1] + 2`.
  - `l == r`: `dp[i][j] = 2 * dp[i+1][j-1] + 1`.
  - `l < r`: `dp[i][j] = 2 * dp[i+1][j-1] - dp[l+1][r-1]`.

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(N^2).

---

## Analysis / Phân tích

### Approach: 2D DP
The limited alphabet ('a'-'d') makes the nested structure more predictable. Handle deletions carefully with modulo math.
Bảng chữ cái hữu hạn ('a'-'d') làm cho cấu trúc lồng nhau dễ dự đoán hơn. Xử lý các phép trừ cẩn thận với toán học modulo.

---
