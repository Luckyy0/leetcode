# Result for Split Array with Equal Sum
# *Kết quả cho bài toán Chia Mảng với Tổng bằng nhau*

## Description
## *Mô tả*

Given an integer array `nums` of length `n`, return `true` if there is a triplet `(i, j, k)` which satisfies the following conditions:
*Cho một mảng số nguyên `nums` có độ dài `n`, trả về `true` nếu tồn tại một bộ ba `(i, j, k)` thỏa mãn các điều kiện sau:*

*   `0 < i, i + 1 < j, j + 1 < k < n - 1`
*   The sum of subarrays `(0, i - 1)`, `(i + 1, j - 1)`, `(j + 1, k - 1)` and `(k + 1, n - 1)` is equal.
    *Tổng của các mảng con `(0, i - 1)`, `(i + 1, j - 1)`, `(j + 1, k - 1)` và `(k + 1, n - 1)` bằng nhau.*

The sum of a subarray `(left, right)` is defined as the sum of elements from index `left` to index `right`.
*Tổng của một mảng con `(left, right)` được định nghĩa là tổng của các phần tử từ chỉ số `left` đến chỉ số `right`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [1,2,1,2,1,2,1]`
**Output:** `true`
**Explanation:**
i = 1, j = 3, k = 5.
sum(0, i - 1) = sum(0, 0) = 1
sum(i + 1, j - 1) = sum(2, 2) = 1
sum(j + 1, k - 1) = sum(4, 4) = 1
sum(k + 1, n - 1) = sum(6, 6) = 1

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [1,2,1,2,1,2,1,2]`
**Output:** `false`

## Constraints:
## *Ràng buộc:*

*   `n == nums.length`
*   `1 <= n <= 2000`
*   `-10^6 <= nums[i] <= 10^6`
