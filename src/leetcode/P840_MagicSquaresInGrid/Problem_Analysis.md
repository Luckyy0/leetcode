# 840. Magic Squares In Grid / Hình vuông Ma thuật trong Lưới

## Problem Description / Mô tả bài toán
A `3 x 3` magic square is a `3 x 3` grid filled with distinct numbers from `1` to `9` such that each row, column, and both diagonals have the same sum (15).
Hình vuông ma thuật `3 x 3` là một lưới `3 x 3` được lấp đầy bởi các số phân biệt từ `1` đến `9` sao cho mỗi hàng, cột và cả hai đường chéo đều có cùng tổng (15).

Given an `n x m` grid, return the number of magic square subgrids.
Cho một lưới `n x m`, trả về số lượng các khung lưới con là hình vuông ma thuật.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Brute Force with Property Check / Duyệt toàn bộ với Kiểm tra Thuộc tính
Iterate through all possible `3 x 3` top-left corners.
Duyệt qua tất cả các góc trên bên trái của hình vuông `3x3` có thể.

Algorithm:
1. For each `(r, c)` from `(0, 0)` to `(n-3, m-3)`:
   - Check if the 9 cells contain all numbers from 1 to 9.
   - Check if rows sum to 15.
   - Check if columns sum to 15.
   - Check if diagonals sum to 15.

Crucial optimization:
- The center element of a 3x3 magic square must be 5.
Phần tử trung tâm của hình vuông ma thuật 3x3 phải là 5.

### Complexity / Độ phức tạp
- **Time**: O(R * C * 9) -> O(R * C).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Systematic Subgrid Validation
Apply the magic square constraints to every possible window. By checking the center value first, we can skip many invalid subgrids immediately.
Áp dụng các ràng buộc hình vuông ma thuật cho mọi cửa sổ có thể. Bằng cách kiểm tra giá trị trung tâm trước, chúng ta có thể bỏ qua nhiều lưới con không hợp lệ ngay lập tức.

---
