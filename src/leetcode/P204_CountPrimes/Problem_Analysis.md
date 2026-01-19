# 204. Count Primes / Đếm Số Nguyên Tố

## Problem Description / Mô tả bài toán
Given an integer `n`, return the number of prime numbers that are strictly less than `n`.
Cho một số nguyên `n`, hãy trả về số lượng số nguyên tố nhỏ hơn hẳn `n`.

### Example 1:
```text
Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
```

### Example 2:
```text
Input: n = 0
Output: 0
```

### Example 3:
```text
Input: n = 1
Output: 0
```

## Constraints / Ràng buộc
- `0 <= n <= 5 * 10^6`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Sieve of Eratosthenes / Sàng Eratosthenes
This is an ancient and efficient algorithm for finding all prime numbers up to a specified integer.
 đây là một thuật toán cổ xưa và hiệu quả để tìm tất cả các số nguyên tố lên đến một số nguyên nhất định.

**Logic**:
1.  Create a boolean array `isPrime[0...n-1]`, initialize all entries to `true`.
2.  Mark `0` and `1` as `false` (not prime).
3.  Iterate from `p = 2` up to `sqrt(n)`.
4.  If `isPrime[p]` is true, then it is a prime.
5.  Mark all multiples of `p` starting from `p*p` as `false`.
    - We start from `p*p` because smaller multiples `p*k` (where `k < p`) would have already been marked by the prime factor `k`.
6.  Finally, count the `true` values in the array.

---

## Analysis / Phân tích

### Approach: Sieve of Eratosthenes

**Complexity / Độ phức tạp**:
- **Time**: O(N * log(log N)) - standard complexity of the Sieve.
- **Space**: O(N) - for the boolean array.

---

## Edge Cases / Các trường hợp biên
1.  **n <= 2**: Returns 0 (no primes < 2).
2.  **Large n**: The algorithm is efficient enough for `5 * 10^6`.
