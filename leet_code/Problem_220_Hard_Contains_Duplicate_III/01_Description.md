# Result for Contains Duplicate III
# *Kết quả cho bài toán Chứa bản sao III*

## Description
## *Mô tả*

You are given an integer array `nums` and two integers `indexDiff` and `valueDiff`.
*Bạn được cho một mảng số nguyên `nums` và hai số nguyên `indexDiff` và `valueDiff`.*

Find a pair of indices `(i, j)` such that:
*Tìm một cặp chỉ số `(i, j)` sao cho:*

*   `i != j`
*   `abs(i - j) <= indexDiff`
*   `abs(nums[i] - nums[j]) <= valueDiff`

Return `true` *if such pair exists or* `false` *otherwise*.
*Trả về `true` *nếu cặp như vậy tồn tại hoặc* `false` *nếu không.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [1,2,3,1], indexDiff = 3, valueDiff = 0`
**Output:** `true`
**Explanation:** We can choose (i, j) = (0, 3).
We satisfy the three conditions:
1. i != j --> 0 != 3
2. abs(i - j) <= indexDiff --> abs(0 - 3) <= 3
3. abs(nums[i] - nums[j]) <= valueDiff --> abs(1 - 1) <= 0

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3`
**Output:** `false`
**Explanation:** After trying all the possible pairs (i, j), we cannot satisfy the three conditions, so we return false.

## Constraints:
## *Ràng buộc:*

*   `2 <= nums.length <= 10^5`
*   `-10^9 <= nums[i] <= 10^9`
*   `1 <= indexDiff <= 10^5`
*   `0 <= valueDiff <= 10^9`
