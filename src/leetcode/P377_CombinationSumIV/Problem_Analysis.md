# 377. Combination Sum IV / Tổng Tổ Hợp IV

## Problem Description / Mô tả bài toán
Given an array of **distinct** integers `nums` and a target integer `target`, return the number of possible combinations that add up to `target`.
Cho một mảng các số nguyên **khác nhau** `nums` và một số nguyên `target`, trả về số lượng tổ hợp có thể có tổng bằng `target`.

The test cases are generated so that the answer can fit in a 32-bit integer.

### Example 1:
```text
Input: nums = [1,2,3], target = 4
Output: 7
Explanation:
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations. (Permutations matter).
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 200`
- `1 <= nums[i] <= 1000`
- All the elements of `nums` are **unique**.
- `1 <= target <= 1000`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Dynamic Programming (Unbounded Knapsack-ish) / Quy Hoạch Động
We want ordered combinations (permutations).
`dp[i]` = Number of ways to get sum `i`.
Recurrence: `dp[i] = sum(dp[i - num])` for every `num` in `nums`.
Base Case: `dp[0] = 1`.
Order of loops:
Since order matters `(1, 2)` != `(2, 1)`, we iterate `target` first, then `nums`.
- For `i` from 1 to `target`:
  - For `num` in `nums`:
    - if `i >= num`: `dp[i] += dp[i - num]`.

Example: nums=[1,2], target=3.
dp[0]=1.
i=1: num=1 -> dp[1]+=dp[0]=1. num=2 skip. dp[1]=1. (Ways: {1})
i=2: num=1 -> dp[2]+=dp[1]=1. num=2 -> dp[2]+=dp[0]=1. dp[2]=2. (Ways: {1,1}, {2})
i=3: num=1 -> dp[3]+=dp[2]=2. num=2 -> dp[3]+=dp[1]=1. dp[3]=3. (Ways: {1,1,1}, {2,1}, {1,2}).

### Complexity / Độ phức tạp
- **Time**: O(target * N).
- **Space**: O(target).

---

## Analysis / Phân tích

### Approach: DP

**Algorithm**:
1.  `dp` array size `target + 1`.
2.  `dp[0] = 1`.
3.  Loop `i` 1 to `target`.
    - Inner loop `num` in `nums`.
    - If `i >= num`, add.

---
