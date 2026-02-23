# Result for Rotated Digits
# *Kết quả cho bài toán Các chữ số Xoay*

## Description
## *Mô tả*

An integer `x` is a **good** if after rotating each digit individually by 180 degrees, we get a valid number that is different from `x`. Each digit must be rotated - we cannot choose to leave it alone.
*Một số nguyên `x` là **tốt** nếu sau khi xoay từng chữ số 180 độ, chúng ta nhận được một số hợp lệ khác với `x`. Mỗi chữ số phải được xoay - chúng ta không thể chọn giữ nguyên nó.*

A number is valid if each digit remains a digit after rotation. `0`, `1`, and `8` rotate to themselves; `2` and `5` rotate to each other (in this specific problem definition, or similar logic); `6` and `9` rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.
*Một số là hợp lệ nếu mỗi chữ số vẫn là một chữ số sau khi xoay. `0`, `1`, và `8` xoay thành chính nó; `2` và `5` xoay thành nhau; `6` và `9` xoay thành nhau, và các số còn lại không xoay thành số nào khác và trở thành không hợp lệ.*
Note: The problem implies standard 7-segment display logic usually.
Rotation rules:
0 -> 0 (Same)
1 -> 1 (Same)
8 -> 8 (Same)
2 -> 5 (Different)
5 -> 2 (Different)
6 -> 9 (Different)
9 -> 6 (Different)
3, 4, 7 -> Invalid

Given an integer `n`, return *the number of **good** integers in the range* `[1, n]`.
*Cho một số nguyên `n`, trả về *số lượng số nguyên **tốt** trong khoảng* `[1, n]`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** n = 10
**Output:** 4
**Explanation:**
There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.

## Example 2:
## *Ví dụ 2:*

**Input:** n = 1
**Output:** 0

## Example 3:
## *Ví dụ 3:*

**Input:** n = 2
**Output:** 1

---

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 10000`
