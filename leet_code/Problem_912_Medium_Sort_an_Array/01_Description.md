# Result for Sort an Array
# *Kết quả cho bài toán Sắp xếp Mảng*

## Description
## *Mô tả*

Given an array of integers `nums`, sort the array in ascending order and return it.
*Cho một mảng số nguyên `nums`, hãy sắp xếp mảng theo thứ tự tăng dần và trả về nó.*

You must solve the problem **without using any built-in functions** in `O(nlog(n))` time complexity and with the smallest space complexity possible.
*Bạn phải giải quyết bài toán **mà không sử dụng bất kỳ hàm tích hợp sẵn nào** với độ phức tạp thời gian `O(nlog(n))` và độ phức tạp không gian nhỏ nhất có thể.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [5,2,3,1]
**Output:** [1,2,3,5]
**Explanation:** After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [5,1,1,2,0,0]
**Output:** [0,0,1,1,2,5]
**Explanation:** Note that the values of nums are not necessairly unique.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 5 * 10^4`
*   `-5 * 10^4 <= nums[i] <= 5 * 10^4`
