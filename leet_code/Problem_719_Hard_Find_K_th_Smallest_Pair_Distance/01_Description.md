# Result for Find K-th Smallest Pair Distance
# *Kết quả cho bài toán Tìm Khoảng cách cặp nhỏ thứ K*

## Description
## *Mô tả*

The **distance of a pair** of integers `a` and `b` is defined as the absolute difference between `a` and `b`.
* **Khoảng cách của một cặp** số nguyên `a` và `b` được định nghĩa là giá trị tuyệt đối của hiệu giữa `a` và `b`.*

Given an integer array `nums` and an integer `k`, return the `kth` smallest **distance among all the pairs** `nums[i]` and `nums[j]` where `0 <= i < j < nums.length`.
*Cho một mảng số nguyên `nums` và một số nguyên `k`, hãy trả về **khoảng cách nhỏ thứ `k`** trong số tất cả các cặp `nums[i]` và `nums[j]` với `0 <= i < j < nums.length`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [1,3,1], k = 1
**Output:** 0
**Explanation:** Here are all the pairs:
(1,3) -> distance 2
(1,1) -> distance 0
(3,1) -> distance 2
Then the 1st smallest distance is 0.

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [1,1,1], k = 2
**Output:** 0

## Example 3:
## *Ví dụ 3:*

**Input:** nums = [1,6,1], k = 3
**Output:** 5

---

## Constraints:
## *Ràng buộc:*

*   `n == nums.length`
*   `2 <= n <= 10^4`
*   `0 <= nums[i] <= 10^6`
*   `1 <= k <= n * (n - 1) / 2`
