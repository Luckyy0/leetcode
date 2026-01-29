# 1497. Check If Array Pairs Are Divisible by k / Kiểm tra xem Các cặp Mảng có Chia hết cho k không

## Problem Description / Mô tả bài toán
Array `arr`. Integer `k`.
Pair elements so sum of each pair divisible by `k`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Remainder Frequency Map
Compute remainder `x % k` (handle negative: `(x % k + k) % k`).
Count frequencies of each remainder.
Conditions:
- Count of remainder 0 must be even.
- Count of remainder `r` must equal count of `k - r`. (for `r > 0` and `r != k-r`).
- If `k` is even, count of `k/2` must be even.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(K) or O(N).

---

## Analysis / Phân tích

### Approach: Frequency Array
Use array `freq[k]` to count remainders.
Iterate `arr`, compute remainder, update frequency.
Check conditions:
- `freq[0] % 2 == 0`.
- For `i` from 1 to `k/2`:
  `freq[i] == freq[k-i]`.
Lặp lại `arr`, tính toán phần dư, cập nhật tần suất.
Kiểm tra các điều kiện.

---
