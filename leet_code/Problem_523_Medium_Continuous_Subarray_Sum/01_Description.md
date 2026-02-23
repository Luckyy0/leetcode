# Result for Continuous Subarray Sum
# *Kết quả cho bài toán Tổng Mảng con Liên tục*

## Description
## *Mô tả*

Given an integer array `nums` and an integer `k`, return `true` *if* `nums` *has a **continuous subarray** of size **at least two** whose elements sum up to a multiple of* `k`*, or* `false` *otherwise*.
*Cho một mảng số nguyên `nums` và một số nguyên `k`, hãy trả về `true` *nếu* `nums` *có một **mảng con liên tục** có kích thước **ít nhất là hai** mà tổng các phần tử của nó là bội số của* `k`*, hoặc* `false` *nếu ngược lại*.*

An integer `x` is a multiple of `k` if there exists an integer `n` such that `x = n * k`. `0` is always a multiple of `k`.
*Một số nguyên `x` là bội số của `k` nếu tồn tại một số nguyên `n` sao cho `x = n * k`. `0` luôn là bội số của `k`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [23,2,4,6,7], k = 6`
**Output:** `true`
**Explanation:** [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [23,2,6,4,7], k = 6`
**Output:** `true`
**Explanation:** [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
42 is a multiple of 6 because 42 = 7 * 6.

## Example 3:
## *Ví dụ 3:*

**Input:** `nums = [23,2,6,4,7], k = 13`
**Output:** `false`

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 10^5`
*   `0 <= nums[i] <= 10^9`
*   `0 <= sum(nums[i]) <= 2^{31} - 1`
*   `1 <= k <= 2^{31} - 1`
