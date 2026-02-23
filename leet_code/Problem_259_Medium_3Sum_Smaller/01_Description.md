# Result for 3Sum Smaller
# *Kết quả cho bài toán 3Sum Nhỏ hơn*

## Description
## *Mô tả*

Given an array of `n` integers `nums` and an integer `target`, find the number of index triplets `(i, j, k)` with `0 <= i < j < k < n` that satisfy the condition `nums[i] + nums[j] + nums[k] < target`.
*Cho một mảng `n` số nguyên `nums` và một số nguyên `target`, hãy tìm số lượng bộ ba chỉ số `(i, j, k)` với `0 <= i < j < k < n` thỏa mãn điều kiện `nums[i] + nums[j] + nums[k] < target`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [-2,0,1,3], target = 2`
**Output:** `2`
**Explanation:** Because there are two triplets which sums are less than 2:
[-2,0,1]
[-2,0,3]

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [], target = 0`
**Output:** `0`

## Example 3:
## *Ví dụ 3:*

**Input:** `nums = [0], target = 0`
**Output:** `0`

## Constraints:
## *Ràng buộc:*

*   `n == nums.length`
*   `0 <= n <= 3500`
*   `-100 <= nums[i] <= 100` (Wait, usually 3500 allows O(n^2), values might be larger but check complexity).
*   `-100 <= target <= 100`
