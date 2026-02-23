# Result for Shortest Unsorted Continuous Subarray
# *Kết quả cho bài toán Mảng con Liên tục Ngắn nhất chưa sắp xếp*

## Description
## *Mô tả*

Given an integer array `nums`, you need to find one **continuous subarray** such that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.
*Cho một mảng số nguyên `nums`, bạn cần tìm một **mảng con liên tiếp** sao cho nếu bạn chỉ sắp xếp mảng con này theo thứ tự tăng dần, thì toàn bộ mảng sẽ được sắp xếp theo thứ tự tăng dần.*

Return the shortest such subarray's length.
*Trả về độ dài của mảng con ngắn nhất như vậy.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [2,6,4,8,10,9,15]
**Output:** 5
**Explanation:** You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [1,2,3,4]
**Output:** 0

## Example 3:
## *Ví dụ 3:*

**Input:** nums = [1]
**Output:** 0

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 104`
*   `-105 <= nums[i] <= 105`
