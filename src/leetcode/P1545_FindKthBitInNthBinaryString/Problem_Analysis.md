# 1545. Find Kth Bit in Nth Binary String / Tìm Bit thứ K trong Chuỗi Nhị phân thứ N

## Problem Description / Mô tả bài toán
Sequence:
S1 = "0"
Si = S(i-1) + "1" + reverse(invert(S(i-1))).
Find k-th bit in Sn.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Recursive Structure
Length of `Si` is $L_i = 2^{i} - 1$.
Mid of `Si` is at $2^{i-1}$.
Bit at mid is always '1'.
Left part is `Si-1`.
Right part is `reverse(invert(Si-1))`.
To find `find(n, k)`:
Mid index `mid = (len + 1) / 2`.
If `k == mid`, return '1'.
If `k < mid`, return `find(n-1, k)`.
If `k > mid`, find corresponding index in `Si-1`: `newK = len - k + 1`. (Due to reverse).
And invert the result. `return invert(find(n-1, newK))`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Recursive
Base case `n=1`, return '0'.
Len `2^n - 1`. Mid `2^(n-1)`.
Check regions.
Cơ sở `n=1`, trả về '0'.
Len `2^n - 1`. Mid `2^(n-1)`.
Kiểm tra các vùng.

---
