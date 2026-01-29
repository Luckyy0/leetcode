# 462. Minimum Moves to Equal Array Elements II / Số Lượng Di Chuyển Tối Thiểu Để Làm Bằng Các Phần Tử Mảng II

## Problem Description / Mô tả bài toán
Given an integer array `nums` of size `n`, return the minimum number of moves required to make all array elements equal.
Cho một mảng số nguyên `nums` có kích thước `n`, hãy trả về số lượng di chuyển tối thiểu cần thiết để làm cho tất cả các phần tử trong mảng bằng nhau.

In one move, you can increment or decrement an element of the array by `1`.
Trong một lần di chuyển, bạn có thể tăng hoặc giảm một phần tử của mảng lên `1` đơn vị.

### Example 1:
```text
Input: nums = [1,2,3]
Output: 2
Explanation:
Only two moves are needed (remember each move increments or decrements one element):
[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
```

### Example 2:
```text
Input: nums = [1,10,2,9]
Output: 16
```

## Constraints / Ràng buộc
- `n == nums.length`
- `1 <= nums.length <= 10^5`
- `-10^9 <= nums[i] <= 10^9`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Median Strategy / Chiến lược Trung vị
To minimize the sum of absolute differences `|nums[i] - x|`, the value `x` should be the **median** of the array.
If we increase or decrease all elements to a common value `x`, the total cost is `Sum(|nums[i] - x|)`.

Algorithm:
1. Sort the array.
2. Find the median: `median = nums[n / 2]`.
3. Calculate the sum of absolute differences between each element and the median.
4. Return the total sum.

Alternative (Two Pointers after sorting):
- The sum of distances to the median is equivalent to `Sum(nums[n-1-i] - nums[i])` for `i` from 0 to `n/2`.

### Complexity / Độ phức tạp
- **Time**: O(N log N) due to sorting. (Can be O(N) using QuickSelect to find median).
- **Space**: O(1) if sorting in-place.

---

## Analysis / Phân tích

### Approach: Median-based Absolute Differences

**Algorithm**:
1.  Sort array.
2.  Median = middle element.
3.  Sum distances to median.

---
