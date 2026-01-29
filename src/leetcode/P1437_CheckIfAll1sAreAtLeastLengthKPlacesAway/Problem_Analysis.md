# 1437. Check If All 1's Are at Least Length K Places Away / Kiểm tra xem Tất cả Số 1 có Cách nhau Ít nhất K Khoảng hay không

## Problem Description / Mô tả bài toán
Array `nums` of 0s and 1s. `k`.
Return true if all 1s are >= k distance apart.
i.e., if `nums[i] == 1` and `nums[j] == 1` ($i < j$), then `j - i - 1 >= k` or `j - i >= k + 1`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Linear Scan
Track `prevIndex` of last seen 1. Initialize to `-1` or very small.
Iterate `i` from 0 to n-1.
If `nums[i] == 1`:
  if `prevIndex != -1` and `i - prevIndex - 1 < k`: return false.
  `prevIndex = i`.
Return true.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Track Previous Index
Iterate through the array. Keep track of the index of the previously encountered 1. If 1 is found, check distance. Update index.
Lặp lại mảng. Theo dõi chỉ số của số 1 đã gặp trước đó. Nếu tìm thấy 1, hãy kiểm tra khoảng cách. Cập nhật chỉ số.

---
