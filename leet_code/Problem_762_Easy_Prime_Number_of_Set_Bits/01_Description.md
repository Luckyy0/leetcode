# Result for Prime Number of Set Bits in Binary Representation
# *Kết quả cho bài toán Số lượng Bit Set là Số Nguyên tố trong Biểu diễn Nhị phân*

## Description
## *Mô tả*

Given two integers `left` and `right`, return *the count of numbers in the inclusive range `[left, right]` having a **prime number of set bits** in their binary representation*.
*Cho hai số nguyên `left` và `right`, hãy trả về *số lượng các số trong phạm vi bao gồm `[left, right]` có **số lượng bit 1 (bit set) là một số nguyên tố** trong biểu diễn nhị phân của chúng*.*

Recall that the **number of set bits** an integer has is the number of `1`s present when written in binary.
*Nhớ lại rằng **số lượng bit set** mà một số nguyên có là số lượng số `1` hiện diện khi viết dưới dạng nhị phân.*

For example, `21` written in binary is `10101`, which has `3` set bits.
*Ví dụ, `21` viết dưới dạng nhị phân là `10101`, có `3` bit set.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** left = 6, right = 10
**Output:** 4
**Explanation:**
6  -> 110 (2 bits, prime)
7  -> 111 (3 bits, prime)
8  -> 1000 (1 bit, not prime)
9  -> 1001 (2 bits, prime)
10 -> 1010 (2 bits, prime)
4 numbers have a prime number of set bits: 6, 7, 9, 10.

## Example 2:
## *Ví dụ 2:*

**Input:** left = 10, right = 15
**Output:** 5
**Explanation:**
10 -> 1010 (2 bits, prime)
11 -> 1011 (3 bits, prime)
12 -> 1100 (2 bits, prime)
13 -> 1101 (3 bits, prime)
14 -> 1110 (3 bits, prime)
15 -> 1111 (4 bits, not prime)
5 numbers have a prime number of set bits: 10, 11, 12, 13, 14.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= left <= right <= 10^6`
*   `0 <= right - left <= 10^4`
