# Result for Binary Search
# *Kết quả cho bài toán Tìm kiếm Nhị phân*

## Description
## *Mô tả*

Given an array of integers `nums` which is sorted in ascending order, and an integer `target`, write a function to search `target` in `nums`. If `target` exists, then return its index. Otherwise, return `-1`.
*Cho một mảng các số nguyên `nums` được sắp xếp theo thứ tự tăng dần và một số nguyên `target`, hãy viết một hàm để tìm kiếm `target` trong `nums`. Nếu `target` tồn tại, hãy trả về chỉ số của nó. Ngược lại, trả về `-1`.*

You must write an algorithm with $O(\log n)$ runtime complexity.
*Bạn phải viết một thuật toán với độ phức tạp thời gian chạy là $O(\log n)$.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [-1,0,3,5,9,12], target = 9
**Output:** 4
**Explanation:** 9 exists in nums and its index is 4

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [-1,0,3,5,9,12], target = 2
**Output:** -1
**Explanation:** 2 does not exist in nums so return -1

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 10^4`
*   `-10^4 < nums[i], target < 10^4`
*   All the integers in `nums` are **unique**.
*   `nums` is sorted in ascending order.
