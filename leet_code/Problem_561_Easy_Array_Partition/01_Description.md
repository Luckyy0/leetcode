# Result for Array Partition
# *Kết quả cho bài toán Phân vùng Mảng*

## Description
## *Mô tả*

Given an integer array `nums` of `2n` integers, group these integers into `n` pairs `(a1, b1), (a2, b2), ..., (an, bn)` such that the sum of `min(ai, bi)` for all `i` is **maximized**. Return the maximized sum.
*Cho một mảng số nguyên `nums` gồm `2n` số nguyên, hãy nhóm các số nguyên này thành `n` cặp `(a1, b1), (a2, b2), ..., (an, bn)` sao cho tổng của `min(ai, bi)` cho tất cả `i` là **lớn nhất**. Trả về tổng lớn nhất đó.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [1,4,3,2]`
**Output:** `4`
**Explanation:** All possible pairings (ignoring the order of elements in each pair) are:
1. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
3. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
So the maximum possible sum is 4.

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [6,2,6,5,1,2]`
**Output:** `9`
**Explanation:** The optimal pairing is (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9.

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 10^4`
*   `nums.length == 2 * n`
*   `-10^4 <= nums[i] <= 10^4`
