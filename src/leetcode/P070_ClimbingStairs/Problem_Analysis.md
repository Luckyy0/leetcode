# 70. Climbing Stairs / Leo Cầu Thang

## Problem Description / Mô tả bài toán
You are climbing a staircase. It takes `n` steps to reach the top.
Bạn đang leo một cầu thang. Phải mất `n` bước để lên đến đỉnh.

Each time you can either climb `1` or `2` steps. In how many distinct ways can you climb to the top?
Mỗi lần bạn có thể leo `1` hoặc `2` bước. Có bao nhiêu cách riêng biệt để bạn leo lên đỉnh?

### Example 1:
```text
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
```

### Example 2:
```text
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
```

## Constraints / Ràng buộc
- `1 <= n <= 45`

---

## Analysis / Phân tích

### Approach: Dynamic Programming (Fibonacci) / Quy Hoạch Động (Fibonacci)
- **Idea**: To reach step `i`, one must have come from step `i-1` (single step) or `i-2` (double step).
- **Ý tưởng**: Để đến bước `i`, người ta phải đến từ bước `i-1` (bước đơn) hoặc `i-2` (bước đôi).
- **Recurrence**: `f(n) = f(n-1) + f(n-2)`.
- **Base Cases**: `f(1) = 1`, `f(2) = 2`.
- **Space Optimization**: Similar to Fibonacci, we only need the last two values.
- **Time Complexity**: O(n).
- **Space Complexity**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **n = 1**: 1.
2.  **n = 2**: 2.
3.  **n = 45**: Max int fits? Yes, fib(45) fits in 32-bit int.
