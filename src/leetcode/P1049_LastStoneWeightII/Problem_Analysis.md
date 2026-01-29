# 1049. Last Stone Weight II / Trọng lượng Viên đá Cuối cùng II

## Problem Description / Mô tả bài toán
You are given an array of integers `stones`.
Assume similar rules to "Last Stone Weight", but we want to minimize the weight of the last stone.
Actually, for Last Stone Weight II, we can choose ANY two stones.
Basically, we want to divide stones into two groups such that the difference of their sums is minimized.
Về cơ bản, chúng ta muốn chia các viên đá thành hai nhóm sao cho sự chênh lệch tổng của chúng là nhỏ nhất.

Minimizing `|Sum1 - Sum2|` is equivalent to Subset Sum problem.
Minimizing `TotalSum - 2 * Sum1`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming (Subset Sum) / Quy hoạch Động (Tổng tập hợp con)
We want to find a subset sum `S1` closest to `TotalSum / 2`.
This is 0/1 Knapsack.
We want max `S1` such that `S1 <= TotalSum / 2`.

Algorithm:
1. `sum = total(stones)`.
2. `target = sum / 2`.
3. `dp[j]` = boolean, true if sum `j` is possible.
4. Iterate `stone` in `stones`:
   - Iterate `j` from `target` down to `stone`:
     - `dp[j] = dp[j] || dp[j - stone]`.
5. Max `j` where `dp[j]` is true is our `S1`.
6. Result: `sum - 2 * S1`.

### Complexity / Độ phức tạp
- **Time**: O(N * Sum).
- **Space**: O(Sum).

---

## Analysis / Phân tích

### Approach: Partition Minimization
Transform the stone smashing problem into a set partitioning problem. The smallest resulting stone corresponds to the smallest difference between two subsets of stones ($|\Sigma A - \Sigma B|$). Use Dynamic Programming (Knapsack style) to find the achievable subset sum closest to half the total weight.
Chuyển đổi bài toán đập đá thành bài toán phân chia tập hợp. Viên đá kết quả nhỏ nhất tương ứng với sự khác biệt nhỏ nhất giữa hai tập hợp con của các viên đá ($|\Sigma A - \Sigma B|$). Sử dụng Quy hoạch động (kiểu Knapsack) để tìm tổng tập hợp con có thể đạt được gần nhất với một nửa tổng trọng lượng.

---
