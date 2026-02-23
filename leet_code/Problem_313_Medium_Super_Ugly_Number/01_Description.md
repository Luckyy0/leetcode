# Result for Super Ugly Number
# *Kết quả cho bài toán Số Siêu Xấu*

## Description
## *Mô tả*

A **super ugly number** is a positive integer whose prime factors are in the array `primes`.
*Một **số siêu xấu** là một số nguyên dương có các thừa số nguyên tố nằm trong mảng `primes`.*

Given an integer `n` and an array of integers `primes`, return *the* `n^th` *super ugly number*.
*Cho một số nguyên `n` và một mảng các số nguyên `primes`, trả về *số siêu xấu thứ* `n`.*

The `n^th` super ugly number is guaranteed to fit in a **32-bit** signed integer.
*Số siêu xấu thứ `n` được đảm bảo nằm trong một số nguyên có dấu **32-bit**.*

## Example 1:
## *Ví dụ 1:*

**Input:** `n = 12, primes = [2,7,13,19]`
**Output:** `32`
**Explanation:** [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12 super ugly numbers given primes = [2,7,13,19].

## Example 2:
## *Ví dụ 2:*

**Input:** `n = 1, primes = [2,3,5]`
**Output:** `1`
**Explanation:** 1 has no prime factors, therefore all of its prime factors are in the array primes = [2,3,5].

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 10^5`
*   `1 <= primes.length <= 100`
*   `2 <= primes[i] <= 1000`
*   `primes[i]` is **guaranteed** to be a prime number.
*   All the values of `primes` are **unique** and sorted in **ascending order**.
