# Result for Preimage Size of Factorial Zeroes Function
# *Kết quả cho bài toán Kích thước Nghịch ảnh của Hàm Số 0 Giai thừa*

## Description
## *Mô tả*

Let `f(x)` be the number of zeroes at the end of `x!`. (Recall that `x! = 1 * 2 * ... * x`, and by convention, `0! = 1`.)
*Gọi `f(x)` là số lượng chữ số 0 ở cuối của `x!`. (Nhắc lại rằng `x! = 1 * 2 * ... * x`, và theo quy ước, `0! = 1`.)*

*   For example, `f(3) = 0` because `3! = 6` has no trailing zeroes, `f(5) = 1` because `5! = 120` has one trailing zero, and `f(10) = 2` because `10! = 3628800` has two trailing zeroes.
*   *Ví dụ, `f(3) = 0` vì `3! = 6` không có số 0 cuối, `f(5) = 1` vì `5! = 120` có một số 0 cuối, và `f(10) = 2` vì `10! = 3628800` có hai số 0 cuối.*

Given an integer `k`, return the number of non-negative integers `x` have the property that `f(x) = k`.
*Cho một số nguyên `k`, trả về số lượng các số nguyên không âm `x` có tính chất `f(x) = k`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** k = 0
**Output:** 5
**Explanation:** 0!, 1!, 2!, 3!, and 4! all have 0 trailing zeroes.

## Example 2:
## *Ví dụ 2:*

**Input:** k = 5
**Output:** 0
**Explanation:** There is no x such that x! ends in 5 zeroes.

## Example 3:
## *Ví dụ 3:*

**Input:** k = 3
**Output:** 5
**Explanation:** 15!, 16!, 17!, 18!, 19! have 3 trailing zeroes.

---

## Constraints:
## *Ràng buộc:*

*   `0 <= k <= 10^9`
