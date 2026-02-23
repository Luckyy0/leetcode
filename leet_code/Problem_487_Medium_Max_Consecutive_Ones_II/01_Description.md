# Result for Max Consecutive Ones II
# *Kết quả cho bài toán Chuỗi số 1 Liên tiếp Dài nhất II*

## Description
## *Mô tả*

Given a binary array `nums`, return *the maximum number of consecutive* `1`*'s in the array if you can flip at most one* `0`.
*Cho một mảng nhị phân `nums`, hãy trả về *số lượng tối đa các số* `1` *liên tiếp trong mảng nếu bạn có thể lật tối đa một số* `0`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [1,0,1,1,0]`
**Output:** `4`
**Explanation:** Flip the first zero will get the maximum number of consecutive 1s. After flipping, the maximum number of consecutive 1s is 4.

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [1,0,1,1,0,1]`
**Output:** `4`

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 10^5`
*   `nums[i]` is either `0` or `1`.

**Follow up:** What if the input numbers come in one by one as an infinite stream? In other words, you can't store all numbers coming from the stream as it's too large to hold in memory. Could you solve it efficiently with `O(1)` extra space?
