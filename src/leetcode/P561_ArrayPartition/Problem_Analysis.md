# 561. Array Partition / Phân Chia Mảng

## Problem Description / Mô tả bài toán
Given an integer array `nums` of `2n` integers, group these integers into `n` pairs `(a1, b1), (a2, b2), ..., (an, bn)` such that the sum of `min(ai, bi)` for all `i` is maximized. Return the maximized sum.
Cho một mảng số nguyên `nums` gồm `2n` số nguyên, hãy nhóm các số nguyên này thành `n` cặp `(a1, b1), (a2, b2), ..., (an, bn)` sao cho tổng của `min(ai, bi)` cho tất cả `i` được tối đa hóa. Hãy trả về tổng tối đa hóa đó.

### Example 1:
```text
Input: nums = [1,4,3,2]
Output: 4
Explanation: All possible pairings (ignoring the ordering of elements):
1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
So the maximum sum is 4.
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Sorting / Sắp Xếp Tham Lam
To maximize the sum of minimums, we should pair the smallest number with the second smallest number.
If we pair the smallest with a large number, the large number is "wasted" (since min takes the small one).
By sorting, `nums[0] <= nums[1] <= nums[2] <= ...`
Pairs: `(nums[0], nums[1])`, `(nums[2], nums[3])`...
Min sums: `nums[0] + nums[2] + ...` (sum of even indexed elements).

Algorithm:
1. Sort `nums`.
2. Sum elements at indices `0, 2, 4, ...`.
3. Return sum.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(log N) for sorting stack.

---

## Analysis / Phân tích

### Approach: Sort and Sum Even Indices

**Algorithm**:
1.  Sort the array.
2.  Iterate with step 2.
3.  Sum up elements at even positions.

---
