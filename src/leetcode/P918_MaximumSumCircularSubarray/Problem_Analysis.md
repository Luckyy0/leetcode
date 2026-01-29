# 918. Maximum Sum Circular Subarray / Tổng lớn nhất của Mảng con Vòng

## Problem Description / Mô tả bài toán
Given a circular integer array `nums` of length `n`, return the maximum possible sum of a non-empty subarray of `nums`.
Cho một mảng số nguyên vòng `nums` độ dài `n`, hãy trả về tổng lớn nhất có thể của một mảng con không rỗng của `nums`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Modified Kadane's Algorithm / Thuật toán Kadane sửa đổi
The maximum subarray sum can be either:
1. A normal subarray (mid-array).
2. A circular subarray (wrapped around).

Case 2 (Circular):
The circular sum is `TotalSum - MinimumSubarraySum`.
By minimizing the internal part, we maximize the external wrap-around part.

Algorithm:
1. Find `maxSum` using standard Kadane.
2. Find `minSum` using standard Kadane (on minimums).
3. Find `totalSum`.
4. If `totalSum == minSum` (all numbers negative), return `maxSum`.
5. Return `max(maxSum, totalSum - minSum)`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Complementary Maximization
A circular subarray consists of a prefix and a suffix. Thus, finding the maximum wrap-around sum is equivalent to finding the total sum minus the smallest possible sum of an interior (non-circular) subarray.
Mảng con vòng bao gồm một tiền tố và một hậu tố. Do đó, việc tìm tổng vòng tối đa tương đương với việc lấy tổng toàn bộ trừ đi tổng nhỏ nhất có thể của một mảng con bên trong (không vòng).

---
