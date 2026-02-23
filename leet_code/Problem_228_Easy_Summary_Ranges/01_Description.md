# Result for Summary Ranges
# *Kết quả cho bài toán Tóm tắt phạm vi*

## Description
## *Mô tả*

You are given a **sorted unique** integer array `nums`.
*Bạn được cung cấp một mảng số nguyên **đã sắp xếp và duy nhất** `nums`.*

A **range** `[a,b]` is the set of all integers from `a` to `b` (inclusive).
*Một **phạm vi** `[a,b]` là tập hợp tất cả các số nguyên từ `a` đến `b` (bao gồm cả a và b).*

Return *the smallest sorted list of ranges that cover all the numbers in the array exactly*. That is, each element of `nums` is covered by exactly one of the ranges, and there is no integer `x` such that `x` is in one of the ranges but not in `nums`.
*Trả về *danh sách nhỏ nhất các phạm vi được sắp xếp bao phủ chính xác tất cả các số trong mảng*. Nghĩa là, mỗi phần tử của `nums` được bao phủ bởi chính xác một trong các phạm vi, và không có số nguyên `x` nào sao cho `x` nằm trong một trong các phạm vi nhưng không có trong `nums`.*

Each range `[a,b]` in the list should be output as:
*Mỗi phạm vi `[a,b]` trong danh sách nên được xuất ra dưới dạng:*

*   `"a->b"` if `a != b`
*   `"a"` if `a == b`

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [0,1,2,4,5,7]`
**Output:** `["0->2","4->5","7"]`
**Explanation:** The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [0,2,3,4,6,8,9]`
**Output:** `["0","2->4","6","8->9"]`
**Explanation:** The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"

## Constraints:
## *Ràng buộc:*

*   `0 <= nums.length <= 20`
*   `-2^31 <= nums[i] <= 2^31 - 1`
*   All the values of `nums` are **unique**.
*   `nums` is sorted in ascending order.
