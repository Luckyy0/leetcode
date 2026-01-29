# 1494. Parallel Courses II / Các Khóa học Song song II

## Problem Description / Mô tả bài toán
N courses. Dependencies `relations`.
Max `k` courses per semester.
Min semesters to complete all.
Constraint: N <= 15.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Bitmask Dynamic Programming
Since N is very small (15), use bitmask to represent completed courses.
`dp[mask]`: Min semesters to reach state `mask` (completed).
Initialize `dp[0] = 0`, others Infinity.
Iterate through masks `m` from 0 to `2^n - 1`.
If `dp[m]` is reachable:
1. Identify courses available to take next (dependencies met in `m`, and not in `m`).
2. If available count <= k, take all. New state `m | available`.
3. If available count > k, must choose subset of size k.
   - Iterate all subsets (combinations) of size k.
   - For each subset, update `dp[m | subset]`.
Subsets iteration: use recursion or Gosper's hack?
Recursion/Backtracking for submask selection is fine.

### Optimization
Iterating all submasks is slow.
Is there a greedy choice? No, sometimes taking enabling courses is better.
But since N=15, simple bitmask DP is borderline?
$2^{15} = 32768$.
For each mask, iterate submasks of size k. $\binom{available}{k}$. Max $\binom{15}{7} = 6435$.
Total complexity $2^N \cdot \binom{N}{N/2}$.
$32000 \times 6000$ approx $2 \times 10^8$. Might be TLE if Java is slow.
BUT "available" is usually small.
And we can optimize: Iterate masks by number of set bits (semesters). Layers.

### Complexity / Độ phức tạp
- **Time**: O(2^N * C(N, K)).
- **Space**: O(2^N).

---

## Analysis / Phân tích

### Approach: BFS with Bitmask / DP
Precompute `prereq[i]` as mask.
`dp[mask]` stores min semesters.
Iterate `mask` from 0 to `1<<n - 1`.
Calculate `available_mask`: nodes `i` not in `mask` s.t. `(prereq[i] & mask) == prereq[i]`.
Count available nodes.
If count <= k: take all. `dp[mask | available] = min(..., dp[mask] + 1)`.
If count > k: need to iterate submasks of `available` with size `k`.
Function `iterate(submask, k, mask)` recursively.
Optimization: Iterate valid masks reachable by step? BFS would be better (min steps).
BFS Queue: `{mask}`.
Level 0: `{0}`.
Level 1: all next masks.
First time reaching `(1<<n)-1` return level.

### Optimizing Submask Iteration
Iterating all submasks of size k from `available` allows finding optimal dependency unlock.
Tiền xử lý `prereq[i]` dưới dạng mask.
`dp[mask]` lưu trữ số học kỳ tối thiểu.
Sử dụng BFS để tìm số bước ngắn nhất.
Trong mỗi bước, xác định các nút khả dụng. Nếu > k, lặp qua tất cả các tổ hợp con kích thước k.

---
