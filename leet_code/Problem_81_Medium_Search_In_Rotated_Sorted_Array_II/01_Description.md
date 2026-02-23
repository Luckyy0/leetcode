# Result for Search in Rotated Sorted Array II
# *Kết quả cho bài toán Tìm Kiếm Trong Mảng Được Xoay Đã Sắp Xếp II*

## Description
## *Mô tả*

There is an integer array `nums` sorted in non-decreasing order (not necessarily with **distinct** values).
*Có một mảng số nguyên `nums` được sắp xếp theo thứ tự không giảm (không nhất thiết phải có các giá trị **phân biệt**).*

Before being passed to your function, `nums` is **rotated** at an unknown pivot index `k` (`0 <= k < nums.length`) such that the resulting array is `[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]` (**0-indexed**). For example, `[0,1,2,4,4,4,5,6,6,7]` might be rotated at pivot index `5` and become `[4,5,6,6,7,0,1,2,4,4]`.
*Trước khi được truyền vào hàm của bạn, `nums` bị **xoay** tại một chỉ số xoay không xác định `k` (`0 <= k < nums.length`) sao cho mảng kết quả là `[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]` (tính từ chỉ số **0**). Ví dụ, `[0,1,2,4,4,4,5,6,6,7]` có thể bị xoay tại chỉ số xoay `5` và trở thành `[4,5,6,6,7,0,1,2,4,4]`.*

Given the array `nums` **after** the rotation and an integer `target`, return `true` *if `target` is in `nums`, or `false` if it is not in `nums`*.
*Cho mảng `nums` **sau khi** bị xoay và một số nguyên `target`, trả về `true` *nếu `target` nằm trong `nums`, ngược lại trả về `false`**.*

You must decrease the overall operation steps as much as possible.
*Bạn phải giảm bớt các bước thực hiện thao tác tổng thể càng nhiều càng tốt.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [2,5,6,0,0,1,2], target = 0`
**Output:** `true`

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [2,5,6,0,0,1,2], target = 3`
**Output:** `false`

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 5000`
*   `-10^4 <= nums[i] <= 10^4`
*   `nums` is guaranteed to be rotated at some pivot.
*   `-10^4 <= target <= 10^4`

## Follow up:
*   This problem is similar to **Search in Rotated Sorted Array**, but `nums` may contain **duplicates**.
*   Would this affect the runtime complexity? How and why?
