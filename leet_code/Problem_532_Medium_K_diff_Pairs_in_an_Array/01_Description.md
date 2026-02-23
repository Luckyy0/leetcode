# Result for K-diff Pairs in an Array
# *Kết quả cho bài toán Cặp K-khác biệt trong Mảng*

## Description
## *Mô tả*

Given an array of integers `nums` and an integer `k`, return *the number of **unique** k-diff pairs in the array*.
*Cho một mảng các số nguyên `nums` và một số nguyên `k`, hãy trả về *số lượng các cặp k-khác biệt **duy nhất** trong mảng*.*

A **k-diff** pair is an integer pair `(nums[i], nums[j])`, where the following are true:
*Một cặp **k-khác biệt** là một cặp số nguyên `(nums[i], nums[j])`, trong đó những điều sau là đúng:*

*   `0 <= i, j < nums.length`
*   `i != j`
*   `|nums[i] - nums[j]| == k`

**Notice** that `|val|` denotes the absolute value of `val`.
**Lưu ý** rằng `|val|` biểu thị giá trị tuyệt đối của `val`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [3,1,4,1,5], k = 2`
**Output:** `2`
**Explanation:** There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of **unique** pairs.

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [1,2,3,4,5], k = 1`
**Output:** `4`
**Explanation:** There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).

## Example 3:
## *Ví dụ 3:*

**Input:** `nums = [1,3,1,5,4], k = 0`
**Output:** `1`
**Explanation:** There is one 0-diff pair in the array, (1, 1).

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 10^4`
*   `-10^7 <= nums[i] <= 10^7`
*   `0 <= k <= 10^7`
