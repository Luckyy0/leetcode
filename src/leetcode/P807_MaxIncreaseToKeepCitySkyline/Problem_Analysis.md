# 807. Max Increase to Keep City Skyline / Tăng tối đa để Giữ nguyên Đường chân trời Thành phố

## Problem Description / Mô tả bài toán
There is a city with an `n x n` grid of buildings. Each cell `(r, c)` contains the height of the building there.
Có một thành phố với một lưới tòa nhà `n x n`. Mỗi ô `(r, c)` chứa độ cao của tòa nhà tại đó.

The **skyline** of the city from the top/bottom is the maximum height in each column.
**Đường chân trời** của thành phố nhìn từ trên xuống/dưới lên là độ cao tối đa trong mỗi cột.

The **skyline** of the city from the left/right is the maximum height in each row.
**Đường chân trời** của thành phố nhìn từ trái sang/phải sang là độ cao tối đa trong mỗi hàng.

We want to increase the height of buildings as much as possible without changing the skylines. Return the maximum total increase.
Chúng ta muốn tăng độ cao của các tòa nhà nhiều nhất có thể mà không làm thay đổi các đường chân trời. Trả về tổng mức tăng tối đa.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Grid Constraint Logic / Logic Ràng buộc Lưới
For any building at `(r, c)`, its new height `H'` must satisfy:
1. `H' <= max(row r)`.
2. `H' <= max(col c)`.
Thus, `H' = min(maxRow[r], maxCol[c])`.

Algorithm:
1. Find the maximum height for each row and store in `maxRow[n]`.
2. Find the maximum height for each column and store in `maxCol[n]`.
3. The increment for building `(r, c)` is `min(maxRow[r], maxCol[c]) - grid[r][c]`.
4. Sum all increments.

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(N) to store row and column maximums.

---

## Analysis / Phân tích

### Approach: Marginal Height Bounds
The skyline determines the permissible "roof" for each cell. By calculating the lower of the two intersecting skyline constraints (row and column), we find the maximum height addition possible.
Đường chân trời xác định "mái nhà" cho từng ô. Bằng cách tính toán giá trị thấp hơn của hai ràng buộc đường chân trời giao nhau (hàng và cột), chúng ta tìm thấy mức tăng độ cao tối đa có thể.

---
