# 1191. K-Concatenation Maximum Sum / Tổng Lớn nhất K-Nối tiếp

## Problem Description / Mô tả bài toán
Given an integer array `arr` and an integer `k`, modify the array by repeating it `k` times.
Return the maximum sub-array sum in the modified array. Note that the length of the sub-array can be `0` and its sum in that case is `0`.
As the answer can be very large, return the answer modulo `10^9 + 7`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Kadane's Algorithm / Modular Arithmetic / Thuật toán Kadane / Số học Modulo
Cases:
1. `k == 1`: Normal Kadane.
2. `Sum(arr) > 0`:
   - Max sum = (Max subarray sum spanning 2 copies) + (k-2) * Sum(arr).
   - "Spanning 2 copies" basically means best prefix + best suffix.
   - Actually simpler: Max sum is `Kadane(arr + arr)` if we don't count full middles.
   - Wait. If total sum > 0, we can take all `k-2` middle copies, plus best suffix of first copy and best prefix of last copy.
   - Best suffix + best prefix = Max subarray crossing boundary of `arr+arr`.
   - So `max(Kadane(arr), Sum(arr) * (k-2) + MaxCrossSum(arr+arr))`.
   - Actually simpler: `Kadane(arr+arr)` covers cases where we just use parts of 2 copies. If we use more, we add `(k-2) * totalSum`.
3. `Sum(arr) <= 0`:
   - Max sum is just `Kadane(arr + arr)`. Why 2 copies? Because max subarray might wrap around (suffix + prefix).
   - `k > 1` effectively allows wrap around. `k=1` does not.

Algorithm:
1. If `k == 1`, return `Kadane(arr)`.
2. Compute `totalSum`.
3. Compute `maxSub2 = Kadane(arr + arr)`.
4. If `totalSum > 0`: result is `max(maxSub2, totalSum * (k - 2) + maxSub2)`.
   - Actually `totalSum * (k-2) + maxSub2` IS the logic if `maxSub2` includes the cross boundary.
   - What if `maxSub2` is just inside one array? Then providing `totalSum` helps extend it?
   - Wait. If `totalSum > 0`, taking the whole array is beneficial.
   - The max subarray will definitely include all `k-2` middle copies.
   - We need max prefix + max suffix.
   - `maxSub2` in `arr+arr` basically finds `max(maxSub, maxSuffix + maxPrefix)`.
   - So `maxSub2 + (k-2) * totalSum` is correct.
   - Careful with modulo. Max sum can be large.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N) or O(1) if simulating `arr+arr`.

---

## Analysis / Phân tích

### Approach: Kadane with K-Extension
If $k=1$, simply run Kadane's algorithm. If $k > 1$, consider the concatenation of two copies of the array. The maximum subarray sum in the fully concatenated structure is either: (1) restricted to a small local segment (found by Kadane on `arr + arr`), or (2) spans across multiple full copies if the total sum of `arr` is positive. Specifically, if `sum(arr) > 0`, we can take all intermediate $k-2$ copies plus the maximal prefix and maximal suffix (which is effectively captured by Kadane on 2 copies plus the remaining sum). Formula: `max(0, Kadane(arr + arr) + (sum > 0 ? (k-2)*sum : 0))`.
Nếu $k=1$, chỉ cần chạy thuật toán Kadane. Nếu $k > 1$, hãy xem xét việc nối hai bản sao của mảng. Tổng mảng con lớn nhất trong cấu trúc được nối đầy đủ là: (1) bị giới hạn ở một đoạn cục bộ nhỏ (được tìm thấy bởi Kadane trên `arr + arr`), hoặc (2) trải dài qua nhiều bản sao đầy đủ nếu tổng của `arr` là dương. Cụ thể, nếu `sum(arr) > 0`, chúng ta có thể lấy tất cả các bản sao trung gian $k-2$ cộng với tiền tố cực đại và hậu tố cực đại (được Kadane nắm bắt hiệu quả trên 2 bản sao cộng với tổng còn lại). Công thức: `max(0, Kadane(arr + arr) + (sum > 0 ? (k-2)*sum : 0))`.

---
