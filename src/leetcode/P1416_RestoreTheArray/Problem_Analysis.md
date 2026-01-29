# 1416. Restore The Array / Khôi phục Mảng

## Problem Description / Mô tả bài toán
String `s` of digits. Integer `k`.
Split `s` into integers `[v1, v2...]`.
Each `vi` must be between `1` and `k`. No leading zeros.
Count ways modulo `10^9 + 7`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming
`dp[i]` = number of ways to restore array from `s[i...n-1]`.
To compute `dp[i]`:
Attempt to form first number using `s[i...j]`.
- Must not have leading zero (unless number is 0? Problem: `1 to k`. So 0 invalid, "0" digit alone invalid). Leading zeros invalid.
- Value `val = parseInt(s[i...j])`.
- If `1 <= val <= k`:
  `dp[i] += dp[j+1]`.
- If `val > k`, break loop (larger substrings will also be > k).
Handle long integer overflow while parsing. Max `k` is `10^9`. Substrings > 10 chars will overflow `int` and likely `k`.
Constraint `n <= 10^5`. `k` up to `10^9`. String length up to 10 is enough.

### Complexity / Độ phức tạp
- **Time**: O(N * 10) = O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: DP from Back/Front
Iterate `i` from `n-1` down to `0`. `dp[i]` depends on `dp[j+1]`.
Inner loop `j` from `i` to `i + 9` (since `k <= 10^9`).
Check for leading zero: `s[i] == '0'`, then `dp[i] = 0` (cannot start number with 0).
Parse number. If valid, add `dp[j+1]`.
Lặp lại `i` từ `n-1` xuống `0`. `dp[i]` phụ thuộc vào `dp[j+1]`.
Vòng lặp bên trong `j` từ `i` đến `i + 9` (vì `k <= 10^9`).
Kiểm tra số 0 đứng đầu: `s[i] == '0'`, thì `dp[i] = 0`.
Phân tích số. Nếu hợp lệ, thêm `dp[j+1]`.

---
