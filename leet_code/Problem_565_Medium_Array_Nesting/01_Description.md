# Result for Array Nesting
# *Kết quả cho bài toán Lồng mảng*

## Description
## *Mô tả*

You are given an integer array `nums` of length `n` where `nums` is a permutation of the numbers in the range `[0, n - 1]`.
*Bạn được cho một mảng số nguyên `nums` có độ dài `n` trong đó `nums` là một hoán vị của các số trong khoảng `[0, n - 1]`.*

You should build a set `s[i] = {nums[i], nums[nums[i]], nums[nums[nums[i]]], ... }` subjected to the following rule:
*Bạn nên xây dựng một tập hợp `s[i] = {nums[i], nums[nums[i]], nums[nums[nums[i]]], ... }` tuân theo quy tắc sau:*

The first element in `s[i]` starts with the selection of the element `nums[i]` of index `i`, the next element in `s[i]` should be `nums[nums[i]]`, and then `nums[nums[nums[i]]]`, and so on, until a duplicate element occurs in `s[i]`.
*Phần tử đầu tiên trong `s[i]` bắt đầu bằng việc chọn phần tử `nums[i]` của chỉ số `i`, phần tử tiếp theo trong `s[i]` nên là `nums[nums[i]]`, và sau đó là `nums[nums[nums[i]]]`, v.v., cho đến khi một phần tử trùng lặp xuất hiện trong `s[i]`.*

Return *the longest length of a set* `s[i]` *from all possible choices of* `i`.
*Trả về *độ dài dài nhất của một tập hợp* `s[i]` *từ tất cả các lựa chọn có thể có của* `i`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [5,4,0,3,1,6,2]`
**Output:** `4`
**Explanation:** 
nums[0] = 5, nums[5] = 6, nums[6] = 2, nums[2] = 0, nums[0] = 5......
So s[0] = {5, 6, 2, 0} has length 4.

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [0,1,2]`
**Output:** `1`

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 10^5`
*   `0 <= nums[i] < nums.length`
*   All the values of `nums` are **unique**.
