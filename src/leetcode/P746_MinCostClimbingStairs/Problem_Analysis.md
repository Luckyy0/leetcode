# 746. Min Cost Climbing Stairs / Chi phí Cực tiểu khi Leo cầu thang

## Problem Description / Mô tả bài toán
You are given an integer array `cost` where `cost[i]` is the cost of `ith` step on a staircase. Once you pay the cost, you can either climb one or two steps.
Bạn được cho một mảng số nguyên `cost` trong đó `cost[i]` là chi phí của bước thứ `i` trên một cầu thang. Sau khi bạn trả chi phí, bạn có thể leo lên một hoặc hai bước.

You can either start from the step with index 0, or the step with index 1.
Bạn có thể bắt đầu từ bước có chỉ số 0 hoặc bước có chỉ số 1.

Return the minimum cost to reach the top of the floor.
Trả về chi phí tối thiểu để đạt đến đỉnh của sàn nhà.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Quy hoạch Động
Let `dp[i]` be the minimum cost to reach step `i`.
Gọi `dp[i]` là chi phí tối thiểu để đạt đến bước `i`.

Transition:
`dp[i] = cost[i] + min(dp[i-1], dp[i-2])`

Base cases:
`dp[0] = cost[0]`
`dp[1] = cost[1]`

Final answer:
`min(dp[n-1], dp[n-2])` because the top is beyond the last index.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1) by only keeping the last two results.

---

## Analysis / Phân tích

### Approach: Iterative Cost Accumulation
Efficiently calculate the min cost by using two variables to store the costs of the two previous steps.
Tính toán chi phí tối thiểu một cách hiệu quả bằng cách sử dụng hai biến để lưu trữ chi phí của hai bước trước đó.

---
