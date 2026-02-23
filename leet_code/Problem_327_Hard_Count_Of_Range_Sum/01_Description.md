# Result for Count of Range Sum
# *Kết quả cho bài toán Đếm tổng Phạm vi*

## Description
## *Mô tả*

Given an integer array `nums` and two integers `lower` and `upper`, return *the number of range sums that lie in* `[lower, upper]` *inclusive*.
*Cho một mảng số nguyên `nums` và hai số nguyên `lower` và `upper`, trả về *số lượng tổng phạm vi nằm trong* `[lower, upper]` *bao gồm cả hai*.*

Range sum `S(i, j)` is defined as the sum of the elements in `nums` between indices `i` and `j` inclusive, where `i <= j`.
*Tổng phạm vi `S(i, j)` được định nghĩa là tổng các phần tử trong `nums` giữa các chỉ số `i` và `j` bao gồm cả hai, trong đó `i <= j`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [-2,5,-1], lower = -2, upper = 2`
**Output:** `3`
**Explanation:** The three ranges are: [0,0], [2,2], [0,2] and their respective sums are: -2, -1, 2.

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [0], lower = 0, upper = 0`
**Output:** `1`

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 10^5`
*   `-2^31 <= nums[i] <= 2^31 - 1`
*   `-10^5 <= lower <= upper <= 10^5`
*   The answer is **guaranteed** to fit in a **32-bit** integer.
