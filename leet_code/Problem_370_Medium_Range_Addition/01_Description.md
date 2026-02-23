# Result for Range Addition
# *Kết quả cho bài toán Cộng dồn Khoảng*

## Description
## *Mô tả*

You are given an integer `length` and an 2D array `updates` where `updates[i] = [starti, endi, inci]`.
*Cho một số nguyên `length` và một mảng 2 chiều `updates` trong đó `updates[i] = [starti, endi, inci]`.*

You have an array `arr` of length `length` with all zeros, and you have to apply each update on `arr`.
*Bạn có một mảng `arr` độ dài `length` gồm toàn số không, và bạn phải áp dụng mỗi lệnh cập nhật lên `arr`.*

For each update `i`, increment `arr[starti...endi]` by `inci`.
*Với mỗi lệnh cập nhật `i`, hãy tăng giá trị `arr[starti...endi]` thêm `inci`.*

Return *the modified array after all `updates` have been applied*.
*Trả về *mảng đã được sửa đổi sau khi tất cả các lệnh cập nhật đã được áp dụng*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]`
**Output:** `[-2,0,3,5,3]`

## Example 2:
## *Ví dụ 2:*

**Input:** `length = 10, updates = [[2,4,6],[5,6,8],[1,9,-4]]`
**Output:** `[0,-4,2,2,2,4,4,-4,-4,-4]`

## Constraints:
## *Ràng buộc:*

*   `1 <= length <= 10^5`
*   `0 <= updates.length <= 10^4`
*   `0 <= starti <= endi < length`
*   `-1000 <= inci <= 1000`
