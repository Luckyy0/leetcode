# 644. Maximum Average Subarray II / Mảng Con Trung Bình Lớn Nhất II

## Problem Description / Mô tả bài toán
You are given an integer array `nums` consisting of `n` elements, and an integer `k`.
Bạn được cho một mảng số nguyên `nums` bao gồm `n` phần tử và một số nguyên `k`.

Find a contiguous subarray whose **length is greater than or equal to** `k` that has the maximum average value, and return this value. Any answer with a calculation error less than `10^-5` will be accepted.
Tìm một mảng con liên tiếp có **độ dài lớn hơn hoặc bằng** `k` có giá trị trung bình lớn nhất và trả về giá trị này. Bất kỳ câu trả lời nào có sai số tính toán nhỏ hơn `10^-5` sẽ được chấp nhận.

### Example 1:
```text
Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation:
Length 4: (12-5-6+50)/4 = 12.75
Length 5: (1+12-5-6+50)/5 = 10.4
Length 6: ...
Max is 12.75.
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Binary Search on Answer / Tìm Kiếm Nhị Phân Trên Câu Trả Lời
The max average must be between `min(nums)` and `max(nums)`.
Function `check(avg)`: Is there a subarray of length >= `k` with average >= `avg`?
Average >= `avg` => `Sum(nums[i]...nums[j]) / (j-i+1) >= avg`
=> `Sum(nums[i]...nums[j]) >= avg * (j-i+1)`
=> `Sum((nums[x] - avg)) >= 0` for `x` in range.
Let `b[x] = nums[x] - avg`. We need to find subarray sum of `b` >= 0 with length >= `k`.
This can be done in O(N):
Iterate `i` from 0 to N. Calculate `prefix_sum[i]` of `b`.
We need `prefix_sum[j] - prefix_sum[i] >= 0` where `j - i >= k` (so `i <= j - k`).
Maintain minimum `prefix_sum` for indices `0` to `j - k`.
If `prefix_sum[j] - min_prefix_sum >= 0`, return true.

Binary Search range `[min, max]`. Iterate e.g. 100 times or until error < epsilon.

### Complexity / Độ phức tạp
- **Time**: O(N * log((Max-Min)/epsilon)).
- **Space**: O(1) or O(N) for temp array.

---

## Analysis / Phân tích

### Approach: Binary Search on Average

**Algorithm**:
1.  Define boundaries for binary search.
2.  Implement validation function `check(mid)`:
    - Transform array by subtracting `mid`.
    - Check if max subarray sum with length >= k is non-negative.
3.  Narrow range.

---
