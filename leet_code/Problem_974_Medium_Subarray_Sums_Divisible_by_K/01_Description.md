# Result for Subarray Sums Divisible by K
# *Kết quả cho bài toán Tổng mảng con chia hết cho K*

## Description
## *Mô tả*

Given an integer array `nums` and an integer `k`, return *the number of non-empty subarrays that have a sum divisible by* `k`.
*Cho một mảng số nguyên `nums` và một số nguyên `k`, trả về *số lượng mảng con không rỗng có tổng chia hết cho* `k`.*

A **subarray** is a **contiguous** part of an array.
*Một **mảng con** là một phần **liên tiếp** của một mảng.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [4,5,0,-2,-3,1], k = 5
**Output:** 7
**Explanation:** There are 7 subarrays with a sum divisible by k = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [5], k = 9
**Output:** 0

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 3 * 10^4`
*   `-10^4 <= nums[i] <= 10^4`
*   `2 <= k <= 10^4`
