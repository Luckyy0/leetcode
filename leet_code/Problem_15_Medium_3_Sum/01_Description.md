# Result for 3Sum
# *Kết quả cho bài toán Tổng 3 Số*

## Description
## *Mô tả*

Given an integer array nums, return all the triplets `[nums[i], nums[j], nums[k]]` such that `i != j`, `i != k`, and `j != k`, and `nums[i] + nums[j] + nums[k] == 0`.
*Cho một mảng số nguyên nums, trả về tất cả các bộ ba `[nums[i], nums[j], nums[k]]` sao cho `i != j`, `i != k`, và `j != k`, và `nums[i] + nums[j] + nums[k] == 0`.*

Notice that the solution set must not contain duplicate triplets.
*Lưu ý rằng tập hợp kết quả không được chứa các bộ ba trùng lặp.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [-1,0,1,2,-1,-4]`
**Output:** `[[-1,-1,2],[-1,0,1]]`
**Explanation:** 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
*Các bộ ba phân biệt là [-1,0,1] và [-1,-1,2].*

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [0,1,1]`
**Output:** `[]`

## Example 3:
## *Ví dụ 3:*

**Input:** `nums = [0,0,0]`
**Output:** `[[0,0,0]]`

## Constraints:
## *Ràng buộc:*

*   `3 <= nums.length <= 3000`
*   `-10^5 <= nums[i] <= 10^5`
