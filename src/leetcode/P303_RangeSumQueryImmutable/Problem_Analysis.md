# 303. Range Sum Query - Immutable / Truy Vấn Tổng Phạm Vi - Bất Biến

## Problem Description / Mô tả bài toán
Given an integer array `nums`, handle multiple queries of the following type:
- Calculate the **sum** of the elements of `nums` between indices `left` and `right` inclusive where `left <= right`.
Cho một mảng số nguyên `nums`, xử lý nhiều truy vấn thuộc loại sau:
- Tính **tổng** các phần tử của `nums` giữa các chỉ số `left` và `right` bao gồm ở hai đầu, trong đó `left <= right`.

Implement the `NumArray` class:
- `NumArray(int[] nums)` Initializes the object with the integer array `nums`.
- `int sumRange(int left, int right)` Returns the sum of the elements of `nums` between indices `left` and `right` inclusive (i.e. `nums[left] + nums[left + 1] + ... + nums[right]`).

### Example 1:
```text
Input
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
Output
[null, 1, -1, -3]

Explanation
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 10^4`
- `-10^5 <= nums[i] <= 10^5`
- `0 <= left <= right < nums.length`
- At most `10^4` calls will be made to `sumRange`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Prefix Sum / Tổng Tiền Tố
To answer range sum queries efficiently (O(1)), we can precompute prefix sums.
Let `prefix[i]` be the sum of `nums[0...i-1]`.
Then `sumRange(i, j) = prefix[j+1] - prefix[i]`.
Note: `prefix` array typically has size `n+1` where `prefix[0] = 0`.
`prefix[k] = sum(nums[0...k-1])`.
`sum(left...right) = sum(0...right) - sum(0...left-1)`.
`sum(0...right) = prefix[right+1]`.
`sum(0...left-1) = prefix[left]`.
So `sumRange(left, right) = prefix[right+1] - prefix[left]`.

### Complexity / Độ phức tạp
- **Time**: O(N) Initialization, O(1) per Query.
- **Space**: O(N) for prefix array.

---

## Analysis / Phân tích

### Approach: Prefix Sum Array

**Algorithm**:
1.  Constructor: Build `preSums` array of size `n+1`.
    `preSums[0] = 0`.
    `preSums[i+1] = preSums[i] + nums[i]`.
2.  Query: `preSums[right+1] - preSums[left]`.

---
