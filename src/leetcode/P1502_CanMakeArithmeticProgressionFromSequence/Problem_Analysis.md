# 1502. Can Make Arithmetic Progression From Sequence / Có thể Tạo Cấp số cộng Từ Chuỗi

## Problem Description / Mô tả bài toán
Array `arr`. Can rearrange to form AP?

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sorting
Sort. Check `diff = arr[1] - arr[0]`.
Check if `arr[i+1] - arr[i] == diff` for all `i`.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(1).
- Note: Can be O(N) using Min/Max and HashSet, but Sorting is easier.

---

## Analysis / Phân tích

### Approach: Sorting
Sort array. Iterate and check differences.
Sắp xếp mảng. Nhắc lại và kiểm tra sự khác biệt.

---
