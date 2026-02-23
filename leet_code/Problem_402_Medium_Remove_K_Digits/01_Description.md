# Result for Remove K Digits
# *Kết quả cho bài toán Xóa K Chữ số*

## Description
## *Mô tả*

Given string `num` representing a non-negative integer, and an integer `k`, return *the smallest possible integer after removing `k` digits from `num`*.
*Cho chuỗi `num` đại diện cho một số nguyên không âm và một số nguyên `k`, hãy trả về *số nguyên nhỏ nhất có thể sau khi xóa `k` chữ số khỏi `num`*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `num = "1432219", k = 3`
**Output:** `"1219"`
**Explanation:** Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

## Example 2:
## *Ví dụ 2:*

**Input:** `num = "10200", k = 1`
**Output:** `"200"`
**Explanation:** Remove the leading 1 and the number is 0200. After removing the leading zeros, it is 200.

## Example 3:
## *Ví dụ 3:*

**Input:** `num = "10", k = 2`
**Output:** `"0"`
**Explanation:** Remove all the digits from the number and it is left with nothing which is 0.

## Constraints:
## *Ràng buộc:*

*   `1 <= k <= num.length <= 10^5`
*   `num` consists of only digits.
*   `num` does not have any leading zeros except for the zero itself.
