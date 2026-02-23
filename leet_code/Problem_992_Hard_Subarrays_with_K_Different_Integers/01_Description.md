# Result for Subarrays with K Different Integers
# *Kết quả cho bài toán Mảng con Có K Số nguyên Khác nhau*

## Description
## *Mô tả*

Given an integer array `nums` and an integer `k`, return *the number of **good subarrays** of* `nums`.
*Cho một mảng số nguyên `nums` và một số nguyên `k`, trả về *số lượng **mảng con tốt** của* `nums`.*

A **good array** is an array where the number of different integers in that array is exactly `k`.
*Một **mảng tốt** là mảng mà số lượng các số nguyên khác nhau trong đó chính xác bằng `k`.*

*   For example, `[1,2,3,1,2]` has `3` different integers: `1`, `2`, and `3`.
    *   *Ví dụ, `[1,2,3,1,2]` có `3` số nguyên khác nhau: `1`, `2`, và `3`.*

A **subarray** is a **contiguous** part of an array.
*Một **mảng con** là một phần **liên tục** của một mảng.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [1,2,1,2,3], k = 2
**Output:** 7
**Explanation:** Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [1,2,1,3,4], k = 3
**Output:** 3
**Explanation:** Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 2 * 10^4`
*   `1 <= nums[i], k <= nums.length`
