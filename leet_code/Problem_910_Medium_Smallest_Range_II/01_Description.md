# Result for Smallest Range II
# *Kết quả cho bài toán Khoảng Nhỏ nhất II*

## Description
## *Mô tả*

You are given an integer array `nums` and an integer `k`.
*Bạn được cho một mảng số nguyên `nums` và một số nguyên `k`.*

For each index `i` where `0 <= i < nums.length`, change `nums[i]` to be either `nums[i] + k` or `nums[i] - k`.
*Đối với mỗi chỉ số `i` trong khoảng `0 <= i < nums.length`, hãy thay đổi `nums[i]` thành `nums[i] + k` hoặc `nums[i] - k`.*

The **score** of `nums` is the difference between the maximum and minimum elements in `nums`.
* **Điểm số** của `nums` là hiệu giữa phần tử lớn nhất và phần tử nhỏ nhất trong `nums`.*

Return *the minimum **score** of `nums` after changing the values at each index*.
*Hãy trả về **điểm số** nhỏ nhất của `nums` sau khi thay đổi các giá trị tại mỗi chỉ số.*

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
**Output:** 3
**Explanation:** Change nums to be [4, 6, 3]. The score is max(nums) - min(nums) = 6 - 3 = 3.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 10^4`
*   `0 <= nums[i] <= 10^4`
*   `0 <= k <= 10^4`
