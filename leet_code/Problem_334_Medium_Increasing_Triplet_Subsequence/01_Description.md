# Result for Increasing Triplet Subsequence
# *Kết quả cho bài toán Chuỗi con Bộ ba Tăng dần*

## Description
## *Mô tả*

Given an integer array `nums`, return `true` *if there exists a triple of indices* `(i, j, k)` *such that* `i < j < k` *and* `nums[i] < nums[j] < nums[k]`. If no such indices exists, return `false`.
*Cho một mảng số nguyên `nums`, trả về `true` *nếu tồn tại một bộ ba chỉ số* `(i, j, k)` *sao cho* `i < j < k` *và* `nums[i] < nums[j] < nums[k]`. Nếu không có chỉ số nào như vậy tồn tại, trả về `false`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [1,2,3,4,5]`
**Output:** `true`
**Explanation:** Any triplet like [1, 2, 3] or [1, 2, 4] is valid.

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [5,4,3,2,1]`
**Output:** `false`
**Explanation:** No triplet exists.

## Example 3:
## *Ví dụ 3:*

**Input:** `nums = [2,1,5,0,4,6]`
**Output:** `true`
**Explanation:** The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 5 * 10^5`
*   `-2^31 <= nums[i] <= 2^31 - 1`

**Follow up:** Could you implement a solution that runs in `O(n)` time complexity and `O(1)` space complexity?
**Câu hỏi mở rộng:** Bạn có thể cài đặt một giải pháp chạy với độ phức tạp thời gian `O(n)` và độ phức tạp không gian `O(1)` không?
