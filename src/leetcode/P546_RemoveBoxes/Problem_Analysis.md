# 546. Remove Boxes / Xóa Các Hộp

## Problem Description / Mô tả bài toán
You are given several `boxes` with different colors represented by different positive integers.
Bạn được cho một số `hộp` với các màu khác nhau được biểu thị bằng các số nguyên dương khác nhau.

You may experience several rounds to remove boxes until there is no box left. Each time you can choose some continuous boxes with the same color (i.e., composed of `k` boxes, `k >= 1`), remove them and get `k * k` points.
Bạn có thể trải qua nhiều vòng để xóa các hộp cho đến khi không còn hộp nào. Mỗi lần bạn có thể chọn một số hộp liên tiếp có cùng màu (tức là bao gồm `k` hộp, `k >= 1`), xóa chúng và nhận được `k * k` điểm.

Return the maximum points you can get.
Hãy trả về số điểm tối đa bạn có thể nhận được.

### Example 1:
```text
Input: boxes = [1,3,2,2,2,3,4,3,1]
Output: 23
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming with Memoization / Quy hoạch động với Ghi nhớ
This is a complex interval DP problem. Reducing the array changes indices, so standard `dp[i][j]` is not enough. We need to carry information about matching boxes that might be appended from the right.

State definition:
`dp(i, j, k)`: Max points for subarray `boxes[i...j]` given that there are `k` boxes of the same color as `boxes[i]` attached to the left of index `i`.
Wait, usually the "attached" part is traditionally handled as attached to the **right** of `boxes[j]`.
Let's use: `dp(i, j, k)` is max points for `boxes[i...j]` followed by `k` boxes of color `boxes[j]`.

Transitions:
Option 1: Remove the `k+1` boxes of color `boxes[j]` (the `j`-th box plus `k` following ones).
   - Points = `(k + 1)^2 + dp(i, j-1, 0)`.
Option 2: Don't remove `boxes[j]` immediately, but merge it with some `boxes[p]` (where `i <= p < j` and `boxes[p] == boxes[j]`).
   - This means we clear out the boxes between `p` and `j` first.
   - Points = `dp(i, p, k+1) + dp(p+1, j-1, 0)`.

### Complexity / Độ phức tạp
- **Time**: O(N^4). Can be optimized to O(N^3) by skipping non-matching elements.
- **Space**: O(N^3).

---

## Analysis / Phân tích

### Approach: 3D Memoization DP

**Algorithm**:
1.  Define state: `dp[i][j][k]`, calculating max score for interval `[i, j]` with `k` trailing matching boxes.
2.  Base case: `i > j` returns 0.
3.  Optimization: Skip identical boxes to consolidate `k`.
4.  Option 1: Remove trailing group.
5.  Option 2: Merge trailing group with internal matching box (split interval).

---
