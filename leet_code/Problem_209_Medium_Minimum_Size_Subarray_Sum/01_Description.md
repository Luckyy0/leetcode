# Result for Minimum Size Subarray Sum
# *Kết quả cho bài toán Tổng mảng con kích thước tối thiểu*

## Description
## *Mô tả*

Given an array of positive integers `nums` and a positive integer `target`, return *the **minimal length** of a **subarray** whose sum is greater than or equal to* `target`. If there is no such subarray, return `0` instead.
*Cho một mảng các số nguyên dương `nums` và một số nguyên dương `target`, hãy trả về ***độ dài tối thiểu** của một **mảng con** có tổng lớn hơn hoặc bằng* `target`. Nếu không có mảng con nào như vậy, hãy trả về `0`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `target = 7, nums = [2,3,1,2,4,3]`
**Output:** `2`
**Explanation:** The subarray `[4,3]` has the minimal length under the problem constraint.

## Example 2:
## *Ví dụ 2:*

**Input:** `target = 4, nums = [1,4,4]`
**Output:** `1`

## Example 3:
## *Ví dụ 3:*

**Input:** `target = 11, nums = [1,1,1,1,1,1,1,1]`
**Output:** `0`

## Constraints:
## *Ràng buộc:*

*   `1 <= target <= 10^9`
*   `1 <= nums.length <= 10^5`
*   `1 <= nums[i] <= 10^4`

**Follow up:** If you have figured out the `O(n)` solution, try coding another solution of which the time complexity is `O(n log n)`.
**Câu hỏi mở rộng:** Nếu bạn đã tìm ra giải pháp `O(n)`, hãy thử viết một giải pháp khác có độ phức tạp thời gian là `O(n log n)`.
