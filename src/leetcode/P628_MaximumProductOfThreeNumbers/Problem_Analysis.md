# 628. Maximum Product of Three Numbers / Tích Lớn Nhất Của Ba Số

## Problem Description / Mô tả bài toán
Given an integer array `nums`, find three numbers whose product is maximum and return the maximum product.
Cho một mảng số nguyên `nums`, tìm ba số có tích lớn nhất và trả về tích lớn nhất đó.

### Example 1:
```text
Input: nums = [1,2,3]
Output: 6
```
### Example 2:
```text
Input: nums = [1,2,3,4]
Output: 24
```
### Example 3:
```text
Input: nums = [-1,-2,-3]
Output: -6
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sorting / Linear Scan / Sắp Xếp / Quét Tuyến Tính
Maximum product can be formed by:
1. Three largest positive numbers.
2. Two smallest negative numbers (their product is positive) and the largest positive number.

So we need:
- `max1, max2, max3`
- `min1, min2`

Result = `Math.max(max1 * max2 * max3, min1 * min2 * max1)`.

If we sort: 
`max(nums[n-1]*nums[n-2]*nums[n-3], nums[0]*nums[1]*nums[n-1])`.

### Complexity / Độ phức tạp
- **Time**: O(N log N) with sort, or O(N) with linear scan.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Linear Scan

**Algorithm**:
1.  Initialize top 3 maximums and bottom 2 minimums.
2.  Iterate through array updating these values.
3.  Compute potential max products.
4.  Return max.

---
