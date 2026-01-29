# 629. K Inverse Pairs Array / Mảng K Cặp Nghịch Đảo

## Problem Description / Mô tả bài toán
For an integer array `nums`, an **inverse pair** is a pair of integers `[i, j]` where `0 <= i < j < nums.length` and `nums[i] > nums[j]`.
Đối với một mảng số nguyên `nums`, một **cặp nghịch đảo** là một cặp số nguyên `[i, j]` trong đó `0 <= i < j < nums.length` và `nums[i] > nums[j]`.

Given two integers `n` and `k`, return the number of different arrays consist of numbers from `1` to `n` such that there are exactly `k` inverse pairs. Since the answer can be huge, return it modulo `10^9 + 7`.
Cho hai số nguyên `n` và `k`, trả về số lượng mảng khác nhau bao gồm các số từ `1` đến `n` sao cho có chính xác `k` cặp nghịch đảo. Vì câu trả lời có thể rất lớn, hãy trả về nó modulo `10^9 + 7`.

### Example 1:
```text
Input: n = 3, k = 0
Output: 1 (Array [1,2,3])
```
### Example 2:
```text
Input: n = 3, k = 1
Output: 2 (Arrays [1,3,2], [2,1,3])
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Quy Hoạch Động
Let `dp[i][j]` be the number of permutations of `1..i` with `j` inverse pairs.
When we insert number `i` into a permutation of `1..i-1`, we can place `i` at any position.
- If we place `i` at the end, we add 0 inverse pairs (since `i` is largest).
- If we place `i` at second to last, we add 1 inverse pair.
- ...
- If we place `i` at the beginning, we add `i-1` inverse pairs.

Transition:
`dp[i][j] = sum(dp[i-1][j-p])` for `p` from `0` to `i-1` (and `j-p >= 0`).
`dp[i][j] = dp[i-1][j] + dp[i-1][j-1] + ... + dp[i-1][j-(i-1)]`.

Optimization (Sliding Window / Optimization of Sum):
`dp[i][j-1] = dp[i-1][j-1] + ... + dp[i-1][j-1-(i-1)]`.
`dp[i][j] - dp[i][j-1] = dp[i-1][j] - dp[i-1][j-i]` (if `j-i >= 0`).
So `dp[i][j] = dp[i][j-1] + dp[i-1][j] - dp[i-1][j-i]`.
Handle modulo carefully (add MOD before subtract).

### Complexity / Độ phức tạp
- **Time**: O(N * K).
- **Space**: O(N * K) or O(K) optimized.

---

## Analysis / Phân tích

### Approach: Optimized DP

**Algorithm**:
1.  Init DP table `dp[k+1]`.
2.  Iterate `n` from 1 to N.
3.  Compute new DP row using sliding window sum logic.
4.  Return `dp[k]`.

---
