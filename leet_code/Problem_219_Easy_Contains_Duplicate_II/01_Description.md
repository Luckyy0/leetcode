# Result for Contains Duplicate II
# *Kết quả cho bài toán Chứa bản sao II*

## Description
## *Mô tả*

Given an integer array `nums` and an integer `k`, return `true` if there are two **distinct indices** `i` and `j` in the array such that `nums[i] == nums[j]` and `abs(i - j) <= k`.
*Cho một mảng số nguyên `nums` và một số nguyên `k`, trả về `true` nếu có hai **chỉ số phân biệt** `i` và `j` trong mảng sao cho `nums[i] == nums[j]` và `abs(i - j) <= k`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [1,2,3,1], k = 3`
**Output:** `true`

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [1,0,1,1], k = 1`
**Output:** `true`

## Example 3:
## *Ví dụ 3:*

**Input:** `nums = [1,2,3,1,2,3], k = 2`
**Output:** `false`

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 10^5`
*   `-10^9 <= nums[i] <= 10^9`
*   `0 <= k <= 10^5`
