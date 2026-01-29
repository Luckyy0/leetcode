# 1269. Number of Ways to Stay in the Same Place After Some Steps / Số cách để Ở lại Cùng một Vị trí Sau một số Bước

## Problem Description / Mô tả bài toán
Steps `steps`, array length `arrLen`. Start at index 0.
Each step: Left, Right, Stay.
Stay within `[0, arrLen-1]`.
Return ways to be at index 0 after `steps` steps. Modulo `10^9 + 7`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming
`dp[i][j]` = ways to be at index `j` after `i` steps.
Transitions: `dp[i][j] = dp[i-1][j-1] + dp[i-1][j] + dp[i-1][j+1]`.
Check bounds.
Space optimization: `dp[j]` only depends on previous array. 2 rows needed.
Max index needed: Since we have `steps`, we can't go further than `steps/2` (to return to 0) or `steps` (if we just go right, but need to return).
Actually, max index is `min(arrLen - 1, steps)`.
Wait, to return to 0, if we are at `k`, we need `k` steps to return. So if `steps_remaining < k`, impossible.
Thus max index we need to track is `steps / 2 + 1` (roughly). Let's use `steps`.
Constraint: `steps` up to 500. `arrLen` up to 10^6.
So effective length is `min(arrLen, steps)`.

### Complexity / Độ phức tạp
- **Time**: O(steps * min(steps, arrLen)).
- **Space**: O(min(steps, arrLen)).

---

## Analysis / Phân tích

### Approach: DP with Space Optimization
Use DP where `dp[j]` is the number of ways to be at index `j` at the current step. The maximum effective index we need to consider is `min(arrLen - 1, steps / 2 + 1)` because if we go further, we cannot return to 0 within the remaining steps. Iterate `steps` times. In each iteration, compute `new_dp[j]` based on `dp[j-1]`, `dp[j]`, and `dp[j+1]` from the previous step. Perform modulo operations.
Sử dụng DP trong đó `dp[j]` là số cách để ở chỉ số `j` ở bước hiện tại. Chỉ số hiệu dụng tối đa chúng ta cần xem xét là `min(arrLen - 1, steps / 2 + 1)` vì nếu chúng ta đi xa hơn, chúng ta không thể quay lại 0 trong các bước còn lại. Lặp lại `steps` lần. Trong mỗi lần lặp, hãy tính `new_dp[j]` dựa trên `dp[j-1]`, `dp[j]` và `dp[j+1]` từ bước trước đó. Thực hiện các phép tính modulo.

---
