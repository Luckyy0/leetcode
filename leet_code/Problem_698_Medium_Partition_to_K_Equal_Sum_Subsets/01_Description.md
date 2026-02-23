# Result for Partition to K Equal Sum Subsets
# *Kết quả cho bài toán Chia mảng thành K tập con có Tổng bằng nhau*

## Description
## *Mô tả*

Given an integer array `nums` and an integer `k`, return `true` if it is possible to divide this array into `k` non-empty subsets whose sums are all equal.
*Cho một mảng số nguyên `nums` và một số nguyên `k`, hãy trả về `true` nếu có thể chia mảng này thành `k` tập con không rỗng có tổng bằng nhau.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [4,3,2,3,5,2,1], k = 4
**Output:** true
**Explanation:** It is possible to divide it into 4 subsets (5), (1, 4), (2, 3), (2, 3) with equal sums.

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [1,2,3,4], k = 3
**Output:** false

---

## Constraints:
## *Ràng buộc:*

*   `1 <= k <= nums.length <= 16`
*   `1 <= nums[i] <= 10^4`
*   The sum of `nums[i]` will not exceed `6 * 10^5`.
