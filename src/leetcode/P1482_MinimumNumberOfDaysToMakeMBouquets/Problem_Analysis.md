# 1482. Minimum Number of Days to Make m Bouquets / Số Ngày Tối thiểu để Làm m Bó hoa

## Problem Description / Mô tả bài toán
Array `bloomDay`. `m` bouquets. `k` adjacent flowers per bouquet.
Flowers contiguous.
Find min days to wait so check can happen.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Binary Search on Answer
Range of days: `min(bloomDay)` to `max(bloomDay)`.
Check function `canMake(day)`:
Iterate array. If `bloomDay[i] <= day`, flower blooms.
Count consecutive blooming flowers.
If `count == k`: `bouquets++`, `count = 0`.
Return `bouquets >= m`.

### Complexity / Độ phức tạp
- **Time**: O(N log(MaxDay)).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Binary Search
Check boundary: if `m * k > n`, impossible (-1).
Binary search `day`. Lower bound.
`canMake` takes O(N).
Kiểm tra biên: nếu `m * k > n`, không thể (-1).
Tìm kiếm nhị phân `day`.

---
