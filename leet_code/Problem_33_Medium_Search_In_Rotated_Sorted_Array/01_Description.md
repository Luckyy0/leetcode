# Result for Search in Rotated Sorted Array
# *Kết quả cho bài toán Tìm Kiếm trong Mảng Đã Sắp Xếp Dịch Chuyển*

## Description
## *Mô tả*

There is an integer array `nums` sorted in ascending order (with **distinct** values). Use `nums` which has been rotated at an unknown pivot index `k` (`0 <= k < nums.length`) such that the resulting array is `[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]`.
*Có một mảng số nguyên `nums` được sắp xếp theo thứ tự tăng dần (với các giá trị **phân biệt**). `nums` đã được xoay tại một chỉ số `k` không xác định (`0 <= k < nums.length`) sao cho mảng kết quả là `[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]`.*

Given the array `nums` after the possible rotation and an integer `target`, return the index of `target` if it is in `nums`, or `-1` if it is not in `nums`.
*Cho mảng `nums` sau khi có thể đã xoay và một số nguyên `target`, trả về chỉ số của `target` nếu nó ở trong `nums`, hoặc `-1` nếu nó không ở trong `nums`.*

You must write an algorithm with `O(log n)` runtime complexity.
*Bạn phải viết một thuật toán với độ phức tạp thời gian `O(log n)`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [4,5,6,7,0,1,2]`, `target = 0`
**Output:** `4`

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [4,5,6,7,0,1,2]`, `target = 3`
**Output:** `-1`

## Example 3:
## *Ví dụ 3:*

**Input:** `nums = [1]`, `target = 0`
**Output:** `-1`

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 5000`
*   `-10^4 <= nums[i] <= 10^4`
*   All values of `nums` are **unique**.
*   `nums` is an ascending array that is possibly rotated.
*   `-10^4 <= target <= 10^4`
