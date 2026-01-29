# 1000. Minimum Cost to Merge Stones / Chi phí Tối thiểu để Gộp đá

## Problem Description / Mô tả bài toán
There are `n` piles of stones. In one move, you can merge `k` **consecutive** piles into one.
Có `n` đống đá. Trong mỗi bước, bạn có thể gộp `k` đống đá **liên tiếp** thành một đống.

The cost of a move is the sum of the stones in the `k` piles. Return the minimum cost to merge all piles into one. If impossible, return -1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Interval Dynamic Programming / Quy hoạch Động Khoảng
This is a standard interval DP problem.
Đây là một bài toán quy hoạch động khoảng tiêu chuẩn.

Condition:
Total stone reduction per move is `k - 1`. Total reduction needed is `n - 1`.
`n - 1` must be divisible by `k - 1`.
Mỗi bước làm giảm số đống đá đi cộng thêm `k - 1`. Tổng số đống cần giảm là `n - 1`. Vậy `n - 1` phải chia hết cho `k - 1`.

Algorithm:
1. `dp[i][j][m]` = min cost to merge `stones[i...j]` into `m` piles.
2. `dp[i][j][m] = min(dp[i][mid][1] + dp[mid+1][j][m-1])`.
3. If `m == 1`:
   `dp[i][j][1] = dp[i][j][k] + sum(i...j)`.

### Complexity / Độ phức tạp
- **Time**: O(N^3 * K). Optimized: O(N^3 / K).
- **Space**: O(N^2 * K) or O(N^2).

---

## Analysis / Phân tích

### Approach: Recursive Composition with Aggregated Costs
Evaluate every possible sub-range and how it can be condensed into smaller subsets of piles. By tracking the exact state of pile reduction ($M$) within each interval, we systematically combine results until the entire array is collapsed into a single pile, accumulating stone sums along the way.
Đánh giá mọi phạm vi phụ có thể có và cách nó có thể được cô đặc thành các tập hợp đống đá nhỏ hơn. Bằng cách theo dõi trạng thái chính xác việc giảm số đống đá ($M$) trong mỗi khoảng, chúng ta kết hợp các kết quả một cách có hệ thống cho đến khi toàn bộ mảng được thu gọn thành một đống duy nhất, đồng thời tích lũy tổng số đá trong quá trình đó.

---
