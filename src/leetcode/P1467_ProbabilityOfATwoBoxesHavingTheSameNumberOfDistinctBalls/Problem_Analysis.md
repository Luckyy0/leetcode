# 1467. Probability of a Two Boxes Having The Same Number of Distinct Balls / Xác suất Hai Hộp Có Cùng Số Lượng Bóng Phân biệt

## Problem Description / Mô tả bài toán
2n balls. `balls` array gives counts of k distinct colors.
Split into 2 boxes of size n.
Return probability that both boxes have same number of distinct colors.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Combinatorics (Multinomial)
We need to distribute balls into Box1 and Box2.
Total balls $S = \sum balls$. Each box gets $S/2$.
We need to track:
1. Number of balls in Box1. (Should end at S/2).
2. Distinct colors in Box1.
3. Distinct colors in Box2.
State: `dp[color_idx][count1][distinct1][distinct2]`?
`count1`: sum of balls in Box1. Range 0 to S/2.
`distinct1 - distinct2`: Diff. Range -k to k.
Or just calculate ways.
Total ways to split: Multinomial coefficient.
$(S)! / ((n!)^2) \times ...$? No.
Total ways to arrange $S$ balls is $S! / (\prod balls_i!)$.
But we just split into two sets without order inside sets? Or order?
Problem says "shuffle ... distribute".
It's equivalent to choosing a multiset of size $S/2$ for Box1.
Total ways to choose half: coefficient of $x^{S/2}$ in $\prod (1 + x + ... + x^{balls_i})$.
Actually easier: Use DFS to iterate distributions.
`dfs(idx, count1, distinct1, distinct2)`: returns number of valid ways (weighted by combinations).
Weight: For color `i` with total `c`, if we put `k` in Box1 and `c-k` in Box2:
Ways = $\binom{c}{k}$.
Total valid ways = $\sum \prod \binom{balls_i}{k_i}$.
Total ways = $\binom{S}{S/2}$.

### Complexity / Độ phức tạp
- **Time**: O(K * S * K). K colors, S total balls.
- **Space**: O(K * S).

---

## Analysis / Phân tích

### Approach: Recursive Search with Memoization
Function `solve(idx, count1, distinct1, distinct2)`.
Iterate `take` from `0` to `balls[idx]`.
New count1: `count1 + take`.
New distinct1: `distinct1 + (take > 0 ? 1 : 0)`.
New distinct2: `distinct2 + ((balls[idx] - take) > 0 ? 1 : 0)`.
Ways multiplier: `combinations(balls[idx], take)`.
Base case: `idx == balls.length`. If `count1 == S/2` and `distinct1 == distinct2`, return 1.
Final Probability = `ValidWays / TotalWays`.
TotalWays = `combinations(S, S/2)`. Wait.
If balls are distinct: Total $\binom{S}{S/2}$.
But balls of same color are indistinguishable.
Actually, the definition of probability implies uniform distribution of PERMUTATIONS usually.
"Shuffle all balls... distribute first n to box 1".
This means all specific balls (even same color) are distinct in positions.
But balls of same color are indistinguishable *in output*.
Wait. The question is probability.
Total outcomes = Permutations of multiset / (n! n!).
Actually, simple:
Number of ways to choose multiset for Box 1.
For each color `i`, we choose `k` balls for Box 1.
Number of ways is product of $\binom{balls_i}{k}$. This counts ways to select specific balls if we treat them distinguishable but only care about counts?
Total ways to choose `n` balls from `2n` balls where color groups exist:
Sum over all valid $(k_1...k_m)$ such that $\sum k_i = n$:
Weight = Product $\binom{balls_i}{k_i}$.
This is correct.
Valid outcomes: those with equal distinct colors.
Calculate sum of weights for valid outcomes.
Calculate sum of weights for ALL outcomes (where $\sum k_i = n$).
Prob = Valid / Total.

### Complexity Note
State can be `dp[idx][count1][distinct_diff]`.
Diff = `d1 - d2`.
Shift diff by `k` to use array.

Tính tổng trọng số cho các kết quả hợp lệ.
Tính tổng trọng số cho TẤT CẢ các kết quả (trong đó $\sum k_i = n$).
Xác suất = Valid / Total.

---
