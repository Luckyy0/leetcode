# Result for Find First and Last Position of Element in Sorted Array
# *Kết quả cho bài toán Tìm Vị Trí Đầu Tiên và Cuối Cùng của Phần Tử trong Mảng Đã Sắp Xếp*

## Description
## *Mô tả*

Given an array of integers `nums` sorted in non-decreasing order, find the starting and ending position of a given `target` value.
*Cho một mảng số nguyên `nums` được sắp xếp theo thứ tự không giảm, hãy tìm vị trí bắt đầu và kết thúc của một giá trị `target` cho trước.*

If `target` is not found in the array, return `[-1, -1]`.
*Nếu `target` không được tìm thấy trong mảng, trả về `[-1, -1]`.*

You must write an algorithm with `O(log n)` runtime complexity.
*Bạn phải viết một thuật toán với độ phức tạp thời gian `O(log n)`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [5,7,7,8,8,10]`, `target = 8`
**Output:** `[3,4]`

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [5,7,7,8,8,10]`, `target = 6`
**Output:** `[-1,-1]`

## Example 3:
## *Ví dụ 3:*

**Input:** `nums = []`, `target = 0`
**Output:** `[-1,-1]`

## Constraints:
## *Ràng buộc:*

*   `0 <= nums.length <= 10^5`
*   `-10^9 <= nums[i] <= 10^9`
*   `nums` is a non-decreasing array.
*   `-10^9 <= target <= 10^9`
