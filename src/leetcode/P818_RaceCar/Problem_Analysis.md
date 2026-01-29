# 818. Race Car / Đua xe

## Problem Description / Mô tả bài toán
Your car starts at position 0 with speed 1 on an infinite number line. Your car can go into negative positions.
Ô tô của bạn bắt đầu ở vị trí 0 với vận tốc 1 trên một trục số vô hạn. Ô tô có thể đi sang các vị trí âm.

At each step, your car can take one of two instructions:
- **A (Accelerate)**: `position += speed`, `speed *= 2`.
- **R (Reverse)**: If speed is positive, `speed = -1`, otherwise `speed = 1`. `position` remains the same.

Given a `target` position, return the length of the shortest sequence of instructions to get there.
Cho vị trí `target`, trả về độ dài của chuỗi hướng dẫn ngắn nhất để đến được đó.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### BFS or Dynamic Programming / BFS hoặc Quy hoạch Động
Since we need the "shortest sequence", BFS is a natural candidate. However, the state space can be large.
Vì chúng ta cần "chuỗi ngắn nhất", BFS là một ứng cử viên tự nhiên. Tuy nhiên, không gian trạng thái có thể rất lớn.

Optimized BFS:
- Limit the search range (usually `2 * target`).
- Track `(position, speed)`.

Dynamic Programming:
Let `dp[t]` be the min instructions to reach target `t`.
- To reach `t`, we can go forward `n` times to position `pos = 2^n - 1`.
- If `pos == t`, `dp[t] = n`.
- If `pos > t`, we can go past `t` and then reverse and go back: `dp[t] = min(dp[t], n + 1 + dp[pos - t])`.
- If `pos < t`, we can go forward `n` times, then reverse and go back `m` times (`m < n`), then reverse again and go forward: `dp[t] = min(dp[t], n + 1 + m + 1 + dp[t - (pos - (2^m - 1))])`.

### Complexity / Độ phức tạp
- **Time**: O(T log T).
- **Space**: O(T).

---

## Analysis / Phân tích

### Approach: Structural DP
The car's movement follows powers of 2. We use DP to calculate the shortest path to each intermediate target by considering over-shooting and under-shooting scenarios.
Chuyển động của xe tuân theo lũy thừa của 2. Chúng ta sử dụng DP để tính toán đường đi ngắn nhất đến từng mục tiêu trung gian bằng cách xem xét các kịch bản đi quá hoặc chưa đến mục tiêu.

---
