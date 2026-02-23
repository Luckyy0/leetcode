# Result for 4Sum
# *Kết quả cho bài toán Tổng 4 Số*

## Description
## *Mô tả*

Given an array `nums` of `n` integers, return an array of all the **unique** quadruplets `[nums[a], nums[b], nums[c], nums[d]]` such that:
*Cho một mảng `nums` gồm `n` số nguyên, trả về một mảng chứa tất cả các bộ bốn **duy nhất** `[nums[a], nums[b], nums[c], nums[d]]` sao cho:*

*   `0 <= a, b, c, d < n`
*   `a`, `b`, `c`, and `d` are **distinct**.
    *`a`, `b`, `c`, và `d` là **phân biệt**.*
*   `nums[a] + nums[b] + nums[c] + nums[d] == target`

You may return the answer in **any order**.
*Bạn có thể trả về câu trả lời theo **bất kỳ thứ tự nào**.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [1,0,-1,0,-2,2]`, `target = 0`
**Output:** `[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]`

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [2,2,2,2,2]`, `target = 8`
**Output:** `[[2,2,2,2]]`

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 200`
*   `-10^9 <= nums[i] <= 10^9`
*   `-10^9 <= target <= 10^9`
