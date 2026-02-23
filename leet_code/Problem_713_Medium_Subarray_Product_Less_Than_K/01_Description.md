# Result for Subarray Product Less Than K
# *Kết quả cho bài toán Tích mảng con nhỏ hơn K*

## Description
## *Mô tả*

Given an array of integers `nums` and an integer `k`, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than `k`.
*Cho một mảng các số nguyên `nums` và một số nguyên `k`, hãy trả về số lượng các mảng con liên tục mà tích của tất cả các phần tử trong mảng con đó nhỏ hơn hẳn `k`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [10,5,2,6], k = 100
**Output:** 8
**Explanation:** The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product is 100 which is not strictly less than 100.

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [1,2,3], k = 0
**Output:** 0

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 3 * 10^4`
*   `1 <= nums[i] <= 1000`
*   `0 <= k <= 10^6`
