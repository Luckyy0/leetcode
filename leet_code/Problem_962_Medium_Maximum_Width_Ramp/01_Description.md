# Result for Maximum Width Ramp
# *Kết quả cho bài toán Đoạn đường nối Rộng nhất*

## Description
## *Mô tả*

A **ramp** in an integer array `nums` is a pair `(i, j)` for which `i < j` and `nums[i] <= nums[j]`. The **width** of such a ramp is `j - i`.
*Một **đoạn đường nối** (ramp) trong một mảng số nguyên `nums` là một cặp `(i, j)` mà `i < j` và `nums[i] <= nums[j]`. **Chiều rộng** của đoạn đường nối như vậy là `j - i`.*

Given an integer array `nums`, return *the maximum width of a ramp in* `nums`. If there is no ramp, return `0`.
*Cho một mảng số nguyên `nums`, hãy trả về *chiều rộng lớn nhất của một đoạn đường nối trong* `nums`. Nếu không có đoạn đường nối nào, hãy trả về `0`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [6,0,8,2,1,5]
**Output:** 4
**Explanation:** The maximum width ramp is achieved at (i, j) = (1, 5): nums[1] = 0 and nums[5] = 5.

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [9,8,1,0,1,9,4,0,4,1]
**Output:** 7
**Explanation:** The maximum width ramp is achieved at (i, j) = (2, 9): nums[2] = 1 and nums[9] = 1.

---

## Constraints:
## *Ràng buộc:*

*   `2 <= nums.length <= 5 * 10^4`
*   `0 <= nums[i] <= 5 * 10^4`
