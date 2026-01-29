# 1388. Pizza With 3n Slices / Pizza Với 3n Lát

## Problem Description / Mô tả bài toán
Circular pizza with `3n` slices.
You pick one, Alice picks next (clockwise), Bob picks next (counter-clockwise?).
Rule: You pick index `i`, neighbors `i-1` and `i+1` are taken.
Repeat `n` times. (You get `n` slices).
Maximize sum.
Equivalent to: Select `n` non-adjacent slices from `3n` circular array.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming (House Robber II variant)
Circular restriction: Can't pick both first and last.
Problem reduces to: Select `k = n` non-adjacent elements from array of size `m = 3n`.
Two cases (break circle):
1. Consider range `0` to `m-2` (exclude last).
2. Consider range `1` to `m-1` (exclude first).
Take max.
Subproblem: Select `k` non-adjacent from linear array `arr`.
`dp[i][j]` = max sum using `j` items from first `i` elements.
Transition:
- Don't pick `arr[i]`: `dp[i-1][j]`.
- Pick `arr[i]`: `dp[i-2][j-1] + arr[i]`.
Space Optimization possible.

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(N^2) or O(N).

---

## Analysis / Phân tích

### Approach: 2D DP on Linear Segments
Since it's circular, we solve two linear problems:
1. Try to pick `n` slices from `slices[0...3n-2]`.
2. Try to pick `n` slices from `slices[1...3n-1]`.
The max of these two is the answer.
Linear DP function `solve(array, k)`:
`dp[i][count]` represents max sum picking `count` slices from first `i` slices.
Transition: `dp[i][c] = max(dp[i-1][c], dp[i-2][c-1] + arr[i])`.
Return `dp[len][k]`.
Vì nó là vòng tròn, chúng ta giải quyết hai bài toán tuyến tính:
1. Cố gắng chọn `n` lát từ `slices[0...3n-2]`.
2. Cố gắng chọn `n` lát từ `slices[1...3n-1]`.
Giá trị tối đa của hai trường hợp này là câu trả lời.
Hàm DP tuyến tính `solve(array, k)`:
`dp[i][count]` đại diện cho tổng tối đa khi chọn `count` lát từ `i` lát đầu tiên.
Chuyển đổi: `dp[i][c] = max(dp[i-1][c], dp[i-2][c-1] + arr[i])`.
Trả về `dp[len][k]`.

---
