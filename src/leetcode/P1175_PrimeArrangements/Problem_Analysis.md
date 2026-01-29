# 1175. Prime Arrangements / Sắp xếp Nguyên tố

## Problem Description / Mô tả bài toán
Return the number of permutations of 1 to `n` so that prime numbers are at prime indices (1-indexed). Modulo `10^9 + 7`.
Trả về số lượng hoán vị của 1 đến `n` sao cho các số nguyên tố ở các chỉ số nguyên tố (chỉ số bắt đầu từ 1). Modulo `10^9 + 7`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Counting Primes / Combinatorics / Đếm số Nguyên tố / Tổ hợp
Count primes up to `n`: `P`.
Non-primes (composites + 1): `C = n - P`.
We have `P` prime numbers and `P` prime indices.
We have `C` non-prime numbers and `C` non-prime indices.
Ways = `P! * C! % MOD`.

### Complexity / Độ phức tạp
- **Time**: O(N log log N) or O(NsqrtN) to find primes. Calculation O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Permutation Layout
Identify the number of prime numbers ($P$) and non-prime numbers ($N-P$) in the range $[1, N]$. Since prime numbers must occupy prime indices (and there are exactly $P$ such indices), we can arrange the primes in $P!$ ways and the non-primes in $(N-P)!$ ways. The total number of valid permutations is $P! \times (N-P)!$.
Xác định số lượng số nguyên tố ($P$) và số không phải nguyên tố ($N-P$) trong phạm vi $[1, N]$. Vì các số nguyên tố phải chiếm các chỉ số nguyên tố (và có chính xác $P$ chỉ số như vậy), chúng ta có thể sắp xếp các số nguyên tố theo $P!$ cách và các số không phải nguyên tố theo $(N-P)!$ cách. Tổng số hoán vị hợp lệ là $P! \times (N-P)!$.

---
