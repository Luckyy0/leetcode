# Result for Wiggle Sort II
# *Kết quả cho bài toán Sắp xếp Lắc lư II*

## Description
## *Mô tả*

Given an integer array `nums`, reorder it such that `nums[0] < nums[1] > nums[2] < nums[3]...`.
*Cho một mảng số nguyên `nums`, sắp xếp lại nó sao cho `nums[0] < nums[1] > nums[2] < nums[3]...`.*

You may assume the input array always has a valid answer.
*Bạn có thể giả định rằng mảng đầu vào luôn có câu trả lời hợp lệ.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [1,5,1,1,6,4]`
**Output:** `[1,6,1,5,1,4]`
**Explanation:** `[1,4,1,5,1,6]` is also accepted.

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [1,3,2,2,3,1]`
**Output:** `[2,3,1,3,1,2]`

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 5 * 10^4`
*   `0 <= nums[i] <= 5000`
*   It is guaranteed that there will be an answer for the given input `nums`.

**Follow Up:** Can you do it in `O(n)` time and/or in-place with `O(1)` extra space?
**Câu hỏi mở rộng:** Bạn có thể thực hiện nó trong thời gian `O(n)` và/hoặc tại chỗ với không gian phụ `O(1)` không?
