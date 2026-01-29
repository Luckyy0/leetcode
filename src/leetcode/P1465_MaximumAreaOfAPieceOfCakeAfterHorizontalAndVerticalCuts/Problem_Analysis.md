# 1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts / Diện tích Tối đa của một Miếng Bánh sau khi Cắt Dọc và Ngang

## Problem Description / Mô tả bài toán
Grid `h x w`. Cuts `horizontalCuts`, `verticalCuts`.
Return max area of piece mod 10^9 + 7.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sort and Max Gap
Area = `height * width`.
Piece `height` determined by adjacent horizontal cuts (or borders).
Piece `width` determined by adjacent vertical cuts (or borders).
Max Area = (Max Height Gap) * (Max Width Gap).
Include `0` and `h`/`w` in cuts.
Sort cuts. Find max difference.

### Complexity / Độ phức tạp
- **Time**: O(H log H + V log V).
- **Space**: O(1) or O(H+V) for copy.

---

## Analysis / Phân tích

### Approach: Max Difference
Add 0 and h to horizontal cuts. Sort. Compute max difference `maxH`.
Add 0 and w to vertical cuts. Sort. Compute max difference `maxW`.
`Result = (long) maxH * maxW % MOD`.
Thêm 0 và h vào các phần cắt ngang. Sắp xếp. Tính toán chênh lệch tối đa `maxH`.
Thêm 0 và w vào các phần cắt dọc. Sắp xếp. Tính toán chênh lệch tối đa `maxW`.
Kết quả = `(long) maxH * maxW % MOD`.

---
