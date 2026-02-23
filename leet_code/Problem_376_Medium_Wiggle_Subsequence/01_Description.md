# Result for Wiggle Subsequence
# *Kết quả cho bài toán Chuỗi con Hình sin*

## Description
## *Mô tả*

A **wiggle sequence** is a sequence where the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with one element and a sequence with two non-equal elements are trivially wiggle sequences.
*Một **chuỗi hình sin (wiggle sequence)** là một chuỗi trong đó sự khác biệt giữa các số liên tiếp xen kẽ nghiêm ngặt giữa âm và dương. Sự khác biệt đầu tiên (nếu có) có thể là dương hoặc âm. Một chuỗi có một phần tử và một chuỗi có hai phần tử không bằng nhau được coi là các chuỗi hình sin một cách hiển nhiên.*

Return *the length of the longest **wiggle subsequence** of `nums`*.
*Trả về *độ dài của **chuỗi con hình sin** dài nhất của `nums`*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [1,7,4,9,2,5]`
**Output:** `6`
**Explanation:** The entire sequence is a wiggle sequence with differences (6, -3, 5, -7, 3).

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [1,17,5,10,13,15,10,5,16,8]`
**Output:** `7`
**Explanation:** There are several wiggle subsequences with length 7. One is [1, 17, 10, 15, 10, 16, 8] with differences (16, -7, 5, -5, 6, -8).

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 1000`
*   `0 <= nums[i] <= 1000`
