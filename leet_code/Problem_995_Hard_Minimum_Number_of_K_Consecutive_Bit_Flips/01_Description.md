# Result for Minimum Number of K Consecutive Bit Flips
# *Kết quả cho bài toán Số lượng lật bit K liên tiếp Tối thiểu*

## Description
## *Mô tả*

You are given a binary array `nums` and an integer `k`.
*Bạn được cho một mảng nhị phân `nums` và một số nguyên `k`.*

A **k-bit flip** is choosing a **subarray** of length `k` from `nums` and simultaneously changing every `0` in the subarray to `1`, and every `1` in the subarray to `0`.
*Một thao tác **lật k bit** là việc chọn một **mảng con** có độ dài `k` từ `nums` và đồng thời thay đổi mọi `0` trong mảng con thành `1`, và mọi `1` trong mảng con thành `0`.*

Return *the minimum number of **k-bit flips** required so that there is no* `0` *in the array*. If it is not possible, return `-1`.
*Trả về *số lượng **lật k bit** tối thiểu cần thiết để không có* `0` *nào trong mảng*. Nếu không thể, trả về `-1`.*

A **subarray** is a **contiguous** part of an array.
*Một **mảng con** là một phần **liên tục** của một mảng.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [0,1,0], k = 1
**Output:** 2
**Explanation:** Flip nums[0], then flip nums[2].

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [1,1,0], k = 2
**Output:** -1
**Explanation:** No matter how we flip subarrays of size 2, we cannot make the array become [1,1,1].

## Example 3:
## *Ví dụ 3:*

**Input:** nums = [0,0,0,1,0,1,1,0], k = 3
**Output:** 3
**Explanation:** 
Flip nums[0],nums[1],nums[2]: nums becomes [1,1,1,1,0,1,1,0]
Flip nums[4],nums[5],nums[6]: nums becomes [1,1,1,1,1,0,0,0]
Flip nums[5],nums[6],nums[7]: nums becomes [1,1,1,1,1,1,1,1]

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 10^5`
*   `1 <= k <= nums.length`
