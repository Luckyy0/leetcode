# 1442. Count Triplets That Can Form Two Arrays of Equal XOR / Đếm Bộ ba Có thể Tạo thành Hai Mảng có XOR Bằng nhau

## Problem Description / Mô tả bài toán
Array `arr`. Triplets `(i, j, k)` such that:
`a = arr[i] ^ ... ^ arr[j-1]`
`b = arr[j] ^ ... ^ arr[k]`
`a == b`.
Constraints: $0 \le i < j \le k < arr.length$.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### XOR Properties
`a == b` -> `a ^ b == 0`.
`a ^ b` represents XOR of range `arr[i...k]`.
So we need `arr[i] ^ ... ^ arr[k] == 0`.
If XOR sum from `i` to `k` is 0, then ANY `j` from `i+1` to `k` satisfies the condition.
(Because `pref[k] ^ pref[i-1] == 0` -> `pref[k] == pref[i-1]`).
For a subarray `[i, k]` with XOR sum 0, there are `k - i` valid `j` values.
Count all such pairs `(i, k)` and add `k - i` to total.

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(N) or O(1).

---

## Analysis / Phân tích

### Approach: Prefix XOR
Compute prefix XORs. `P[x] = arr[0] ^ ... ^ arr[x-1]`. `P[0] = 0`.
We want `P[k+1] ^ P[i] == 0` -> `P[k+1] == P[i]`.
Iterate `i` from 0 to `n-1`. Iterate `k` from `i+1` to `n`.
If `P[i] == P[k]`, then for subarray start `i` and end `k-1`, XOR sum is 0.
Number of triplets is `(k-1) - i`.
Wait. Indices:
Input indices `i, j, k` ($0 \le i < j \le k < n$).
`a = arr[i]...arr[j-1]`.
`b = arr[j]...arr[k]`.
This means `P[j] ^ P[i] == P[k+1] ^ P[j]`.
Actually implies `P[i] == P[k+1]`.
If `P[i] == P[k+1]`, then any `j` between `i+1` and `k` works. (`j` can be `i+1` to `k`).
Count of such `j` values is `k - (i + 1) + 1 = k - i`.
Algorithm:
Iterate pairs `(start, end)` of `P`. If `P[start] == P[end]`, add `end - start - 1`.
Wait. `P[i]` corresponds to prefix ending at `i-1`.
Indices in `P` iterate `0` to `n`.
If `P[x] == P[y]` ($x < y$), then subarray from index `x` to `y-1` has XOR sum 0.
Length `len = y - x`.
Number of splits is `len - 1` ($y - x - 1$).
Sum `y - x - 1` for all pairs `x, y` where `P[x] == P[y]`.

Tính toán các tiền tố XOR. `P[x] = arr[0] ^ ... ^ arr[x-1]`.
Nếu `P[x] == P[y]` ($x < y$), thì mảng con từ chỉ số `x` đến `y-1` có tổng XOR bằng 0.
Độ dài `len = y - x`.
Số lần chia là `len - 1` ($y - x - 1$).
Cộng tổng `y - x - 1` cho tất cả các cặp `x, y` mà `P[x] == P[y]`.

---
