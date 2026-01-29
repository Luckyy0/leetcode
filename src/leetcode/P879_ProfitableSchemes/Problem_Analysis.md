# 879. Profitable Schemes / Các Kế hoạch có Lợi nhuận

## Problem Description / Mô tả bài toán
There is a group of `n` members. There are `p` crimes. Each crime `i` requires `group[i]` members and results in `profit[i]`.
Có một nhóm gồm `n` thành viên. Có `p` tội ác. Mỗi tội ác `i` yêu cầu `group[i]` thành viên và mang lại lợi nhuận `profit[i]`.

Return the number of subsets of crimes such that:
1. Total members used $\le n$.
2. Total profit $\ge minProfit$.

Since the answer may be large, return it **modulo 10^9 + 7**.
Vì câu trả lời có thể lớn, hãy trả về kết quả theo **modulo 10^9 + 7**.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### 3D/2D Dynamic Programming (Knapsack variation) / Quy hoạch Động 3D/2D (Biến thể Knapsack)
Let `dp[i][j][k]` be the number of ways using the first `i` crimes, `j` members, and achieving at least `k` profit.
Gọi `dp[i][j][k]` là số cách sử dụng `i` tội ác đầu tiên, `j` thành viên, và đạt được ít nhất `k` lợi nhuận.

Transition:
`dp[i][j][k] = dp[i-1][j][k] + dp[i-1][j - group[i]][max(0, k - profit[i])]`.

Optimization:
We can reduce space to 2D by iterating backwards over member counts.
`dp[j][k]` = number of ways using `j` members to get at least `k` profit.

### Complexity / Độ phức tạp
- **Time**: O(Crimes * GroupLimit * minProfit).
- **Space**: O(GroupLimit * minProfit).

---

## Analysis / Phân tích

### Approach: Capacity-constrained Counting
This is a multidimensional knapsack problem where we track both a resource limit (members) and a success threshold (profit). By updating the DP table for each crime, we accumulate the total valid combinations.
Đây là một bài toán cái túi đa chiều, trong đó chúng ta theo dõi cả giới hạn về nguồn lực (thành viên) và ngưỡng thành công (lợi nhuận). Bằng cách cập nhật bảng DP cho từng tội ác, chúng ta tích lũy tổng số các tổ hợp hợp lệ.

---
