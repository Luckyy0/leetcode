# Result for Number of Subarrays with Bounded Maximum
# *Kết quả cho bài toán Số lượng Mảng con với Giá trị Lớn nhất bị Ràng buộc*

## Description
## *Mô tả*

Given an integer array `nums` and two integers `left` and `right`, return *the number of contiguous non-empty subarrays such that the value of the maximum array element in that subarray is in the range* `[left, right]`.
*Cho một mảng số nguyên `nums` và hai số nguyên `left` và `right`, trả về *số lượng mảng con liên tiếp không rỗng sao cho giá trị của phần tử lớn nhất trong mảng con đó nằm trong khoảng* `[left, right]`.*

The following relationship is valid: `left <= max(subarray) <= right`.
*Mối quan hệ sau đây là hợp lệ: `left <= max(subarray) <= right`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [2,1,4,3], left = 2, right = 3
**Output:** 3
**Explanation:** There are three subarrays that meet the requirements: [2], [2, 1], [3].

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [2,9,2,5,6], left = 2, right = 8
**Output:** 7

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 10^5`
*   `0 <= nums[i] <= 10^9`
*   `0 <= left <= right <= 10^9`
