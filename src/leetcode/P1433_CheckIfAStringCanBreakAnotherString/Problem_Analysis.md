# 1433. Check If a String Can Break Another String / Kiểm tra xem Chuỗi có thể Phá vỡ Chuỗi khác hay không

## Problem Description / Mô tả bài toán
Two strings `s1`, `s2` same size.
Can permute `s1` to `p1` and `s2` to `p2`.
Check if `p1` can break `p2` (all `p1[i] >= p2[i]`) OR `p2` can break `p1` (all `p2[i] >= p1[i]`).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Sorting
To maximize "break" potential:
Sort `s1` and `s2`.
Check if `sorted_s1[i] >= sorted_s2[i]` for all `i`.
Or `sorted_s2[i] >= sorted_s1[i]` for all `i`.
Why sorting works? Best way to beat smallest is with smallest? No.
To satisfy `p1[i] >= p2[i]`, we need `s1`'s elements to cover `s2`'s elements.
Sorting aligns smallest with smallest, largest with largest. If sorted doesn't work, no permutation works (proved by rearrangement inequality or Hall's Marriage Theorem concept).

### Complexity / Độ phức tạp
- **Time**: O(N log N) or O(N) with counting sort.
- **Space**: O(N) or O(1).

---

## Analysis / Phân tích

### Approach: Sort and Compare
Sort both strings. Check if one dominants the other index by index.
Sắp xếp cả hai chuỗi. Kiểm tra xem chuỗi này có chiếm ưu thế hơn chuỗi kia theo chỉ số không.

---
