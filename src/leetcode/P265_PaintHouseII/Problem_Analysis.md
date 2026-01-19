# 265. Paint House II / Sơn Nhà II

## Problem Description / Mô tả bài toán
There are a row of `n` houses, each house can be painted with one of the `k` colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
Có một dãy `n` ngôi nhà, mỗi ngôi nhà có thể được sơn bằng một trong `k` màu. Chi phí sơn mỗi ngôi nhà với một màu nhất định là khác nhau. Bạn phải sơn tất cả các ngôi nhà sao cho không có hai ngôi nhà liền kề nào có cùng màu.

The cost of painting each house with a certain color is represented by an `n x k` cost matrix costs.
Chi phí sơn mỗi ngôi nhà với một màu nhất định được biểu thị bằng ma trận chi phí `n x k` costs.

Return the minimum cost to paint all houses.
Trả về chi phí tối thiểu để sơn tất cả các ngôi nhà.

### Example 1:
```text
Input: costs = [[1,5,3],[2,9,4]]
Output: 5
Explanation: 
Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5; 
Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5.
```

### Example 2:
```text
Input: costs = [[1,3],[2,4]]
Output: 5
```

## Constraints / Ràng buộc
- `costs.length == n`
- `costs[i].length == k`
- `1 <= n <= 100`
- `1 <= k <= 20`
- `1 <= costs[i][j] <= 20`

**Follow up**: Could you solve it in `O(nk)` runtime?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Dynamic Programming with Optimization / Quy Hoạch Động Tối Ưu
Standard DP: `dp[i][j] = costs[i][j] + min(dp[i-1][color])` where `color != j`.
Naive finding of `min` takes `O(k)`, leading to `O(N * K^2)`.
Optimization:
- For row `i-1`, we only need the **minimum** cost (`min1`) and the **second minimum** cost (`min2`).
- If current color `j` matches the color index of `min1`, we use `min2`.
- Otherwise, we use `min1`.
This reduces the finding of optimal previous state to `O(1)` per color, total `O(N * K)`.

**Algorithm**:
1.  Initialize `min1 = 0`, `min2 = 0`, `index1 = -1` (Min values from "previous" row, initially row -1 is cost 0).
2.  Iterate `i` from `0` to `n-1`.
    - Find `m1`, `m2`, `idx1` for current row `i` (based on row `i-1` values).
    - But wait, easier logic:
        - Store `min1`, `min2`, `index1` of `dp[i-1]`.
        - For each color `j` in row `i`:
            - `cost = costs[i][j] + (j == index1 ? min2 : min1)`.
            - Tracks new `min1`, `min2`, `index1` for current row `i`.
3.  Return `min1` of the last row.

### Complexity / Độ phức tạp
- **Time**: O(N * K).
- **Space**: O(1) (In-place or constant variables).

---

## Analysis / Phân tích

### Approach: O(NK) DP

**Edge Cases**:
1.  **k=1**: Impossible if `n > 1`. (Adjacent houses same color).
    - Constraints `k >= 1`. If `k=1` and `n>1`, return what? Problem implies valid solution usually exists or constraints k>=2 usually if n>1?
    - If `k=1` and `n=1`, return cost.
    - If `k=1` and `n>1`, theoretically impossible (infinite cost). But let's check constraints. `k<=20`.
    - If valid input always guaranteed, ok. If not, handle k=1.
2.  **Empty**: 0.

---
