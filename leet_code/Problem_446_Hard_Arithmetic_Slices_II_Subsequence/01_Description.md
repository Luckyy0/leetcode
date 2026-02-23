# Result for Arithmetic Slices II - Subsequence
# *Kết quả cho bài toán Lát cắt Cấp số cộng II - Dãy con*

## Description
## *Mô tả*

Given an integer array `nums`, return *the number of all the **arithmetic subsequences** of `nums`*.
*Cho một mảng số nguyên `nums`, hãy trả về *số lượng tất cả các **dãy con cấp số cộng** của `nums`***.*

A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
*Một dãy số được gọi là cấp số cộng nếu nó bao gồm ít nhất ba phần tử và nếu hiệu giữa hai phần tử liên tiếp bất kỳ là giống nhau.*

A **subsequence** of an array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements.
*Một **dãy con** của một mảng là một dãy có thể được rút ra từ mảng bằng cách xóa đi một số hoặc không phần tử nào mà không làm thay đổi thứ tự của các phần tử còn lại.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [2,4,6,8,10]`
**Output:** `7`
**Explanation:** All arithmetic subsequences are:
[2,4,6]
[4,6,8]
[6,8,10]
[2,4,6,8]
[4,6,8,10]
[2,4,6,8,10]
[2,6,10]

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [7,7,7,7,7]`
**Output:** `16`
**Explanation:** Any subsequence of this array is arithmetic.

## Constraints:
## *Ràng buộc:*

*   `1  <= nums.length <= 1000`
*   `-2^{31} <= nums[i] <= 2^{31} - 1`
