# Result for Arithmetic Slices
# *Kết quả cho bài toán Các mảng con Cấp số cộng*

## Description
## *Mô tả*

An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
*Một mảng số nguyên được gọi là cấp số cộng nếu nó bao gồm ít nhất ba phần tử và nếu sự khác biệt giữa hai phần tử liên tiếp bất kỳ là như nhau.*

- For example, `[1,3,5,7,9]`, `[7,7,7,7]`, and `[3,-1,-5,-9]` are arithmetic sequences.

Given an integer array `nums`, return *the number of arithmetic **subarrays** of `nums`*.
*Cho một mảng số nguyên `nums`, hãy trả về *số lượng **mảng con** cấp số cộng của `nums`*.*

A **subarray** is a contiguous subsequence of the array.
*Một **mảng con** là một dãy con liên tiếp của mảng.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [1,2,3,4]`
**Output:** `3`
**Explanation:** We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [1]`
**Output:** `0`

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 5000`
*   `-1000 <= nums[i] <= 1000`
