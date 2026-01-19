# 53. Maximum Subarray / Mảng Con Có Tổng Lớn Nhất

## Problem Description / Mô tả bài toán
Given an integer array `nums`, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
Cho một mảng số nguyên `nums`, hãy tìm mảng con liên tiếp (chứa ít nhất một số) có tổng lớn nhất và trả về tổng của nó.

A **subarray** is a **contiguous** part of an array.
Một **mảng con** là một phần **liên tiếp** của một mảng.

### Example 1:
```text
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
```

### Example 2:
```text
Input: nums = [1]
Output: 1
```

### Example 3:
```text
Input: nums = [5,4,-1,7,8]
Output: 23
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 10^5`
- `-10^4 <= nums[i] <= 10^4`

---

## Analysis / Phân tích

### Approach 1: Kadane's Algorithm / Thuật Toán Kadane
- **Idea**: Iterate through the array. For each element `nums[i]`, we decide whether to start a new subarray at `nums[i]` or extend the existing subarray ending at `nums[i-1]`.
- **Ý tưởng**: Duyệt qua mảng. Đối với mỗi phần tử `nums[i]`, chúng ta quyết định bắt đầu một mảng con mới tại `nums[i]` hay mở rộng mảng con hiện có kết thúc tại `nums[i-1]`.
- **Formula**: `currentMax = max(nums[i], currentMax + nums[i])`.
- **Global Max**: `maxSum = max(maxSum, currentMax)`.
- **Time Complexity**: O(n).
- **Space Complexity**: O(1).

### Approach 2: Divide and Conquer / Chia Để Trị
- **Idea**: Max subarray is either in left half, right half, or crossing the midpoint.
- **Time Complexity**: O(n log n).

---

## Edge Cases / Các trường hợp biên
1.  **Single Element**: `[-1]` -> -1.
2.  **All Negative**: `[-2, -3, -1]` -> -1. (Kadane handles this correctly).
3.  **Large Numbers**: Int overflow possibility (but constraints say -10^4 to 10^4, sum fits in int).
