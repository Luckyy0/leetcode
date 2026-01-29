# 1498. Number of Subsequences That Satisfy the Given Sum Condition / Số lượng Chuỗi con Thỏa mãn Điều kiện Tổng đã cho

## Problem Description / Mô tả bài toán
Array `nums`, integer `target`.
Subsequence such that `min + max <= target`.
Count modulo 10^9 + 7.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sorting + Two Pointers
Subsequence elements don't need to be contiguous or ordered.
Sort `nums`.
For sorted array, pick `left` (min) and `right` (max).
If `nums[left] + nums[right] <= target`:
All subsequences using `left` and ANY subset of `nums[left+1 ... right]` are valid.
Number of such subsequences: $2^{right - left}$. (Fix `left`, choose any from `right - left` elements).
Wait. "Any subset"?
We MUST include `min` (which is `nums[left]`). `max` can be `nums[right]` OR smaller.
Actually, if we fix `min` at `left` and `max` at `right`, we have valid range.
If `nums[left] + nums[right] <= target`, then `nums[left] + nums[any index <= right]` is also `<= target` (since sorted).
So if we fix `nums[left]` as the minimum element, the maximum element can be any element from index `left` to `right`.
Wait. Let's rephrase.
We want any subsequence where min+max <= target.
Sort `nums`. Use two pointers `left` and `right`.
If `nums[left] + nums[right] > target`:
  `right--`. (Max is too big, cannot be part of any valid subsequence with `nums[left]`).
If `nums[left] + nums[right] <= target`:
  Any subsequence starting with `nums[left]` and containing elements from `nums[left+1...right]` is valid.
  The minimum is guaranteed to be `nums[left]` (since sorted).
  The maximum will be <= `nums[right]`.
  So `nums[left]` + ANY other max <= target.
  BUT we specifically want to count subsequences where `nums[left]` IS the minimum.
  How many such subsequences?
  We MUST choose `nums[left]`. And we can choose ANY subset of `nums[left+1...right]`.
  Total ways = $2^{right - left}$. Make sure `nums[left]` is in it.
  Add $2^{right - left}$ to count.
  Increment `left`.
Wait, does this double count?
Iteration 1: left=0. Valid range 0..R. Count $2^{R-0}$. These are subsequences with min at index 0.
Iteration 2: left=1. Valid range 1..R (maybe smaller R). Count $2^{R-1}$. These are subsequences with min at index 1.
Since min index is unique property (leftmost element in subsequence), no double counting.
Correct.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(N) for powers.

---

## Analysis / Phân tích

### Approach: Sort + Two Pointers + Precompute Powers
1. Sort `nums`.
2. Precompute powers of 2.
3. `left = 0`, `right = n-1`.
4. While `left <= right`:
   If sum <= target:
     `res += pow[right - left]`.
     `left++`.
   Else:
     `right--`.

---
