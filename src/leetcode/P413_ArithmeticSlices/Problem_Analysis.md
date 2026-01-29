# 413. Arithmetic Slices / Các Lát Cắt Cấp Số Cộng

## Problem Description / Mô tả bài toán
An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
Một mảng số nguyên được gọi là cấp số cộng nếu nó bao gồm ít nhất ba phần tử và nếu hiệu giữa hai phần tử liên tiếp bất kỳ là giống nhau.

For example, `[1, 3, 5, 7, 9]`, `[7, 7, 7, 7]`, and `[3, -1, -5, -9]` are arithmetic sequences.
Ví dụ: `[1, 3, 5, 7, 9]`, `[7, 7, 7, 7]`, và `[3, -1, -5, -9]` là các dãy cấp số cộng.

Given an integer array `nums`, return the number of arithmetic **subarrays** of `nums`.
Cho một mảng số nguyên `nums`, hãy trả về số lượng **mảng con** là cấp số cộng của `nums`.

### Example 1:
```text
Input: nums = [1,2,3,4]
Output: 3
Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.
```

### Example 2:
```text
Input: nums = [1]
Output: 0
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 5000`
- `-1000 <= nums[i] <= 1000`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Dynamic Programming / Quy hoạch động
Let `dp[i]` be the number of arithmetic subarrays ending at index `i`.
1. An arithmetic subarray must have at least 3 elements.
2. If `nums[i] - nums[i-1] == nums[i-1] - nums[i-2]`, then we can form an arithmetic slice ending at `i`.
3. Every arithmetic slice that ended at `i-1` can be extended with `nums[i]`, plus a new base slice `[nums[i-2], nums[i-1], nums[i]]` is formed.
4. Hence, `dp[i] = dp[i-1] + 1`.
5. If the condition is not met, `dp[i] = 0`.

Total number of arithmetic slices is the sum of all `dp[i]`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1) (We only need the previous `dp` value).

---

## Analysis / Phân tích

### Approach: Constant Space DP

**Algorithm**:
1.  Initialize `sum = 0`, `current = 0`.
2.  Iterate from `i = 2` to `n - 1`.
3.  Apply formula.

---
