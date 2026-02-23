# Result for Max Consecutive Ones III
# *Kết quả cho bài toán Số lượng số 1 liên tiếp tối đa III*

## Description
## *Mô tả*

Given a binary array `nums` and an integer `k`, return *the maximum number of consecutive `1`'s in the array if you can flip at most* `k` `0`'s.
*Cho một mảng nhị phân `nums` và một số nguyên `k`, trả về số lượng các số `1` liên tiếp tối đa trong mảng nếu bạn có thể lật tối đa `k` số `0`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
**Output:** 6
**Explanation:** [1,1,1,0,0,**1,1,1,1,1,1**]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
*Các số in đậm đã được lật từ 0 sang 1. Dãy con dài nhất được gạch chân.*

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
**Output:** 10
**Explanation:** [0,0,1,1,**1,1,1,1,1,1,1,1**,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
*Các số in đậm đã được lật từ 0 sang 1. Dãy con dài nhất được gạch chân.*

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 10^5`
*   `nums[i]` is either `0` or `1`.
*   `0 <= k <= nums.length`
