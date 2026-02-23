# Result for Binary Subarrays With Sum
# *Kết quả cho bài toán Mảng con Nhị phân Có Tổng Bằng S*

## Description
## *Mô tả*

Given a binary array `nums` and an integer `goal`, return *the number of non-empty **subarrays** with a sum* `goal`.
*Cho một mảng nhị phân `nums` và một số nguyên `goal`, hãy trả về *số lượng **mảng con** không rỗng có tổng bằng* `goal`.*

A **subarray** is a contiguous part of the array.
*Một **mảng con** là một phần liên tiếp của mảng.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [1,0,1,0,1], goal = 2
**Output:** 4
**Explanation:** The 4 subarrays are bolded and underlined below:
[**1,0,1**,0,1]
[**1,0,1,0**,1]
[1,**0,1,0,1**]
[1,0,**1,0,1**]

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [0,0,0,0,0], goal = 0
**Output:** 15

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 3 * 10^4`
*   `nums[i]` is either `0` or `1`.
*   `0 <= goal <= nums.length`
