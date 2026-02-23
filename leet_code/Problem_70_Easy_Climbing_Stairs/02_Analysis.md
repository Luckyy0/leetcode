# Analysis for Climbing Stairs
# *Phân tích cho bài toán Leo Cầu Thang*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Integer `n` (steps). *Số nguyên `n` (số bước).*
*   **Output:** Number of ways to reach the top. *Số cách để lên đến đỉnh.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `n` up to 45.
*   *`n` lên tới 45.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Dynamic Programming (Fibonacci)
### *Hướng tiếp cận: Quy Hoạch Động (Fibonacci)*

*   **Intuition:** To reach step `n`, you could have come from step `n-1` (by taking 1 step) or from step `n-2` (by taking 2 steps).
*   *Ý tưởng: Để đạt đến bậc `n`, bạn có thể đi từ bậc `n-1` (bằng cách thực hiện 1 bước) hoặc từ bậc `n-2` (bằng cách thực hiện 2 bước).*

*   **Recurrence Relation:** `dp[n] = dp[n-1] + dp[n-2]`.
*   *Công thức truy hồi: `dp[n] = dp[n-1] + dp[n-2]`.*

*   **Algorithm Steps:**
    1.  Handle `n <= 2`: return `n`.
    2.  `first = 1`, `second = 2`.
    3.  Loop from `i = 3` up to `n`:
        *   `third = first + second`.
        *   `first = second`.
        *   `second = third`.
    4.  Return `second`.

*   **Complexity:**
    *   Time: $O(N)$.
    *   Space: $O(1)$.

### Dry Run
### *Chạy thử*
`n = 4`
1. `n = 1`: 1 way.
2. `n = 2`: 2 ways.
3. `n = 3`: `1 + 2 = 3` ways.
4. `n = 4`: `2 + 3 = 5` ways.
Result: 5.
---
*Bài toán này thực chất là tính số Fibonacci thứ n.*
This problem is essentially calculating the n-th Fibonacci number.
