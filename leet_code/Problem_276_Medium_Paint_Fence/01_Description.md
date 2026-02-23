# Result for Paint Fence
# *Kết quả cho bài toán Sơn hàng rào*

## Description
## *Mô tả*

You are painting a fence of `n` posts with `k` different colors. You must paint the posts following these rules:
*   Every post must be painted exactly one color.
*   There cannot be three or more consecutive posts with the same color.

Given the two integers `n` and `k`, return *the number of ways you can paint the fence*.
*Bạn đang sơn một hàng rào gồm `n` trụ bằng `k` màu khác nhau. Bạn phải sơn các trụ theo các quy tắc sau:*
*   *Mỗi trụ phải được sơn chính xác một màu.*
*   *Không được có ba hoặc nhiều trụ liên tiếp có cùng màu.*

*Cho hai số nguyên `n` và `k`, hãy trả về *số cách bạn có thể sơn hàng rào*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `n = 3, k = 2`
**Output:** `6`
**Explanation:** All the possibilities are shown.
Note that painting all the posts red or all the posts green is invalid because there cannot be three posts in a row with the same color.

## Example 2:
## *Ví dụ 2:*

**Input:** `n = 1, k = 1`
**Output:** `1`

## Example 3:
## *Ví dụ 3:*

**Input:** `n = 7, k = 2`
**Output:** `42`

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 50`
*   `1 <= k <= 10^5`
*   The testcases are generated such that the answer is in the range of a 32-bit integer.
