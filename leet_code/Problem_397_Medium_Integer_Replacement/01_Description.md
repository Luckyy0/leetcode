# Result for Integer Replacement
# *Kết quả cho bài toán Thay thế Số nguyên*

## Description
## *Mô tả*

Given a positive integer `n`, you can apply one of the following operations:
*Cho một số nguyên dương `n`, bạn có thể áp dụng một trong các thao tác sau:*

1. If `n` is even, replace `n` with `n / 2`.
2. If `n` is odd, replace `n` with either `n + 1` or `n - 1`.
*1. Nếu `n` là số chẵn, hãy thay thế `n` bằng `n / 2`.*
*2. Nếu `n` là số lẻ, hãy thay thế `n` bằng `n + 1` hoặc `n - 1`.*

Return *the minimum number of operations needed for `n` to become `1`*.
*Trả về *số lượng thao tác tối thiểu cần thiết để `n` trở thành `1`*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `n = 8`
**Output:** `3`
**Explanation:** 8 -> 4 -> 2 -> 1

## Example 2:
## *Ví dụ 2:*

**Input:** `n = 7`
**Output:** `4`
**Explanation:** 7 -> 8 -> 4 -> 2 -> 1 or 7 -> 6 -> 3 -> 2 -> 1

## Example 3:
## *Ví dụ 3:*

**Input:** `n = 4`
**Output:** `2`

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 2^31 - 1`
