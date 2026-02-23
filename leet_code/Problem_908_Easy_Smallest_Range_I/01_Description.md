# Result for Smallest Range I
# *Kết quả cho bài toán Khoảng Nhỏ nhất I*

## Description
## *Mô tả*

You are given an integer array `nums` and an integer `k`.
*Bạn được cho một mảng số nguyên `nums` và một số nguyên `k`.*

In one operation, you can choose any index `i` where `0 <= i < nums.length` and change `nums[i]` to `nums[i] + x` where `x` is an integer from the range `[-k, k]`. You can apply this operation at most once for each index `i`.
*Trong một thao tác, bạn có thể chọn bất kỳ chỉ số `i` nào trong khoảng `0 <= i < nums.length` và thay đổi `nums[i]` thành `nums[i] + x`, trong đó `x` là một số nguyên từ khoảng `[-k, k]`. Bạn có thể áp dụng thao tác này tối đa một lần cho mỗi chỉ số `i`.*

The **score** of `nums` is the difference between the maximum and minimum elements in `nums`.
* **Điểm số** của `nums` là hiệu giữa phần tử lớn nhất và phần tử nhỏ nhất trong `nums`.*

Return *the minimum **score** of `nums` after applying the mentioned operation at most once for each index in it*.
*Hãy trả về **điểm số** nhỏ nhất của `nums` sau khi áp dụng thao tác được đề cập tối đa một lần cho mỗi chỉ số trong đó.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [1], k = 0
**Output:** 0
**Explanation:** The score is max(nums) - min(nums) = 1 - 1 = 0.

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [0,10], k = 2
**Output:** 6
**Explanation:** Change nums to be [2, 8]. The score is max(nums) - min(nums) = 8 - 2 = 6.

## Example 3:
## *Ví dụ 3:*

**Input:** nums = [1,3,6], k = 3
**Output:** 0
**Explanation:** Change nums to be [4,4,4]. The score is max(nums) - min(nums) = 4 - 4 = 0.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 10^4`
*   `0 <= nums[i] <= 10^4`
*   `0 <= k <= 10^4`
