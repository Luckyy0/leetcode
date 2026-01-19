# 276. Paint Fence / Sơn Hàng Rào

## Problem Description / Mô tả bài toán
You are painting a fence of `n` posts with `k` different colors. You must paint the posts following these rules:
Bạn đang sơn một hàng rào gồm `n` cột với `k` màu khác nhau. Bạn phải sơn các cột theo các quy tắc sau:

- Every post must be painted exactly one color.
- There cannot be three or more consecutive posts with the same color.
- Không thể có ba hoặc nhiều cột liên tiếp có cùng một màu.

Given the two integers `n` and `k`, return the number of ways you can paint the fence.
Cho hai số nguyên `n` và `k`, hãy trả về số cách bạn có thể sơn hàng rào.

### Example 1:
```text
Input: n = 3, k = 2
Output: 6
Explanation: All the possibilities are shown.
Note: n=3, k=2 (colors 0, 1).
Valid: 
0, 1, 0
0, 1, 1 (2 consecutive ok)
1, 0, 1
1, 0, 0
0, 0, 1
1, 1, 0
Invalid (3 consecutive): 0,0,0 and 1,1,1.
Total ways 2^3 = 8. Invalid = 2. Valid = 6.
```

### Example 2:
```text
Input: n = 1, k = 1
Output: 1
```

### Example 3:
```text
Input: n = 7, k = 2
Output: 42
```

## Constraints / Ràng buộc
- `1 <= n <= 50`
- `1 <= k <= 10^5`
- The testcases are generated such that the answer is in the range of a 32-bit signed integer.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Dynamic Programming / Quy Hoạch Động
Let `W(n)` be the number of ways to paint `n` posts.
We can define state based on whether the last two posts have the same color or different colors.
- `Same(i)`: Number of ways to paint `i` posts such that post `i` and `i-1` have the **same** color.
- `Diff(i)`: Number of ways to paint `i` posts such that post `i` and `i-1` have **different** colors.

Transitions:
- To form `Same(i)`, post `i` must match post `i-1`.
    - This is only allowed if `i-1` and `i-2` were DIFFERENT. (If `Same(i-1)` was true, adding another same color makes 3 consecutive).
    - So, `Same(i) = Diff(i-1)`. (Choosing color of `i` is fixed to color of `i-1` -> 1 choice).
- To form `Diff(i)`, post `i` must be different from `i-1`.
    - Previous state could be `Same(i-1)` OR `Diff(i-1)`.
    - Color of `i` has `k-1` choices.
    - So, `Diff(i) = (Same(i-1) + Diff(i-1)) * (k - 1)`.

Total ways `Total(i) = Same(i) + Diff(i)`.
Substitute:
`Total(i) = Diff(i-1) + (Total(i-1)) * (k - 1)`.
Wait, `Diff(i-1) = Same(i-2) * (k-1) + Diff(i-2) * (k-1) = Total(i-2) * (k-1)`.
So `Same(i) = Total(i-2) * (k-1)`.
`Diff(i) = Total(i-1) * (k-1)`.
`Total(i) = (Total(i-1) + Total(i-2)) * (k - 1)`.

Base Cases:
- `n=1`: `k` ways.
- `n=2`:
    - Same: `k * 1` (00, 11...) -> `k`.
    - Diff: `k * (k-1)`.
    - Total: `k + k^2 - k = k^2`. (Makes sense, any 2 colors allowed).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1) (Only tracking last 2 totals).

---

## Analysis / Phân tích

### Approach: Optimized DP

**Algorithm**:
1.  If `n=1`: return `k`.
2.  If `n=2`: return `k*k`.
3.  `prev2 = k`, `prev1 = k*k`.
4.  Loop `3` to `n`:
    - `cur = (prev1 + prev2) * (k - 1)`.
    - `prev2 = prev1`, `prev1 = cur`.
5.  Return `prev1`.

---

## Edge Cases / Các trường hợp biên
1.  **n=1**: k.
2.  **k=1**:
    - n=1 -> 1.
    - n=2 -> 1.
    - n=3 -> (1+1)*0 = 0. Correct (1,1,1 disallowed).
