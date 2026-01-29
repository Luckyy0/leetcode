# 1434. Number of Ways to Wear Different Hats to Each Other / Số Cách Đội Mũ Khác Nhau cho Nhau

## Problem Description / Mô tả bài toán
`n` people. List of hats each person likes.
Assign distinct hats to people.
Count mod 10^9 + 7.
Constraint: `n` small (<= 10). `hats` up to 40.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Bitmask Dynamic Programming
Since `n` is small, assign state to people.
`dp[hat_id][mask]`: Ways to assign hats up to `hat_id` to people represented by `mask`.
Or iterate hats.
For each hat `h` (1 to 40):
- It can be assigned to no one (transition `dp[mask]` unchanged).
- It can be assigned to person `p` if `p` likes `h` and `p` not in mask. (transition `dp[mask | (1<<p)] += dp[mask]`).
State space: `2^10 * 40`. Operations approx `10 * 2^10 * 40`. Feasible.
`dp[mask]`. Iterate hats. Update mask in reverse or use `next_dp`.

### Complexity / Độ phức tạp
- **Time**: O(H * 2^N * N). (Checking people).
- **Space**: O(2^N).

---

## Analysis / Phân tích

### Approach: DP on Hat
Precompute `peopleWhoLike[hat]` list.
Array `dp[mask]` storing ways to cover `mask` of people. Initial `dp[0] = 1`.
Iterate hats `h` from 1 to 40.
Create `next_dp` (copy of `dp`).
For each person `p` who likes `h`:
  For each `mask`:
    If `p` not in `mask`:
      `next_dp[mask | (1<<p)] += dp[mask]`.
Swap `dp` and `next_dp`.
Or use one array iterating mask backwards. But we need to combine "assign to p" with "original state".
Usually:
`dp[mask]` is ways using first `h` hats.
For a new hat `h`:
It can be skipped: implicitly carried over.
It can be used by ONE person `p`.
So:
Iterate `mask` from `(1<<n)-1` down to 0.
For each person `p` who likes `h`:
  If `p` not in `mask`:
    Wait. Mask represents assigned people.
    If we assign `p`, we transition FROM `mask without p` TO `mask with p`.
    So iterated loop:
    If `(mask & (1<<p)) == 0` (p free):
       `dp[mask | (1<<p)] += dp[mask]`.
    Wait. Same hat cannot be assigned to multiple people.
    Correct inner loop:
    Iterate `mask` (backwards).
    For each person `p`:
       if `(mask & (1<<p)) == 0`:
           `dp[mask | (1<<p)] += dp[mask]`.
    This logic counts assigning ONE hat to MULTIPLE people in one hat-step? NO.
    We must use hat `h` ONCE.
    So: `new_dp = clone(dp)`.
    For each person `p` who likes `h`:
       Iterate `mask`:
           If `(mask & (1<<p)) == 0`:
              `new_dp[mask | (1<<p)] += dp[mask]`.
    `dp = new_dp`.
    Here `dp[mask]` is ways without `h`. `new_dp` accumulates ways WITH `h` (assigned to any valid `p`) + ways WITHOUT `h`.
    Correct.

Tiền xử lý danh sách `peopleWhoLike[hat]`.
Mảng `dp[mask]` lưu trữ các cách để che `mask` của mọi người. `dp[0] = 1`.
Lặp lại các mũ `h` từ 1 đến 40.
Tạo `new_dp` (bản sao của `dp`).
Đối với mỗi người `p` thích `h`:
   Lặp lại `mask`:
       Nếu `(mask & (1<<p)) == 0`:
          `new_dp[mask | (1<<p)] += dp[mask]`.
`dp = new_dp`.

---
