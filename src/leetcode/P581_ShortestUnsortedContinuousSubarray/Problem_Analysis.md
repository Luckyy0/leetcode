# 581. Shortest Unsorted Continuous Subarray / Mảng Con Liên Tục Không Sắp Xếp Ngắn Nhất

## Problem Description / Mô tả bài toán
Given an integer array `nums`, you need to find one **continuous subarray** that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.
Cho một mảng số nguyên `nums`, bạn cần tìm một **mảng con liên tục** mà nếu bạn chỉ sắp xếp mảng con này theo thứ tự tăng dần, thì toàn bộ mảng sẽ được sắp xếp theo thứ tự tăng dần.

Return the shortest such subarray and output its length.
Trả về mảng con ngắn nhất như vậy và xuất độ dài của nó.

### Example 1:
```text
Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] to make the whole array sorted.
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sorting Comparison / So Sánh Sắp Xếp
Compare `nums` with a sorted version of `nums`.
- Find the first index `start` where `nums[start] != sorted[start]`.
- Find the last index `end` where `nums[end] != sorted[end]`.
- Length = `end - start + 1`. If already sorted, length = 0.

### Linear Scan (Stack or Min/Max) / Quét Tuyến Tính (Ngăn Xếp hoặc Min/Max)
We can solve this in O(N) time without sorting.
From left to right, we maintain `max`. If a number `nums[i] < max`, it means `nums[i]` is out of order (it should be >= max). We confirm `end = i`.
From right to left, we maintain `min`. If a number `nums[i] > min`, it means `nums[i]` is out of order (it should be <= min). We confirm `start = i`.

Algorithm:
1. `max = MinValue`, `min = MaxValue`.
2. `start = -1`, `end = -2` (to make result 0 if sorted).
3. Loop `i` from 0 to n-1:
   - `max = Max(max, nums[i])`.
   - if `nums[i] < max`, `end = i`.
4. Loop `i` from n-1 to 0:
   - `min = Min(min, nums[i])`.
   - if `nums[i] > min`, `start = i`.
5. Return `end - start + 1` (if `end > start`, else 0).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Two-Pass Scan

**Algorithm**:
1.  Identify right boundary by finding the last element smaller than maximum seen so far from left.
2.  Identify left boundary by finding the last element larger than minimum seen so far from right.
3.  Compute difference.

---
