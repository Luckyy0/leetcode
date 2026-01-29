# 313. Super Ugly Number / Số Siêu Xấu

## Problem Description / Mô tả bài toán
A **super ugly number** is a positive integer whose prime factors are in the given prime list `primes`.
Một **số siêu xấu** là một số nguyên dương có các thừa số nguyên tố nằm trong danh sách số nguyên tố đã cho `primes`.

Given an integer `n` and an array of integers `primes`, return the `n-th` **super ugly number**.
Cho số nguyên `n` và mảng số nguyên `primes`, trả về số siêu xấu thứ `n`.

The `n-th` super ugly number is guaranteed to fit in a **32-bit** signed integer.

### Example 1:
```text
Input: n = 12, primes = [2,7,13,19]
Output: 32
Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12 super ugly numbers.
```

### Example 2:
```text
Input: n = 1, primes = [2,3,5]
Output: 1
```

## Constraints / Ràng buộc
- `1 <= n <= 10^5`
- `1 <= primes.length <= 100`
- `2 <= primes[i] <= 1000`
- `primes[i]` is guaranteed to be a prime number.
- All the values of `primes` are unique and sorted in ascending order.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Dynamic Programming with Multiple Pointers / Quy Hoạch Động với Nhiều Con Trỏ
Similar to Ugly Number II (2,3,5), but here with `K` primes.
We maintain `dp` array where `dp[i]` is the i-th ugly number.
We have `indices` array of size K, where `indices[j]` points to the index in `dp` that `primes[j]` should multiply next.
`next_val = min(primes[j] * dp[indices[j]])` for all `j`.
Update `indices[j]` if `primes[j] * dp[indices[j]] == next_val`.

### Complexity / Độ phức tạp
- **Time**: `O(N * K)`. With 10^5 * 100, might be 10^7. Acceptable.
- Optimization: Use Priority Queue to find min in O(log K) -> O(N log K).
  - Heap stores `(value, prime_index, index_in_dp)`.
  - Though simple loop is faster if K is small due to constant overhead of Heap. Here K <= 100.
  - O(N*K) is fine.

---

## Analysis / Phân tích

### Approach: Array Pointers

**Algorithm**:
1.  `dp` size n. `dp[0] = 1`.
2.  `idx` size primes.length, init 0.
3.  Loop `i` from 1 to n-1.
    - Find `minVal`.
    - Update `dp[i]`.
    - Loop `j` again to increment `idx[j]` if match.

---
