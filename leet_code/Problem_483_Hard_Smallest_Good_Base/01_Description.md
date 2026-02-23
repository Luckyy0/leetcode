# Result for Smallest Good Base
# *Kết quả cho bài toán Cơ số Tốt Nhỏ nhất*

## Description
## *Mô tả*

Given an integer `n` represented as a string, return *the smallest **good base** of* `n`.
*Cho một số nguyên `n` được biểu diễn dưới dạng chuỗi, hãy trả về *cơ số tốt **nhỏ nhất** của* `n`.*

We call `k >= 2` a **good base** of `n`, if all digits of `n` base `k` are `1`.
*Chúng ta gọi `k >= 2` là một **cơ số tốt** của `n`, nếu tất cả các chữ số của `n` trong hệ cơ số `k` đều là `1`.*

For example, `13` base `3` is `111` and base `12` is `1`, so `3` and `12` are good bases. Note that `1` is the only representation of `n` in base `n`, but the problem asks for base `k >= 2` such that representation is `11...1`. Wait, base `12` of `13` is `11`.
*Ví dụ, `13` hệ `3` là `111` và hệ `12` là `11`, vì vậy `3` và `12` là các cơ số tốt.*

## Example 1:
## *Ví dụ 1:*

**Input:** `n = "13"`
**Output:** `"3"`
**Explanation:** 13 base 3 is 111.

## Example 2:
## *Ví dụ 2:*

**Input:** `n = "4681"`
**Output:** `"8"`
**Explanation:** 4681 base 8 is 11111.

## Example 3:
## *Ví dụ 3:*

**Input:** `n = "1000000000000000000"`
**Output:** `"999999999999999999"`
**Explanation:** n base n-1 is always 11.

## Constraints:
## *Ràng buộc:*

*   `n` is an integer in the range `[3, 10^18]`.
*   `n` does not contain any leading zeros.
