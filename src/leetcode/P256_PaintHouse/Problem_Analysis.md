# 256. Paint House / Sơn Nhà

## Problem Description / Mô tả bài toán
There is a row of `n` houses, where each house can be painted one of three colors: red, blue, or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
Có một dãy `n` ngôi nhà, trong đó mỗi ngôi nhà có thể được sơn một trong ba màu: đỏ, xanh lam hoặc xanh lục. Chi phí sơn mỗi ngôi nhà với một màu nhất định là khác nhau. Bạn phải sơn tất cả các ngôi nhà sao cho không có hai ngôi nhà liền kề nào có cùng màu.

The cost of painting each house with a certain color is represented by an `n x 3` cost matrix `costs`.
- `costs[i][0]` is the cost of painting house `i` red.
- `costs[i][1]` is the cost of painting house `i` green.
- `costs[i][2]` is the cost of painting house `i` blue.

Return the minimum cost to paint all houses.
Trả về chi phí tối thiểu để sơn tất cả các ngôi nhà.

### Example 1:
```text
Input: costs = [[17,2,17],[16,16,5],[14,3,19]]
Output: 10
Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue. 
Minimum cost: 2 + 5 + 3 = 10.
Wait, let's recheck colors: red(0), green(1), blue(2).
House 0: Blue(2) -> cost 17 (wait, example indices confused? Cost array says col 2 is 17). 
Let's follow array: [17, 2, 17]. Min is 2 (index 1, Green).
House 1: [16, 16, 5]. If H0 is Green, H1 cannot be Green. Options: Red(16), Blue(5). Min is 5 (Blue).
House 2: [14, 3, 19]. if H1 is Blue, H2 cannot be Blue. Options: Red(14), Green(3). Min is 3 (Green).
Total: 2 + 5 + 3 = 10. Correct.
```

### Example 2:
```text
Input: costs = [[7,6,2]]
Output: 2
```

## Constraints / Ràng buộc
- `costs.length == n`
- `costs[i].length == 3`
- `1 <= n <= 100`
- `1 <= costs[i][j] <= 20`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Dynamic Programming / Quy Hoạch Động
Let `dp[i][color]` be the min cost to paint houses `0` to `i`, with house `i` painted `color`.
- `dp[i][0] = costs[i][0] + min(dp[i-1][1], dp[i-1][2])`
- `dp[i][1] = costs[i][1] + min(dp[i-1][0], dp[i-1][2])`
- `dp[i][2] = costs[i][2] + min(dp[i-1][0], dp[i-1][1])`

Base case: `dp[0][j] = costs[0][j]`.

**Optimization**:
We only need the previous row `i-1`. So we can use O(1) space variables or modify input array in-place.

---

## Analysis / Phân tích

### Approach: DP (In-place or constant space)

**Algorithm**:
1.  Iterate `i` from `1` to `n-1`.
2.  Update `costs[i][0] += min(costs[i-1][1], costs[i-1][2])`.
3.  Update `costs[i][1] += min(costs[i-1][0], costs[i-1][2])`.
4.  Update `costs[i][2] += min(costs[i-1][0], costs[i-1][1])`.
5.  Return `min(costs[n-1][0], costs[n-1][1], costs[n-1][2])`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1) (In-place).

---

## Edge Cases / Các trường hợp biên
1.  **Empty**: 0.
2.  **One house**: Min of row 0.
