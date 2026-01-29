# 325. Maximum Size Subarray Sum Equals k / Kích Thước Mảng Con Lớn Nhất Có Tổng Bằng k

## Problem Description / Mô tả bài toán
Given an integer array `nums` and an integer `k`, return the maximum length of a subarray that sums to `k`. If there is not one, return `0` instead.
Cho một mảng số nguyên `nums` và một số nguyên `k`, trả về độ dài lớn nhất của một mảng con có tổng bằng `k`. Nếu không có, trả về `0`.

### Example 1:
```text
Input: nums = [1,-1,5,-2,3], k = 3
Output: 4
Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
```

### Example 2:
```text
Input: nums = [-2,-1,2,1], k = 1
Output: 2
Explanation: The subarray [-1, 2] sums to 1 and is the longest.
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 2 * 10^5`
- `-10^4 <= nums[i] <= 10^4`
- `-10^9 <= k <= 10^9`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Prefix Sum + HashMap / Tổng Tiền Tố + HashMap
We want `sum(i, j) = k`.
`prefix[j] - prefix[i-1] = k` -> `prefix[i-1] = prefix[j] - k`.
We iterate `j`. `currentSum = prefix[j]`.
We look for `target = currentSum - k` in our map.
Map stores `(sum, first_index_of_sum)`. We store first index because we want maximum length (farthest distance).
If `target` exists in map at `idx`: `len = j - idx`. Update max.
If `currentSum` not in map, put `(currentSum, j)`. (Don't update if exists, to keep earliest index).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: HashMap

**Edge Cases**:
1.  Subarray starting at 0: `prefix[j] == k`. Equivalent to `prefix[-1] = 0`. Initialize Map `{0: -1}`.

---
