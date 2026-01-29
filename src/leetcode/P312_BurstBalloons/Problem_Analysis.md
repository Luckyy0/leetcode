# 312. Burst Balloons / Bắn Bóng Bay

## Problem Description / Mô tả bài toán
You are given `n` balloons, indexed from `0` to `n - 1`. Each balloon is painted with a number on it represented by an array `nums`. You are asked to burst all the balloons.
Bạn được cung cấp `n` quả bóng bay, được lập chỉ mục từ `0` đến `n - 1`. Mỗi quả bóng được sơn một số trên đó đại diện bởi một mảng `nums`. Bạn được yêu cầu làm nổ tất cả các quả bóng.

If you burst the `i-th` balloon, you will get `nums[i - 1] * nums[i] * nums[i + 1]` coins. If `i - 1` or `i + 1` goes out of bounds of the array, then treat it as if there is a balloon with a `1` painted on it.
Nếu bạn làm nổ quả bóng thứ `i`, bạn sẽ nhận được `nums[i - 1] * nums[i] * nums[i + 1]` xu. Nếu chỉ số nằm ngoài giới hạn, coi như có quả bóng giá trị `1`.

Return the maximum coins you can collect by bursting the balloons wisely.
Trả về số xu tối đa bạn có thể thu thập.

### Example 1:
```text
Input: nums = [3,1,5,8]
Output: 167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 15 + 120 + 24 + 8 = 167
```

### Example 2:
```text
Input: nums = [1,5]
Output: 10
```

## Constraints / Ràng buộc
- `n == nums.length`
- `1 <= n <= 300`
- `0 <= nums[i] <= 100`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Interval DP / Quy Hoạch Động Trên Khoảng
Consider the **Last Balloon** to burst.
Suppose in range `(i, j)`, the balloon `k` (where `i < k < j`) is the LAST ONE to burst.
Since it's the last one, at the moment of bursting `k`, the balloons adjacent to it are `i` and `j` (which are outside the range and haven't been burst yet - or rather, `i` and `j` bound the subproblem, effectively adjacent to `k` after everything between `i` and `k` and `k` and `j` is gone).

Transition:
`dp[i][j]` = max coins from `(i, j)` exclusive.
`dp[i][j] = max(dp[i][k] + dp[k][j] + nums[i] * nums[k] * nums[j])` for all `k` in `(i, j)`.
(Note: `nums` is augmented with 1 at Start and End).

Base cases: `dp[i][i+1] = 0` (No balloons between adjacent indices).

**Algorithm**:
1.  Augment `nums` with `[1, ...nums..., 1]`. New length `N+2`.
2.  `dp[N+2][N+2]`.
3.  Iterate `length` from 2 to N+1 (distance between i and j).
4.  Iterate `start` i. `end` j = i + len.
5.  Iterate `k` from `i+1` to `j-1`.
6.  Update `dp[i][j]`.
7.  Result `dp[0][N+1]`.

### Complexity / Độ phức tạp
- **Time**: O(N^3). N=300 -> 27*10^6, manageable.
- **Space**: O(N^2).

---

## Analysis / Phân tích

### Approach: Interval DP

**Edge Cases**:
1.  `n=1`.
2.  Zeros in nums? Allowed (`0 <= nums[i]`).

---
