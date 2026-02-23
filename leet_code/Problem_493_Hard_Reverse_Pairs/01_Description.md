# Result for Reverse Pairs
# *Kết quả cho bài toán Cặp Đảo ngược*

## Description
## *Mô tả*

Given an integer array `nums`, return *the number of **reverse pairs** in the array*.
*Cho một mảng số nguyên `nums`, hãy trả về *số lượng **cặp đảo ngược** trong mảng*.*

A **reverse pair** is a pair `(i, j)` where:
*Một **cặp đảo ngược** là một cặp `(i, j)` trong đó:*

*   `0 <= i < j < nums.length` and
*   `nums[i] > 2 * nums[j]`.

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [1,3,2,3,1]`
**Output:** `2`
**Explanation:** The reverse pairs are:
(1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [2,4,3,5,1]`
**Output:** `3`
**Explanation:** The reverse pairs are:
(1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
(2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 5 * 10^4`
*   `-2^{31} <= nums[i] <= 2^{31} - 1`
