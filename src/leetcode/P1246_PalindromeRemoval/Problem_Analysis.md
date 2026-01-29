# 1246. Palindrome Removal / Xóa Palindrome

## Problem Description / Mô tả bài toán
Given an integer array `arr`, in one move you can select a **palindromic** subarray `arr[i...j]` and remove it. The remaining elements merge.
Return minimum moves to delete whole array.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming (Interval DP) / Quy hoạch Động (DP Khoảng)
`dp[i][j]` = min moves to clear `arr[i...j]`.
Base cases:
- `dp[i][i] = 1`.
- `dp[i][i+1] = (arr[i] == arr[i+1]) ? 1 : 2`.

Transitions for `dp[i][j]`:
1. Split point `k`: `dp[i][j] = min(dp[i][k] + dp[k+1][j])` for all `i <= k < j`.
2. Palindrome detection: If `arr[i] == arr[j]`.
   - If i and j match, they can be removed along with the removal of `arr[i+1...j-1]`.
   - Actually, if `arr[i+1...j-1]` is cleared, `arr[i]` and `arr[j]` become adjacent and form a palindrome pair `AA`, which takes 1 move.
   - Wait. If `arr[i+1...j-1]` takes K moves, maybe in one of those moves, the leftover was a single palindrome?
   - Correct logic: If `arr[i] == arr[j]`, then `dp[i][j] = min(dp[i][j], max(1, dp[i+1][j-1]))`.
   - `max(1, ...)` handles case where `i+1 > j-1` (empty subarray needs 0 moves, but pair AA needs 1 move). But wait, strictly `dp[i+1][j-1]` could be 0? If subarray is empty, moves is 0. Pair `i, j` needs 1 move.
   - So `dp[i+1][j-1]` should handle i+1 > j-1 case properly (return 0).
   - `dp[i][j] = max(1, dp[i+1][j-1])` if `arr[i]==arr[j]`.
   - E.g. `[1, 2, 1]`. `dp[1][1] = 1`. `dp[0][2] = max(1, dp[1][1]) = 1` if 1==1. Correct.
   - What if inner is complicated? `1, 2, 3, 2, 1`. `2,3,2` takes 1 move (remove 3, then 22). Then `1, 1` takes 1 move?
   - Wait. Removing palindrome `2,3,2` merges `1, 1`.
   - Actually interval DP usually assumes we clear ranges.
   - Does removing `arr[i...j]` allow merging outer parts? Yes.
   - The problem is isomorphic to: "find min moves to clear range".
   - If `arr[i] == arr[j]`, we can clear `i` and `j` in the same move as the *last move* that clears `arr[i+1...j-1]`.
   - Exception: If `arr[i+1...j-1]` is empty, we just clear `i, j` (1 move).
   - If `arr[i+1...j-1]` takes `M` moves, at least one of them must reduce it to a palindrome. We can append `i` and `j` to that palindrome.
   - So `dp[i][j]`.

### Complexity / Độ phức tạp
- **Time**: O(N^3).
- **Space**: O(N^2).

---

## Analysis / Phân tích

### Approach: Interval DP
Use interval dynamic programming. Let `dp[i][j]` be the minimum moves to remove the subarray `arr[i...j]`.
- Iterate length `len` from 1 to n.
- For each subarray `i` to `j`:
  - Default: split it into two parts `(i, k)` and `(k+1, j)` for all `k`. Take minimum sum. `dp[i][j] = min(dp[i][k] + dp[k+1][j])`.
  - Optimization if `arr[i] == arr[j]`: They can be removed together.
    - If `len == 2`: `dp[i][j] = 1`.
    - Else: `dp[i][j] = min(dp[i][j], dp[i+1][j-1])`. Why `dp[i+1][j-1]`? Because if `arr[i+1...j-1]` takes `X` moves, the last move clears the remaining palindrome. We can attach `arr[i]` and `arr[j]` to that last removed palindrome. If `X` moves are needed, adding `i` and `j` doesn't increase moves, just makes the last palindrome bigger.
    - Example: `1 2 2 1`. `2 2` needs 1 move. `1 ... 1` matches. So `1 2 2 1` cleared in `max(1, dp[22])`? No, just `dp[22]`. Moves: `1`.
    - Example: `1 3 1`. `3` needs 1. `1...1` match. Total `dp[3]=1`. Moves `1`. (`1 3 1` is palindrome).
    - So logic `dp[i][j] = dp[i+1][j-1]` is only valid if `arr[i] == arr[j]`.
    - Wait. Is it always `dp[i+1][j-1]`?
    - If `arr` is `1 2 3`. `dp` is 3. `1 != 3`.
    - If `arr` is `1 2 1`. `1==1`. `dp = dp[2] = 1`. Correct.
    - So if `arr[i] == arr[j]`, consider `dp[i+1][j-1]`.
    - But wait, `dp[i][j]` is initialized to something?
    - Usually `dp[i][j]` initialized to `1 + dp[i+1][j]` (remove `i` alone).
    - Or better, initialize with splits, then try `arr[i] == arr[j]`.

Summary:
1. `dp[i][i] = 1`.
2. `dp[i][i+1] = 1` if equal, else 2.
3. For longer len:
   - `dp[i][j] = 1 + dp[i+1][j]` (naive upper bound).
   - If `arr[i] == arr[i+1]`, `dp[i][j] = min(dp[i][j], 1 + dp[i+2][j])` is covered by split?
   - Try all splits: `min(dp[i][k] + dp[k+1][j])` for `k=i..j-1`.
   - Special case `arr[i] == arr[j]`: `dp[i][j] = min(dp[i][j], max(1, dp[i+1][j-1]))`.

Sử dụng quy hoạch động khoảng. Gọi `dp[i][j]` là số nước đi tối thiểu để xóa mảng con `arr[i...j]`.
- Lặp lại độ dài `len` từ 1 đến n.
- Đối với mỗi mảng con `i` đến `j`:
  - Mặc định: chia nó thành hai phần `(i, k)` và `(k+1, j)` cho tất cả `k`. Lấy tổng tối thiểu. `dp[i][j] = min(dp[i][k] + dp[k+1][j])`.
  - Tối ưu hóa nếu `arr[i] == arr[j]`: Chúng có thể được xóa cùng nhau. `dp[i][j] = min(dp[i][j], max(1, dp[i+1][j-1]))`.

---
