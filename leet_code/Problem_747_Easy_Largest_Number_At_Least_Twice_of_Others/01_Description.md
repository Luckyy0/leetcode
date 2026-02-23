# Result for Largest Number At Least Twice of Others
# *Kết quả cho bài toán Số Lớn nhất Gấp Ít nhất Hai lần Các Số Khác*

## Description
## *Mô tả*

You are given an integer array `nums` where the largest integer is **unique**.
*Bạn được cho một mảng số nguyên `nums` trong đó số lớn nhất là **duy nhất**.*

Determine whether the largest element in the array is **at least twice** as much as every other number in the array. If it is, return *the index of the largest element*, or return `-1` otherwise.
*Hãy xác định xem phần tử lớn nhất trong mảng có **lớn gấp ít nhất hai lần** so với mọi số khác trong mảng hay không. Nếu có, trả về *chỉ số của phần tử lớn nhất*, ngược lại trả về `-1`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [3,6,1,0]
**Output:** 1
**Explanation:** 6 is the largest integer.
For every other number in the array x, 6 is at least twice as big as x.
The index of value 6 is 1, so we return 1.

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [1,2,3,4]
**Output:** -1
**Explanation:** 4 is not at least as big as twice the value of 3, so we return -1.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 50`
*   `0 <= nums[i] <= 100`
*   The largest element in `nums` is unique.
