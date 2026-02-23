# Result for Patching Array
# *Kết quả cho bài toán Vá Mảng*

## Description
## *Mô tả*

Given a sorted integer array `nums` and an integer `n`, add/patch elements to the array such that any number in the range `[1, n]` inclusive can be formed by the sum of some elements in the array.
*Cho một mảng số nguyên đã sắp xếp `nums` và một số nguyên `n`, hãy thêm/vá các phần tử vào mảng sao cho bất kỳ số nào trong phạm vi `[1, n]` bao gồm cả hai đều có thể được tạo thành bởi tổng của một số phần tử trong mảng.*

Return *the minimum number of patches required*.
*Trả về *số lượng bản vá tối thiểu cần thiết*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [1,3], n = 6`
**Output:** `1`
**Explanation:**
Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
So we only need 1 patch.

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [1,5,10], n = 20`
**Output:** `2`
**Explanation:** The two patches can be [2, 4].

## Example 3:
## *Ví dụ 3:*

**Input:** `nums = [1,2,2], n = 5`
**Output:** `0`

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 1000`
*   `1 <= nums[i] <= 10^4`
*   `nums` is sorted in **ascending order**.
*   `1 <= n <= 2^31 - 1`
