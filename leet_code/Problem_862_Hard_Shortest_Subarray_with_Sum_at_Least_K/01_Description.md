# Result for Shortest Subarray with Sum at Least K
# *Kết quả cho bài toán Mảng con Ngắn nhất có Tổng ít nhất K*

## Description
## *Mô tả*

Given an integer array `nums` and an integer `k`, return *the length of the shortest non-empty **subarray** of `nums` with a sum of at least `k`*. If there is no such subarray, return `-1`.
*Cho một mảng số nguyên `nums` và một số nguyên `k`, hãy trả về *độ dài của mảng con không trống ngắn nhất của `nums` có tổng ít nhất là `k`*. Nếu không có mảng con nào như vậy, hãy trả về `-1`.*

A **subarray** is a **contiguous** part of an array.
*Một mảng con là một phần **liên tục** của một mảng.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [1], k = 1
**Output:** 1

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [1,2], k = 4
**Output:** -1

## Example 3:
## *Ví dụ 3:*

**Input:** nums = [2,-1,2], k = 3
**Output:** 3

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 10^5`
*   `-10^5 <= nums[i] <= 10^5`
*   `1 <= k <= 10^9`
