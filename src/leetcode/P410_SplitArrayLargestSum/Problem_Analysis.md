# 410. Split Array Largest Sum / Chia Mảng Theo Tổng Lớn Nhất

## Problem Description / Mô tả bài toán
Given an integer array `nums` and an integer `m`, you can split the array into `m` non-empty continuous subarrays.
Cho một mảng số nguyên `nums` và một số nguyên `m`, bạn có thể chia mảng thành `m` mảng con liên tiếp không rỗng.

Write an algorithm to minimize the largest sum among these `m` subarrays.
Hãy viết một thuật toán để thu nhỏ (minimize) giá trị tổng lớn nhất trong số `m` mảng con này.

### Example 1:
```text
Input: nums = [7,2,5,10,8], m = 2
Output: 18
Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.
```

### Example 2:
```text
Input: nums = [1,2,3,4,5], m = 2
Output: 9
```

### Example 3:
```text
Input: nums = [1,4,4], m = 3
Output: 4
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 1000`
- `0 <= nums[i] <= 10^6`
- `1 <= m <= min(50, nums.length)`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Binary Search on the Answer / Tìm kiếm nhị phân trên kết quả
This is a classic optimization problem where we want to find a threshold.
1. The possible answer (the largest sum) lies in the range `[max(nums), sum(nums)]`.
   - `low = max(nums)`: At least one subarray must contain the maximum element.
   - `high = sum(nums)`: The entire array as one subarray.
2. We can perform binary search in this range. For a target sum `mid`, we check if it's possible to partition the array into `m` or fewer subarrays where each subarray sum is at most `mid`.
3. If it's possible, `mid` is a potential answer, so we try a smaller value (`high = mid - 1`). Otherwise, we try a larger value (`low = mid + 1`).

Check function `canSplit(maxSum)`:
- Greedily group continuous elements until the sum exceeds `maxSum`.
- Count the number of subarrays needed. If the count is $\le m$, return true.

### Complexity / Độ phức tạp
- **Time**: O(N * log(Sum)) where N is the length of `nums` and Sum is the total sum of elements.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Binary Search

**Algorithm**:
1.  Calculate `max` and `sum`.
2.  Implement the binary search loop.
3.  Implement the greedy check function.

---
