# 485. Max Consecutive Ones / Số Lượng Chữ Số 1 Liên Tiếp Tối Đa

## Problem Description / Mô tả bài toán
Given a binary array `nums`, return the maximum number of consecutive `1`'s in the array.
Cho một mảng nhị phân `nums`, hãy trả về số lượng tối đa các chữ số `1` liên tiếp trong mảng đó.

### Example 1:
```text
Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
```

### Example 2:
```text
Input: nums = [1,0,1,1,0,1]
Output: 2
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 10^5`
- `nums[i]` is either `0` or `1`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Linear Iteration / Duyệt tuyến tính
This is a straightforward counting problem. We iterate through the array once and maintain a counter.

Algorithm:
1. Initialize `maxCount = 0` and `currentCount = 0`.
2. Iterate through each element in `nums`:
   - If the element is `1`, increment `currentCount`. Update `maxCount = max(maxCount, currentCount)`.
   - If the element is `0`, reset `currentCount = 0`.
3. Return `maxCount`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Running Counter

**Algorithm**:
1.  Initialize counter.
2.  Increment on 1, reset on 0.
3.  Keep track of global maximum.

---
