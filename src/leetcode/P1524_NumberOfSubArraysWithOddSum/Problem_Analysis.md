# 1524. Number of Sub-arrays With Odd Sum / Số lượng Mảng con có Tổng Lẻ

## Problem Description / Mô tả bài toán
Array `arr`. Count subarrays with odd sum. Modulo 10^9 + 7.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Prefix Sum Parity
Subarray sum `arr[i...j] = prefix[j+1] - prefix[i]`.
Odd sum if `prefix[j+1]` and `prefix[i]` have different parity.
Iterate array. Track count of Even prefixes and Odd prefixes encountered so far.
If current prefix is odd: add `countEven` to result. `countOdd++`.
If current prefix is even: add `countOdd` to result. `countEven++`.
Init: `countEven = 1` (prefix 0 is even).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Prefix Count
Iterate. Update `curSum` parity. Update result.
Lặp lại. Cập nhật tính chẵn lẻ `curSum`. Cập nhật kết quả.

---
