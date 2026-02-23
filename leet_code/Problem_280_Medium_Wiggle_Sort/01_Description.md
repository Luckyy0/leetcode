# Result for Wiggle Sort
# *Kết quả cho bài toán Sắp xếp Lắc lư*

## Description
## *Mô tả*

Given an integer array `nums`, reorder it such that `nums[0] <= nums[1] >= nums[2] <= nums[3]...`.
*Cho một mảng số nguyên `nums`, hãy sắp xếp lại nó sao cho `nums[0] <= nums[1] >= nums[2] <= nums[3]...`.*

You may assume the input array always has a valid answer.
*Bạn có thể giả định rằng mảng đầu vào luôn có câu trả lời hợp lệ.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [3,5,2,1,6,4]`
**Output:** `[3,5,1,6,2,4]`
**Explanation:** [1,6,2,5,3,4] is also accepted.

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [6,6,5,6,3,8]`
**Output:** `[6,6,5,6,3,8]`

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 5 * 10^4`
*   `0 <= nums[i] <= 10^4`
*   It is guaranteed that there will be an answer for the given input `nums`.

**Follow up:** Could you do it without decoding it? Just kidding (problem actually asks for in-place O(n)).
*Bài toán thường yêu cầu O(n) tại chỗ.*
