# Result for Total Hamming Distance
# *Kết quả cho bài toán Tổng Khoảng cách Hamming*

## Description
## *Mô tả*

The [Hamming distance](https://en.wikipedia.org/wiki/Hamming_distance) between two integers is the number of positions at which the corresponding bits are different.
*Khoảng cách Hamming giữa hai số nguyên là số vị trí mà các bit tương ứng tại đó khác nhau.*

Given an integer array `nums`, return *the sum of **Hamming distances** between all the pairs of the integers in* `nums`.
*Cho một mảng số nguyên `nums`, hãy trả về *tổng **khoảng cách Hamming** giữa tất cả các cặp số nguyên trong* `nums`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [4,14,2]`
**Output:** `6`
**Explanation:** In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case).
The answer will be:
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [4,14,4]`
**Output:** `4`

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 10^4`
*   `0 <= nums[i] <= 10^9`
*   The answer for the given input will fit in a **32-bit** integer.
