# 915. Partition Array into Disjoint Intervals / Chia mảng thành các Khoảng Rời nhau

## Problem Description / Mô tả bài toán
Given an integer array `nums`, partition it into two contiguous subarrays `left` and `right` such that:
- Every element in `left` is less than or equal to every element in `right`.
- `left` and `right` are non-empty.
- `left` has the smallest possible size.

Return the size of `left`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Subarray Max and Min / Mảng con Max và Min
Algorithm:
1. Precompute `minRight[i]`: the minimum value in `nums[i...n-1]`.
2. Iterate `i` from 0 to `n-2`:
   - Keep track of `maxLeft`: the maximum value in `nums[0...i]`.
   - If `maxLeft <= minRight[i+1]`, it is a valid split. Since we want smallest `left`, return `i + 1`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

### Optimization (O(1) space):
Iterate once and keep track of current max and the "potential" split point.

---

## Analysis / Phân tích

### Approach: Boundary Inequality Check
A valid split occurs when the highest point reached in the prefix is lower than or equal to the lowest point in the remaining suffix. By precomputing suffix minimums, we can identify this transition point in a single linear scan.
Một sự phân chia hợp lệ xảy ra khi điểm cao nhất đạt được trong tiền tố thấp hơn hoặc bằng điểm thấp nhất trong hậu tố còn lại. Bằng cách tính toán trước các giá trị nhỏ nhất của hậu tố, chúng ta có thể xác định điểm chuyển tiếp này trong một lần quét tuyến tính duy nhất.

---
