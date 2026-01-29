# 1223. Dice Roll Simulation / Mô phỏng Tung Xúc xắc

## Problem Description / Mô tả bài toán
Die simulator generates random integer from 1 to 6.
You want to count number of distinct sequences of length `n` such that:
- The `i-th` face is not rolled more than `rollMax[i-1]` times consecutively.
Return modulo `10^9 + 7`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming
State: `dp[len][lastVal][consecutiveCount]`.
`len`: current length of sequence (1 to `n`).
`lastVal`: value of the last die roll (1 to 6).
`consecutiveCount`: how many times `lastVal` has appeared consecutively at the end (1 to `rollMax[lastVal-1]`).

Transitions:
For `dp[i][curr][1]`: sum of `dp[i-1][prev][any]` where `prev != curr`.
For `dp[i][curr][k]` (k > 1): `dp[i-1][curr][k-1]`.
This `k` state can go up to 15.
Size: `N * 6 * 15`. `N` up to 5000.
Computation: `5000 * 6 * 15` is small (~450,000 ops).

Wait, optimizing space: only need previous row.
Or aggregate state?
Usually `rollMax` constraint is separate for each face.
Let `dp[i][j]` be number of sequences length `i` ending with face `j`.
But we need to know consecutive count to apply limit.
If we only store `dp[i][j]`, we don't know if we can add another `j`.
So keeping consecutive count is necessary. `dp[i][face][count]`.
Or simplified DP:
`dp[i][face] = sum(dp[i-1][prev]) for all prev` (total sequences length `i` ending in `face`).
BUT we must subtract invalid sequences where `face` appeared `rollMax[face] + 1` times.
Invalid seq ending in `face` at `i`:
It means `i-th` is `face`, `(i-1)-th` is `face` ... `(i-rollMax)`-th is `face`.
And `(i-rollMax-1)`-th was NOT `face`.
So we can subtract valid sequences of length `i - rollMax - 1` that ended in something NOT `face`.
Total valid at `i` ending `face`:
`sum(all valid at i-1) - excessive ones`.
Excessive: valid seqs length `i-1` ending in `face` such that adding one more `face` violates.
Actually, let's use the explicit state `dp[i][face][count]` as it fits constraints easily.
`n=5000`, `rollMax=15`.
`dp[len][face][k]`.

### Complexity / Độ phức tạp
- **Time**: O(N * 6 * 15).
- **Space**: O(N * 6 * 15) or O(6 * 15).

---

## Analysis / Phân tích

### Approach: 3D DP
Use a DP table `dp[i][die][count]` representing the number of valid sequences of length `i`, ending with die face `die`, having appeared `count` times consecutively at the end.
- Base case: Length 1, each face has count 1.
- Transition `i` to `i+1`:
  - If picking the same face `die`: valid only if `count + 1 <= rollMax[die]`. Transition to `dp[i+1][die][count+1]`.
  - If picking a different face `newDie`: valid for `newDie` with count 1. Sum up all `dp[i][die][any]` to feed into `dp[i+1][newDie][1]`.
Summing is actually: `dp[i+1][newDie][1] += sum(dp[i][oldDie][any])` for all `oldDie != newDie`.
Precomputing total sums per length helps optimize.

### Complexity / Độ phức tạp
- **Time**: $O(N \times 6 \times \text{maxRoll})$.
- **Space**: $O(N \times 6 \times \text{maxRoll})$ or optimized to $O(6 \times \text{maxRoll})$.

---
