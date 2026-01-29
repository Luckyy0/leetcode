# 334. Increasing Triplet Subsequence / Dãy Con Tăng Bộ Ba

## Problem Description / Mô tả bài toán
Given an integer array `nums`, return `true` if there exists a triple of indices `(i, j, k)` such that `i < j < k` and `nums[i] < nums[j] < nums[k]`. If no such indices exists, return `false`.
Cho một mảng số nguyên `nums`, trả về `true` nếu tồn tại bộ ba chỉ số `(i, j, k)` sao cho `i < j < k` và `nums[i] < nums[j] < nums[k]`. Nếu không, trả về `false`.

### Example 1:
```text
Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet like [1,2,3] is valid.
```

### Example 2:
```text
Input: nums = [5,4,3,2,1]
Output: false
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 5 * 10^5`
- `-2^31 <= nums[i] <= 2^31 - 1`

**Follow up**: Could you implement a solution that runs in `O(n)` time complexity and `O(1)` space complexity?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Greedy Tracking / Theo Dõi Tham Lam
We don't need to store the actual triplet, just potential candidates for the "first" and "second" elements of the triplet.
Two variables:
- `first`: The smallest number seen so far.
- `second`: The smallest number seen so far that is *greater than `first`*.
Logic:
- Iterate through `n` in `nums`.
- If `n <= first`: update `first = n`. (We found a smaller start, which is always better).
- Else If `n <= second`: update `second = n`. (We found a number > first, but smaller than current second. Better for finding third).
- Else: `n > second`. Since `second` implies there is a `first` before it, we found `first < second < n`. Return `true`.

Why updating `first` after finding `second` is safe?
Suppose we have `3, 5`. `first=3, second=5`.
Next comes `1`. `first` becomes `1`. State: `first=1, second=5`.
Does this mean we think `1` is before `5`? Yes, but `5` was established by some `old_first` (3).
If we find `6` now: `6 > second (5)`. So `old_first (3) < second (5) < 6`. Valid.
The `first` updates are just to prepare for a *future* better pair, but `second` retains the validity of an existing pair start.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Linear Scan

**Edge Cases**:
1.  Len < 3.
2.  Descending: `first` updates, `second` stays MAX.
3.  Equal: `n <= first` handles `n == first`, `n <= second` handles `n == second`. Correct.

---
