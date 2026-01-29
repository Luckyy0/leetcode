# 446. Arithmetic Slices II - Subsequence / Các Lát Cắt Cấp Số Cộng II - Dãy Con

## Problem Description / Mô tả bài toán
Given an integer array `nums`, return the number of all the **arithmetic subsequences** of `nums`.
Cho một mảng số nguyên `nums`, hãy trả về số lượng tất cả các **dãy con cấp số cộng** của `nums`.

A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
Một dãy số được gọi là cấp số cộng nếu nó bao gồm ít nhất ba phần tử và nếu hiệu giữa hai phần tử liên tiếp bất kỳ là giống nhau.

A **subsequence** of an array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements.
Một **dãy con** của một mảng là một dãy có thể được rút ra từ mảng đó bằng cách xóa một số hoặc không xóa phần tử nào mà không làm thay đổi thứ tự của các phần tử còn lại.

### Example 1:
```text
Input: nums = [2,4,6,8,10]
Output: 7
Explanation: All arithmetic subsequences are:
[2,4,6], [4,6,8], [6,8,10], [2,4,6,8], [4,6,8,10], [2,4,6,8,10], [2,6,10]
```

### Example 2:
```text
Input: nums = [7,7,7,7,7]
Output: 16
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 1000`
- `-2^31 <= nums[i] <= 2^31 - 1`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Dynamic Programming with HashMap / Quy hoạch động với HashMap
This is a more complex version of Arithmetic Slices (which was only for contiguous subarrays). Here we look for subsequences.
Let `dp[i]` be a map where `dp[i][diff]` is the number of arithmetic subsequences ending at index `i` with common difference `diff` and length $\ge 2$.

Algorithm:
1. Initialize `total_count = 0`.
2. Initialize an array of maps `dp` where `dp[i]` is `Map<Long, Integer>`.
3. Iterate `i` from 0 to $n-1$:
   - Iterate `j` from 0 to $i-1$:
     - Calculate `diff = (long)nums[i] - (long)nums[j]`.
     - Get `count_at_j = dp[j].getOrDefault(diff, 0)`.
     - The number of arithmetic subsequences of length $\ge 3$ formed by adding `nums[i]` to existing subsequences ending at `j` with difference `diff` is `count_at_j`.
     - Add `count_at_j` to `total_count`.
     - Update `dp[i]`: `dp[i][diff] += count_at_j + 1`. The `+ 1` represents the pair `(nums[j], nums[i])`, which has length 2.
4. Return `total_count`.

### Complexity / Độ phức tạp
- **Time**: O(N^2) because of the nested loops.
- **Space**: O(N^2) to store the maps.

---

## Analysis / Phân tích

### Approach: Map-Based DP for Each Difference

**Algorithm**:
1.  Iterate and compute diff.
2.  Store cumulative counts in DP maps.
3.  Be careful with integer overflow for differences.

---
