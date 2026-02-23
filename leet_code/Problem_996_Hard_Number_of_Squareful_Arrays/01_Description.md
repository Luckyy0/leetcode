# Result for Number of Squareful Arrays
# *Kết quả cho bài toán Số lượng mảng Squareful*

## Description
## *Mô tả*

An array is **squareful** if the sum of every pair of adjacent elements is a **perfect square**.
*Một mảng được gọi là **squareful** nếu tổng của mọi cặp phần tử liền kề là một **số chính phương**.*

Given an integer array `nums`, return *the number of permutations of* `nums` *that are **squareful***.
*Cho một mảng số nguyên `nums`, trả về *số lượng hoán vị của* `nums` *là **squareful***.*

Two permutations `perm1` and `perm2` are considered different if there is some index `i` such that `perm1[i] != perm2[i]`.
*Hai hoán vị `perm1` và `perm2` được coi là khác nhau nếu tồn tại một số chỉ số `i` sao cho `perm1[i] != perm2[i]`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [1,17,8]
**Output:** 2
**Explanation:** [1,8,17] and [17,8,1] are the valid permutations.

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [2,2,2]
**Output:** 1

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 12`
*   `0 <= nums[i] <= 10^9`
